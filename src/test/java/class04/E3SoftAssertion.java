package class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;

public class E3SoftAssertion extends CommonMethods {

    // put pre-condition for the test case in the @beforeMethod
    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndNavigate() {
      openBrowserAndLaunchApplication("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22","chrome");
    }

    // put @AfterMethod after post conditions
    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        if (driver != null) {
            driver.close();
        }
    }

    // login into syntax HRMS application
    //verify that the welcome message  is displayed
    //verify that the message is "Welcome Admin"
    @Test(groups = "regression")
    public void verifyTheErrorMessage() {
        //send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        //send password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm12");
        //click on logIn
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        //get the message
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        String actualWelcomeText = welcomeMessage.getText();

        //verify is displayed
        boolean isDisplayed = welcomeMessage.isDisplayed();
        SoftAssert soft= new SoftAssert();
       // isDisplayed = false;
        soft.assertTrue(isDisplayed);

        System.out.println("still executing......");

        //verify the message is Welcome Admin
        String expectedWelcomeText = "Welcome Admin";
        soft.assertEquals(actualWelcomeText, expectedWelcomeText);

        soft.assertAll();

    }
}