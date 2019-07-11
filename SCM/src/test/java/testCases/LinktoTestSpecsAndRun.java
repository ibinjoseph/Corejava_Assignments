package testCases;

import static TestRunner.TestRunner.driver;
import static common.functions.CommonFunctions.waitAndInputData;
import static common.functions.CommonFunctions.waitAndInputDataforDropdown;
import static common.functions.CommonFunctions.waitForElementLocator;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import page.objects.JiraPageCreateTestSpec;

public class LinktoTestSpecsAndRun {

	public static void linkJiraId(String linkType, String ID) throws IOException, InterruptedException, AWTException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		waitForElementLocator(JiraPageCreateTestSpec.moreClick()).click();
		new Actions(driver).moveToElement(waitForElementLocator(JiraPageCreateTestSpec.moreClick())).build().perform();
		jse.executeScript("window.scrollBy(0,250)", "");
		waitForElementLocator(By.linkText("Link")).click();
		waitAndInputDataforDropdown(JiraPageCreateTestSpec.linkTypeSelect(), linkType);
		waitAndInputData(JiraPageCreateTestSpec.linkedTo(), ID);
		waitForElementLocator(JiraPageCreateTestSpec.linkButton()).click();

	}
}
