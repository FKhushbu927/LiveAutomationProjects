package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_013 {

    @Test
    public void verifyPlaceholderOfRegisterAccForm(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String expectedFirstNamePlaceholderText ="First Name";
        Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),expectedFirstNamePlaceholderText);

        String expectedLastNamePlaceholderText = "Last Name";
        Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),expectedLastNamePlaceholderText);

        String expectedEmailPlaceholderText = "E-Mail";
        Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),expectedEmailPlaceholderText);

        String expectedTelephonePlaceholderText = "Telephone";
        Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelephonePlaceholderText);

        String expectedPasswordPlaceholderText = "Password";
        Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expectedPasswordPlaceholderText);

        String expectedConfirmPasswordPlaceholderText = "Password Confirm";
        Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedConfirmPasswordPlaceholderText);

        driver.quit();
    }
}
