package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonMethods;

/** running from listener1.xml*/
public class ImplementationOfListener extends CommonMethods implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The test case passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The test case failed");
    }
}
