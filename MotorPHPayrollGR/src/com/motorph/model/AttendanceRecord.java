package com.motorph.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a single attendance record for an employee.
 */
public class AttendanceRecord {

    private String empId;
    private LocalDate date;
    private LocalTime clockIn;
    private LocalTime clockOut;
    private double duration;    // hours worked
    private double late;        // late minutes
    private double overtime;    // overtime hours
    private String status;      // e.g. "Present", "Absent", "Late"

    public AttendanceRecord(String empId, LocalDate date, LocalTime clockIn,
                            LocalTime clockOut, double duration,
                            double late, double overtime, String status) {
        this.empId = empId;
        this.date = date;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.duration = duration;
        this.late = late;
        this.overtime = overtime;
        this.status = status;
    }

    public String getEmpId() { return empId; }
    public LocalDate getDate() { return date; }
    public LocalTime getClockIn() { return clockIn; }
    public LocalTime getClockOut() { return clockOut; }
    public double getDuration() { return duration; }
    public double getLate() { return late; }
    public double getOvertime() { return overtime; }
    public String getStatus() { return status; }

    public void setEmpId(String empId) { this.empId = empId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setClockIn(LocalTime clockIn) { this.clockIn = clockIn; }
    public void setClockOut(LocalTime clockOut) { this.clockOut = clockOut; }
    public void setDuration(double duration) { this.duration = duration; }
    public void setLate(double late) { this.late = late; }
    public void setOvertime(double overtime) { this.overtime = overtime; }
    public void setStatus(String status) { this.status = status; }
}
