package class01;

import org.testng.annotations.*;

public class Annotations {

    /** By default, @Test annotation follows alphabetical order of execution of the test cases */

    @Test
    public void firstTestCase(){
        System.out.println("Hello i'm the first test case");
    }

    @Test
    public void secondTestCase(){
        System.out.println("Hello, again i'm the second test case");
    }

    @Test
    public void thirdTestCase(){
        System.out.println("Hello, again i'm the third test case");
    }

    /*
        @BeforeMethod
            @AfterMethod -> are not test cases that's why we don't see it on
                            Default Suite bottom left corner on result display
                            & also you can't run it independently like @Test
                            Coz, they are depended on @Test
      */
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("I'm before method");
    }

    @AfterMethod
    public  void afterMethod(){
        System.out.println("I'm after method");
    }

}
