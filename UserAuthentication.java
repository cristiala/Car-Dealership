import java.util.List;

/**
 * Handles user authentication by verifying credentials, as well as
 * providing access to current user
 */
public class UserAuthentication 
{
    private List<User> users;
    private User currentUser;

    /**
     * Constructs new UserAuthentication object with list of users
     * 
     * @param users list of users to authenicate from
     */
    public UserAuthentication(List<User> users)
    {
        this.users = users;
    }

    /**
     * Verifies credentials of user with given username and password
     * 
     * @param usernameIN username being entered
     * @param passwordIN password being entered
     * @return True if credentials are valid, and false otherwise
     */
    public boolean verifyCredentials(String usernameIN, String passwordIN)
    {
        for(User user : users)
        {
            if(user.getUsername().equals(usernameIN) && user.getPassword().equals(passwordIN)) // if username and password match file info
            {
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    /**
     * Retrieves currently authenicated user
     * 
     * @return current user that has been authenticated, null if no user is
     * authenicated
     */
    public User getCurrentUser() 
    {
        return currentUser;
    }

}
