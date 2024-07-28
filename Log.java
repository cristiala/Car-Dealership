import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logs user actions to file such as time when user logged in, displayed all cars etc.
 */
public class Log 
{
    private static final String LOG_FIlE = "dealership_log.txt";

    /**
     * Writes the log entry to the log file
     * 
     * @param action the action performed by user
     * @param user the user that performed said action
     */
    public void writeToLog(String action, User user)
    {
        try(FileWriter fw = new FileWriter(LOG_FIlE,true))
        {
            String timeString =  new SimpleDateFormat("HH:mm:ss MM/dd/yy").format(new Date()); //  formats the time by hour, minute, second and month day year
            fw.write(timeString + " - " + user.getUsername() +" "+ action + "\n");
        }
        catch(IOException e)
        {
            System.err.println("Error wrtitin to log file: "+ e.getMessage());  // error message
        }
    }

    /**
     * Writes the log entry to the log file when Admin uses the program.
     * 
     * @param action the action performed by the Admin
     */
    public void writeToLog(String action)
    {
        try(FileWriter fw = new FileWriter(LOG_FIlE,true))
        {
            String timeString =  new SimpleDateFormat("HH:mm:ss MM/dd/yy").format(new Date()); //  formats the time by hour, minute, second and month day year
            fw.write(timeString + " - " + "Admin" +" "+ action + "\n");
        }
        catch(IOException e)
        {
            System.err.println("Error wrtitin to log file: "+ e.getMessage());  // error message
        }
    }
}