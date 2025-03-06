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

public class TC_RF_021 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyVisibilityTogglineOfPasswordFieldOnRegisterAccount() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"), "password");
        Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"), "password");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
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
        return gmailWithTimeStamp;
    }
}
