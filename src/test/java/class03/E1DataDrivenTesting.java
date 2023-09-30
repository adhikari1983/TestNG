package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class E1DataDrivenTesting {
    //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"
    @DataProvider(name = "invalidCredentials")
    public Object[][] data() {                                   // method signature
        Object[][] loginData = {                                 // 2D array
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }

    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public  void openBrowserAndNavigate(){
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // put @AfterMethod after post conditions
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String user, String pass , String expectedMsg){

//finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
//send username
        username.sendKeys(user);

//        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys(pass);
        //        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();
//             get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        //        extract the error message
        String actualMsg = errorMsg.getText();

        Assert.assertEquals(actualMsg, expectedMsg);
    }
}