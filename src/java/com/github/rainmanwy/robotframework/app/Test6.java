package com.github.rainmanwy.robotframework.app;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import org.testng.annotations.Test;
import org.sikuli.*;

import main.base.BasePage; 


public class Test6 extends BasePage{

	@Test
	public void facebookLogin() throws FindFailed{

		Screen screen = new Screen();
		Pattern username = new Pattern("C:\\tc\\dev\\objects\\Login.png");
		Pattern password = new Pattern("C:\\tc\\dev\\objects\\Password.png");
		Pattern login = new Pattern("C:\\tc\\dev\\objects\\Submit.png");
		
		BasePage.fn_LaunchBrowser("CH");
		BasePage.fn_OpenURL("https://en-gb.facebook.com/");
		screen.wait(username, 10);	 
		screen.type(username, "softwaretestingmaterial@gmail.com");
		screen.type(password, "softwaretestingmaterial");
		screen.click(login);
		
		
		BasePage.screenshot();
		BasePage.CloseBrowser();
	}
}