package class01;

import org.testng.annotations.Test;

public class DependsOnMethod {

    @Test
    public void login(){
        System.out.println(10/0);
    }

    @Test(dependsOnMethods = {"login"})
    public void testTheDashBoardPage(){
        System.out.println("i am testing the DashBoard page");
    }
}
