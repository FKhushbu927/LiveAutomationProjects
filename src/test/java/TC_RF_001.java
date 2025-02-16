import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {


    @Test
    public void verifyRegistrationFunctionality() {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo");

        driver.findElement(By.xpath("//span[text()= 'My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Fatema");
        driver.findElement(By.id("input-lastname")).sendKeys("Khushbu");
        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("123456789");
        driver.findElement(By.id("input-password")).sendKeys("@#1234");
        driver.findElement(By.id("input-confirm")).sendKeys("@#1234");

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String expeectedHeading = "Your Account Has Been Created!";

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expeectedHeading);

        String successContentPara1 = "Congratulations! Your new account has been successfully created!";
        String successContentPara2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String successContentPara3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String successContentPara4 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

        String successContentParaLink = "contact us";

        String expectedSuccessContent = driver.findElement(By.id("content")).getText();

        Assert.assertTrue(expectedSuccessContent.contains(successContentPara1));
        Assert.assertTrue(expectedSuccessContent.contains(successContentPara2));
        Assert.assertTrue(expectedSuccessContent.contains(successContentPara3));
        Assert.assertTrue(expectedSuccessContent.contains(successContentPara4));
        Assert.assertTrue(expectedSuccessContent.contains(successContentParaLink));

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

        driver.quit();

    }

    public String generateEmail() {
        Date date = new Date();
        String dateString = date.toString();
        String noSpaceDateString = dateString.replaceAll("\\s", "");
        String noSpaceAndNoColonsDateString = noSpaceDateString.replaceAll("\\:", "");

        String emailWithTimeStamp = noSpaceAndNoColonsDateString + "khushbu@gmail.com";
        System.out.println(emailWithTimeStamp);
        return emailWithTimeStamp;

    }
}
