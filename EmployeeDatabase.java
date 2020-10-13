// --== CS400 File Header Information ==--
// Name: Isaac Colbert
// Email: icolbert@wisc.edu
// Team: CG
// Role: Back End Developer
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class EmployeeDatabase implements EmployeeDatabaseInterface {
  private static Database database;
  
  /**
   * Constructor that initializes the hash table with a initial capacity of 10.
   */
  public EmployeeDatabase() {
    database = new Database();
  }
  
  /**
   * Constructor that initializes the hash table with the initial capacity specified by 
   * initCapacity.
   * <p>
   * @param initCapacity - The initial capacity of the hash table.
   */
  public EmployeeDatabase(int initCapacity) {
    database = new Database(initCapacity);
  }

  /**
   * Returns the employee specified by the employeeID number.
   * <p>
   * @param employeeID - the ID number of the employee being searched for.
   * @return the employee that corresponds to the employee ID number.
   */
  @Override
  public Employee getEmployee(int employeeID) {
    return database.getEmployeeInfoByID(employeeID);
  }

  /**
   * Returns whether there is an employee in the database with the employee ID provided.
   * <p>
   * @param employeeID - the ID number to search for in the database and determine if is in the 
   *                     table.
   * @return true if the employee with the ID number is in the database, false otherwise.
   */
  @Override
  public boolean hasEmployee(int employeeID) {
    return database.containEmployeeByID(employeeID);
  }

  /**
   * Adds an employee into the database, first creating an Employee object then adding 
   * it to the database.
   * <p>
   * @param employeeID - the ID number to be associated with the employee.
   * @param name - the employee's name.
   * @param dob - the employee's date of birth.
   * @param recordDate - the employee's record date.
   * @param hireDate - the date the employee was hired.
   * @param jobTitle - the employee's job title.
   * @param gender - the employee's gender.
   * @param status - the employee's status.
   * @param businessUnit - the business unit the employee works in.
   * @return true when the employee is successfully added to the database, false otherwise.
   */
  @Override
  public boolean addEmployee(int employeeID, String name, LocalDate dob, LocalDate recordDate,
      LocalDate hireDate, String jobTitle, String gender, String status, String businessUnit) {
    Employee newEmployee = new Employee(employeeID, name, dob, recordDate, hireDate, jobTitle, 
        gender, status, businessUnit);
    return database.addEmployee(newEmployee);
  }

  /**
   * Removes an employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee to remove.
   * @return true when the employee is successfully removed, false otherwise.
   */
  @Override
  public boolean removeEmployee(int employeeID) {
    return database.deleteEmployeeByID(employeeID);
  }

  /**
   * Updates the name of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose name is to be updated.
   * @param newName - the string of the new name of the employee.
   * @return true when the employee's name is successfully updated, false otherwise.
   */
  @Override
  public boolean updateName(int employeeID, String newName) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setName(newName);
      return true;
    }
  }

  /**
   * Updates the date of birth of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose date of birth is to be updated.
   * @param newDOB - the new date of birth.
   * @return true when the date of birth is successfully updated, false otherwise.
   */
  @Override
  public boolean updateDateOfBirth(int employeeID, LocalDate newDOB) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setDateOfBirth(newDOB);
      return true;
    }
  }

  /**
   * Updates the hire date of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose hire date is to be updated.
   * @param newHireDate - the new hire date.
   * @return true when the hire date is successfully updated, false otherwise.
   */
  @Override
  public boolean updateHireDate(int employeeID, LocalDate newHireDate) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setHireDate(newHireDate);
      return true;
    }
  }

  /**
   * Updates the record date of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose record date is to be updated.
   * @param newRecordDate - the new record date.
   * @return true when the record date is successfully updated, false otherwise.
   */
  @Override
  public boolean updateRecordDate(int employeeID, LocalDate newRecordDate) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setRecordDate(newRecordDate);
      return true;
    }
  }

  /**
   * Updates the title of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose title is to be updated.
   * @param newTitle - the employee's new title.
   * @return true when the title is successfully updated, false otherwise.
   */
  @Override
  public boolean updateTitle(int employeeID, String newTitle) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setJobTitle(newTitle);
      return true;
    }
  }

  /**
   * Updates the gender of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose gender is to be updated.
   * @param newGender - the employee's new gender.
   * @return true when the gender is successfully updated, false otherwise.
   */
  @Override
  public boolean updateGender(int employeeID, String newGender) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setGender(newGender);
      return true;
    }
  }

  /**
   * Updates the status of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose status is to be updated.
   * @param newStatus - the employee's new status.
   * @return true when the status is successfully updated, false otherwise.
   */
  @Override
  public boolean setStatus(int employeeID, String newStatus) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setStatus(newStatus);
      return true;
    }
  }

  /**
   * Updates the business unit of the employee with the associated ID number.
   * <p>
   * @param employeeID - the ID number of the employee whose business unit is to be updated.
   * @param newBusinessUnit - the employee's new business unit.
   * @return true when the business unit is successfully updated, false otherwise.
   */
  @Override
  public boolean updateBusinessUnit(int employeeID, String newBusinessUnit) {
    Employee employee = database.getEmployeeInfoByID(employeeID);
    if (employee == null) {
      return false;
    } else {
      employee.setBusinessUnit(newBusinessUnit);
      return true;}
  }
}
