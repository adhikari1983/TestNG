package zreview;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
    // your test case is going to be same
    //but the data that you will be using for testing is going to be changing

    @DataProvider(name="myData")
    public Object[][] data(){
        Object[][] loginData = {                                 // 2D array
                {"A", "B", "C"},
                {"1", "2", "3"},
                {"0", "0", "100"},
                {"343", "1e3", "34"}
        };
        return loginData;
    }

    //col1 inputA
    //col2 inputB
    //col3 inputC

    @Test(dataProvider = "myData")
    public void randomTest(String inputA, String inputB, String inputC){
        System.out.print("log in with " +  inputA + " ");

    }
}
