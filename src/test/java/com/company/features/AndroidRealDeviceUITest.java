package com.company.features;

import com.company.base.BaseTest;
import com.company.pages.RedmineHomePage;
import com.company.pages.RedmineLandingPage;
import com.company.pages.RedmineLoginPage;
import com.company.utils.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidRealDeviceUITest extends BaseTest {


    @Test
    public void testLoginRedmineRealDeviceLGXAndroid9(){

        /* Consideraciones
        1.- Requisito: Activar las opciones para desarrolladores y la depuración por usb en el
        dispositivo real.
        2.- Descargar el chromedriver para la versión correcta de nuestro chrome de nuestro dispositivo móvil.
        3.- Identificar el "udid" correcto, conectando con un cable usb Movil - COmputadora ; luego ejecutar comando:
        en la terminal : adb devices .
        */

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","9.0");
        cap.setCapability("deviceName","Nexus5Android7");
        cap.setCapability("udid","LGK240IN9HSGHA");

        cap.setCapability("browserName","Chrome");

        //Para Windows
        cap.setCapability("chromedriverExecutableDir","/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/drivers/chrome/windows");

        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        //Para MAC
        //cap.setCapability("chromedriverExecutableDir","/Users/jhumbertoh/Proyectos/Publicos/projectg4-appium-e2e/resources/drivers/chrome/mac");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_URL_LOCAL);

        RedmineLandingPage redmineLandingPage = new RedmineLandingPage(driver);
        redmineLandingPage.clickOnMobileMenu();

        RedmineLoginPage redmineLoginPage = redmineLandingPage.clickLinkLogin();

        RedmineHomePage redmineHomePage = redmineLoginPage.login("user", "bitnami1");

        redmineLandingPage.clickOnMobileMenu();

        String expectedUser = "user";
        String actualUser = redmineHomePage.getUserLoggedMobileEmulation();

        Assert.assertEquals("Login Fallido", expectedUser, actualUser);

    }
}
