@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository employeeRepo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {

        employeeRepo.findByEmployeeId(employee.getEmployeeId())
                .ifPresent(e -> {
                    throw new BadRequestException("EmployeeId already exists");
                });

        employeeRepo.findByEmail(employee.getEmail())
                .ifPresent(e -> {
                    throw new BadRequestException("Email already exists");
                });

        if (employee.getJobRole() == null) {
            employee.setJobRole("STAFF");
        }

        return employeeRepo.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return employeeRepo.save(emp);
    }
}
