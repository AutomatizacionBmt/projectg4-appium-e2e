package com.company.features;

import com.company.base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorNativeDemoAppUITest extends BaseTest {


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



}
