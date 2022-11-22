package com.SeleniumFlipKartTask;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartt {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\FlipKartTask\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement X= driver.findElement(By.xpath("//button[text()='✕']"));
		X.click();
		WebElement go=driver.findElement(By.xpath("//input[@type='text']"));
		go.sendKeys("Apple iphone 13 128 midnight");
		Thread.sleep(3000);
		Robot Act=new Robot();                    
		Act.keyPress(KeyEvent.VK_ENTER);
		Act.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		WebElement Select = driver.findElement(By.xpath("(//div[contains(text(),'APPLE iPhone 13 Mini ')])[1]"));
		Select.click();
		String PW = driver.getWindowHandle();//parent window              //<<<----  ---->>>
		Set<String> CW = driver.getWindowHandles();//child window Handling..
//		for (String Q:CW) {
//			if (!(Q==PW));
//				driver.switchTo().window(Q);
//		}
		//getWindowsHandles written type is set.its not allows duplicate.so change to list method,its allows duplicate. 
		Thread.sleep(3000);
		List<String> LK=new ArrayList<>();
		LK.addAll(CW);
		String window=LK.get(1);
		driver.switchTo().window(window);
//		driver.switchTo().window(PW);
		Thread.sleep(2000);
		WebElement AddCart = driver.findElement(By.xpath("//button[text()='BUY NOW']"));
		AddCart.click();
		Thread.sleep(2000);
		WebElement Buy=driver.findElement(By.xpath("//button[@type='submit']"));
		Buy.click();
		String Tittle= driver.getTitle();
		TakesScreenshot SS=(TakesScreenshot)driver;
		Thread.sleep(2000);
		File get = SS.getScreenshotAs(OutputType.FILE);
		//File save=new File("C:\\Users\\User\\eclipse-workspace\\ScreenShortMethord\\TakesScreenShots\\Flip1.png");
		File save=new File("C:\\Users\\User\\eclipse-workspace\\ScreenShortMethord\\TakesScreenShots\\"+Tittle+".png");
		Thread.sleep(2000);
		FileUtils.copyFile(get, save);		
	}

}
