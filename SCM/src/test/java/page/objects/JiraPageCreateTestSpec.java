package page.objects;

import static TestRunner.TestRunner.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JiraPageCreateTestSpec {

	private JiraPageCreateTestSpec() {
		throw new IllegalStateException("Test Spec Creation");
	}

	public static By projectEntryInput() {
		return By.xpath("//input[@id='project-field']");
	}

	public static By createButton() {
		return By.xpath("//a[@id='create_link']");
	}

	public static By issueTypeEntry() {
		return By.xpath("//input[@id='issuetype-field']");
	}

	public static By summaryHeading() {
		return By.xpath("//input[@id='summary']");
	}

	public static By prioritySelection() {
		return By.xpath("//input[@id='priority-field']");
	}

	public static By testTTypeSelection() {
		return By.xpath("//select[@id='customfield_10150']");
	}

	public static By descriptionEntry() {
		return By.xpath("//textarea[@id='description']");
	}

	public static By assigneeEntry() {
		return By.xpath("//input[@id='assignee-field']");
	}

	public static By testerEntry() {
		return By.xpath(
				"//div[contains(@class, 'field-group')][descendant::label[contains(text(), 'Tester')]]/descendant::input");
	}

	public static By reporterEntry() {
		return By.xpath("//input[@id='reporter-field']");
	}

	public static By runModeEntry() {
		return By.xpath("//select[@id='customfield_10120']");
	}

	public static By SearchField() {
		return By.xpath("//input[@id='quickSearchInput']");
	}

	public static By createTestSpec() {
		return By.xpath("//input[@id='create-issue-submit']");
	}

	public static By moreClick() {
		return By.xpath("//a[@id='opsbar-operations_more']");
	}

	public static By linkTypeSelect() {
		return By.xpath("//select[@id='link-type']");
	}

	public static By linkedTo() {
		return By.xpath("//textarea[@id='jira-issue-keys-textarea']");
	}

	public static By linkButton() {
		return By.xpath("//input[@name='Link']");
	}

	public static By getTestSpecId() {
		return By.xpath("//a[contains(@class, 'issue-created-key')]");
	}

	public static By StoryOpenClick() {
		return By.xpath("//a[@class='issue-link link-title']");
	}

	public static List<WebElement> labelValues() {
		return driver.findElements(By.xpath("//ul/descendant::a[contains(@class, 'lozenge')]//span"));
	}

	public static By labelValuesNames(int j) {
		return By.xpath("//ul/descendant::a[contains(@class, 'lozenge')][" + j + "]//span");
	}

	public static By labelValueInput() {
		return By.xpath("//span[@class='labels']");
	}

	public static By labelValueInputField() {
		return By.xpath("//textarea[@id='labels-textarea']");
	}

	public static By fixVersionInput() {
		return By.xpath("//span[@id='fixfor-val']");
	}

	public static By cancelTestSpec() {
		return By.xpath("//div[contains(@class, 'buttons')]/descendant::a[contains(@class, 'cancel')]");
	}

	public static By cancelTestRun() {
		return By.xpath("//div[contains(@class, 'buttons')]/descendant::a[contains(@class, 'cancel')]");
	}

	public static By fixVersion() {
		return By.xpath("//textarea[@id='fixVersions-textarea']");
	}

	public static By labels() {
		return By.xpath("//textarea[@id='labels-textarea']");
	}
}
