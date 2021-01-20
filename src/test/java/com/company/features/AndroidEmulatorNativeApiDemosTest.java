package com.company.features;

import com.company.base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AndroidEmulatorNativeApiDemosTest extends BaseTest {


    @Test
    public void testTouchActionsNexusAndroid7() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");

        cap.setCapability(MobileCapabilityType.APP, "/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/apk/ApiDemos-debug.apk");


        configAppiumDriver(cap);

        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();

        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@content-desc='Expandable Lists']");

        TouchAction touch = new TouchAction(driver);
        ElementOption elementOption = element(expandList);
        TapOptions tapOptions = tapOptions().withElement(elementOption);

        touch.tap(tapOptions).perform();

        driver.findElementByXPath("//android.widget.TextView[@content-desc='1. Custom Adapter']").click();

        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        touch.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();

        List<WebElement> listTitles = driver.findElementsById("android:id/title");

        Assert.assertTrue(listTitles.get(1).isDisplayed());

    }

    //Swipe Up
    @Test
    public void testSwipeDemoNexusAndroid7() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");

        cap.setCapability(MobileCapabilityType.APP, "/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/apk/ApiDemos-debug.apk");


        configAppiumDriver(cap);

        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByAccessibilityId("Date Widgets").click();

        AndroidDriver driverAndroid = (AndroidDriver) driver;
        driverAndroid.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

        driver.findElementByXPath("//*[@content-desc='9']").click();

        TouchAction touch = new TouchAction(driver);

        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second = driver.findElementByXPath("//*[@content-desc='45']");

        touch.longPress(longPressOptions()
                .withElement(element(first))
                .withDuration(Duration.ofSeconds(2)))
                .moveTo(element(second)).release().perform();
    }
}
