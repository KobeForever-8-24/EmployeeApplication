 // --== CS400 File Header Information ==--
// Name: Dawson Bauer
// Email: djbauer2@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
public class TestLogInDatabase {

  public static void main (String[] args) {
	  if(testLogIn()){
		  System.out.println("testLogIn: success");
	  }
	  if(testLogInFail()){
		  System.out.println("testLogInFail: success");
	  }
	  if(testAddUser()){
		  System.out.println("testAddUser: success");
	  }
	  if(testIsUserExist()){
		  System.out.println("testIsUserExist: success");
	  }
	  if(testIsUserExistFalse()){
		  System.out.println("testIsUserExistFalse: success");
	  }
	  if(testIsAdmin()){
		  System.out.println("testIsAdmin: success");
	  }
	  if(testIsAdminFalse()){
		  System.out.println("testIsAdminFalse: success");
	  }
	}

 /** This method tests logIn(). A user is added is added, and the 
   * logIn() is used to check if the user can log in. The method should
   * return true.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testLogIn() {
	  LogInAndRegister test = new LogInAndRegister();
	  test.addUser("username", "password", true);
	  if (!test.logIn("username", "password")) {
		  System.out.println("logIn() failed.");
		  return false;
	  }
	  return true;
  }
 /** This method tests logIn(). The logIn() is used to check if the 
   * user can log in and there is no user in the database. The method should
   * return false.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testLogInFail() {
	  LogInAndRegister test = new LogInAndRegister();
	  if (test.logIn("username", "password")) {
		  System.out.println("logIn() should have failed but didn't.");
		  return false;
	  }
	  return true;
  }
 /** This method tests if a user can be added to the database. The addUser
   * method should return true if the user is added.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testAddUser() {
	  LogInAndRegister test = new LogInAndRegister();
	  if (!test.addUser("username", "password", true)) {
		  System.out.println("addUser() failed.");
		  return false;
	  }
	  return true;
  }
 /** This method tests the isUserExist method. A user is added to the 
   * database. The isUserExist method should return true if the user
   * is in the database.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testIsUserExist() {
	  LogInAndRegister test = new LogInAndRegister();
	  test.addUser("username", "password", true);
	  if(!test.isUserExist("username")) {
		  System.out.println("isUserExist() failed.");
		  return false;
	  }
	  return true;
  }
 /** This method tests the isUserExist method. No user is added to the 
   * database. The isUserExist method should return false if no user
   * is in the database.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testIsUserExistFalse() {
	  LogInAndRegister test = new LogInAndRegister();
	  if(test.isUserExist("username")) {
		  System.out.println("isUserExist() should have failed.");
		  return false;
	  }
	  return true;
  }
 /** This method tests the isAdmin method. A user is added to the 
   * database with true in the param for the Admin param of addUser().
   * isAdmin() should return true.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */
  public static boolean testIsAdmin() {
	  LogInAndRegister test = new LogInAndRegister();
	  test.addUser("username", "password", true);
	  if(!test.isUserExist("username")) {
		  System.out.println("isUserExist() failed.");
		  return false;
	  }
	  return true;
  }
 /** This method tests the isAdmin method. A user is added to the 
   * database with false in the param for the Admin param of addUser().
   * isAdmin() should return false.
   * <p>
   * @return true when the test passes, false and sends message when fails.
   */

  public static boolean testIsAdminFalse() {
	  LogInAndRegister test = new LogInAndRegister();
	  test.addUser("username", "password", false);
	  if(test.isAdmin("username")) {
		  System.out.println("isAdmin() should have failed but didn't.");
		  return false;
	  }
	  return true;
  }
}
