package sit707_week2;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
	public MainTest() {
		System.out.println("MainTest");
	}
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the Chrome driver path
    	System.setProperty("webdriver.chrome.driver", "C://Users//sandr//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");

        
        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
	public void testStudentIdentity() {
		String studentId = "s223561446";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Sandriya Fernandes";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testValidEmailValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "sandriyafernandes35@gmail.com", "San@1012");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Expected URL after successful login", "https://www.bunnings.com.au", currentUrl);
    }

    @Test
    public void testInvalidEmailValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "invalidEmail@gmail.com", "San@1012");
        
        // Check expected result (error message, no URL change, etc.)
        // For example, you may want to verify an error message is displayed
        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }

    @Test
    public void testInvalidEmailInValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "invalidEmail@gmail.com", "San012");
        
        // Check expected result (error message, no URL change, etc.)
        // For example, you may want to verify an error message is displayed
        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }
    
    @Test
    public void testValidEmailInValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "sandriyafernandes35@gmail.com", "San012");

        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }
    
    
    @Test
    public void testEmptyEmailValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "", "San@1012");

        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }
    
    @Test
    public void testValidEmailEmptyPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "sandriyafernandes35@gmail.com ", "");
        
        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }
    
    @Test
    public void testEmptyEmailEmptyPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "", "");
        
        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }
    
    @Test
    public void testInvalidEmailFormatValidPassword() {
        // Call Selenium operation to perform login
        SeleniumOperations.login(driver, "https://www.bunnings.com.au/login", "abc#gmail.com", "San@1012");
        
        boolean isErrorDisplayed = SeleniumOperations.isErrorDisplayed(driver);
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed);
    }

    
}

