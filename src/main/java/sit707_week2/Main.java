package sit707_week2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Set up the path to the Chrome driver
    	System.setProperty("webdriver.chrome.driver", "C://Users//sandr//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");

        // Initialize a new WebDriver instance (Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Define the URL to navigate to (login page)
        String loginUrl = "https://www.bunnings.com.au/login";

        // Define the email and password for login (use valid credentials)
        String email = "sandriyafernandes35@gmail.com";
        String password = "San@1012";

        try {
            // Perform the login operation using SeleniumOperations class
            SeleniumOperations.login(driver, loginUrl, email, password);

            // Wait for a few seconds to allow page navigation (adjust as needed)
            Thread.sleep(3000);

            // After logging in, you can add additional operations such as navigating to other pages or interacting with other elements.
            
            // For demonstration purposes, print the current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login: " + currentUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser after use
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
