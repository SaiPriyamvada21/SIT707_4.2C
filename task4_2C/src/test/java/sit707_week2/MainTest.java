package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebElement;
/**
 * @author Ahsan Habib
 */

public class MainTest {
	
	private WebDriver driver;
	
	public MainTest() {
		System.out.println("MainTest");
	}
	
	@Before
    public void setUp() {
        // Define the link to the Bunnings login page
        String loginPageURL = "https://www.bunnings.com.au/login";

        // Set up Selenium WebDriver for Microsoft Edge
        System.setProperty("webdriver.edge.driver", "D:\\EDGE DERIVER\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get(loginPageURL);
    }
	
	
  public static boolean isErrorDisplayed(WebDriver driver) {
	        
	        try {
	            WebElement errorMessage = driver.findElement(By.id("error-message-id"));
	            return errorMessage.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
  @Test
	public void testStudentIdentity() {
		String studentId = "s223711461";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "SAI PRIYAMVADA.K";
		Assert.assertNotNull("Student name is null", studentName);
	}
	@Test
	public void testSuccessfulLogin() {
	    WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));

	    usernameInput.sendKeys("Pri@gmail.com");
	    passwordInput.sendKeys("Pri21@gmail.com");
	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();

	    assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	
//	valid passeword
	@Test
	public void  testInvalidUsername () {
	    WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));

	    usernameInput.sendKeys("saipriyamv");
	    passwordInput.sendKeys("Pri21@gmail.com");

	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();

	    Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
	}
//	valid username
	
	@Test
	public void  testInvalidPassword () {
	    WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
	    usernameInput.sendKeys("Pri@gmail.com");
	    passwordInput.sendKeys("Priya");

	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();
	    Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
	}
	
	@Test
    public void testInvalidUsernameInValidPassword() {
		WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
	    usernameInput.sendKeys("saipriy");
	    passwordInput.sendKeys("Priya");

	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();
	   
        Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
    }
//	validpasssword
	@Test
	public void  testEmptyUsername () {
	    WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
	    usernameInput.sendKeys("");
	    passwordInput.sendKeys("Pri21@gmail.com");

	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();
	    Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
	}
//	valid username
	@Test
	public void  testEmptyPassword () {
	    WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
	    usernameInput.sendKeys("Pri@gmail.com");
	    passwordInput.sendKeys("");

	    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	    loginButton.click();
	    Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
	}
	  @Test
	    public void testEmptyUsernameEmptyPassword() {
		  	WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
		    WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
		    usernameInput.sendKeys("");
		    passwordInput.sendKeys("");

		    WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
		    loginButton.click();
		    Assert.assertTrue("Error message should be displayed", isErrorDisplayed(driver));
		}
	  @Test
	  public void testSpecialCharactersInUsernamePassword() {
	      WebElement usernameInput = driver.findElement(By.id("okta-signin-username"));
	      WebElement passwordInput = driver.findElement(By.id("okta-signin-password"));
	      
	     
	      usernameInput.sendKeys("!@#$%^&*()");
	      
	    
	      passwordInput.sendKeys("!@#$%^&*()");
	      
	      WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
	      loginButton.click();
	    
	      assertTrue("Error message should be displayed or URL should remain on login page", isErrorDisplayed(driver) || driver.getCurrentUrl().contains("login"));
	  }

	    
}
