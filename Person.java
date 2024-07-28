/**
 * The Person class is the superclass of User and Admin, since both will be sharing
 * a username and a password. 
 */
public class Person 
{
    private String username;
    private String password;

    /**
     * Constructs the Person object 
     * 
     * @param username the username of the person
     * @param password the password of the person
     */
    public Person(String username, String password){
        this.username = username;
        this.password = password;
    } 

    /**
     * Sets the username of a person
     * @param nameIn the new username of the new person obj
     */ 
    public void setUsername(String nameIn) 
    {
        this.username = nameIn;
    }

    /**
     * Sets the password of a person
     * @param passwordIn the new password of the new person obj
     */
    public void setPassword(String passwordIn) 
    {
        this.username = passwordIn;
    }


    /**
     * Returns the username of the given person
     * @return the username
     */
    public String getUsername() 
    {
        return username;
    }

    /**
     * Returns the password of the given person
     * @return the password
     */
    public String getPassword() 
    {
        return password;
    }

}   

