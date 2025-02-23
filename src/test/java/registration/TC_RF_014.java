package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_014 {

    @Test
    public void verifyAsteriskSignAndColorOfMandatoryFieldsForRegisterAcc() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String expectedContent = "\"* \"";
        String expectedColor = "rgb(255, 0, 0)";


        WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String firstNameContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
        String firstNameColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
        System.out.println(firstNameContent);
        System.out.println(firstNameColor);

        Assert.assertEquals(firstNameContent, expectedContent);
        Assert.assertEquals(firstNameColor, expectedColor);

        WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        String lastNameContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
        String lastNameColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);


        Assert.assertEquals(lastNameContent, expectedContent);
        Assert.assertEquals(lastNameColor, expectedColor);


        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        String emailContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
        String emailColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);


        Assert.assertEquals(emailContent, expectedContent);
        Assert.assertEquals(emailColor, expectedColor);


        WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        String telephoneContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephoneLabel);
        String telephoneColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephoneLabel);


        Assert.assertEquals(telephoneContent, expectedContent);
        Assert.assertEquals(telephoneColor, expectedColor);


        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        String passwordContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordLabel);
        String passwordColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordLabel);


        Assert.assertEquals(passwordContent, expectedContent);
        Assert.assertEquals(passwordColor, expectedColor);


        WebElement passwordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
        // JavascriptExecutor jse = (JavascriptExecutor)driver;
        String passConfirmContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordConfirmLabel);
        String passConfirmColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordConfirmLabel);


        Assert.assertEquals(passConfirmContent, expectedContent);
        Assert.assertEquals(passConfirmColor, expectedColor);
        System.out.println("Password Confirm content" + passConfirmContent);
    }
}
