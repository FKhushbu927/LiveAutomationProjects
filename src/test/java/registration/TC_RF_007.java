package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_007 {
    @Test
    public void verifyDifferentWaysToNavigateRegisterAccountPage() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());


    }
}
