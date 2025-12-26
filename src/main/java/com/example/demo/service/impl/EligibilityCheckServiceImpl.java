package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.EligibilityCheckService;
import java.util.List;
import org.springframework.stereotype.Service;

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

        EmployeeProfile employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if (!employee.getActive()) {
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

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();
        for (PolicyRule rule : rules) {

            boolean roleMatch = rule.getAppliesToRole() == null
                    || rule.getAppliesToRole().equals(employee.getJobRole());

            boolean deptMatch = rule.getAppliesToDepartment() == null
                    || rule.getAppliesToDepartment().equals(employee.getDepartment());

            if (roleMatch && deptMatch && activeCount >= rule.getMaxDevicesAllowed()) {
                throw new BadRequestException("Policy violation");
            }
        }

        EligibilityCheckRecord record = new EligibilityCheckRecord(
                employee, device, true, "Eligible");

        return checkRepo.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return checkRepo.findByEmployeeId(employeeId);
    }
}
