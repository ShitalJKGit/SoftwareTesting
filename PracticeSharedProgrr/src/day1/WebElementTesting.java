package day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class WebElementTesting {
	WebDriver driver;
	
  @Test (priority = 1)
  public void chkbox() {
	  driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(4) > td > label:nth-child(2) > span")).click();
	  System.out.println("chk box selected");
	  boolean test = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(4) > td > label:nth-child(2) > span")).isEnabled();
	  System.out.println("chk box is::  "+test);
  }

  @Test (priority = 3)
	public void dragDrop() {
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		WebElement FROM = driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		WebElement TO = driver.findElement(By.xpath("//*[@id=\"bank\"]"));
		
		Actions action = new Actions(driver);
		
		//we can make this in both the following ways
		//Action dragdrop = action.clickAndHold(FROM).moveToElement(TO).release(TO).build();
		Actions dragdrop1 = action.dragAndDrop(FROM, TO);
		dragdrop1.perform();
		System.out.println("drag n drop done... plz chk");
		
	}
  
  @Test (priority = 2)
  public void dropdown() throws InterruptedException {
	  Select dropdown = new Select(driver.findElement(By.id("ccompound")));
	  dropdown.selectByIndex(1);
	  Thread.sleep(1000);
	  dropdown.selectByValue("quarterly");
	  Thread.sleep(1000);
	  dropdown.selectByVisibleText("continuously");
	  Thread.sleep(1000);
	  dropdown.deselectAll();
	  }
  
    
  @BeforeMethod 
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.get("https://www.calculator.net/interest-calculator.html");
  }

  @AfterMethod
  public void afterMethod() {
	  	//driver.close();
  }

}
 