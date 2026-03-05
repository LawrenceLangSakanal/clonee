package com.motorph.util;

import com.motorph.model.Role;

/**
 * Maps position title strings (as used in the CSV / User class) to the Role enum.
 */
public class RoleUtil {

    private RoleUtil() {
        // utility class
    }

    /**
     * Determines the Role for a given position title string.
     *
     * @param positionTitle the position string (e.g. "HR Manager")
     * @return the matching Role, or Role.REGULAR if not recognised
     */
    public static Role determineRole(String positionTitle) {
        if (positionTitle == null) {
            return Role.REGULAR;
        }
        switch (positionTitle.trim()) {
            case "Chief Executive Officer":    return Role.CEO;
            case "Chief Operating Officer":    return Role.COO;
            case "Chief Finance Officer":      return Role.CFO;
            case "Chief Marketing Officer":    return Role.CMO;
            case "IT Operations and Systems":  return Role.IT_OPERATIONS;
            case "HR Manager":                 return Role.HR_MANAGER;
            case "HR Team Leader":             return Role.HR_TEAM_LEADER;
            case "HR Rank and File":           return Role.HR_RANK_AND_FILE;
            case "Payroll Manager":            return Role.PAYROLL_MANAGER;
            case "Payroll Team Leader":        return Role.PAYROLL_TEAM_LEADER;
            case "Payroll Rank and File":      return Role.PAYROLL_RANK_AND_FILE;
            case "Accounting Head":            return Role.ACCOUNTING_HEAD;
            case "Account Manager":            return Role.ACCOUNT_MANAGER;
            case "Account Team Leader":        return Role.ACCOUNT_TEAM_LEADER;
            default:                           return Role.REGULAR;
        }
    }
}
