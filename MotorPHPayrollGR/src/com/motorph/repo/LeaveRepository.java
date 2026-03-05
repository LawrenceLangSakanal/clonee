package com.motorph.repo;

import com.motorph.model.LeaveRequest;
import com.motorph.model.LeaveStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * In-memory repository for leave requests.
 */
public class LeaveRepository {

    private final List<LeaveRequest> requests = new ArrayList<>();
    private final AtomicInteger idSequence = new AtomicInteger(1);

    public void save(LeaveRequest request) {
        if (request.getId() == 0) {
            request.setId(idSequence.getAndIncrement());
        }
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getId() == request.getId()) {
                requests.set(i, request);
                return;
            }
        }
        requests.add(request);
    }

    public List<LeaveRequest> findByEmpId(String empId) {
        return requests.stream()
                .filter(r -> r.getEmpId().equals(empId))
                .collect(Collectors.toList());
    }

    public List<LeaveRequest> findPending() {
        return requests.stream()
                .filter(r -> r.getStatus() == LeaveStatus.PENDING)
                .collect(Collectors.toList());
    }

    public List<LeaveRequest> findAll() {
        return new ArrayList<>(requests);
    }

    public LeaveRequest findById(int id) {
        return requests.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
