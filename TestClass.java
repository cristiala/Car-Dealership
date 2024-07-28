import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

public class TestClass {
    
    private List<Car> cars;
    private List<User> users;
    private User currentUser;
    private UserMenu userMenu;
    private AdminMenu adminMenu;
    private RegisterCarsPurchased registerMock;

    @BeforeEach
    public void setUp() {
        // cars and users based on the provided data
        cars = new ArrayList<>();
        cars.add(new Car(1, "SUV", "Toyota", "New", "Black", 5, 2022, "Gas", "Automatic", "VIN1234", 30000.0, 5, "Yes"));
        cars.add(new Car(2, "Sedan", "Honda", "New", "White", 4, 2021, "Gas", "Automatic", "VIN5678", 25000.0, 1, "No"));
        cars.add(new Car(3, "Truck", "Ford", "Used", "Blue", 6, 2019, "Diesel", "Automatic", "VIN91011", 35000.0, 1, "Yes"));

        
        users = new ArrayList<>();
        currentUser = new User(1, "John", "Doe", 5000.0, 0, false, "john", "password");

        // UserMenu with the loaded data
        userMenu = new UserMenu(cars, users, currentUser, "userFile", "carFile");

    }

    @Test
    void testCreateUserFromMap() {
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("Money Available", "5000.0");
        userInfo.put("Password", "test123");
        userInfo.put("Last Name", "Doe");
        userInfo.put("ID", "1");
        userInfo.put("Cars Purchased", "2");
        userInfo.put("First Name", "John");
        userInfo.put("Username", "johndoe");
        userInfo.put("MinerCars Membership", "true");

        User user = UserFactory.createUser(userInfo);

        assertNotNull(user);
        assertEquals(5000.0, user.getMoneyAvailable());
        assertEquals("test123", user.getPassword());
        assertEquals("Doe", user.getLastName());
        assertEquals(1, user.getID());
        assertEquals(2, user.getCarsPurchased());
        assertEquals("John", user.getFirstName());
        assertEquals("johndoe", user.getUsername());
        assertTrue(user.getMinerCarsMembership());
    }

    @Test
    public void testDisplayCars() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // call displayCars
        userMenu.displayCars("New");

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("Toyota") && output.contains("2022")); // Check if car details are in the output
        assertTrue(output.contains("New"));
    }

    

    @Test
    public void testViewTickets() {
        // add a purchased car to the currentUser's list
        currentUser.getPurchasedCars().add(cars.get(2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // call viewTickets
        userMenu.viewTickets();

        // that the printed output contains the ticket information
        assertTrue(outputStream.toString().contains("Car Type: Truck"));
        assertTrue(outputStream.toString().contains("Model: Ford"));
        assertTrue(outputStream.toString().contains("Color: Blue"));
    }

}
