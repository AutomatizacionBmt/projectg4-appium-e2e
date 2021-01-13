package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.NativeDemoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorNativeDemoAppUITest extends BaseTest {

    private NativeDemoPage nativeDemoPage;


    @Test
    public void testDemoAppPixelAndroid81(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1");
        cap.setCapability("deviceName", "Pixel_8.1");
        cap.setCapability("avd", "Pixel_8.1");
        cap.setCapability("avdArgs", "-port 5558");
        cap.setCapability("orientation","PORTRAIT");

        cap.setCapability("app", "/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/apk/Android-NativeDemoApp-0.2.1.apk");

        configAppiumDriver(cap);
    }

    @Test
    public void testLoginNativeDemoAppPixelAndroid81(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1");
        cap.setCapability("deviceName", "Pixel_8.1");
        cap.setCapability("avd", "Pixel_8.1");
        cap.setCapability("avdArgs", "-port 5558");
        cap.setCapability("orientation","PORTRAIT");

        cap.setCapability("app", "/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/apk/Android-NativeDemoApp-0.2.1.apk");

        configAppiumDriver(cap);

        nativeDemoPage = new NativeDemoPage(driver);
        nativeDemoPage.clickMenuLogin();
        nativeDemoPage.loginNativeDemo("test@webdriver.io", "Test1234!");

        Assert.assertEquals("Login Fallido!",
                "Success\n" +
                "You are logged in!",
                nativeDemoPage.alert_getText());
    }
}