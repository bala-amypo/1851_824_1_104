@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository ruleRepo;
    private final EligibilityCheckRecordRepository checkRepo;

    public EligibilityCheckServiceImpl(
            EmployeeProfileRepository employeeRepo,
            DeviceCatalogItemRepository deviceRepo,
            IssuedDeviceRecordRepository issuedRepo,
            PolicyRuleRepository ruleRepo,
            EligibilityCheckRecordRepository checkRepo) {

        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.issuedRepo = issuedRepo;
        this.ruleRepo = ruleRepo;
        this.checkRepo = checkRepo;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {

        EmployeeProfile emp = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if (!emp.getActive()) {
            throw new BadRequestException("not active");
        }

        DeviceCatalogItem device = deviceRepo.findById(deviceItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        if (!device.getActive()) {
            throw new BadRequestException("inactive");
        }

        if (!issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId).isEmpty()) {
            throw new BadRequestException("active issuance");
        }

        Long activeCount = issuedRepo.countActiveDevicesForEmployee(employeeId);
        if (activeCount >= device.getMaxAllowedPerEmployee()) {
            throw new BadRequestException("Maximum allowed devices");
        }

        for (PolicyRule rule : ruleRepo.findByActiveTrue()) {

            boolean roleMatch = rule.getAppliesToRole() == null ||
                    rule.getAppliesToRole().equals(emp.getJobRole());

            boolean deptMatch = rule.getAppliesToDepartment() == null ||
                    rule.getAppliesToDepartment().equals(emp.getDepartment());

            if (roleMatch && deptMatch && activeCount >= rule.getMaxDevicesAllowed()) {
                throw new BadRequestException("Policy violation");
            }
        }

        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployee(emp);
        record.setDeviceItem(device);
        record.setIsEligible(true);
        record.setReason("Eligible for device issuance");

        return checkRepo.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return checkRepo.findByEmployeeId(employeeId);
    }
}
