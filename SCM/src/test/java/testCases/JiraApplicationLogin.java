package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static TestRunner.TestRunner.driver;
import java.io.IOException;

public class JiraApplicationLogin {
	@Test
	public void f() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@id='login-form-username']")).sendKeys("vu3k5");
		driver.findElement(By.xpath("//input[@id='login-form-password']")).sendKeys("Jos560037KA#");
		WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
		login.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(login));
	}
}
