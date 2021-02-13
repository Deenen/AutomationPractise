package com.automationPractise.pages;



import com.automationPractise.util.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class SelectedItemPage extends BasePage{

    @FindBy(id = "group_1")
    WebElement sizeDropDown;

    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    WebElement addToCart;

    String allProductXpath = "//ul[@class='product_list grid row']/li//a[@class='product_img_link']";
    String allQuickViewXpath = "//ul[@class='product_list grid row']/li//a[@class='quick-view']";
    String cartOptionsXpath = "//div[@class='button-container']//*[@title='%s']";


    /**
     * @param productName Printed Summer Dress, Printed Chiffon Dress
     *
     *  since there are two printed Summer Dress items
     *  I would need to ask to clarify which items i am testing
     *  ***here i assumed i am choosing the item with the discount
     */
    public void userMouseOveAndClickButton (String productName){
        List<WebElement> listOfProduct = driver.findElements(By.xpath(allProductXpath));
        List<WebElement> ListOfQuickViewBtn = driver.findElements(By.xpath(allQuickViewXpath));

        HashMap<Integer,String> mapOfAllProduct = new HashMap<>();
        HashMap<Integer,WebElement> searchedProduct = new HashMap<>();

        int index = 0;
        for (WebElement each : listOfProduct){
            mapOfAllProduct.put(index,each.getAttribute("title"));
            if (each.getAttribute("title").equalsIgnoreCase(productName)){
                searchedProduct.put(index,each);
            }
            index++;
        }

        Map.Entry<Integer, WebElement> entry = searchedProduct.entrySet().iterator().next();

        WebElement firstPrintedSummerDress = entry.getValue();
        WebElement quickViewBtn = ListOfQuickViewBtn.get(entry.getKey());

        action.moveToElement(firstPrintedSummerDress).moveToElement(quickViewBtn).click().build().perform();
    }

    /**
     * select the size from param
     * @param size S,M,L
     */
    public void  selectSizeFromDropDownAndClickOnButton(String size){
        int iframeSize = driver.findElements(By.tagName("iframe")).size();
        // System.out.println("iframe size = " + iframeSize);

        driver.switchTo().frame(0);
        Select select = new Select(sizeDropDown);
        select.selectByVisibleText(size);
        BrowserUtil.clickOnElement(addToCart);
        driver.switchTo().parentFrame();
    }

    /**
     * can click on either continue shopping or proceed to checkout btn
     * @param string Continue shopping, Proceed to checkout
     */
    public void clickOnButton(String string) {
        String xpath = String.format(cartOptionsXpath,string);
        BrowserUtil.clickOnElement(driver.findElement(By.xpath(xpath)));
    }

}
