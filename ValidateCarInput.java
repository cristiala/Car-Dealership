import java.util.Scanner;

/**
 *  This class provides methods to validate various inputs related to car
 */
public class ValidateCarInput
{
    private Scanner scan = new Scanner(System.in);

    /**
     * Validates car input based on the specified request.
     * 
     * @param text the text to prompt the user for input
     * @param request the type of input being requested
     * @return the validated input
     */
    public String carInput(String text, String request)
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
                case "capacity":
                    return validateCapacity(input);
                case "availability":
                    return validateAvailability(input);
                case "condition":
                    return validateCondition(input);
                case "ID":
                    return validateID(input);
                case "year":
                    return validateYear(input);
                case "price":
                    return validatePrice(input);
                case "transmission":
                    return validateTransmission(input);
                case "vin":
                    return validateVIN(input);
                case "fuel type":
                    return validateFuelType(input);
                case "turbo":
                    return validateTurbo(input);
                case "car type":
                    return validateCarType(input);
                default:
                    return false;

            }    
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates the capacity input.
     * 
     * @param input the input to validate
     * @return if the input is valid, false otherwise
     */
    private boolean validateCapacity(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if(newInput<1 || newInput>10)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Validates the availability input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateAvailability(String input)
    {
        
        try {
            int newInput = Integer.parseInt(input);
            if(newInput<0)
                return false;
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates the condition input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateCondition(String input)
    {
        return (input.equalsIgnoreCase("used") || 
        input.equalsIgnoreCase("new"));
    }

    /**
     * Validates the ID input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
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
     * Validates the year input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateYear(String input)
    {
        try{
            int newInput = Integer.parseInt(input);
            if (newInput<1960 || newInput>=2024)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Validates the price input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validatePrice(String input)
    {
        try{
            double newInput = Double.parseDouble(input);
            if(newInput<=1000)
                return false;
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Validates the transmission input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateTransmission(String input)
    {
        return (input.equalsIgnoreCase("automatic") ||
        input.equalsIgnoreCase("manual"));
    }

    /**
     * Validates the VIN input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateVIN(String input)
    {
        return input.length()>=15;
    }

    /**
     * Validate the car type input
     * 
     * @param input the input to validate
     * @return true if the inpout is valid, false otherwise
     */
    private boolean validateCarType(String input)
    {
        return (input.equalsIgnoreCase("sedan") || 
        input.equalsIgnoreCase("suv") ||
        input.equalsIgnoreCase("hatchback") ||
        input.equalsIgnoreCase("pickup"));
    }

    /**
     * Validates the fuel type input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateFuelType(String input)
    {
        return (input.equalsIgnoreCase("gasoline") ||
        input.equalsIgnoreCase("diesel") ||
        input.equalsIgnoreCase("hybrid") ||
        input.equalsIgnoreCase("electric"));
    }

    /**
     * Validates the turbo input.
     * 
     * @param input the input to validate
     * @return true if the input is valid, false otherwise
     */
    private boolean validateTurbo(String input)
    {
        return (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no"));
    }
}
