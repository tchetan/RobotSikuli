package main.base;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {

	public static WebDriver driver;

	public static WebDriver OpenApp(String BrowserName, String url){
		fn_LaunchBrowser(BrowserName);
		fn_OpenURL(url);
		return driver;
	}
	public static void fn_OpenURL(String url){
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static WebDriver fn_LaunchBrowser(String browsername){
		if(browsername=="CH"){
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browsername=="FF"){
			driver= new FirefoxDriver();
		}else if(browsername=="IE"){
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		return driver;
	}

	public static  void screenshot() {

		//WebDriver driver = new ChromeDriver();
		//Driver.get("http://www.google.com");
		//Take screenshot and save to file
		File screenshot = ((TakesScreenshot)driver).
				getScreenshotAs(OutputType.FILE);
		//Copy the file to system ScreenshotPath
		String ScreenshotPath = "C:\\tc\\dev\\screenshots\\Test6.png";
		try {
			FileUtils.copyFile(screenshot, new File(ScreenshotPath));
			System.out.println("printed :  " + screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CloseBrowser() {
		driver.close();
	}




}
