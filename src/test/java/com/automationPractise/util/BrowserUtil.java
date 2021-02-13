package com.automationPractise.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {
    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    /**
     * wait until the webElement is clickable, then clicks it
     * simple click method
     * @param webElement
     */
    public static void clickOnElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    /**
     * scroll down until the selected webElement is visible
     * @param webElement
     */
    public static void scrollTillVisibleWithJS(WebElement webElement){
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].scrollIntoView", webElement);
    }

    /**
     * Enter specified text to the target webElement
     * @param element
     * @param text
     */
    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        // System.out.println("Entering text: " + text);
    }

    public static WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Performs a pause
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
