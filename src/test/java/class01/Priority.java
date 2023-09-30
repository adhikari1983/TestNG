package class01;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 4, groups = "smoke")
    public void aTestCase(){
        System.out.println("Hello i'm the first test case");
    }

    @Test(priority = 3)
    public void bTestCase(){
        System.out.println("Hello, again i'm the second test case");
    }

    @Test(priority = 2)
    public void cTestCase(){
        System.out.println("Hello, again i'm the third test case");
    }

    @Test(priority = 1)
    public void dTestCase(){
        System.out.println("Hello i'm the first test case");
    }

    /** No priority mentioned means 0, the highest priority  -> runs first */
    @Test
    public void ddTestCase(){
        System.out.println("Hello i'm the first test case");
    }
}
