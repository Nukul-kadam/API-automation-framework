package base;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentHtmlReporter html = new ExtentHtmlReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(html);
    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
