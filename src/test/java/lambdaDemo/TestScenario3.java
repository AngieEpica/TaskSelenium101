package lambdaDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class TestScenario3 extends BaseTest{
    @Test
    public void inputFormSubmitTest() {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // 1. Open page and click "Input Form Submit"
    WebElement inputFormLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Input Form Submit")));
    inputFormLink.click();
	//2. Click “Submit” without filling in any information in the form.
    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='seleniumform']/div[6]/button")));
    submitButton.click();

    // 3. Assert “Please fill out this field.” error message.
   
    WebElement nameField = driver.findElement(By.name("name"));
    String validationMsg = nameField.getAttribute("validationMessage");
    //English or Spanish
    boolean isValid = validationMsg.contains("Please fill out this field") || validationMsg.contains("Completa este campo");

    Assert.assertTrue(isValid, "Validation message: " + validationMsg);

    // 4. Fill in Name, Email, and other fields.
    driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Angeles");
    driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys("pruebasLambatest@gmail.com");
    driver.findElement(By.xpath("//*[@id='inputPassword4']")).sendKeys("PruebaLamba123");
    driver.findElement(By.xpath("//*[@id='company']")).sendKeys("LAMBDATEST");
    driver.findElement(By.xpath("//*[@id='websitename']")).sendKeys("www.LAMBDTEST.com");
    driver.findElement(By.xpath("//*[@id='inputCity']")).sendKeys("Torreon");
    driver.findElement(By.xpath("//*[@id='inputAddress1']")).sendKeys("Calle B");
    driver.findElement(By.xpath("//*[@id='inputAddress2']")).sendKeys("Calle C");
    driver.findElement(By.xpath("//*[@id='inputState']")).sendKeys("State");
    driver.findElement(By.xpath("//*[@id='inputZip']")).sendKeys("28012");

    //5. From the Country drop-down, select “United States” using the text
    //property.
    WebElement countryDropdown = driver.findElement(By.xpath("//*[@id='seleniumform']/div[3]/div[1]/select"));
    Select selectCountry = new Select(countryDropdown);
    selectCountry.selectByVisibleText("United States");

    //6. Fill in all fields and click “Submit”.
    submitButton.click();

    //7. Once submitted, validate the success message “Thanks for contacting
    //us, we will get back to you shortly.” on the screen.
    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id='__next']/div/section[2]/div/div/div/div/p")));
    
    Assert.assertTrue(successMessage.isDisplayed(), "Success message is displayed");
    System.out.println("Mensaje de éxito: " + successMessage.getText());
    }
}
