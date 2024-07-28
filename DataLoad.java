import java.io.IOException;
import java.util.List;

/**
 * The interface for loading and updating data.
 * 
 * @param <T> The type of data to load and update
 */
public interface DataLoad<T> 
{
    /**
     * Loads data from the file.
     * 
     * @param filePath path of file to load
     * @return A list (of objects) containing loaded data
     * @throws IOException if error occurs while reading file
     */
    List<T> loadData(String filePath) throws IOException;

    
    /**
     * Updates the data in file.
     * 
     * @param data list of objects containing the updated data.
     * @param filePath the path of file to update.
     */
    void updateData(List<T> data, String filePath);

    String[] getHeaders(List<T> data, String filePath);
}