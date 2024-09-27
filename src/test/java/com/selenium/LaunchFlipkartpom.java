package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pom.Flipkartpom;
import com.utility.Library1;

public class LaunchFlipkartpom extends Library1{

	public static void main(String[] args) {
	
		// TODO Auto-generated method s
		driver=new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		Flipkartpom obj= new Flipkartpom(driver);
		obj.EnterGmoONline.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		obj.ExternalFrameBackpack.sendKeys("3");
		obj.PlaceOrder.click();
		
		String TitleOfPage=driver.getTitle();
		Assert.assertEquals(TitleOfPage, "Place Order");
		String Unitprice=obj.UnitPrice.getText();
		System.out.println("Unitprice" +Unitprice);
		String UnitPriceWthOutDoller=Unitprice.substring(2);
		System.out.println("UnitPriceWthOutDoller:"  +UnitPriceWthOutDoller);
		float ActualPrice=Float.parseFloat(UnitPriceWthOutDoller);
		String MultipilicationFactor=obj.MultipicationFactor.getText();
		float ActualMultipicationfactor=Float.parseFloat(MultipilicationFactor);
		float FinalPrice=ActualPrice*ActualMultipicationfactor;
		System.out.println("FinalPrice:"   +FinalPrice);
		String Finalprice=obj.FinalPrice.getText();
		System.out.println("Finalprice" +Finalprice);
		String FinalPriceWthOutDoller=Finalprice.substring(2);
		System.out.println("FinalPriceWthOutDoller:"  +FinalPriceWthOutDoller);
		float ActualFinalPrice=Float.parseFloat(FinalPriceWthOutDoller);
		System.out.println("ActualFinalPrice:"   +ActualFinalPrice);
		Assert.assertEquals(FinalPrice, ActualFinalPrice, "Programme is running" );
		
		
		
		
		

	}

}
