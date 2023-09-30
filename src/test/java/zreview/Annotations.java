package zreview;

import org.testng.annotations.*;

public class Annotations {

    @BeforeClass
    public  void beforeClass(){
        System.out.println("i am before class");
    }
    @AfterClass
    public  void afterClass(){
        System.out.println("i am after class");
    }


    @BeforeMethod
    public void beforeTest() {
        System.out.println("i am test before Method ");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("i am test After Method");
    }

    @Test
    public void testA() {
        System.out.println("i am test A Annotations");
    }

    @Test
    public void testB() {
        System.out.println("i am test B Annotations");
    }


}
