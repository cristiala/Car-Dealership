import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * File to create new car and set car fields from file to variables.
 * This simplfies adding new cars by the admin
 */
public class CarFactory
{
    /**
     * Sets a new Car object based on the provided car information.
     * @param carInformation an array containing car information based on car file order
     * @return new car object
     */
    public static Car createCar(Map<String,String> carInformation)
    {
        int capacity = Integer.parseInt(carInformation.get("Capacity"));
        String carType = carInformation.get("Car Type");
        int carsAvailable = Integer.parseInt(carInformation.get("Cars Available"));
        String condition = carInformation.get("Condition");
        String color = carInformation.get("Color");
        int id = Integer.parseInt(carInformation.get("ID"));
        int year = Integer.parseInt(carInformation.get("Year"));
        double price = Double.parseDouble(carInformation.get("Price"));
        String transmission = carInformation.get("Transmission");
        String vin = carInformation.get("VIN");
        String fuelType = carInformation.get("Fuel Type");
        String model = carInformation.get("Model");
        String hasTurbo = carInformation.get("hasTurbo").isEmpty() ? "No" : carInformation.get("hasTurbo");

        switch (carType.toLowerCase())
         {
            case "sedan":
                return new Sedan(id,carType,model,condition,color,capacity,
                year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
            case "suv":
                return new SUV(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "hatchback":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            case "pickup":
                return new Hatchback(id, carType, model, condition, color, capacity,
                year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }

    /**
     * Gets car object based on the provided car information.
     * 
     * @param carInformation An ArrayList containing car information
     * @return The newly created Car object.
     */
    public static Car createCar(ArrayList<String> carInformation)
    {
        try
        {
            int capacity = Integer.parseInt(carInformation.get(0));
            String carType = carInformation.get(1);
            int carsAvailable = Integer.parseInt(carInformation.get(2));
            String condition = carInformation.get(3);
            String color = carInformation.get(4);
            int id = Integer.parseInt(carInformation.get(5));
            int year = Integer.parseInt(carInformation.get(6));
            double price = Double.parseDouble(carInformation.get(7));
            String transmission = carInformation.get(8);
            String vin = carInformation.get(9);
            String fuelType = carInformation.get(10);
            String model = carInformation.get(11);
            String hasTurbo = carInformation.get(12);

            switch (carType.toLowerCase())
            {
                case "sedan":
                    return new Sedan(id,carType,model,condition,color,capacity,
                    year,fuelType,transmission,vin,price,carsAvailable,hasTurbo);
                case "suv":
                    return new SUV(id, carType, model, condition, color, capacity,
                    year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
                case "hatchback":
                    return new Hatchback(id, carType, model, condition, color, capacity,
                    year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
                case "pickup":
                    return new Hatchback(id, carType, model, condition, color, capacity,
                    year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
                default:
                    throw new IllegalArgumentException("Invalid car type");
        }
        }
        catch(NumberFormatException e)
        {
            throw new IllegalArgumentException("Error passing information", e);
        }
    }
}