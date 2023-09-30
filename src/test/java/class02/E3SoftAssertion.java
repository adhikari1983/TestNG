package class02;

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
/**The code snippet you provided is an @AfterMethod annotated method called quit(), which is defined in the
 E3SoftAssertion class. The @AfterMethod annotation is used in TestNG to indicate that the annotated method
 should be executed after each test method.

 In the quit() method, driver.close() is called. The close() method is provided by the WebDriver interface
 and is implemented by the browser-specific driver classes (e.g., ChromeDriver, FirefoxDriver). This method
 is used to close the current browser window or tab.

 However, it's important to note that using driver.close() alone may not terminate the WebDriver session
 completely, especially if there are multiple windows or tabs open. To ensure proper termination of the
 WebDriver session and to close all browser instances, it is recommended to use driver.quit() instead.

 If you want to close the current browser window or tab after each test method, you can modify the quit() method
 to use driver.close() as you have shown. But keep in mind that if there are multiple windows or tabs open, the
 WebDriver session may still be active in the background.
 Remember to use driver.quit() in the closeBrowser() method if you want to ensure complete termination of the
 WebDriver session, as discussed earlier.
 */
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
        password.sendKeys("Hum@nhrm123");
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