// --== CS400 File Header Information ==--
// Name: Dawson Bauer
// Email: djbauer2@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.time.LocalDate;

public class TestEmployeeDatabase {
	private static LocalDate recordDate = LocalDate.of(2001, 1, 30);
	private static LocalDate hireDate = LocalDate.of(2000, 1, 30);
	private static LocalDate dob = LocalDate.of(1980, 1, 30);
	
	public static void main (String args []) {
		if(testHasEmployee()){
			System.out.println("testHasEmployee: success");
		}
		if(testHasEmployeeFalse()){
			System.out.println("testHasEmployeeFalse: success");
		}
		if(testAddEmployee()){
			System.out.println("testAddEmployee: success");
		}
		if(testGetEmployee()){
			System.out.println("testGetEmployee: success");
		}
		if(testRemoveEmployee()){
			System.out.println("testRemoveEmployee: success");
		}
		if(testUpdateName()){
			System.out.println("testUpdateName: success");
		}
		if(testUpdateDOB()){
			System.out.println("testUpdateDOB: success");
		}
		if(testUpdateHireDate()){
			System.out.println("testUpdateHireDate: success");
		}
		if(testUpdateRecordDate()){
			System.out.println("testUpdateRecordDate: success");
		}
		if(testUpdateTitle()){
			System.out.println("testUpdateTitle: success");
		}
		if(testUpdateGender()){
			System.out.println("testUpdateGender: success");
		}
		if(testUpdateStatus()){
			System.out.println("testUpdateStatus: success");
		}
		if(testUpdateBusinessUnit()){
			System.out.println("testUpdateBusinessUnit: success");
		}
	}
	 /**
	   * This method tests if an Employee exists in the Employee Database.
	   * The method adds an Employee object and then runs hasEmployee ().
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testHasEmployee() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		if(!test.hasEmployee(10)) {
			System.out.println("hasEmployee() failed.");
			return false;
		}
		return 
		  true;
	}
	 /** This method tests if an Employee exists in the Employee Database.
	   * The method runs hasEmployee () but there is no Employee object.
	   * The hasEmployee method should return false.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testHasEmployeeFalse() {
		EmployeeDatabase test = new EmployeeDatabase();
		if(test.hasEmployee(10)) {
			System.out.println("hasEmployee() should have failed but didn't.");
			return false;
		}
		return true;
	}
	 /** This method tests if an Employee object can be added to the
	   * Employee Database.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testAddEmployee() {
		EmployeeDatabase test = new EmployeeDatabase();
		if(!test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business")) {
			System.out.println("addEmployee() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests the getEmployee(). An Employee object is added, and
	   * then the GetEmployee method is called with the object ID at the param.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testGetEmployee() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		if(test.getEmployee(10) == null) {
			System.out.println("getEmployee() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests removeEmployee(). An Employee object is added, and
	   * then the removeEmployee method is called with the object ID at the param.
	   * The added object should be removed. The hasEmployee method is then called
	   * to see if the object is still in the Database.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testRemoveEmployee() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.removeEmployee(10);
		if(test.hasEmployee(10)) {
			System.out.println("removedEmployee() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateName(). An Employee object is added, and
	   * then the updateName method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the name is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateName() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateName(10, "Mark");
		if(!test.getEmployee(10).getName().equals("Mark")) {
			System.out.println("updateName() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateBirth(). An Employee object is added, and
	   * then the updateBirth method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the DOB is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateDOB() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateDateOfBirth(10, LocalDate.of(1981, 01, 01));
		if(!test.getEmployee(10).getDateOfBirth().equals(LocalDate.of(1981, 01, 01))) {
			System.out.println("updateBirth() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateHire(). An Employee object is added, and
	   * then the updateHire method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Hire Date is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateHireDate() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateHireDate(10, LocalDate.of(1981, 01, 01));
		if(!test.getEmployee(10).getHireDate().equals(LocalDate.of(1981, 01, 01))) {
			System.out.println("updateHireDate() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateRecord(). An Employee object is added, and
	   * then the updateRecord method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Record Date is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateRecordDate() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateRecordDate(10, LocalDate.of(1981, 01, 01));
		if(!test.getEmployee(10).getRecordDate().equals(LocalDate.of(1981, 01, 01))) {
			System.out.println("updateRecordDate() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateTitle(). An Employee object is added, and
	   * then the updateTitle method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Title is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateTitle() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateTitle(10, "boss");
		if(!test.getEmployee(10).getJobTitle().equals("boss")) {
			System.out.println("updateTitle() failed.");
			return false;
		}
		return true;
	}
	 /** This method tests updateGender(). An Employee object is added, and
	   * then the updateGender method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Gender is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateGender() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateGender(10, "female");
		if(!test.getEmployee(10).getGender().equals("female")) {
			System.out.println("updateGender() failed.");
			return false;
		}
		return true;
	}
	/** This method tests updateStatus(). An Employee object is added, and
	   * then the updateStatus method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Status is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateStatus() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.setStatus(10, "fired");
		if(!test.getEmployee(10).getStatus().equals("fired")) {
			System.out.println("updateStatus() failed.");
			return false;
		}
		return true;
	}
	/** This method tests updateUnit(). An Employee object is added, and
	   * then the updateUnit method is called with the object ID at the param.
	   * The getEmployee method is then called to see if the Business Unit is updated.
	   * <p>
	   * @return true when the test passes, false and sends message when fails.
	   */
	public static boolean testUpdateBusinessUnit() {
		EmployeeDatabase test = new EmployeeDatabase();
		test.addEmployee(10, "Bob", dob, recordDate, hireDate, "intern", "male", "active", "Business");
		test.updateBusinessUnit(10, "Finance");
		if(!test.getEmployee(10).getBusinessUnit().equals("Finance")) {
			System.out.println("updateUnit() failed.");
			return false;
		}
		return true;
	}
	
}
