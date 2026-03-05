package com.motorph.service;

import com.motorph.model.Employee;
import com.motorph.model.Role;

/**
 * Maps an employee's position string to a {@link Role} enum value, and exposes
 * permission checks used by the UI layer.
 */
public class RoleService {

    /** Derive the logical Role from an employee's position. */
    public Role getRole(Employee employee) {
        if (employee == null) return Role.REGULAR;
        return getRole(employee.getPosition());
    }

    public Role getRole(String position) {
        if (position == null) return Role.REGULAR;
        switch (position) {
            case "Chief Executive Officer":   return Role.CEO;
            case "Chief Operating Officer":   return Role.COO;
            case "Chief Finance Officer":     return Role.CFO;
            case "Chief Marketing Officer":   return Role.CMO;
            case "Accounting Head":           return Role.ACCOUNTING_HEAD;
            case "Account Manager":           return Role.ACCOUNT_MANAGER;
            case "Account Team Leader":       return Role.ACCOUNT_TEAM_LEADER;
            case "Payroll Manager":           return Role.PAYROLL_MANAGER;
            case "Payroll Team Leader":       return Role.PAYROLL_TEAM_LEADER;
            case "Payroll Rank and File":     return Role.PAYROLL_RANK_AND_FILE;
            case "HR Manager":                return Role.HR_MANAGER;
            case "HR Team Leader":            return Role.HR_TEAM_LEADER;
            case "HR Rank and File":          return Role.HR_RANK_AND_FILE;
            case "IT Operations and Systems": return Role.IT_OPERATIONS;
            default:                          return Role.REGULAR;
        }
    }

    // ── Permission helpers ────────────────────────────────────────────────────

    public boolean canAccessEmployeeManagement(Employee e) {
        if (e == null) return false;
        Role r = getRole(e);
        return r == Role.IT_OPERATIONS || r == Role.CEO || r == Role.COO
                || r == Role.CFO || r == Role.CMO || r == Role.ACCOUNTING_HEAD
                || r == Role.ACCOUNT_MANAGER || r == Role.PAYROLL_MANAGER
                || isHRPosition(e.getPosition());
    }

    public boolean canAccessPayrollManagement(Employee e) {
        if (e == null) return false;
        return isFinancePosition(e.getPosition());
    }

    public boolean canApproveLeave(Employee e) {
        if (e == null) return false;
        Role r = getRole(e);
        return r == Role.IT_OPERATIONS || r == Role.CEO || r == Role.COO
                || r == Role.CFO || r == Role.CMO || r == Role.ACCOUNTING_HEAD
                || r == Role.ACCOUNT_MANAGER || r == Role.PAYROLL_MANAGER
                || r == Role.HR_MANAGER || r == Role.HR_TEAM_LEADER;
    }

    public boolean canAccessSystemMaintenance(Employee e) {
        if (e == null) return false;
        return "IT Operations and Systems".equals(e.getPosition());
    }

    // ── Private helpers ───────────────────────────────────────────────────────

    private boolean isHRPosition(String position) {
        return position != null && (
                position.equals("HR Manager")
                || position.equals("HR Team Leader")
                || position.equals("HR Rank and File"));
    }

    private boolean isFinancePosition(String position) {
        return position != null && (
                position.equals("Chief Finance Officer")
                || position.equals("Payroll Manager")
                || position.equals("Payroll Team Leader")
                || position.equals("Payroll Rank and File"));
    }
}
