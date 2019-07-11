package page.objects;

import static TestRunner.TestRunner.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JiraHomePage {

	private JiraHomePage() {
		throw new IllegalStateException("Jira HomePage");
	}

	public static WebElement createButton() {
		return driver.findElement(By.xpath("//li[@id='create-menu']"));
	}
	
	public static WebElement issueTypeDropdownList() {
		return driver.findElement(By.xpath("//input[@id='issuetype-field']"));
	}
	
	public static By fixVersion() {
		return By.xpath("//span[contains(@id, 'fixVersions-field')]/a");
	}
	
	public static By specNumber() {
		return By.xpath("//a[@id='key-val']");
	}
	
	public static By specSummary() {
		return By.xpath("//h1[@id='summary-val']");
	}
	
	public static By createButtonforClone() {
		return By.xpath("//input[@id='clone-issue-submit']");
	}
	
	
	
}
