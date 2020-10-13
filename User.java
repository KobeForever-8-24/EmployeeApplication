// --== CS400 File Header Information ==--
// Name: Deming Xu
// Email: dxu227@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: No note

/**
 * User Class
 *
 * @author Deming Xu
 */
public class User {
    private String username;            // username
    private String passwordEncrypted;   // password after encryption
    private boolean isAdmin;            // whether the user is an administrator

    /**
     * user constructor
     *
     * @param username
     * @param passwordEncrypted
     * @param isAdmin
     */
    public User(String username, String passwordEncrypted, boolean isAdmin) {
        this.username = username;
        this.passwordEncrypted = passwordEncrypted;
        this.isAdmin = isAdmin;
    }

    /**
     * get method for username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set method for username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get method for password encrypted
     *
     * @return passwordEncrypted
     */
    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    /**
     * set method for password encrypted
     *
     * @param passwordEncrypted
     */
    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    /**
     * check whether the user is admin
     *
     * @return true if the user is admin, false if not
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * set method for admin
     *
     * @param admin
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
