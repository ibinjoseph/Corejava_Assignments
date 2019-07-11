package testCases;

import static common.functions.CommonFunctions.waitForElementLocator;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static TestRunner.TestRunner.driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.objects.JiraHomePage;
import page.objects.JiraPageCreateTestSpec;

public class UploadByCreate extends TestCaseSpecCreation {

	@Test
	public static void testSetup() throws IOException, InterruptedException, AWTException {
		FileInputStream fis = new FileInputStream("src\\resources\\TestCaseUpload.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int rowcount = sheet.getLastRowNum();
		ArrayList<String> list = new ArrayList<String>();

		String summary, description, storyID, testCaseSpecNumber;
		for (int i = 0; i < rowcount; i++) {

			summary = sheet.getRow(i + 1).getCell(2).getStringCellValue();
			description = sheet.getRow(i + 1).getCell(1).getStringCellValue();
			storyID = sheet.getRow(i + 1).getCell(3).getStringCellValue();

			// Pull Labels and Fix Versions from Story
			waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(storyID);
			waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(Keys.ENTER);
			List<WebElement> labelsList = JiraPageCreateTestSpec.labelValues();
			for (WebElement webElement : labelsList) {
				list.add(webElement.getText());
			}

			// Create Test Case Spec
			String fixVersion = waitForElementLocator(JiraHomePage.fixVersion()).getText();
			specCreation("TestCase_" + summary, description, list, fixVersion);

			// Link Test Spec to Story
			Thread.sleep(4000);
			// Uncomment below 3 lines for testing purpose
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).click();
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys("PO-4831");
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(Keys.ENTER);
			testCaseSpecNumber = waitForElementLocator(JiraHomePage.specNumber()).getText();
			LinktoTestSpecsAndRun.linkJiraId("validates", storyID);

			// Create Test Run
			UploadTestRun.runCreation(fixVersion, "TestRun_" + summary);

			// Link Test Run to Test Spec
			Thread.sleep(4000);
			// Uncomment below 3 lines for testing purpose
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).click();
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys("PO-4833");
			// waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(Keys.ENTER);
			LinktoTestSpecsAndRun.linkJiraId("records", testCaseSpecNumber);

		}
		workbook.close();
	}

}
