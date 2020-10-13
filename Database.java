// --== CS400 File Header Information ==--
// Name: Deming Xu
// Email: dxu227@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: No note

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.NoSuchElementException;

/**
 * This is the class for database of the program.
 * The instance is a hashtable used to store all the employee objects.
 *
 * @author Deming Xu
 */
public class Database {
    private HashTableMap<Integer, Employee> employeeTable;      // Hashtable used to store employee objects

    /**
     * Default constructor
     */
    public Database() {
        this.employeeTable = new HashTableMap<>();      // initiate the hashtable
        importEmployees();      // load data
    }

    /**
     * Constructor
     */
    public Database(int capacity) {
        this.employeeTable = new HashTableMap<>(capacity);      // initiate the hashtable with capacity
        importEmployees();      // load data
    }

    /**
     * Load all the data from external files into the program. The file name is txt.
     */
    private void importEmployees(){
        FileReader fileReader;      // File reader object
        String os = System.getProperty("os.name");  // get the current operation system
        String filePath = "employee_info.txt";      // File path, linux' file path by default

        // If the current operation system is Windows, change the file path for windows. Same for MacOS
        if(os.toLowerCase().contains("win")) {
            filePath = "src\\employee_info.txt";
        }else if(os.toLowerCase().contains("mac")){
            filePath = "src/employee_info.txt";
        }

        // Import the file and extract every pieces of data
        try {
            // Get ready for file reader and buffered reader
            fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Scan file line by line
            String line = bufferedReader.readLine();
            while(line != null && !line.equals("")){
                // Split the line by comma and store them into a String array
                String[] info = line.split(",");

                int employeeId = Integer.parseInt(info[0]);                    // Get the employee's id

                String name = info[1];                                         // Get the employee's name

                // Get the employee's dob, split by "/", and put the date into a LocalDate object
                String[] dob = info[2].split("/");
                int year = Integer.parseInt(dob[2]);
                int month = Integer.parseInt(dob[0]);
                int day = Integer.parseInt(dob[1]);
                LocalDate dateOfBirth = LocalDate.of(year, month, day);

                // Get the employee's record date, split by "/", and put the date into a LocalDate object
                String[] record = info[3].split("/");
                year = Integer.parseInt(record[2]);
                month = Integer.parseInt(record[0]);
                day = Integer.parseInt(record[1]);
                LocalDate recordDate = LocalDate.of(year, month, day);

                // Get the employee's hire date, split by "/", and put the date into a LocalDate object
                String[] hire = info[4].split("/");
                year = Integer.parseInt(hire[2]);
                month = Integer.parseInt(hire[0]);
                day = Integer.parseInt(hire[1]);
                LocalDate hireDate = LocalDate.of(year, month, day);

                String jobTitle = info[5];                                      // Get employee's job title

                String gender = info[6];                                        // Get employee's gender

                String status = info[7];                                        // Get employee's status.
                                                                                // Active or inactive

                String businessUnit = info[8];                                  // Get employee's business unit

                // Create the employee object with info above
                Employee employee = new Employee(employeeId, name, dateOfBirth, recordDate, hireDate,
                                                 jobTitle, gender, status, businessUnit);
                // Store the employee object into the hashtable
                employeeTable.put(employee.getEmployeeID(), employee);
                // Read next line in the file
                line = bufferedReader.readLine();
            }
        }catch (Exception ignored){
            // If any Exception thrown, such as cannot locate the file,
            // just ignore and stop importing
        }
    }

    /**
     * get the employeeInfo with all the information of employees
     *
     * @return hashtable of employees
     */
    public HashTableMap<Integer, Employee> allEmployeeInfos(){
        // If the size is 0, return null
        if(employeeTable.size() == 0){
            return null;
        }
        return employeeTable;
    }

    /**
     * put an employee object to the hashtable. Return false if there is any conflict, or add a duplicate employee.
     *
     * @param employee
     * @return true if the put is successful, otherwise return false
     */
    public boolean addEmployee(Employee employee){
        return employeeTable.put(employee.getEmployeeID(), employee);
    }

    /**
     * find and return the employee object by employee ID
     *
     * @param employeeId
     * @return the employee object found by id. Return null if no match is found.
     */
    public Employee getEmployeeInfoByID(int employeeId){
        try {
            return employeeTable.get(employeeId);
        }catch (NoSuchElementException nsee){
            // Since get method will thrown an exception when no match found. Catch the exception and return null
            return null;
        }
    }

    /**
     * update the employee information by employee ID
     *
     * @param employeeID
     * @param employee
     * @return true if update is successful, false if the id does not exist (no match found)
     */
    public boolean updateEmployeeByID(int employeeID, Employee employee){
        // If the param employeeID is different than the id in the param employee object, return false
        if(employeeID != employee.getEmployeeID()) return false;
        // Remove the employee object from the hashtable and replace with the param employee object
        // If there's no such employee, return false
        if(employeeTable.remove(employeeID) != null){
            return employeeTable.put(employeeID, employee);
        }else{
            return false;
        }
    }

    /**
     * delete the employee by employee ID
     * @param employeeId
     * @return true if the deletion is successful, false if no match is found.
     */
    public boolean deleteEmployeeByID(int employeeId){
        return employeeTable.remove(employeeId) != null;
    }

    /**
     * check if an employee exits by employee ID
     * @param employeeId
     * @return true if exist, and false if not
     */
    public boolean containEmployeeByID(int employeeId){
        return employeeTable.containsKey(employeeId);
    }

    /**
     * clear all the employee in the hash table
     */
    public void clearEmployees(){
        employeeTable.clear();
    }
}
