package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.AndroidCalculatorPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorNativeUITest extends BaseTest {

    private AndroidCalculatorPage androidCalculatorPage;

    @Test
    public void testCalculatorCalculatePlusTwoNumbersNexusAndroid7() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("appWaitActivity", "com.android.calculator2.Calculator");

        configAppiumDriver(cap);

        androidCalculatorPage = new AndroidCalculatorPage(driver);
        androidCalculatorPage.calculate("120", "12", "plus");

        Assert.assertEquals("La suma es incorrecta:",
                "132",
                androidCalculatorPage.getResult());

    }
}
