package testngpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener {

	ExtentSparkReporter spark; //for handling UI of report
	ExtentReports report; // for adding common info in report
	ExtentTest test; //for adding test case entries

	public void onStart(ITestContext context) {
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\extentreport\\report.html");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.STANDARD);

		report=new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("Tester", "Akash Jadhav");

	}
	public void onTestSuccess(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.PASS, result.getName());

	}

	public  void onTestFailure(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.FAIL, result.getName());
		test.log(Status.FAIL, result.getThrowable());

	}

	public  void onTestSkipped(ITestResult result) {
		test=report.createTest(result.getName());
		test.log(Status.SKIP, result.getName());
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
