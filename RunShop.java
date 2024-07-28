import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 * The RunSop class is where we have our main method, therefore, is where
 * we start to run the dealership.
 */
public class RunShop 
{
    /**
     * Scan stays as a constant since having multiple scanners can
     * lead to errors
     */
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Just one object of UserAuthentication to simplify the code
     */
    private static final UserAuthentication authenticate;

    /**
     * The list of users will remain the same throughout the program
     */
    private static List<User> users;

    /**
     * The list of cars remain the same throughout the program
     */
    private static List<Car> cars;

    /**
     * Logger
     */

    private static final Log logger = new Log();
    /**
     * car data file path
     */
    private static String car_data_file = "updatedCarData.csv";

    /**
     * use data file path
     */
    private static String user_data_file = "updated_user_data.csv";

    static
    {
        /** 
        * Loading all the users from the csv file 
        */
        UserDataLoad loadU = new UserDataLoad();
        users = loadU.loadData(user_data_file);
        authenticate = new UserAuthentication(users);

        /** 
        * Loading all the cars from the csv file 
        */
        CarDataLoad loadC = new CarDataLoad();
        cars = loadC.loadData(car_data_file);
    }

    /**
     * This method is the starting point of the whole program. Here is where the user
     * will start interacting with the car delearship
     * 
     * @throws InputMismatchException if the user inputs a string/char that cannot be
     *                                converted to an int 
     * @param args takes in strings
     */
    public static void main(String[] args)
    {  
        
        boolean inSystem = true;
        while(inSystem)
        {
            System.out.println("Welcome to MineCars!");
            System.out.println("Please choose one of the following:");
            System.out.println("1. Login");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.println("Select either 1, 2 or 3 please type it:");

            try 
            {
                int choice = scan.nextInt();
                System.out.println();

                switch (choice) {
                    case 1:
                        userLogin();
                        break;
                    case 2:
                        adminLogin();
                        break;
                    case 3:
                        System.out.println("Exiting program...");
                        inSystem = false;
                        break;
                    default:
                        throw new MenuException("Invalid option selected. Please select 1, 2, or 3.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid, please enter a number."); // prompts if user enters something other than a number
                scan.nextLine();
            }
            catch(MenuException e){
                System.out.println(e.getMessage());
            }
            System.out.println();
        }


    }

    /**
     * Asks the user to input username and password
     * Verifires them using veryCredentials()
     */
    public static void userLogin()
    {
        scan.nextLine();
        boolean verified = false;
        int attempts = 0;
        while(attempts < 10 && !verified) // limits sign in attempts
        {
            System.out.println("Username: ");
            String usernameIN = scan.nextLine();
            System.out.println("Password: ");
            String passwordIn = scan.nextLine();
            if(authenticate.verifyCredentials(usernameIN, passwordIn))
            {
                System.out.println();
                System.out.println("Welcome " + usernameIN);
                verified = true;
                logger.writeToLog("Logged in", authenticate.getCurrentUser()); // updates log in action to dealership_log.txt
                new UserMenu(cars, users, authenticate.getCurrentUser(), user_data_file, car_data_file).MenuDisplay();                
            }
            else 
                System.out.println("Username or password is incorrect. Please try again.");
            attempts++;
        }
    }

    /**
     * The login process for an admin user and displays the admin menu.
     */
    public static void adminLogin()
    {
        scan.nextLine();
        logger.writeToLog("Logged in");
        List<Car> purchasedCarsByUsers = new ArrayList<>(); 
        new AdminMenu(cars, users, user_data_file, car_data_file, purchasedCarsByUsers).MenuDisplay();
    }
    
}

