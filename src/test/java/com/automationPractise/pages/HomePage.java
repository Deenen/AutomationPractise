package com.automationPractise.pages;

import com.automationPractise.util.BrowserUtil;
import com.automationPractise.util.configurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCart;

    @FindBy(id = "button_order_cart")
    private WebElement checkOutBtn;

    protected String listOfCategoriesXpath = "//div[@class='cat-title']/following-sibling::*/li/a[@title='%s']";
    protected String listOfSubCategoriesXpath = "/..//a[contains(.,'%s')]";

    /**
     * retrieve the url from configuration.property file
     */
    public void goToUrlPage(){
        driver.get(configurationReader.getProperty("url"));
    }

    /**
     * @param mainMenu Women, Dresses, T-shirts
     * @param subMenu  Casual Dresses, Evening Dresses, Summer Dresses
     *                 T-shirts, Blouses
     */
    public void userSelectToAndSelectFromTheMenu(String mainMenu, String subMenu){
        String string1Xpath = String.format(listOfCategoriesXpath,mainMenu);
        String string2Xpath = String.format((string1Xpath + listOfSubCategoriesXpath), subMenu);

        WebElement mainMenuElement = driver.findElement(By.xpath(string1Xpath));
        WebElement subMenuElement = driver.findElement(By.xpath(string2Xpath));
        action.moveToElement(mainMenuElement).moveToElement(subMenuElement).click().build().perform();
    }

    public void userHoverOverToSectionAndClickOnButton() {
        BrowserUtil.waitFor(1);
        action.moveToElement(shoppingCart).build().perform();
        BrowserUtil.clickOnElement(checkOutBtn);
    }

}
