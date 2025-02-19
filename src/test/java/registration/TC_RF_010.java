package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TC_RF_010 {


    @Test
    public void verifyingRegisterAccUsingInvalidEmail() throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("khushbu");
        driver.findElement(By.id("input-lastname")).sendKeys("Fatema");
        driver.findElement(By.id("input-email")).sendKeys("fkhushbu");
        driver.findElement(By.id("input-telephone")).sendKeys("0581199");
        driver.findElement(By.id("input-password")).sendKeys("@#Khushbu1234");
        driver.findElement(By.id("input-confirm")).sendKeys("@#Khushbu1234");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(3000);

        File srcScreenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(srcScreenShot1, new File(System.getProperty("user.dir") + "\\Screenshots\\ActualScrnShot.png"));


    }
}
