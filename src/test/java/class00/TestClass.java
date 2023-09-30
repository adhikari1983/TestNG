package class00;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        driver.quit();
    }

}
