package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;

import java.time.Duration;

public class E2HardAssertions extends CommonMethods {
    //    goto HRMS
//    enter username
//    enter wrong password
//    click on login
//    verify that the error message "Invalid credentials" is displayed
//    also confirm that the error message is Displayed

public static WebDriver driver;

    // put pre-condition for the test case in the @beforeMethod
    @BeforeMethod
    public  void openBrowserAndNavigate(){
        openBrowserAndLaunchApplication("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22","chrome");
    }


    // post conditions
    @AfterMethod
    public void quitBrowser() {
        driver.close();
    }

    //test case 1:
    @Test
    public  void verifyTheErrorMessage(){
        //send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        //send password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm1231");
        //click on logIn
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        //get the error message
        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
        String actualErrorMessage = errorMessage.getText();
        String exceptedErrorMessage = "Invalid credentials";

        // comparing two strings, which assertion to useE1HardAssertions
        Assert.assertEquals(actualErrorMessage, exceptedErrorMessage);

        //check that assertion no 2 is running or not
        System.out.println("check that assertion no 2 is running or not ");

        //check if it displayed
        boolean errorMessageIsDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(errorMessageIsDisplayed);


    }

}
