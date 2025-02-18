package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_009 {

    @Test
    public void verfiyingRegisterAccUsingExistingEmailAdd() {


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("khushbu");
        driver.findElement(By.id("input-lastname")).sendKeys("Fatema");
        driver.findElement(By.id("input-email")).sendKeys("fkhushbu75@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("0581199");
        driver.findElement(By.id("input-password")).sendKeys("@#Khushbu1234");
        driver.findElement(By.id("input-confirm")).sendKeys("@#Khushbu1234");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String expectedWarningEmailAddMessage = "Warning: E-Mail Address is already registered!";

        Assert.assertEquals(driver.findElement(By.xpath(" //div[@class='alert alert-danger alert-dismissible']")).getText(), expectedWarningEmailAddMessage);

    }
}
