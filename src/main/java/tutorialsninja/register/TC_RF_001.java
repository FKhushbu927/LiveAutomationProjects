package tutorialsninja.register;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

       // <span class="hidden-xs hidden-sm hidden-md">My Account</span>

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


    }

    public static String generateEmail(){
        Date date = new Date();
        String dateString = date.toString();
        String noSpaceDateString = dateString.replaceAll("\\s", "");
        String noSpaceAndNoColonsDateString = noSpaceDateString.replaceAll("\\:", "");

        String emailWithTimeStamp = noSpaceAndNoColonsDateString+"fkhushbu@gmail.com";
        System.out.println(emailWithTimeStamp);
        return emailWithTimeStamp;

    }
}
