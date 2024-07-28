/**
 * Admin class extenteding person class, represents the admin of the 
 * car dealership
 */
public class Admin extends Person
{   
    private int employeeID;

    /**
     * Constructs Admin object
     * 
     * @param username admin username they use to sign in
     * @param password admin password they use to sign in
     * @param employeeID admin's employee ID
     */
    public Admin(String username, String password, int employeeID) 
    {
        super(username, password);
        this.employeeID = employeeID;
    }

    /**
     * Sets the employee ID
     * @param newID employee ID to be set
     */
    public void setEmployeeID(int newID)
    {
        employeeID = newID;
    }

    /**
     * Returns the employee ID
     * @return integer of the employee ID
     */
    public int getEmployeeID()
    {
        return employeeID;
    }
  
}
 