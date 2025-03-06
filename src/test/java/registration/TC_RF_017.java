package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_RF_017 {


    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void verifyRegiAccFieldsHeightWidthAlignment(){

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();


        String expectedHeight = "34px";
        String expectedWidth = "701.25px";

        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        String actualFirstNameFieldHeight = firstNameField.getCssValue("height");
        String actualFirstNameFieldWidth  = firstNameField.getCssValue("width");

        System.out.println(actualFirstNameFieldHeight );
        System.out.println(actualFirstNameFieldWidth);

        Assert.assertEquals(actualFirstNameFieldHeight,expectedHeight);
        Assert.assertEquals(actualFirstNameFieldWidth,expectedWidth);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));

        firstNameField.sendKeys("");
        continueBtn.click();

        firstNameField = driver.findElement(By.id("input-firstname"));

        String expectedFnWarning = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),expectedFnWarning);


        firstNameField.sendKeys("x");
        continueBtn.click();

        firstNameField = driver.findElement(By.id("input-firstname"));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());

        firstNameField.sendKeys("zy");
        continueBtn.click();
        firstNameField = driver.findElement(By.id("input-firstname"));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());


        firstNameField.sendKeys("xyxklshdgajshduiwegahb");
        continueBtn.click();
        firstNameField = driver.findElement(By.id("input-firstname"));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());

        firstNameField.sendKeys("aBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHi");
        continueBtn.click();
        //firstNameField = driver.findElement(By.id("input-firstname"));
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed());


        //-----------------------lastname
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));

        String actualLastNameFieldHeight = lastNameField.getCssValue("height");
        String actualLastNameFieldWidth  = lastNameField.getCssValue("width");

        Assert.assertEquals(actualLastNameFieldHeight,expectedHeight);
        Assert.assertEquals(actualLastNameFieldWidth,expectedWidth);


        lastNameField.sendKeys("");
//        continueBtn.click();
//        lastNameField = driver.findElement(By.id("input-lastname"));
//
//        String expectedLnWarning = "Last Name must be between 1 and 32 characters!";
//        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLnWarning);
//
//
//        lastNameField.sendKeys("x");
//        continueBtn.click();
//        lastNameField = driver.findElement(By.id("input-lastname"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
//
//        lastNameField.sendKeys("zy");
//        continueBtn.click();
//
//        lastNameField = driver.findElement(By.id("input-lastname"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
//
//
//        lastNameField.sendKeys("xyxklshdgajshduiwegahb");
//        continueBtn.click();
//        lastNameField = driver.findElement(By.id("input-lastname"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
//
//        lastNameField.sendKeys("aBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHi");
//        continueBtn.click();
//        lastNameField = driver.findElement(By.id("input-lastname"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed());
//
//        // email field
//
//        WebElement emailField = driver.findElement(By.id("input-email"));
//
//        String actualEmailFieldHeight = emailField.getCssValue("height");
//        String actualEmailFieldWidth  = emailField.getCssValue("width");
//
//        Assert.assertEquals(actualEmailFieldHeight,expectedHeight);
//        Assert.assertEquals(actualEmailFieldWidth,expectedWidth);
//
//        emailField.sendKeys("");
//        continueBtn.click();
//        emailField = driver.findElement(By.id("input-email"));
//        String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
//        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedEmailWarning);
//
//
//        emailField.sendKeys("x@gmail.com");
//        continueBtn.click();
//
//        emailField = driver.findElement(By.id("input-email"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
//
//        emailField.sendKeys("zy@gmail.com");
//        continueBtn.click();
//        emailField = driver.findElement(By.id("input-email"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
//
//
//        emailField.sendKeys("xyxklshdgajshduiwegahb@gmail.com");
//        continueBtn.click();
//        emailField = driver.findElement(By.id("input-email"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
//
//        emailField.sendKeys("aBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHiaBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHiaBcDeFgHiJkLmNoPqRsTuVwXyZaBcDeFgHi@gmail.com");
//        continueBtn.click();
//        emailField = driver.findElement(By.id("input-email"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed());
//
//       // -----------------------telephone field
//        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
//
//        String actualTelephoneFieldHeight =  telephoneField.getCssValue("height");
//        String actualTelephoneFieldWidth  =  telephoneField.getCssValue("width");
//
//        Assert.assertEquals(actualTelephoneFieldHeight,expectedHeight);
//        Assert.assertEquals(actualTelephoneFieldWidth,expectedWidth);
//
//        telephoneField.sendKeys("");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//
//        String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
//        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);
//
//
//        telephoneField.sendKeys("12");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//        telephoneField.sendKeys("789");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//
//        telephoneField.sendKeys("34534578");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//        telephoneField.sendKeys("58392017465283910476583920174658");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//        telephoneField.sendKeys("583920174652839104765839201746586");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//        telephoneField.sendKeys("5839201746528391047658392017469876586");
//        continueBtn.click();
//        telephoneField = driver.findElement(By.id("input-telephone"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed());
//
//
//        //----------------password field
//        WebElement passwordField = driver.findElement(By.id("input-password"));
//
//        String actualPasswordFieldHeight =  passwordField.getCssValue("height");
//        String actualPasswordFieldWidth  = passwordField.getCssValue("width");
//
//        Assert.assertEquals(actualPasswordFieldHeight,expectedHeight);
//        Assert.assertEquals(actualPasswordFieldWidth,expectedWidth);
//
//        String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
//        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);
//
//        passwordField.sendKeys("");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//        passwordField.sendKeys("12");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//        passwordField.sendKeys("789");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//
//        passwordField.sendKeys("7890");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//
//
//        passwordField.sendKeys("34534578");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//        passwordField.sendKeys("58392017465283910476583920174658");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//        passwordField.sendKeys("583920174652839104765839201746586");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//        passwordField.sendKeys("5839201746528391047658392017469876586");
//        continueBtn.click();
//        passwordField = driver.findElement(By.id("input-password"));
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed());
//
//
//        WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
//
//        String actualConfirmPasswordFieldHeight = confirmPasswordField.getCssValue("height");
//        String actualConfirmPasswordFieldWidth  = confirmPasswordField.getCssValue("width");
//
//        Assert.assertEquals(actualConfirmPasswordFieldHeight,expectedHeight);
//        Assert.assertEquals(actualConfirmPasswordFieldWidth,expectedWidth);

    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
