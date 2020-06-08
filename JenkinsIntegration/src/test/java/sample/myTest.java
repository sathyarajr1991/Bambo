package test.java.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class myTest{
    static Logger logger = Logger.getLogger(myTest.class.getName());
    public WebDriver driver;
    @Test()
    public void myTestExample1() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjarayht\\Cucumber\\JenkinsIntegration\\src\\main\\resource\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.care.com");
        driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).click();
        driver.findElement(By.id("emailId")).sendKeys("dkrupinski@gmail.com");
        driver.findElement(By.name("password")).sendKeys("letmein1");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        boolean isLoginSuccessful = false;
        if (driver.findElements(By.xpath("//button[contains(text(),'Log out')]")).size() > 0) {
            isLoginSuccessful = true;
        }
        Assert.assertEquals(isLoginSuccessful, true, "FAILED LOGIN STEP 1");
        driver.close();
    }
   }