package lambdaDemo;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;
//import org.testng.annotations.Test;

public class BaseTest {
	
	//protected WebDriver driver;
    protected ChromeOptions options;
    protected RemoteWebDriver driver=null;
    public String username = "angeles.cergon@gmail.com";
    public String accesskey = "LT_nQF5oVDxuclEiJb52QTqCi6NnImVAUgOMDBAwBC9fsVUX8D";
    public String gridURL = "@hub.lambdatest.com/wd/hub";
	
    @BeforeTest
    public void setupCapabilities() {
    	this.options = new ChromeOptions();
    	this.options.setCapability("platformName", "Windows 10");
    	this.options.setCapability("browserVersion", "latest");
    	this.options.setCapability("LT:Options", Map.of(
    			"build", "Java Codespace Build",
    			"name", "LambdaTest Selenium Example",
    			"video", true,
    			"network", true,
    			"console", true,
    			"visual", true
     ));}
    
    @BeforeMethod
    public void session() throws MalformedURLException {
        String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
        String hub = "https://" + encodedUsername + ":" + accesskey + gridURL;
        driver = new RemoteWebDriver(new URL(hub), options);
        System.out.println("RemoteWebDriver session ID: " + driver.getSessionId());

        driver.get("https://www.lambdatest.com/selenium-playground");
    }
    
	/*@BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //1. Open LambdaTest’s Selenium Playground from
        //https://www.lambdatest.com/selenium-playground
        driver.get("https://www.lambdatest.com/selenium-playground");
    }*/
	


	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void dummyTest() {
        System.out.println("Test de prueba");
    }

}
