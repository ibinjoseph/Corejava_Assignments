package common.functions;

import static TestRunner.TestRunner.driver;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	public static int tabOrderIterator = 1;
	private static final String VALUE_TEXT = "value";

	public CommonFunctions() {
		throw new IllegalStateException("Common Functions");
	}

	// public static ConfigFileReader configFileReader = new ConfigFileReader();
	public static WebDriverWait wait = new WebDriverWait(driver, 60);

	// Wait for element locator
	public static WebElement waitForElementLocator(By Locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}

	// Steps for wait and input data
	public static void waitAndInputData(By Locator, String keysToSend) throws AWTException, InterruptedException {
		Thread.sleep(1000);
		jsClick(waitForElementLocator(Locator));
		waitForElementLocator(Locator).clear();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(keysToSend), null);
		waitForElementLocator(Locator).sendKeys(Keys.CONTROL + "v");
		waitForElementLocator(Locator).sendKeys(Keys.TAB);
		waitForElementLocator(Locator);
	}

	// Steps for wait and input data
	public static void waitAndPasteData(By Locator, String keysToSend) {
		waitForElementLocator(Locator).click();
		waitForElementLocator(Locator).clear();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(keysToSend), null);
		waitForElementLocator(Locator).sendKeys(Keys.CONTROL + "v");
		waitForElementLocator(Locator).sendKeys(Keys.TAB);
		waitForElementLocator(Locator);
	}

	// Select for Drop-down
	public static void waitAndInputDataforDropdown(By Locator, String keysToSend) {
		Select dropdown = new Select(waitForElementLocator(Locator));
		dropdown.selectByVisibleText(keysToSend);
		waitForElementLocator(Locator).sendKeys(Keys.TAB);
		waitForElementLocator(Locator);
	}

	// Javascript Click
	public static void jsClick(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", e);
	}

	// Steps for inputing data character by character
	public static void waitAndInputDataCharByChar(WebElement element, String keysToSend) {
		for (int i = 0; i < keysToSend.length(); i++) {
			element.sendKeys(Character.toString(keysToSend.charAt(i)));
			wait.until(ExpectedConditions.attributeContains(element, "value", keysToSend.substring(0, i)));
		}
	}

	// Select From Drop-down List
	public static void selectFromDropdownByValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);

	}

	// Select From Drop-down List By Index
	public static void selectFromDropdownByIndex(WebElement ele, int index) {
		wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return new Select(ele).getOptions().size() > 2;
			}
		});
		new Select(ele).selectByIndex(index);
	}

	// Switch To Different Window
	public static void switchToDifferentWindow(String parentWindowTitle, String newWindowTitle, WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {

			if (!handle.equals(parentWindowTitle)) {
				driver.switchTo().window(handle);
				String title = driver.getTitle();

				if (title.contains(newWindowTitle)) {
					break;
				}
			}
		}
	}

	// Compare Two WebElement Arrays
	public static boolean compareTwoWebElementLists(List<WebElement> webElementArray1,
			List<WebElement> webElementArray2) {
		String[] str1 = new String[webElementArray1.size()];
		String[] str2 = new String[webElementArray2.size()];
		int i = 0;
		for (WebElement e : webElementArray1) {
			str1[i] = e.getText();
			i++;
		}

		i = 0;
		for (WebElement e : webElementArray2) {
			if (e.getAttribute(VALUE_TEXT) != null) {
				str2[i] = e.getAttribute(VALUE_TEXT);
			} else {
				str2[i] = e.getText();
			}
			i++;
		}
		return Arrays.equals(str1, str2);
	}

	// Compare Two String Arrays
	public static boolean compareTwoArrayLists(String[] array1, String[] array2) {
		ArrayList<String> listOne = new ArrayList<>(Arrays.asList(array1));
		ArrayList<String> listTwo = new ArrayList<>(Arrays.asList(array2));
		Collections.sort(listOne);
		Collections.sort(listTwo);
		return listOne.equals(listTwo);
	}

}
