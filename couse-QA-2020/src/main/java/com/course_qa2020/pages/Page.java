package com.course_qa2020.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Page {

    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public Page(final RemoteWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    //TODO I'd recommend to at least log out exception rather than just returning null as this will help with debugging/same applies to the method below
    protected WebElement getElement(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

        try {
            return driver.findElement(selector);
        } catch (Exception ex) {
            return null;
        }
    }

    protected List<WebElement> getElements(By selector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        try {
            return driver.findElements(selector);
        } catch (Exception ex) {
            return null;
        }
    }
}
