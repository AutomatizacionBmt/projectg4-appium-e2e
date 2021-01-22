package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import com.company.utils.Urls;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSSimulatorRedmineLoginUITest extends BaseTest {

    @Test
    public void testLoginRedmineSimulatorIphoneXS(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCuiTest");
        cap.setCapability("platformName", "IOS");
        cap.setCapability("platformVersion", "12.0");
        cap.setCapability("deviceName", "iPhone Xs");
        cap.setCapability("webkitDebugProxyPort", 27753);
        cap.setCapability("wdaLocalPort", 8101);
        cap.setCapability("noReset", true);
        cap.setCapability("userNewWDA", true);
        cap.setCapability("fullReset", false);
        cap.setCapability("startIWDP", true);


        cap.setCapability("newCommandTimeout", 180);

        cap.setCapability("app", "");
        cap.setCapability("browserName", "Safari");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_URL_LOCAL);

        RedmineLandingPage redmineLandingPage = new RedmineLandingPage(driver);
        redmineLandingPage.clickOnMobileMenu();

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();

        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        redmineLandingPage.clickOnMobileMenu();

        String expectedUser = "user";
        String actualUser = redmineHomePage.getUserLoggedMobileEmulation();

        if(actualUser.equals("")) {
            redmineLandingPage.clickOnMobileMenu();
            actualUser = redmineHomePage.getUserLoggedMobileEmulation();
        }

        Assert.assertEquals("Login Fallido", expectedUser, actualUser);
    }

}
