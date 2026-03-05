package com.motorph.service;

import com.motorph.repo.EmployeeRepository;
import com.motorph.model.Employee;

import java.util.Optional;

/**
 * Handles profile photo updates and retrieval.
 */
public class ProfileService {

    private final EmployeeRepository employeeRepository;

    public ProfileService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Updates the profile photo path for an employee.
     *
     * @param empId    the employee ID
     * @param filePath the absolute path to the new profile photo
     */
    public void updateProfilePhoto(String empId, String filePath) {
        Optional<Employee> opt = employeeRepository.findById(empId);
        if (opt.isPresent()) {
            Employee emp = opt.get();
            emp.setProfilePhotoPath(filePath);
            employeeRepository.save(emp);
        }
    }

    /**
     * Returns the profile photo path for an employee, or null if not set.
     *
     * @param empId the employee ID
     * @return the file path, or null
     */
    public String getProfilePhoto(String empId) {
        return employeeRepository.findById(empId)
                .map(Employee::getProfilePhotoPath)
                .orElse(null);
    }
}
