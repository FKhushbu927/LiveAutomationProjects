package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_016 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyRegisterAccountWithPasswordComplexity() {
        System.out.println("Running test case...");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();


        driver.findElement(By.id("input-firstname")).sendKeys("Fatema");
        driver.findElement(By.id("input-lastname")).sendKeys("Jannat");
        driver.findElement(By.id("input-email")).sendKeys(generateGmail());
        driver.findElement(By.id("input-telephone")).sendKeys("12345676");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningMessage = "Password entered is not matching with the Complexity standards";

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedWarningMessage);
        Assert.assertFalse(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String generateGmail() {
        Date date = new Date();
        System.out.println(date);
        String stringDate = date.toString();
        System.out.println(stringDate);
        String noSpaceStringDate = stringDate.replaceAll("\\s", "");
        String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");
        String lowercaseString = noColonStringDate.toLowerCase();
        String gmailWithTimeStamp = lowercaseString + "@gmail.com";
        //System.out.println(gmailWithTimeStamp);
        return gmailWithTimeStamp;
    }
}
