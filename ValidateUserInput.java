import java.util.Scanner;

/**
 * This class provides methods to validate various inputs related to the user
 */
public class ValidateUserInput 
{
    private Scanner scan = new Scanner(System.in);

    /**
     * Validates user input based on the specified request.
     * 
     * @param text the text to prompt the user for input
     * @param request the type of input being requested
     * @return the validated input
     */
    public String userInput(String text, String request)
    {
        String input;
        do
        {
            System.out.println(text);
            input = scan.nextLine().trim();

            if(input.isEmpty())
            {
                System.out.println("Please enter a valid value.\n");
                continue;
            }
            if(!validateInput(input, request))
                System.out.println("Please enter a valid input.\n");
        }
        while(input.isEmpty() || !validateInput(input, request));
        return input;
    }

    /**
     * Validates the input based on the specified request.
     * 
     * @param input the input to validate
     * @param request request the type of input being requested
     * @return true if the input is valid, false otherwise
     */
    private boolean validateInput(String input, String request)
    {
        try 
        {
            switch (request) 
            {
                case "money":
                    return validateMoney(input);
                case "password":
                    return validatePassword(input);
                case "ID":
                    return validateID(input);
                case "cars purchased":
                    return validateCarsPurchased(input);
                case "username":
                    return validateUsername(input);
                case "membership":
                    return validateMembership(input);
                default:    
                    return false;
            }    
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates the money input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateMoney(String input)
    {
        try{
            double newInput = Double.parseDouble(input);
            if(newInput<0)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Validates the password input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validatePassword(String input)
    {
        if(input.length()<6)
        {
            System.out.println("Password needs to be at least 6 characters long.");
            return false;
        }
        return true;
    }

    /**
     * Validates the ID input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateID(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<=0)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Validates the car purchased input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateCarsPurchased(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<0)
                return false;
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * Validates the username input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateUsername(String input)
    {
        if(input.length()<3)
        {
            System.out.println("Username has to be at least 3 characters long");
            return false;
        }
        return true;
    }

    /**
     * Validates the membership input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateMembership(String input)
    {
        return (input.equalsIgnoreCase("true") ||
        input.equalsIgnoreCase("false"));
    }
}
