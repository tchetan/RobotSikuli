package com.github.rainmanwy.robotframework.app;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.IScreen;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.testng.annotations.Test;
import org.sikuli.*;

import main.base.BasePage; 

public class Test4 extends BasePage{

	@Test
	public void facebookLogin() throws FindFailed{

		// Settings.OcrTextRead = true; // to switch on the Region.text() function
		//Settings.OcrTextSearch = true; // to switch on finding text with find("some text")

		// Creating Object of 'Screen' class
		//Screen is a base class provided by Sikuli. It allows us to access all the methods provided by Sikuli.
		Screen screen = new Screen();
		// Creating Object of Pattern class and specify the path of specified images
		// I have captured images of Facebook Email id field, Password field and Login button and placed in my local directory
		// Facebook user id image 
		Pattern username = new Pattern("C:\\tc\\dev\\objects\\Login.png");
		// Facebook password image
		Pattern password = new Pattern("C:\\tc\\dev\\objects\\Password.png");
		// Facebook login button image
		Pattern login = new Pattern("C:\\tc\\dev\\objects\\Submit.png");
		// Initialization of driver object to launch firefox browser 
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\tc\\dev\\drivers\\chrome\\32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// To maximize the browser
		driver.manage().window().maximize();
		// Open Facebook
		driver.get("https://en-gb.facebook.com/");
		
		/* int dx = 0 ; 
		int dy = 0 ;
		username.targetOffset(dx, dy);
		screen.userCapture();
		screen.getX();
*/
		String uname = screen.find(username).getText();
		System.out.println(uname);

		screen.wait(username, 10);	 
		// Calling 'type' method to enter username in the email field using 'screen' object
		screen.type(username, "softwaretestingmaterial@gmail.com");
		// Calling the same 'type' method and passing text in the password field
		screen.type(password, "softwaretestingmaterial");
		// This will click on login button
		screen.click(login);

		BasePage.screenshot();
		BasePage.CloseBrowser();



	}

}