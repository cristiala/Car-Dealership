import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * File to create new user and store user fields in variables.
 * Simplifies addind new users to user file by admin. 
 */
public class UserFactory {
    /**
     * Sets a new User object based on the provided user information.
     * 
     * @param userInformation an array containing user information based on user file order
     * @return new user object
     */
    public static User createUser(Map<String,String> userInformation)
    {
        double moneyAvailable = Double.parseDouble(userInformation.get("Money Available"));
        String password = userInformation.get("Password");
        String lastname = userInformation.get("Last Name");
        int id = Integer.parseInt(userInformation.get("ID"));
        int carsPurchased = Integer.parseInt(userInformation.get("Cars Purchased"));
        String firstname = userInformation.get("First Name");
        String username = userInformation.get("Username");
        boolean minerCarsMembership = Boolean.parseBoolean(userInformation.get("MinerCars Membership"));

        return new User(id, firstname, lastname, moneyAvailable, carsPurchased, 
        minerCarsMembership, username, password);
    }

    /**
     * Gets User object based on the provided user information
     * 
     * @param userInformation An ArrayList containing user information
     * @return The newly created User object.
     */
    public static User createUser(ArrayList<String> userInformation)
    {
        try
        {
            double moneyAvailable = Double.parseDouble(userInformation.get(0));
            String password = userInformation.get(1);
            String lastname = userInformation.get(2);
            int id = Integer.parseInt(userInformation.get(3));
            int carsPurchased = Integer.parseInt(userInformation.get(4));
            String firstname = userInformation.get(5);
            String username = userInformation.get(6);            
            boolean minerCarsMembership = Boolean.parseBoolean(userInformation.get(7));

            return new User(id, firstname, lastname, moneyAvailable, carsPurchased, 
            minerCarsMembership, username, password);

        }
        catch(NumberFormatException e)
        {
            throw new IllegalArgumentException("Error passing information", e);
        }
        
    }
}
