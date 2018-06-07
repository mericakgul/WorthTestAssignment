package com.worth;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static String LOGIN_URL;

    public static WebDriver driver;

    String propFilePath = "./worth.properties";


  public void initializeEnvironment() throws Exception {
      String propFilePath = ".\\worth.properties";
      Properties properties = new Properties();
      properties.load(new FileInputStream(propFilePath));
      LOGIN_URL = properties.getProperty("URL");
  }
  	@Parameters( "browser" )
    @BeforeClass(alwaysRun = true)
 
    public void initializeDrivers( @Optional("chrome") String browser) throws Exception{

            initializeEnvironment();

        if (browser.equalsIgnoreCase("chrome")) {
        	DesiredCapabilities cap =  DesiredCapabilities.chrome();
        	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        	driver = new ChromeDriver(cap);
        	

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

  	@AfterClass (alwaysRun = true)
    public void afterTest() {
        driver.close();
		driver.quit();
		driver = null;
    }
}