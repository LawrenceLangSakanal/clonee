package com.motorph.service;

import com.motorph.model.LeaveRequest;
import com.motorph.model.LeaveStatus;
import com.motorph.repo.LeaveRepository;
import com.motorph.util.DateUtil;

import java.util.List;

/**
 * Business logic for leave requests: submit, approve, reject, and query.
 */
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    /**
     * Submits a new leave request. Sets status to PENDING.
     *
     * @param request the leave request to submit
     */
    public void submitLeave(LeaveRequest request) {
        request.setStatus(LeaveStatus.PENDING);
        leaveRepository.save(request);
    }

    /**
     * Approves a leave request.
     *
     * @param requestId     the ID of the request
     * @param approverEmpId the employee ID of the approver
     */
    public void approveLeave(int requestId, String approverEmpId) {
        LeaveRequest request = leaveRepository.findById(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Leave request not found: " + requestId);
        }
        request.setStatus(LeaveStatus.APPROVED);
        request.setApprovedBy(approverEmpId);
        request.setApprovedDate(DateUtil.todayManila());
        leaveRepository.save(request);
    }

    /**
     * Rejects a leave request.
     *
     * @param requestId     the ID of the request
     * @param approverEmpId the employee ID of the person rejecting
     */
    public void rejectLeave(int requestId, String approverEmpId) {
        LeaveRequest request = leaveRepository.findById(requestId);
        if (request == null) {
            throw new IllegalArgumentException("Leave request not found: " + requestId);
        }
        request.setStatus(LeaveStatus.REJECTED);
        request.setApprovedBy(approverEmpId);
        request.setApprovedDate(DateUtil.todayManila());
        leaveRepository.save(request);
    }

    /**
     * Returns all leave requests for a given employee.
     */
    public List<LeaveRequest> getLeavesByEmployee(String empId) {
        return leaveRepository.findByEmpId(empId);
    }

    /**
     * Returns all pending leave requests.
     */
    public List<LeaveRequest> getPendingLeaves() {
        return leaveRepository.findPending();
    }

    /**
     * Returns all leave requests.
     */
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }
}
