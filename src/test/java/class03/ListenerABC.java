package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonMethods;

import java.io.IOException;

/** running from listener2.xml*/
public class ListenerABC extends CommonMethods implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        try {
/**  result.getName() -> will go to the corresponding classes via XML config & get the method name from that class
          listener2.xml -> listeners -> listener -> [test -> classes -> class ]
           So, basically it's the name that appears in the file of the screenshot that was taken
 */
            takeScreenshot(result.getName());
            System.out.println(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot(result.getName());
            System.out.println(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
