package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	public WebDriver getwebDriverSession() {

		WebDriver driver = null;

		String browserName = AppProperties.getProperty("src/test/resources/test.properties", "browser");

		try {

			if (browserName != null) {

				if (browserName.equalsIgnoreCase("Chrome")) {

					WebDriverManager.chromedriver().setup();

					driver = new ChromeDriver();

				} else if (browserName.equalsIgnoreCase("fireofox")) {
					WebDriverManager.firefoxdriver().setup();

					driver = new FirefoxDriver();

				} else if (browserName.equalsIgnoreCase("safari")) {

					WebDriverManager.safaridriver().setup();

					driver = new SafariDriver();

				}

				else {
					Logs.getLog().getLogger("WebDriverFactory").error("Error--> Invalid Browser Name :" + browserName);

				}

			}

		} catch (Exception ex) {
			Logs.getLog().getLogger("WebDriverFactory").error("Error--> Invalid Browser Name :" + browserName);

		}

		if (driver != null) {

			Logs.getLog().getLogger("WebDriverFactory").info("Info-->Get WebDriverSession is Success :" + browserName);
			return driver;
		} else {
			Logs.getLog().getLogger("WebDriverFactory").error("Error-->Get WebDriverSession is Failure :" + browserName);

		}
		return driver;

	}
}