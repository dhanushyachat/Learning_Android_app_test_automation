import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base_Class {
	public AndroidDriver<AndroidElement> driver;

	@BeforeMethod

	public void initiate() throws MalformedURLException
	{
		File appFile = new File("src/main/resources");
		File file = new File(appFile, "amazon_shopping_24.6.0.100.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 30");
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@AfterMethod
	public void teardown()
	{
		if (driver != null) {
			driver.quit();
		}

	}
	public void TakeScreenshot(String filename) throws IOException {
		if(driver!=null) {
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File DestFile=new File("src/main/resources/screenshots/"+filename+".png");
		    FileUtils.copyFile(scrFile, DestFile);
		}
	}
	
	
	public void commonsteps() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement cancelElement = driver.findElement(By.xpath("//android.widget.TextView[@text = 'CANCEL']"));
		cancelElement.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement skipElement=driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button"));
		skipElement.click();	
	}
	
}
