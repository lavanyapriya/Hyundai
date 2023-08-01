package org.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
public class Mobile {
	

    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {

          

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("deviceName", "a63abfa5");
            caps.setCapability("platformName", "Android");
            caps.setCapability("appium:platfornVersion", "13");
    		 caps.setCapability("appPackage", "com.amazon.mShop.android.shopping"); 
            caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
            caps.setCapability("automationName", "UiAutomator2");
    		
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            clickOnLogin();

            clickOnProduct();

            addToCart();

            navigateToPaymentPage();



        } catch (Exception e) {

            e.printStackTrace();

        } finally {



            if (driver != null) {

                driver.quit();

            }

        }

    }


    private static void clickOnLogin() {

	       

        driver.findElementById("loginButton").click();
        
        String otp = getOTPFromMobileDevice(); 

        driver.findElement(By.id("otpInputField")).sendKeys(otp);

    }



    private static void clickOnProduct() {

        driver.findElementById("iphone13pro").click();

    }



    private static void addToCart() {

         driver.findElementById("addToCartButton").click();

    }



    private static void navigateToPaymentPage() {

        driver.findElementById("checkoutButton").click();

    }



    private static String getOTPFromMobileDevice() {


         String otp = executeAdbCommand("adb shell cat /path/to/otp_file");

         return otp;

    }


    private static String executeAdbCommand(String command) {

        Process process = Runtime.getRuntime().exec(command);

         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

         String line;

         StringBuilder output = new StringBuilder();

         while ((line = reader.readLine()) != null) {

             output.append(line).append("\n");

         }

         return output.toString();



    }
}

}
