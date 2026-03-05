package com.motorph.model;

/**
 * Domain model mirroring the fields of com.gui.Home.User plus a profilePhotoPath.
 */
public class Employee {

    private String empId;
    private String firstName;
    private String lastName;
    private String dob;
    private String position;
    private String status;
    private String phoneNumber;
    private String immediateSupervisor;
    private String basicSalary;
    private String hourlyRate;
    private String riceSubsidy;
    private String phoneAllowance;
    private String clothingAllowance;
    private String grossSemiRate;
    private String sss;
    private String philHealth;
    private String tin;
    private String pagIbig;
    private String address;
    private Role role;
    private String profilePhotoPath;

    public Employee(String empId, String firstName, String lastName, String dob,
                    String position, String status, String phoneNumber,
                    String immediateSupervisor, String basicSalary, String hourlyRate,
                    String riceSubsidy, String phoneAllowance, String clothingAllowance,
                    String grossSemiRate, String sss, String philHealth, String tin,
                    String pagIbig, String address, Role role) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.position = position;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiRate = grossSemiRate;
        this.sss = sss;
        this.philHealth = philHealth;
        this.tin = tin;
        this.pagIbig = pagIbig;
        this.address = address;
        this.role = role;
    }

    // Getters
    public String getEmpId() { return empId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDob() { return dob; }
    public String getPosition() { return position; }
    public String getStatus() { return status; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getImmediateSupervisor() { return immediateSupervisor; }
    public String getBasicSalary() { return basicSalary; }
    public String getHourlyRate() { return hourlyRate; }
    public String getRiceSubsidy() { return riceSubsidy; }
    public String getPhoneAllowance() { return phoneAllowance; }
    public String getClothingAllowance() { return clothingAllowance; }
    public String getGrossSemiRate() { return grossSemiRate; }
    public String getSss() { return sss; }
    public String getPhilHealth() { return philHealth; }
    public String getTin() { return tin; }
    public String getPagIbig() { return pagIbig; }
    public String getAddress() { return address; }
    public Role getRole() { return role; }
    public String getProfilePhotoPath() { return profilePhotoPath; }

    // Setters
    public void setEmpId(String empId) { this.empId = empId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDob(String dob) { this.dob = dob; }
    public void setPosition(String position) { this.position = position; }
    public void setStatus(String status) { this.status = status; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setImmediateSupervisor(String immediateSupervisor) { this.immediateSupervisor = immediateSupervisor; }
    public void setBasicSalary(String basicSalary) { this.basicSalary = basicSalary; }
    public void setHourlyRate(String hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setRiceSubsidy(String riceSubsidy) { this.riceSubsidy = riceSubsidy; }
    public void setPhoneAllowance(String phoneAllowance) { this.phoneAllowance = phoneAllowance; }
    public void setClothingAllowance(String clothingAllowance) { this.clothingAllowance = clothingAllowance; }
    public void setGrossSemiRate(String grossSemiRate) { this.grossSemiRate = grossSemiRate; }
    public void setSss(String sss) { this.sss = sss; }
    public void setPhilHealth(String philHealth) { this.philHealth = philHealth; }
    public void setTin(String tin) { this.tin = tin; }
    public void setPagIbig(String pagIbig) { this.pagIbig = pagIbig; }
    public void setAddress(String address) { this.address = address; }
    public void setRole(Role role) { this.role = role; }
    public void setProfilePhotoPath(String profilePhotoPath) { this.profilePhotoPath = profilePhotoPath; }

    @Override
    public String toString() {
        return empId + " - " + lastName + ", " + firstName + " (" + position + ")";
    }
}
