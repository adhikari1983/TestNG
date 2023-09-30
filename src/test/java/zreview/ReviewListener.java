package zreview;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReviewListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("i'm test success " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("i'm test failure " + result.getName());
    }
}
