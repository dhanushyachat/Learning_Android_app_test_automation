import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Single_product extends Base_Class {

	@Test
	// [ADD_CART]Validating Available Item from the List

	public void Single_product_TC_1() throws IOException {
//	  Launch Amazon app
//	  Skip Sign in button
//	  In the Widget click on the "Shop Laptop" view
//	  Perform a mobile gesture like scrolling and halt to the desired element
//	  Click on the "lenovo Flex" latop product
//	  Verify for the item
//	  Click on the "Add to Cart" button
//	  Capture the "cart count"
//	  Click on "cart" button
//	  "Verify for the following
//	  qty - 1
//	  item price - 
//	  total - 
//	  Item description - 
//	  checkout button details - 
//
//	  and grab them into the results screen"
//	  Tap on "Proceed to checkout" button

	
		commonsteps();
		
		WebElement selectitemElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Shop laptops']"));
		selectitemElement.click();
		
		MobileElement toelement = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().textContains(\"Lenovo Flex 5 Laptop, 14.0\"))"));

		toelement.click();
	 
		MobileElement addtocart = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Add to Cart\"))"));
		addtocart.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement  msg = driver.findElementById("com.amazon.mShop.android.shopping:id/mash_web_fragment");
		WebElement addtocartviewelement= msg.findElement(By.xpath("//android.view.View[@resource-id = 'attach-accessory-card-deck']"));
		
		WebElement msgdataElement=	addtocartviewelement.findElement(By.xpath("//android.view.View[@text = 'Added to your cart']"));
		System.out.println(msgdataElement.getText());
		WebElement done = msg.findElement(By.xpath("//android.view.View[@text = 'DONE']"));
		done.click();
		
		String itemcount = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/cart_count")).getText();
		System.out.println(itemcount);
				
		WebElement bottombar = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/bottom_tab_nav_bar"));
		WebElement cart= bottombar.findElements(By.className("androidx.appcompat.app.ActionBar$Tab")).get(2);
	    cart.click();
	    
//	    String price= driver.findElement(By.id("00000000-0000-01bc-0000-2d1900000143")).getText();
//	    System.out.println(price);
//	    price=price.substring(1);
//	    double pricefinal= Double.parseDouble(price);
//	    
//	    String subtotal= driver.findElement(By.id("00000000-0000-01bc-0000-2ce100000143")).getText();
//	    System.out.println(subtotal);
//	    subtotal=subtotal.substring(1);
//	    double subtotalfinal= Double.parseDouble(subtotal);
//	    
//	    assertEquals(pricefinal, subtotalfinal);

		TakeScreenshot("Single_product_TC_1");
	    
	    WebElement checkout = driver.findElement(By.xpath("//android.widget.Button[@text='Proceed to checkout (1 item)']"));
	    checkout.click();
	    
	    
	}

	@Test
	// [ADD CART] Validating Not existing Product

	public void Single_product_TC_2() throws IOException {
//	  Launch Amazon app
//	  Skip Sign in button
//	  In the Widget click on the "Shop Laptop" view
//	  Add the procut of "One plus laptop"

		commonsteps();
		
		WebElement selectitemElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Shop laptops']"));
		selectitemElement.click();
		try {
			MobileElement toelement = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			         ".scrollIntoView(new UiSelector().textContains(\"One Plus Laptop\"))"));
			
			Assert.assertNull(toelement);
			
	//		assertThrows(NoSuchElementException.class,toelement);
		} catch (InvalidSelectorException  e) {
			
		 assertTrue(true,e.getMessage());
			// TODO: handle exception
		} catch (NoSuchElementException  e) {

			 assertTrue(true,e.getMessage());
			// TODO: handle exception
		} catch (RuntimeException  e) {

			 assertTrue(true,e.getMessage());
			// TODO: handle exception
		}catch (Exception  e) {

			 assertTrue(true,e.getMessage());
			// TODO: handle exception
		}
		TakeScreenshot("Single_product_TC_2");
		//String v= toelement.getText();
//		 String value = "One Plus Laptop";
//		if (v == value)
//		{
//			System.out.println("Not available in the list");
//		}
	}



}
