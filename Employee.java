// --== CS400 File Header Information ==--
// Name: Deming Xu
// Email: dxu227@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: No note

import java.time.LocalDate;

/**
 * Employee Class
 *
 * @author Deming Xu
 */
public class Employee{
    private int employeeID;     // 4-digit unique employee id
    private String name;        // employee name
    private LocalDate dateOfBirth;  // employee date of birth
    private LocalDate recordDate;   // employee record date
    private LocalDate hireDate;     // employee hire date
    private String jobTitle;        // employee job title
    private String gender;          // employee gender
    private String status;          // employee status. Active or inactive
    private String businessUnit;    // employee business unit

    /**
     * default constructor
     */
    public Employee(){}

    /**
     * constructor for employee
     *
     * @param employeeID
     * @param name
     * @param dateOfBirth
     * @param recordDate
     * @param hireDate
     * @param jobTitle
     * @param gender
     * @param status
     * @param businessUnit
     */
    public Employee(int employeeID, String name, LocalDate dateOfBirth, LocalDate recordDate, LocalDate hireDate,
                    String jobTitle, String gender, String status, String businessUnit) {
        this.employeeID = employeeID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.recordDate = recordDate;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.status = status;
        this.businessUnit = businessUnit;
    }

    /**
     * get method for employee id
     *
     * @return employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * set method for employee id
     *
     * @param employeeID
     */
    public void setEmployeeID(int employeeID) {
        employeeID = employeeID;
    }

    /**
     * get method for employee name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set method for employee name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get method for employee date of birth
     *
     * @return dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * print method for employee date of birth
     *
     * @return string of date of birth in MM/DD/YYYY
     */
    public String printDateOfBirth() {
        int year = dateOfBirth.getYear();
        int month = dateOfBirth.getMonthValue();
        int day = dateOfBirth.getDayOfMonth();
        return String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
    }

    /**
     * set method for date of birth
     *
     * @param year
     * @param month
     * @param day
     */
    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    /**
     * set method for date of birth
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * get method for record date
     *
     * @return recordDate
     */
    public LocalDate getRecordDate() {
        return recordDate;
    }

    /**
     * print method for employee record date
     *
     * @return string of record date in MM/DD/YYYY
     */
    public String printRecordDate() {
        int year = recordDate.getYear();
        int month = recordDate.getMonthValue();
        int day = recordDate.getDayOfMonth();
        return String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
    }

    /**
     * set method for employee record date
     *
     * @param year
     * @param month
     * @param day
     */
    public void setRecordDate(int year, int month, int day) {
        this.recordDate = LocalDate.of(year, month, day);
    }

    /**
     * set method for employee record date
     *
     * @param recordDate
     */
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * get method for employee hire date
     *
     * @return hireDate
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * print method for employee hire date
     *
     * @return string of hire date in MM/DD/YYYY
     */
    public String printHireDate() {
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
    }

    /**
     * set method for hire date
     *
     * @param year
     * @param month
     * @param day
     */
    public void setHireDate(int year, int month, int day) {
        this.hireDate = LocalDate.of(year, month, day);
    }

    /**
     * set method for hire date
     *
     * @param hireDate
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * get method for employee job title
     *
     * @return jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * set method for job title
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * get method for employee gender
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * set method for gender
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * get method for employee status
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * set method for status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get method for employee business unit
     *
     * @return businessUnit
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * set method for business unit
     *
     * @param businessUnit
     */
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
}
