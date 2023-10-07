package com.tutorialsninja.qa.base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.SearchDetailsPage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public LoginPage loginPage;
	public HomePage homePage;
	public SearchPage searchPage;
	public AccountPage accountPage;
	public SearchDetailsPage searchDetailsPage;

	public Base() {

		prop = new Properties();
		// File propFile = new
		// File(\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		dataProp = new Properties();
		// File dataPropFile = new
		// File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");

		try {
			FileInputStream dataFis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
			dataProp.load(dataFis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static final String USERNAME = "dheerendra_eMbucF";
    public static final String AUTOMATE_KEY = "Lx5EkNa3pxKzvzJMsnVn";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
   
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}else if (browserName.equalsIgnoreCase("bs")) {
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("browser", "Firefox");
		    caps.setCapability("browser_version", "118.0.1");
		    caps.setCapability("name", "My First Test");

		    try {
				driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		homePage =new HomePage(driver);
		return driver;

	}

}
