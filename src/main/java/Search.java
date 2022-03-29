import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Search extends Base_Class {
	@Test
	// [SEARCH] Validating search Functionality from the auto suggestion

	public void Search_Test_TC_1() throws IOException
	{
//		  Launch Amazon app
//		  Skip Sign in button
//		  Click on the "Search" bar
//		  Input the text "toys" and  verify for the auto suggestions
//		  Perform a mobile gesture like scrolling and halt to the desired element
//		  Click on the "toys for 1 year old boy" element 
		
		commonsteps();
		
		WebElement searchbar=driver.findElement(By.id( "com.amazon.mShop.android.shopping:id/chrome_search_hint_view"));
		searchbar.click();
		
		WebElement searchproducttext = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
		searchproducttext.sendKeys("toys");
		
		 MobileElement selectitem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrolltaable(true))" +
			         ".scrollIntoView(new UiSelector().text(\"toys for 1 year old boy\"))"));
		 assertNotNull(selectitem);
		 selectitem.click();
		
		 TakeScreenshot("Search_Test_TC_1");
		

	}

	@Test
	// [SEARCH] Validating search Functionality

	public void Search_Test_TC_2() throws IOException
	{
//		  Launch Amazon app
//		  Skip Sign in button
//		  Click on the "Search" bar
//		  Input the text "toys" and  verify for the auto suggestions
//		  Click on the "Enter" element without selecting from the auto suggestions.
		commonsteps();
		
		WebElement searchbar=driver.findElement(By.id( "com.amazon.mShop.android.shopping:id/chrome_search_hint_view"));
		searchbar.click();
		
		WebElement searchproducttext = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
		searchproducttext.sendKeys("toys");
		
		searchproducttext.sendKeys(Keys.ENTER);
		
		

		 TakeScreenshot("Search_Test_TC_2");
		
		

// 
	}

}
