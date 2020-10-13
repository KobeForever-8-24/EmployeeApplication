// --== CS400 File Header Information ==--
// Name: Deming Xu
// Email: dxu227@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: No note

/**
 * Class that handles log in authentication and register
 *
 * @author Deming Xu
 */
public class LogInAndRegister {
    private HashTableMap<String, User> userTable;       // Hash table for user

    /**
     * Password encryption. Add every char in the String by 8
     *
     * @param password
     * @return encrypted password
     */
    private String encryption(String password){
        // convert String to char array
        char[] chars = password.toCharArray();
        // for every char, add 8 to encrypt
        for(int i=0;i<chars.length;i++){
            chars[i] += 8;
        }
        return String.valueOf(chars);
    }

    /**
     * default constructor
     */
    public LogInAndRegister() {
        userTable = new HashTableMap<>();
    }

    /**
     * log in authentication
     *
     * @param username
     * @param password
     * @return true if authentication granted, false if authencation failed
     */
    public boolean logIn(String username, String password){
        // check whether username exists in the database
        if(!isUserExist(username)){
            return false;
        }
        String encryptPasswd = encryption(password);        // encrypt the password
        // check whether the encrypted password math the one in the hashtable
        return userTable.get(username).getPasswordEncrypted().equals(encryptPasswd);
    }

    /**
     * Register helper
     *
     * @param username
     * @param password
     * @param isAdmin
     * @return true of registration success, false if username exists
     */
    public boolean addUser(String username, String password, boolean isAdmin){
        // determine whether username exists in the hash table
        if(!userTable.containsKey(username)) {
            User user = new User(username, encryption(password), isAdmin);      // create a user object
            userTable.put(username, user);          // add user object to the hashtable and return true
            return true;
        }else{
            return false;
        }
    }

    /**
     * check whether username exists
     *
     * @param username
     * @return true if username exists, false if not
     */
    public boolean isUserExist(String username){
        return userTable.containsKey(username);
    }

    /**
     * check whether user is an administrator
     *
     * @param username
     * @return true if the user is admin, false if not
     */
    public boolean isAdmin(String username){
        return userTable.get(username).isAdmin();
    }
}
