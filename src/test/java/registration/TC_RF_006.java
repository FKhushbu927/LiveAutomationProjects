package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_006 {

    @Test
    public void verifyRegisterAccountSayingNoToNewsLetter() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("khushbu");
        driver.findElement(By.id("input-lastname")).sendKeys("Fatema");
        driver.findElement(By.id("input-email")).sendKeys(generateGmail());
        driver.findElement(By.id("input-telephone")).sendKeys("787655342");
        driver.findElement(By.id("input-password")).sendKeys("@#Khushbu1234");
        driver.findElement(By.id("input-confirm")).sendKeys("@#Khushbu1234");

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//div[@class='buttons']//a[text()='Continue']")).click();

        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());

        driver.quit();
    }


    public String generateGmail() {
        Date date = new Date();
        String stringDate = date.toString();
        String noSpaceStringDate = stringDate.replaceAll("\\s", "");
        String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");
        String lowercaseString = noColonStringDate.toLowerCase();
        String gmailWithTimeStamp = lowercaseString + "@gmail.com";
        return gmailWithTimeStamp;
    }
}
