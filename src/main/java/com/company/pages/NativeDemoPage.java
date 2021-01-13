package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NativeDemoPage {

    private WebDriver driver;

    private By menuLogin = By.xpath("//android.view.ViewGroup[@content-desc='Login']");
    private By txtEmail = By.xpath("//android.widget.EditText[@content-desc='input-email']");
    private By txtPassword = By.xpath("//android.widget.EditText[@content-desc='input-password']");
    private By btnLogin = By.xpath("//android.view.ViewGroup[@content-desc='button-LOGIN']");


    public NativeDemoPage(WebDriver driver){

        this.driver = driver;
    }

    public void loginNativeDemo(String email, String password){

        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public void clickMenuLogin(){
        driver.findElement(menuLogin).click();
    }

    public String alert_getText(){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        return driver.switchTo().alert().getText();
    }


}
