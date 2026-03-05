package com.motorph.service;

import com.motorph.repo.AttendanceRepository;
import com.motorph.repo.EmployeeRepository;
import com.motorph.repo.LeaveRepository;

/**
 * Simple service locator that provides singleton instances of all services
 * and repositories for use by the GUI layer.
 */
public class ServiceLocator {

    private static final EmployeeRepository employeeRepository = new EmployeeRepository();
    private static final AttendanceRepository attendanceRepository = new AttendanceRepository();
    private static final LeaveRepository leaveRepository = new LeaveRepository();

    private static final AuthService authService = new AuthService(employeeRepository);
    private static final AttendanceService attendanceService = new AttendanceService(attendanceRepository);
    private static final LeaveService leaveService = new LeaveService(leaveRepository);
    private static final ProfileService profileService = new ProfileService(employeeRepository);

    private ServiceLocator() {}

    public static EmployeeRepository getEmployeeRepository() { return employeeRepository; }
    public static AttendanceRepository getAttendanceRepository() { return attendanceRepository; }
    public static LeaveRepository getLeaveRepository() { return leaveRepository; }
    public static AuthService getAuthService() { return authService; }
    public static AttendanceService getAttendanceService() { return attendanceService; }
    public static LeaveService getLeaveService() { return leaveService; }
    public static ProfileService getProfileService() { return profileService; }
}
