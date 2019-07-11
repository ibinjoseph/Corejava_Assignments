package testCases;

import static common.functions.CommonFunctions.waitAndInputData;
import static common.functions.CommonFunctions.waitAndInputDataforDropdown;
import static common.functions.CommonFunctions.waitAndPasteData;
import static common.functions.CommonFunctions.waitForElementLocator;
import static TestRunner.TestRunner.driver;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import page.objects.JiraPageCreateTestSpec;

public class TestCaseSpecCreation {

	public static void specCreation(String data1, String data2, ArrayList<String> list, String fixVersion)
			throws IOException, InterruptedException, AWTException {

		waitForElementLocator(JiraPageCreateTestSpec.createButton()).click();
		waitAndInputData(JiraPageCreateTestSpec.projectEntryInput(),
				"SCM Procurement - Supplier Ecommerce Application (SEC)");
		waitAndInputData(JiraPageCreateTestSpec.issueTypeEntry(), "Test Case Spec");
		waitAndInputData(JiraPageCreateTestSpec.summaryHeading(), data1);
		waitAndInputData(JiraPageCreateTestSpec.prioritySelection(), "Low");
		waitAndInputDataforDropdown(JiraPageCreateTestSpec.testTTypeSelection(), "Function");
		waitAndPasteData(JiraPageCreateTestSpec.descriptionEntry(), data2);
		waitAndInputData(JiraPageCreateTestSpec.fixVersion(), fixVersion);
		waitAndInputData(JiraPageCreateTestSpec.assigneeEntry(), "vu3k5");
		waitAndInputData(JiraPageCreateTestSpec.testerEntry(), "vu3k5");
		waitAndInputData(JiraPageCreateTestSpec.reporterEntry(), "Ibin Joseph");
		waitAndInputDataforDropdown(JiraPageCreateTestSpec.runModeEntry(), "Manual");

		for (String label : list) {
			waitAndInputData(JiraPageCreateTestSpec.labels(), label);
		}

		waitForElementLocator(JiraPageCreateTestSpec.createTestSpec()).click();
		waitForElementLocator(JiraPageCreateTestSpec.getTestSpecId()).click();
		//Comment above 2 lines, and uncomment below 2 lines for testing purpose
		//waitForElementLocator(JiraPageCreateTestSpec.cancelTestSpec()).click();
		//driver.switchTo().alert().accept();
		list.clear();
	}
}
