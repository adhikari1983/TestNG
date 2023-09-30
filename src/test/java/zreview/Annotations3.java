package zreview;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations3 {


    @BeforeTest
    public void beforeTest() {
        System.out.println("i am before Test Annotations3");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("i am after Test Annotations3");
    }
}
