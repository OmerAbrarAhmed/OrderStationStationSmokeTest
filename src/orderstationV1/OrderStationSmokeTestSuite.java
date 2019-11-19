package orderstationV1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrderStationSmokeTestSuite {
private static final String Screenshot = "C:\\Users\\ThinkPad\\QA Test Screenshots\\TC-";
private static final String Staging = "com.hungerstation.android.reception.debug:id";
private static final String USER_DIR = "user.dir";
private static AndroidDriver driver;
private static final String Link_Device_Key = "204907999944";
private static final String Path_to_CutomerApp_apk = "C:\\Users\\ThinkPad\\eclipse-workspace\\OmarAutomationScript\\Apps\\HungerStation\\HungerStation-794-(6.5.8).apk";
private static WebElement element;	
public static void PlacingOrderFromCustomerApp (AndroidDriver driver ) throws IOException {
			driver.installApp(Path_to_CutomerApp_apk);
			driver.navigate().back();
			driver.navigate().back();
			driver.findElementByAccessibilityId("HungerStation").click();
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/txtlanguage").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/orders_item").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/btnaction").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/phone_number").sendKeys("533730426");
			MobileElement a1 = (MobileElement) driver.findElementById("com.hungerstation.android.web.debug:id/btn_login");
			a1.click();
			a1.sendKeys("000000");
			driver.findElementByXPath(
					"//android.widget.FrameLayout[@content-desc=\"Restaurants\"]/android.widget.ImageView").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/imgloc").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/loc_text").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/input").sendKeys("Omar");
			driver.findElementById("com.hungerstation.android.web.debug:id/constrain_parent").click();
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
					.click();
			driver.findElementById("com.hungerstation.android.web.debug:id/image_plus").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[3]/android.widget.TextView")
					.click();
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
					.click();
			driver.findElementById("com.hungerstation.android.web.debug:id/image_plus").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/btn_checkout").click();
			driver.findElementById("com.hungerstation.android.web.debug:id/btn_checkout").click();

	}	
public static void linkingDeviceTest(AndroidDriver driver ) throws IOException {  
		driver.launchApp();
		driver.findElementById(Staging + "/btnManual").click();
		driver.findElementById(Staging + "/et_company_code").click();
		driver.findElementById(Staging + "/et_company_code").sendKeys(Link_Device_Key);
		driver.findElementById(Staging + "/bt_go").click();
		screenshot(Screenshot + "Linking Device Test(OS)");
		}
public static void AcceptingPendingOrderTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		screenshot(Screenshot + "Order Successfully Received(OS) ");
		driver.findElementById(Staging + "/btnAccept").click();// accepting order test
		screenshot(Screenshot + "Choosing delivery time(OS) ");
		driver.findElementById(Staging + "/md_title").click();// accepting order test
		driver.findElementById(Staging + "/md_buttonDefaultPositive").click(); // accepting order test
		Thread.sleep(5000);
		screenshot(Screenshot + "Order Accepted Test(OS)");
		Thread.sleep(5000);
		}	
public static void ViewCustomerInformationTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById(Staging + "/action_user").click(); // customer details test (human icon)
		screenshot(Screenshot + "View Customer Information or Customer's previous no. of orders (OS)");
		driver.findElementById(Staging + "/md_buttonDefaultPositive").click(); // customer detail icon test
		driver.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(5000);	
	}
public static void MenuItemAvailibilityTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById("com.hungerstation.android.reception.debug:id" + "/menuIcon").click();// View Menu
		driver.findElementById("com.hungerstation.android.reception.debug:id" + "/actionMenu").click();// view Bakery
		driver.findElementById("com.hungerstation.android.reception.debug:id" + "/tv_name_group").click();// View Bakery
		Thread.sleep(3000);
		screenshot(Screenshot + "View bakery items in the menu(OS)");
		driver.findElementById("com.hungerstation.android.reception.debug:id" + "/sw_unavailable").click();// View
																											// Bakery
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='1']").click();// View Canned Food Items
		Thread.sleep(5000);
		screenshot(Screenshot + "View Canned Food Items(OS)");
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='2']").click();// view food items in the menu
		Thread.sleep(3000);
		screenshot(Screenshot + "View Food Items(OS)");
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(5000);
	}
