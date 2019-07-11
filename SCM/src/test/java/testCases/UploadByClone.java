package testCases;

import static common.functions.CommonFunctions.waitForElementLocator;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.objects.JiraHomePage;
import page.objects.JiraPageCreateTestSpec;

public class UploadByClone extends TestCaseSpecClone {

	@Test
	public static void testSetup() throws IOException, InterruptedException, AWTException {
		FileInputStream fis = new FileInputStream("src\\resources\\TestCaseUpload.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();

		String storyID, testID, TempSummary;
		for (int i = 0; i < rowcount; i++) {

			storyID = sheet.getRow(i + 1).getCell(0).getStringCellValue();
			testID = sheet.getRow(i + 1).getCell(1).getStringCellValue();
			TempSummary = sheet.getRow(i + 1).getCell(2).getStringCellValue();

			// Pull Fix Versions from Story
			waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(storyID);
			waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(Keys.ENTER);
			String fixVersion = waitForElementLocator(JiraHomePage.fixVersion()).getText();

			// Clone Test Spec
			TestCaseSpecClone.specClone(testID);

			// Link Test Spec to Story
			Thread.sleep(5000);
			LinktoTestSpecsAndRun.linkJiraId("validates", storyID);

			// Create Test Run
			UploadTestRun.runCreation(fixVersion, testCaseSpecSummary.replace("TC_TestSpec", "TR_TestRun"));
			//UploadTestRun.runCreation(fixVersion, TempSummary);
			
			// Link Test Run to Test Spec
			Thread.sleep(4000);
			LinktoTestSpecsAndRun.linkJiraId("records", testCaseSpecNumber);
			//LinktoTestSpecsAndRun.pulldata("records", testID);
		}
		workbook.close();
	}

}
