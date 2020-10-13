import java.time.LocalDate;

public interface EmployeeDatabaseInterface {
  public Employee getEmployee(int employeeID);
  public boolean hasEmployee(int employeeID);
  public boolean addEmployee(int employeeID, String name, LocalDate dob, LocalDate recordDate, 
      LocalDate hireDate, String jobTitle, String gender, String status, String businessUnit);
  public boolean removeEmployee(int employeeID);
  public boolean updateName(int employeeID, String newName);
  public boolean updateDateOfBirth(int employeeID, LocalDate newDOB);
  public boolean updateHireDate(int employeeID, LocalDate newHireDate);
  public boolean updateRecordDate(int employeeID, LocalDate newRecordDate);
  public boolean updateTitle(int employeeID, String newTitle);
  public boolean updateGender(int employeeID, String newGender);
  public boolean setStatus(int employeeID, String newStatus);
  public boolean updateBusinessUnit(int employeeID, String newBusinessUnit);
}
