package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AndroidCalculatorPage {

    private WebDriver driver;

    //Numbers
    private By btnZero = By.xpath("//android.widget.Button[@text='0']");
    private By btnOne = By.xpath("//android.widget.Button[@text='1']");
    private By btnTwo = By.xpath("//android.widget.Button[@text='2']");
    private By btnThree = By.xpath("//android.widget.Button[@text='3']");
    private By btnFour = By.xpath("//android.widget.Button[@text='4']");
    private By btnFive = By.xpath("//android.widget.Button[@text='5']");
    private By btnSix = By.xpath("//android.widget.Button[@text='6']");
    private By btnSeven = By.xpath("//android.widget.Button[@text='7']");
    private By btnEight = By.xpath("//android.widget.Button[@text='8']");
    private By btnNine = By.xpath("//android.widget.Button[@text='9']");

    //Operators
    private By btnAdd = By.id("com.android.calculator2:id/op_add");
    private By btnSub = By.id("com.android.calculator2:id/op_sub");
    private By btnMul = By.id("com.android.calculator2:id/op_mul");
    private By btnDiv = By.id("com.android.calculator2:id/op_div");
    private By btnEqu = By.id("com.android.calculator2:id/eq");

    //Result
    private By txtResult = By.id("com.android.calculator2:id/result");

    public AndroidCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void calculate(String operator1, String operator2, String operation) {

        //120 ; Char[0] = 1; Char[1] = 2; Char[2] = 0;
        //Ingresar operador 1
        for (Character digit : operator1.toCharArray()) {
            if (digit.equals('0')) {
                driver.findElement(btnZero).click();
            } else if (digit.equals('1')) {
                driver.findElement(btnOne).click();
            } else if (digit.equals('2')) {
                driver.findElement(btnTwo).click();
            } else if (digit.equals('3')) {
                driver.findElement(btnThree).click();
            } else if (digit.equals('4')) {
                driver.findElement(btnFour).click();
            } else if (digit.equals('5')) {
                driver.findElement(btnFive).click();
            } else if (digit.equals('6')) {
                driver.findElement(btnSix).click();
            } else if (digit.equals('7')) {
                driver.findElement(btnSeven).click();
            } else if (digit.equals('8')) {
                driver.findElement(btnEight).click();
            } else if (digit.equals('9')) {
                driver.findElement(btnNine).click();
            }
        }

        //Ingresar la operacion
        switch (operation.toUpperCase()) {
            case "PLUS":
                driver.findElement(btnAdd).click();
                break;
            case "SUBTRACTION":
                driver.findElement(btnSub).click();
                break;
            case "MULTIPLICATION":
                driver.findElement(btnMul).click();
                break;
            case "DIVISION":
                driver.findElement(btnDiv).click();
                break;
            default:
                throw new IllegalStateException("The option " + operation.toUpperCase() + " is not present");
        }

        //Ingresar el operador 2
        for (Character digit : operator2.toCharArray()) {
            if (digit.equals('0')) {
                driver.findElement(btnZero).click();
            } else if (digit.equals('1')) {
                driver.findElement(btnOne).click();
            } else if (digit.equals('2')) {
                driver.findElement(btnTwo).click();
            } else if (digit.equals('3')) {
                driver.findElement(btnThree).click();
            } else if (digit.equals('4')) {
                driver.findElement(btnFour).click();
            } else if (digit.equals('5')) {
                driver.findElement(btnFive).click();
            } else if (digit.equals('6')) {
                driver.findElement(btnSix).click();
            } else if (digit.equals('7')) {
                driver.findElement(btnSeven).click();
            } else if (digit.equals('8')) {
                driver.findElement(btnEight).click();
            } else if (digit.equals('9')) {
                driver.findElement(btnNine).click();
            }
        }

        driver.findElement(btnEqu).click();

    }

    public String getResult(){
        return driver.findElement(txtResult).getText();
    }

}
