package testCases;

import static TestRunner.TestRunner.driver;
import static common.functions.CommonFunctions.waitAndInputData;
import static common.functions.CommonFunctions.waitAndInputDataforDropdown;
import static common.functions.CommonFunctions.waitForElementLocator;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.objects.JiraHomePage;
import page.objects.JiraPageCreateTestSpec;

public class TestCaseSpecClone {
	public static String testCaseSpecNumber, testCaseSpecSummary;
	public static void specClone(String testID) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(testID);
		waitForElementLocator(JiraPageCreateTestSpec.SearchField()).sendKeys(Keys.ENTER);
		waitForElementLocator(JiraPageCreateTestSpec.moreClick()).click();
		new Actions(driver).moveToElement(waitForElementLocator(JiraPageCreateTestSpec.moreClick())).build().perform();
		jse.executeScript("window.scrollBy(0,250)", "");
		waitForElementLocator(By.linkText("Clone")).click();
		
		waitForElementLocator(JiraHomePage.createButtonforClone()).click();
		Thread.sleep(5000);
		//waitForElementLocator(JiraPageCreateTestSpec.cancelTestSpec()).click();
		testCaseSpecNumber = waitForElementLocator(JiraHomePage.specNumber()).getText();
		testCaseSpecSummary = waitForElementLocator(JiraHomePage.specSummary()).getText();
		System.out.println(testCaseSpecNumber +"and"+ testCaseSpecSummary);
	}
}
