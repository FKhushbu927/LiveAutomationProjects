package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_004 {

    WebDriver driver;
    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void verifyResistrationWithoutFillingMandatoryFields() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");


        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // driver.findElement(By.xpath("//div[@class='buttons']//input[@value='Continue']")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
        String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
        String expectedGmailWarning = "E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
        String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
        String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedGmailWarning);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);


        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedPrivacyPolicyWarning);

        driver.quit();
    }
}
