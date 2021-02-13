package com.automationPractise.pages;

import com.automationPractise.util.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver = Driver.getDriver();
    Actions action = new Actions(driver);

}
