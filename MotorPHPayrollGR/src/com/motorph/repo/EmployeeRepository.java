package com.motorph.repo;

import com.motorph.model.Employee;
import com.motorph.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * In-memory repository of MotorPH employees.
 * Password for each employee defaults to their employee ID.
 */
public class EmployeeRepository {

    private static final List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("10001", "Garcia", "Manuel III", "10/11/1983",
                "Chief Executive Officer", "Active", "53-876-2870",
                "N/A", "90,000", "535.71", "1,500", "2,000", "1,000",
                "45,000", "44-050-1782-5", "13-874824-5", "512-276-732",
                "17-048-2300432-5", "Valero Carpark Building Valero Street, Salcedo Village Makati City", Role.CEO));

        employees.add(new Employee("10002", "Lim", "Antonio", "06/19/1988",
                "Chief Operating Officer", "Active", "63-487-1928",
                "Garcia, Manuel III", "60,000", "357.14", "1,500", "2,000", "1,000",
                "30,000", "52-020-6413-2", "09-756809-4", "210-805-911",
                "20-128-3752393-1", "San Antonio Village Makati City", Role.COO));

        employees.add(new Employee("10003", "Aquino", "Bianca Sofia", "08/04/1989",
                "Chief Finance Officer", "Active", "63-404-7488",
                "Lim, Antonio", "60,000", "357.14", "1,500", "2,000", "1,000",
                "30,000", "30-712-5510-8", "12-517381-0", "212-781-253",
                "40-571-5469788-6", "Guadalupe Viejo Makati City", Role.CFO));

        employees.add(new Employee("10004", "Reyes", "Isabella", "06/16/1994",
                "Chief Marketing Officer", "Active", "63-417-4799",
                "Lim, Antonio", "60,000", "357.14", "1,500", "2,000", "1,000",
                "30,000", "40-407-6073-0", "12-541382-9", "515-993-000",
                "40-573-9329749-2", "San Isidro Makati City", Role.CMO));

        employees.add(new Employee("10005", "Hernandez", "Eduard", "09/23/1989",
                "IT Operations and Systems", "Active", "63-772-7464",
                "Lim, Antonio", "52,000", "309.52", "1,500", "1,000", "1,000",
                "26,000", "50-145-0671-6", "11-703280-4", "110-771-005",
                "40-574-2946742-9", "Bangkal Makati City", Role.IT_OPERATIONS));

        employees.add(new Employee("10006", "Villanueva", "Andrea Mae", "02/14/1988",
                "HR Manager", "Active", "63-926-2652",
                "Lim, Antonio", "52,000", "309.52", "1,500", "1,000", "1,000",
                "26,000", "49-506-4437-8", "10-261321-0", "113-987-145",
                "40-574-2996100-0", "Olympia Makati City", Role.HR_MANAGER));

        employees.add(new Employee("10007", "San Jose", "Brad", "03/15/1996",
                "HR Team Leader", "Active", "63-928-2141",
                "Villanueva, Andrea Mae", "42,000", "250.00", "1,500", "800", "800",
                "21,000", "40-570-5630-2", "10-060553-9", "514-474-844",
                "40-570-5630-2", "Malamig Mandaluyong City", Role.HR_TEAM_LEADER));

        employees.add(new Employee("10008", "Romualdez", "Alice", "05/14/1992",
                "HR Rank and File", "Active", "63-917-5419",
                "San Jose, Brad", "22,500", "133.93", "1,500", "800", "800",
                "11,250", "55-175-1091-0", "10-934605-9", "210-780-005",
                "10-578-6969897-5", "Liamzon Rizal", Role.HR_RANK_AND_FILE));

        employees.add(new Employee("10009", "Atienza", "Rosie", "09/24/1948",
                "HR Rank and File", "Active", "63-990-7131",
                "San Jose, Brad", "22,500", "133.93", "1,500", "800", "800",
                "11,250", "41-616-3505-2", "11-450413-1", "275-792-449",
                "30-572-3959997-1", "Magdiwang Rizal", Role.HR_RANK_AND_FILE));

        employees.add(new Employee("10010", "Alvaro", "Roderick", "03/30/1988",
                "Payroll Manager", "Active", "63-796-2768",
                "Aquino, Bianca Sofia", "52,000", "309.52", "1,500", "1,000", "1,000",
                "26,000", "60-266-2830-6", "12-458876-0", "220-699-400",
                "63-575-8930005-4", "Metrogate Complex Antipolo City", Role.PAYROLL_MANAGER));

        employees.add(new Employee("10011", "Salcedo", "Anthony Oni", "09/14/1993",
                "Payroll Team Leader", "Active", "63-808-3380",
                "Alvaro, Roderick", "24,000", "142.86", "1,500", "800", "800",
                "12,000", "36-027-9133-5", "11-187609-0", "210-395-651",
                "10-515-2477982-9", "Metrogate Complex Antipolo City", Role.PAYROLL_TEAM_LEADER));

        employees.add(new Employee("10012", "Lopez", "Josie", "01/14/1987",
                "Payroll Rank and File", "Active", "63-928-2958",
                "Salcedo, Anthony Oni", "22,500", "133.93", "1,500", "800", "800",
                "11,250", "57-026-5612-3", "12-570927-8", "212-056-720",
                "38-576-2831005-8", "Bayanan Muntinlupa City", Role.PAYROLL_RANK_AND_FILE));

        employees.add(new Employee("10013", "Ramos", "Fredrick", "08/31/1985",
                "Accounting Head", "Active", "63-910-6869",
                "Aquino, Bianca Sofia", "52,000", "309.52", "1,500", "1,000", "1,000",
                "26,000", "45-792-4548-1", "12-698516-8", "343-814-900",
                "49-579-4409188-4", "Pio del Pilar Makati City", Role.ACCOUNTING_HEAD));

        employees.add(new Employee("10014", "Castro", "Rodney", "03/08/1989",
                "Account Manager", "Active", "63-938-1729",
                "Ramos, Fredrick", "52,000", "309.52", "1,500", "1,000", "1,000",
                "26,000", "35-725-2063-9", "11-874616-7", "512-945-875",
                "20-578-1013245-7", "Bagong Pag-Asa Quezon City", Role.ACCOUNT_MANAGER));

        employees.add(new Employee("10015", "Martinez", "Carmen", "02/22/1985",
                "Account Team Leader", "Active", "63-916-9398",
                "Castro, Rodney", "42,000", "250.00", "1,500", "800", "800",
                "21,000", "31-148-6867-8", "12-029379-9", "216-035-088",
                "38-578-9844892-1", "Fairview Quezon City", Role.ACCOUNT_TEAM_LEADER));
    }

    public Optional<Employee> findById(String empId) {
        return employees.stream()
                .filter(e -> e.getEmpId().equals(empId))
                .findFirst();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public List<Employee> findByRole(Role role) {
        return employees.stream()
                .filter(e -> e.getRole() == role)
                .collect(Collectors.toList());
    }

    public void save(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpId().equals(employee.getEmpId())) {
                employees.set(i, employee);
                return;
            }
        }
        employees.add(employee);
    }
}
