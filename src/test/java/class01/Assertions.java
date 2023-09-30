package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assertions {
    //test1
    // goto HRMS
    //enter username Admin
    //enter no password
    //verify that the message is "Password cannot be empty"

public static WebDriver driver;
    @BeforeMethod
    public void OpenAndLaunchBrowser() {
//    webdriver
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public  void afterMethod(){
        driver.quit();
    }

    @Test
    public void verifyTheErrorMessage(){
        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userNameTextBox.sendKeys("Admin");

        WebElement logInBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        logInBtn.click();

        //get the text
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Password cannot be empty";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void checkTextBoxDisplay(){
        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        boolean displayed = userNameTextBox.isDisplayed();
        Assert.assertTrue(displayed);
    }
}
