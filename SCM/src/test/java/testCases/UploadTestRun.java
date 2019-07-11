package testCases;

import static common.functions.CommonFunctions.waitAndInputData;
import static common.functions.CommonFunctions.waitForElementLocator;

import java.awt.AWTException;
import java.io.IOException;
import page.objects.JiraPageCreateTestSpec;
import static TestRunner.TestRunner.driver;

public class UploadTestRun {

	public static void runCreation(String fixVersion, String summaryTestRun)
			throws IOException, InterruptedException, AWTException {

		Thread.sleep(5000);
		waitForElementLocator(JiraPageCreateTestSpec.createButton()).click();
		waitAndInputData(JiraPageCreateTestSpec.issueTypeEntry(), "Test");
		waitAndInputData(JiraPageCreateTestSpec.prioritySelection(), "Low");
		waitAndInputData(JiraPageCreateTestSpec.fixVersion(), fixVersion);
		waitForElementLocator(JiraPageCreateTestSpec.summaryHeading()).sendKeys(summaryTestRun);
		waitForElementLocator(JiraPageCreateTestSpec.createTestSpec()).click();
		waitForElementLocator(JiraPageCreateTestSpec.getTestSpecId()).click();
		// Comment above 2 lines, and uncomment below 2 lines for testing purpose
		//waitForElementLocator(JiraPageCreateTestSpec.cancelTestRun()).click();
		//driver.switchTo().alert().accept();
	}
}
