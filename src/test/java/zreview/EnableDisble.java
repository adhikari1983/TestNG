package zreview;

import org.testng.annotations.Test;

public class EnableDisble {

    @Test(enabled = true)
    public void hello() {
        System.out.println("hello.............");
    }

    @Test
    public void funcA(){
        System.out.println((5/1));
    }

    @Test(dependsOnMethods = "funcA")
    public void funcB(){
        System.out.println("i am depentdent on A");
    }

}
