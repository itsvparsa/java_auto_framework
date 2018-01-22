package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Latest_auto/pageobjects_framework/src/main/java/config_properties/config.properties");
		prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		}
	}
	
