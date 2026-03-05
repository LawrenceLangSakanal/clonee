package com.motorph.service;

import com.motorph.model.AttendanceRecord;
import com.motorph.repo.AttendanceRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Business logic for attendance: clock-in, clock-out, and record retrieval.
 */
public class AttendanceService {

    private static final LocalTime STANDARD_START = LocalTime.of(8, 0);
    private static final LocalTime STANDARD_END = LocalTime.of(17, 0);
    private static final double STANDARD_HOURS = 8.0;
    private static final String STATUS_PRESENT = "Present";
    private static final String STATUS_LATE = "Late";
    private static final String STATUS_UNDER_TIME = "Under Time";

    private final AttendanceRepository attendanceRepository;

    // Tracks employees who have clocked in but not yet out
    private final java.util.Map<String, LocalTime> openClockIns = new java.util.HashMap<>();

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    /**
     * Records a clock-in for today. Throws if already clocked in.
     *
     * @param empId the employee ID
     */
    public void clockIn(String empId) {
        if (openClockIns.containsKey(empId)) {
            throw new IllegalStateException("Employee " + empId + " is already clocked in.");
        }
        openClockIns.put(empId, LocalTime.now());
    }

    /**
     * Records a clock-out for today. Calculates duration, late time, and overtime.
     *
     * @param empId the employee ID
     */
    public AttendanceRecord clockOut(String empId) {
        LocalTime clockInTime = openClockIns.remove(empId);
        if (clockInTime == null) {
            throw new IllegalStateException("Employee " + empId + " has no open clock-in.");
        }

        LocalTime clockOutTime = LocalTime.now();
        long minutesWorked = ChronoUnit.MINUTES.between(clockInTime, clockOutTime);
        double hoursWorked = minutesWorked / 60.0;

        long lateMinutes = 0;
        if (clockInTime.isAfter(STANDARD_START)) {
            lateMinutes = ChronoUnit.MINUTES.between(STANDARD_START, clockInTime);
        }

        double overtimeHours = 0;
        if (hoursWorked > STANDARD_HOURS) {
            overtimeHours = hoursWorked - STANDARD_HOURS;
        }

        String status;
        if (lateMinutes > 0) {
            status = STATUS_LATE;
        } else if (hoursWorked < STANDARD_HOURS) {
            status = STATUS_UNDER_TIME;
        } else {
            status = STATUS_PRESENT;
        }

        AttendanceRecord record = new AttendanceRecord(
                empId, LocalDate.now(), clockInTime, clockOutTime,
                hoursWorked, lateMinutes, overtimeHours, status);
        attendanceRepository.save(record);
        return record;
    }

    /**
     * Returns attendance records for an employee within a date range.
     */
    public List<AttendanceRecord> getRecords(String empId, LocalDate from, LocalDate to) {
        return attendanceRepository.findByEmpIdAndDateRange(empId, from, to);
    }
}
