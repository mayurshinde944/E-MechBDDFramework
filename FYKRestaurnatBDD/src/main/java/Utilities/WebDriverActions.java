package Utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions {

	private WebDriver driver = DriverFactory.getInstance().getWebDriver();

	private JavascriptExecutor javascriptExecuator = (JavascriptExecutor) driver;

	long timeOut = Long.parseLong(AppProperties.getProperty("src/test/resources/test.properties", "timeOut"));

	long timeOutInMillis = Long
			.parseLong(AppProperties.getProperty("src/test/resources/test.properties", "timeOutInMillis"));

	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

	public WebElement waitUntilElementToBeClickable(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		execuationOrder(element);

		return element;
	}

	public WebElement waitUntilvisibilityOfElementLocated(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		execuationOrder(element);

		return element;
	}

	public void scrollToElement(WebElement element) {
		javascriptExecuator.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void highLightElement(WebElement element) {
		javascriptExecuator.executeScript(
				"arguments[0].setAttribute('style','background: yellow; border: solid 2px red');", element);
	}

	public void removeHighLight(WebElement element) {
		javascriptExecuator.executeScript(
				"arguments[0].setAttribute('style','background: white; border: solid 2px green');", element);
	}

	public void pause() {
		try {
			TimeUnit.MILLISECONDS.sleep(timeOutInMillis);
		} catch (InterruptedException e) {

			Logs.getLog().getLogger("WebDriverActions").error("Error--> Failed to Wait :" + e.getMessage());
		}

	}

	public void execuationOrder(WebElement element) {
		scrollToElement(element);
		highLightElement(element);
		pause();
		removeHighLight(element);
		pause();

	}

}
