package lambdaDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


/* BaseTest Class
    1. Open LambdaTest’s Selenium Playground from
    https://www.lambdatest.com/selenium-playground 
*/

public class TestScenario1 extends BaseTest {

	@Test
	public void testSimple() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//2. Click “Simple Form Demo”.
		WebElement simpleFormLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Simple Form Demo")));
		simpleFormLink.click();
		
		//3. Validate that the URL contains “simple-form-demo”.
		 wait.until(ExpectedConditions.urlContains("simple-form-demo"));
		Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));
		//4. Create a variable for a string value, e.g., “Welcome to LambdaTest”.
	    String message = "ScenarioTest 1: Welcome to LambdaTest";
	    //5. Use this variable to enter values in the “Enter Message” text box.
	    WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-message")));
	    messageInput.sendKeys(message);
	    //6. Click “Get Checked Value”.
	    WebElement showButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("showInput")));
	    showButton.click();
	    // 7. Validate whether the same text message is displayed in the right-hand
	    //panel under the “Your Message:” section.
	    WebElement displayedMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
	    String displayedMessage = displayedMessageElement.getText();
	    System.out.println("Message " + displayedMessage);
	    Assert.assertEquals(displayedMessage, message);
	    
	}
	
}
