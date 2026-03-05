package com.motorph.model;

import java.time.LocalDate;

/**
 * Represents an employee leave request.
 */
public class LeaveRequest {

    private int id;
    private String empId;
    private String empName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String reason;
    private LeaveStatus status;
    private String approvedBy;
    private LocalDate approvedDate;

    public LeaveRequest(int id, String empId, String empName,
                        LocalDate dateFrom, LocalDate dateTo,
                        String reason) {
        this.id = id;
        this.empId = empId;
        this.empName = empName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.reason = reason;
        this.status = LeaveStatus.PENDING;
    }

    public int getId() { return id; }
    public String getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public LocalDate getDateFrom() { return dateFrom; }
    public LocalDate getDateTo() { return dateTo; }
    public String getReason() { return reason; }
    public LeaveStatus getStatus() { return status; }
    public String getApprovedBy() { return approvedBy; }
    public LocalDate getApprovedDate() { return approvedDate; }

    public void setId(int id) { this.id = id; }
    public void setEmpId(String empId) { this.empId = empId; }
    public void setEmpName(String empName) { this.empName = empName; }
    public void setDateFrom(LocalDate dateFrom) { this.dateFrom = dateFrom; }
    public void setDateTo(LocalDate dateTo) { this.dateTo = dateTo; }
    public void setReason(String reason) { this.reason = reason; }
    public void setStatus(LeaveStatus status) { this.status = status; }
    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }
    public void setApprovedDate(LocalDate approvedDate) { this.approvedDate = approvedDate; }
}
