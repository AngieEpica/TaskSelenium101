package lambdaDemo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario2 extends BaseTest{
	
	@Test
	public void slide15To95() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//click “Drag & Drop Sliders”.
	    WebElement sliderLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Drag & Drop Sliders")));
	    sliderLink.click();
		//2. Select the slider “Default value 15” and drag the bar to make it 95 by
		//validating whether the range value shows 95.

	    WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='15']")));
	    WebElement rangeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rangeSuccess"))); 
	    
		 
		Actions action = new Actions(driver);			  
		action.dragAndDropBy(slider, 215, 0).perform();
		Thread.sleep(200); 
		 
			 
	    wait.until(ExpectedConditions.textToBe(By.id("rangeSuccess"), "95"));
		String value = rangeValue.getText();
		System.out.println("Slider value: " + value);
		Assert.assertEquals(value, "95", "Slider value is 95");

	}
	
	

}
