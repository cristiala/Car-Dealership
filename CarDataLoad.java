import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

/**
 * CarDataLoad reads through car_data csv and find and sets Car attributes
 * to variables
 */
public class CarDataLoad implements DataLoad<Car>
{

    /**
     * Loads car data from csv file.
     * 
     * @param file The path of the csv file to load data from.
     * @return A list containing Car objects loaded from the csv file
     */
    @Override
    public List<Car> loadData(String carFile)
    {
        List<Car> cars = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(carFile)))
        {
            String[] headers = br.readLine().split(",");
            
            String line = br.readLine();
            
            while(line != null)
            {
                if (line.trim().isEmpty())
                    continue; // Skip the empty line and move to the next

                Map<String, String> carInformation = new HashMap<>();

                String []details = line.split(",",-1);
                int i = 0;

                for(String header:headers)
                {
                    carInformation.put(header,details[i]);
                    i++;
                }
                
                Car car = CarFactory.createCar(carInformation);

                cars.add(car);
                line = br.readLine();
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public String[] getHeaders(List<Car> cars, String filePath)
    {
        String[] headers = null;
        try(BufferedReader br =  new BufferedReader(new FileReader(filePath)))
        {   
            headers = br.readLine().split(",");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return headers;
    }


    /**
     * Updates car data in csv file.
     * 
     * @param cars The list of Car objects containing updated data.
     * @param file The path of the csv file to update.
     */
    @Override
    public void updateData(List<Car> cars, String carFile)
    {
        String[] headers = getHeaders(cars, carFile);
        

        try(BufferedWriter wr = new BufferedWriter(new FileWriter(carFile)))
        {
            wr.write(String.join(",", headers)+"\n");

            for (Car car : cars) 
            {
                Map<String, String> carMap = car.toMap();
                List<String> info = new ArrayList<>();

                for (String header : headers)
                    info.add(carMap.getOrDefault(header, "Not found"));

                wr.write(String.join(",", info));
                wr.newLine();
            }
        }    
        catch (IOException e)
        {
            System.out.println("Error writing the new data");
        }
        
    }
}
