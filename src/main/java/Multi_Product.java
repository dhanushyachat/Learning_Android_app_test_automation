import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Multi_Product extends Base_Class {
	@Test
	// [SEARCH] Validating search Functionality from the auto suggestion

	public void Multi_Product_TC_1() throws IOException {

//			  Launch Amazon app
//			  Skip Sign in button
//			  Click on the "Search" bar
//			  Input the text "toys" and  verify for the auto suggestions
//			  Perform a mobile gesture like scrolling and halt to the desired element
//			  Click on the "toys for 1 year old boy" element 
//			  Perform a mobile gesture like scrolling and halt to the desired element
//			  Click on the " " element
//			  Perform a mobile gesture like scrolling and halt to the desired element
//			  Click on the "Add to Cart" button
//			  Capture the "cart count"
//			  Click on the "back" button 
//			  Click on the " " element
//			  Perform a mobile gesture like scrolling and halt to the desired element
//			  Click on the "Add to Cart" button
//			  Capture the "cart count"
//			  Click on "cart" button
//			  "Verify for the following
//
//			  qty - 
//			  item price - 
//			  total - 
//			  Item description - 
//			  checkout button details - 
//
//			  and grab them into the results screen"
//			  Tap on "Proceed to checkout" button

		commonsteps();

		WebElement searchbar = driver
				.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view"));
		searchbar.click();

		WebElement searchproducttext = driver
				.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
		searchproducttext.sendKeys("toys");

		MobileElement selectitem = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"toys for 1 year old boy\"))"));
		selectitem.click();

		MobileElement item1 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().textContains(\"Little Tikes 2-in-1 Pirate Ship\"))"));
		item1.click();

//			AndroidElement item1pricetag= driver.findElementById("00000000-0000-0099-0000-017c000001b4");
//			String item1price= item1pricetag.getText();
//			
//			System.out.println(item1price);

		MobileElement cart1 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"Add to Cart\"))"));
		cart1.click();

		WebElement done = driver.findElement(By.xpath("//android.view.View[@text = 'DONE']"));
		done.click();

		String item1count = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/cart_count")).getText();
		System.out.println(item1count);

		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_back_icon_image")).click();

		MobileElement item2 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().textContains(\"Soft Car Toy Set with Play Mat\"))"));
		item2.click();

//			 
//			 AndroidElement item2pricetag= driver.findElementById("00000000-0000-0060-0000-434200000241");
//				String item2price= item2pricetag.getText();
//			 System.out.println(item2price);
//				
		MobileElement cart2 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"Add to Cart\"))"));
		cart2.click();

		String item2count = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/cart_count")).getText();
		System.out.println(item2count);

		WebElement bottombar = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/bottom_tab_nav_bar"));
		WebElement cart = bottombar.findElements(By.className("androidx.appcompat.app.ActionBar$Tab")).get(2);
		cart.click();

		TakeScreenshot("Multi_Product_TC_1");

		WebElement checkout = driver
				.findElement(By.xpath("//android.widget.Button[@text='Proceed to checkout (2 items)']"));
		checkout.click();

		// AndroidElement cartitem1=
		// totalitem.findElement(By.id("sc-item-Cc439f5a9-a6d6-46d6-82b3-a5b7dfc1332f"));
		// AndroidElement cartitem2=
		// totalitem.findElement(By.id("sc-item-Cf92facaf-c0cd-491e-8469-142207316a25"));

//			 String amount1 = driver.findElement(By.xpath("//android.view.View[@text='$18.99'])")).getText();
//			 System.out.println(amount1);
//			 
//			 String amount2 = driver.findElement(By.xpath("//android.view.View[@text='$11.99'])")).getText();
//			 System.out.println(amount1);
//			 
//			 String subtotal = driver.findElement(By.xpath("//android.widget.TextView[@text='$30.98'])")).getText();
//			 System.out.println(subtotal);

	}

	@Test
	public void Multi_Product_TC_2() throws IOException {
//		"To the above,
//
//		Click on the ""delete"" button to one of the product"
//		Capture the "cart count"

		commonsteps();

		WebElement searchbar = driver
				.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view"));
		searchbar.click();

		WebElement searchproducttext = driver
				.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
		searchproducttext.sendKeys("toys");

		MobileElement selectitem = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"toys for 1 year old boy\"))"));
		selectitem.click();

		MobileElement item1 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().textContains(\"Little Tikes 2-in-1 Pirate Ship\"))"));
		item1.click();

		MobileElement cart1 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"Add to Cart\"))"));
		cart1.click();

		WebElement done = driver.findElement(By.xpath("//android.view.View[@text = 'DONE']"));
		done.click();

		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_back_icon_image")).click();

		MobileElement item2 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().textContains(\"Soft Car Toy Set with Play Mat\"))"));
		item2.click();

		MobileElement cart2 = (MobileElement) driver
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().text(\"Add to Cart\"))"));
		cart2.click();

		WebElement bottombar = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/bottom_tab_nav_bar"));
		WebElement cart = bottombar.findElements(By.className("androidx.appcompat.app.ActionBar$Tab")).get(2);
		cart.click();

			WebElement cartformAndroidElement = driver
				.findElement(By.xpath("//android.view.View[@resource-id='activeCartViewForm']"));
		List<AndroidElement> deleteicon = cartformAndroidElement
				.findElements(By.xpath("//android.widget.Button[@text='Delete']"));

		if (deleteicon != null && deleteicon.size() > 0)
		{
			Integer numberofitemsInteger=  deleteicon.size();
			deleteicon.get(0).click();
			
		}
		TakeScreenshot("Multi_Product_TC_2");
		

	}

}