public static void PlacingSecondOrderFromCustomerApp(AndroidDriver driver ) throws IOException{  
		driver.installApp(Path_to_CutomerApp_apk);
		driver.navigate().back();
		driver.navigate().back();
		driver.findElementByAccessibilityId("HungerStation").click();
		driver.findElementByXPath(
				"//android.widget.FrameLayout[@content-desc=\"Restaurants\"]/android.widget.ImageView").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/imgloc").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/loc_text").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/input").sendKeys("Omar");
		driver.findElementById("com.hungerstation.android.web.debug:id/constrain_parent").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
				.click();
		driver.findElementById("com.hungerstation.android.web.debug:id/image_plus").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[3]/android.widget.TextView")
				.click();
		driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
				.click();
		driver.findElementById("com.hungerstation.android.web.debug:id/image_plus").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/parent_layout").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/btn_checkout").click();
		driver.findElementById("com.hungerstation.android.web.debug:id/btn_checkout").click();
	}	
public static void DecliningPendingOrderTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.launchApp();
		driver.findElementById(Staging + "/btnManual").click();
		driver.findElementById(Staging + "/et_company_code").click();
		driver.findElementById(Staging + "/et_company_code").sendKeys(Link_Device_Key);
		driver.findElementById(Staging + "/bt_go").click();
		screenshot(Screenshot + "Linking Device Test(OS)");
		driver.findElementById(Staging + "/btnShowMap").click();// view map from pop up dialog test
		screenshot(Screenshot + "Changing Language Test");
		Thread.sleep(7000);
		screenshot(Screenshot + "View Map From Pop-up Test(OS)");
		driver.findElementById(Staging + "/btnDecline").click(); // declining order test
		driver.findElementById(Staging + "/md_control").click(); // declining order test
		screenshot(Screenshot + "Pick a Reason for Decline Test(OS)");
		driver.findElementByXPath("//android.widget.LinearLayout[@index='4']").click();// Kitchen is busy
		driver.findElementById(Staging + "/md_buttonDefaultPositive").click(); // declining order test
		screenshot(Screenshot + "Kitchen is busy(OS)");
		driver.findElementById(Staging + "/md_buttonDefaultPositive").click();
		Thread.sleep(7000);
	}	
public static void FoodPreparedOutForDeliveryTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById("com.hungerstation.android.reception.debug:id/txtOrderId").click();// Out for delivery
		driver.findElementById("com.hungerstation.android.reception.debug:id/btnOutForDelivery").click();
		driver.findElementById("android:id/button1").click();
		screenshot(Screenshot + "Send Loation to Driver & Out for Delivery Button(OS)");
	}
public static void ChangingAppLanguageTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById(Staging + "/menuIcon").click(); // changing language test
		driver.findElementById(Staging + "/actionSettings").click(); // changing language test
		driver.findElementById(Staging + "/pspinnerLanguage").click(); // changing language test
		driver.findElementById("android:id/text1").click(); // changing language test
		driver.findElement(By.className("android.widget.ImageButton")).click(); // changing language test
	}
public static void ViewOrdersDailyReportTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById("com.hungerstation.android.reception.debug:id/menuIcon").click();// view history
		driver.findElementById("com.hungerstation.android.reception.debug:id/actionHistory").click();// view history
		Thread.sleep(3000);
		screenshot(Screenshot + "View History(OS)");
		Thread.sleep(3000);
	}
public static void PrintOrdersDailyReportTest(AndroidDriver driver ) throws IOException, InterruptedException {  
		driver.findElementById("com.hungerstation.android.reception.debug:id/action_print").click(); // print history
		driver.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);
		driver.quit();
	}

public static void main(String[] args) throws MalformedURLException, InterruptedException, IOException {
File classpathRoot = new File(System.getProperty(USER_DIR));
File appDir = new File(classpathRoot, "/Apps/Orderstation/");
File app = new File(appDir, "app-debug.apk");
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
capabilities.setCapability("deviceName", "V1s-G");
capabilities.setCapability("platformVersion", "7.1.1");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("app", app.getAbsolutePath());
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	
PlacingOrderFromCustomerApp(driver);
linkingDeviceTest(driver);
AcceptingPendingOrderTest(driver);
ViewCustomerInformationTest(driver);
MenuItemAvailibilityTest(driver);
PlacingSecondOrderFromCustomerApp(driver);
DecliningPendingOrderTest(driver);
FoodPreparedOutForDeliveryTest(driver);
ChangingAppLanguageTest(driver);
ViewOrdersDailyReportTest(driver);
PrintOrdersDailyReportTest(driver);
	}

public static void screenshot(String path_screenshot) throws IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		// String filename=UUID.randomUUID().toString();
		File targetFile = new File(path_screenshot + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);

	}
}
