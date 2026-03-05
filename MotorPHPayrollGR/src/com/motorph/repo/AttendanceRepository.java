package com.motorph.repo;

import com.motorph.model.AttendanceRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * In-memory repository for attendance records.
 */
public class AttendanceRepository {

    private final List<AttendanceRecord> records = new ArrayList<>();

    public void save(AttendanceRecord record) {
        records.add(record);
    }

    public List<AttendanceRecord> findByEmpId(String empId) {
        return records.stream()
                .filter(r -> r.getEmpId().equals(empId))
                .collect(Collectors.toList());
    }

    public List<AttendanceRecord> findByEmpIdAndDateRange(String empId,
                                                           LocalDate from,
                                                           LocalDate to) {
        return records.stream()
                .filter(r -> r.getEmpId().equals(empId)
                        && !r.getDate().isBefore(from)
                        && !r.getDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public List<AttendanceRecord> findAll() {
        return new ArrayList<>(records);
    }
}
