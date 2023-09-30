package class01;

import org.testng.annotations.Test;

public class EnableDisable {

    // will not execute this aTest() test case/this method
    // won't even give the right click & run option
    @Test(enabled = false)
    public void aTest() {
        System.out.println("i am test a");
    }

    @Test
    public void bTest() {
        System.out.println("i am test b");
    }

    @Test
    public void cTest() {
        System.out.println("i am test c");
    }
}
