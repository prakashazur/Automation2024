package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LaunchFlipkart {
	static WebDriver driver;

	public static void main(String[] args) {
	
		// TODO Auto-generated method s
		driver=new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("3");
		driver.findElement(By.name("bSubmit")).click();
		
		String TitleOfPage=driver.getTitle();
		Assert.assertEquals(TitleOfPage, "Place Order");
		String Unitprice=driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("Unitprice" +Unitprice);
		String UnitPriceWthOutDoller=Unitprice.substring(2);
		System.out.println("UnitPriceWthOutDoller:"  +UnitPriceWthOutDoller);
		float ActualPrice=Float.parseFloat(UnitPriceWthOutDoller);
		String MultipilicationFactor=driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[2]/td[1]")).getText();
		float ActualMultipicationfactor=Float.parseFloat(MultipilicationFactor);
		float FinalPrice=ActualPrice*ActualMultipicationfactor;
		System.out.println("FinalPrice:"   +FinalPrice);
		
		
		
		
		

	}

}
