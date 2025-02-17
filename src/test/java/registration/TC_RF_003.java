package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_003 {

    @Test
    public void verifyRegisterAccountWithAllFields() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");



        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("khushbu");
        driver.findElement(By.id("input-lastname")).sendKeys("Fatema");
        driver.findElement(By.id("input-email")).sendKeys(generateGmail());

        driver.findElement(By.id("input-telephone")).sendKeys("787655342");

        driver.findElement(By.id("input-password")).sendKeys("@#Khushbu1234");
        driver.findElement(By.id("input-confirm")).sendKeys("@#Khushbu1234");

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

        //input[@name='newsletter'][@value='0']


        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Assert.assertTrue(driver.findElement(By.));


        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
       // Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Account']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());


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

        //driver.quit();
    }

    public  String generateGmail(){
        Date date = new Date();
        System.out.println(date);
        String stringDate = date.toString();
        System.out.println(stringDate);
        String noSpaceStringDate = stringDate.replaceAll("\\s", "");
        String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");
        String lowercaseString = noColonStringDate.toLowerCase();
        String gmailWithTimeStamp = lowercaseString+"@gmail.com";
        //System.out.println(gmailWithTimeStamp);
        return gmailWithTimeStamp;
    }
}
