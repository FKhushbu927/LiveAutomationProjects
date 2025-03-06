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

public class TC_RF_018 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyLeadingAndTrailingSpacesOfRegistrationAcc() {

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String enteredFirstName = "   " + "Fatema" + "   ";
        driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstName);

        String enteredLastName = "  " + "Jannat" + "  ";
        driver.findElement(By.id("input-lastname")).sendKeys(enteredLastName);

        driver.findElement(By.id("input-email")).sendKeys(generateGmail());

        String enteredTelephone = " " + "9847012938" + "  ";
        driver.findElement(By.id("input-telephone")).sendKeys(enteredTelephone);

        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Edit your account information")).click();

        Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"), enteredFirstName.trim());
        Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"), enteredLastName.trim());

        Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"), enteredTelephone.trim());
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
        //System.out.println(gmailWithTimeStamp);
        return gmailWithTimeStamp;
    }
}
