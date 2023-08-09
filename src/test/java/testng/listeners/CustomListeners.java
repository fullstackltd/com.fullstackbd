package testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class CustomListeners implements ITestListener {
	public void onStart(ITestContext arg) {
		System.out.println("Starts Test execution......"+arg.getName());
	}
	public void onFinish(ITestContext arg) {
		System.out.println("Finish Test execution......"+arg.getName());
	}
	public void onTestStart(ITestContext arg) {
		System.out.println("Start Test ......"+arg.getName());
	}
	public void onTestSkipped(ITestContext arg) {
		System.out.println("Skipped Test ......"+arg.getName());
	}
	public void onTestSuccess(ITestContext arg) {
		System.out.println("Passed Test ......"+arg.getName());
	}
	public void onTestFailure(ITestContext arg) {
		System.out.println("Failed Test ......"+arg.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestContext arg) {
		System.out.println("Failed Test ......"+arg.getName());
	}
}
