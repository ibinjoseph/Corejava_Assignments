package testCases;

import static TestRunner.TestRunner.driver;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static common.functions.CommonFunctions.waitAndInputData;
import static common.functions.CommonFunctions.waitForElementLocator;
import page.objects.JiraPageCreateTestSpec;


public class TestCaseSpecLink {
	@Test
	public static void Link() throws Exception {
		FileInputStream fis = new FileInputStream("src\\resources\\TestCaseUpload.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		String data3 = sheet.getRow(1).getCell(3).getStringCellValue();
		System.out.println("value is :"+data3);
		waitForElementLocator(JiraPageCreateTestSpec.moreClick()).click();
		new Actions(driver).moveToElement(waitForElementLocator(JiraPageCreateTestSpec.moreClick())).build().perform();
		driver.findElement(By.linkText("Link")).click();
		waitAndInputData(JiraPageCreateTestSpec.linkTypeSelect(), "v");
		waitAndInputData(JiraPageCreateTestSpec.linkTypeSelect(), data3);
		waitForElementLocator(JiraPageCreateTestSpec.linkButton()).click();
	}
}