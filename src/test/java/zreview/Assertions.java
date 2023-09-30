package zreview;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    //whenever hard assertions have been implemented
    //a failure of one Assertion leads to dismissal of the test case
    //and it never even checks for other assertions
    @Test
    public void hardAssert() {
        //assuming this information from the WebElement ona Website
        String actualName = "Kiran";
        String actualDesignation = "softwareEngineer";

        Assert.assertEquals(actualName, "Kiran");
        System.out.println("hello i am here1");
        Assert.assertEquals(actualDesignation, "softwareEngineer");

    }


    //soft assertions
    //no matter if your assertion fails, it will still continue to check other assertions
    @Test
    public void softAssert() {
        String actualName1 = "Kiran";
        String actualDesignation1 = "softwareEngineer";

        // declare the instance
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualName1, "ksdhkm");
        System.out.println("hello i am here2");
        soft.assertEquals(actualDesignation1, "softwareEngineer");

        //don't forget to assertAll
        soft.assertAll();



    }
}