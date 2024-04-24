
package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumOperations {
    public static void login(WebDriver driver, String url, String email, String password) {
        // Navigate to the login page
        driver.get(url);
        
        // Locate and enter email and password
        WebElement emailInput = driver.findElement(By.id("okta-signin-username"));
        emailInput.sendKeys(email);
        
        WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
        passwordInput.sendKeys(password);
        
        // Click the login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();
        
        // Add a sleep statement if necessary to allow time for page navigation
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isErrorDisplayed(WebDriver driver) {
        // Check for error message on the page
        // Adjust the locator based on the actual error message element
        try {
            WebElement errorMessage = driver.findElement(By.id("error-message-id"));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

   
}
