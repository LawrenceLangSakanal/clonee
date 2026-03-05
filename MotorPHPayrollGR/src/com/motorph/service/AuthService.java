package com.motorph.service;

import com.motorph.model.Employee;
import com.motorph.repo.EmployeeRepository;

/**
 * Handles authentication using the in-memory EmployeeRepository.
 * Default password for each employee is their employee ID.
 */
public class AuthService {

    private final EmployeeRepository employeeRepository;

    public AuthService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Authenticates an employee. Returns the Employee if credentials are valid,
     * or null if not found or password is incorrect.
     *
     * @param empId    the employee ID
     * @param password the password (default: same as empId)
     * @return the authenticated Employee or null
     */
    public Employee login(String empId, String password) {
        return employeeRepository.findById(empId)
                .filter(e -> e.getEmpId().equals(password))
                .orElse(null);
    }
}
