package com.automationPractise.pages;

import com.automationPractise.util.BrowserUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage{

    Faker faker = new Faker();
    String randomEmail;

    @FindBy(xpath = "//p//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(id = "email_create")
    private WebElement emailInputBox;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInputBox;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInputBox;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passwordBox;

    @FindBy(id = "firstname")
    private WebElement firstnameAddressBox;

    @FindBy(id = "lastname")
    private WebElement lastnameAddressBox;

    @FindBy(id = "address1")
    private WebElement addressBox;

    @FindBy(id = "city")
    private WebElement cityBox;

    @FindBy(id = "postcode")
    private WebElement postcodeInputBox;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileInputBox;

    @FindBy(id = "id_state")
    private WebElement stateDropDown;

    @FindBy(id = "id_country")
    private WebElement countryDropDown;

    @FindBy(id = "alias")
    private WebElement aliasInputBox;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckOutAddressTab;

    @FindBy(id = "cgv")
    private WebElement termOfServiceCheckBox;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckOutShippingTab;

    @FindBy(xpath = "//p[@class='product-name']/a")
    private WebElement productName;

    public void clickProceedToCheckOutButton() {
        BrowserUtil.scrollTillVisibleWithJS(proceedToCheckoutBtn);
        BrowserUtil.clickOnElement(proceedToCheckoutBtn);
    }

    public void userEnterEmailAndClickOnButton() {
        randomEmail = faker.internet().emailAddress();
        BrowserUtil.enterText(emailInputBox, randomEmail);
        BrowserUtil.clickOnElement(createAnAccountBtn);
    }

    /**
     * enters text on mandatory fields
     * used javafaker library so that it will generate new information each time
     */
    public void userFillInMandatoryFieldsAndClickRegisterButton() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        BrowserUtil.enterText(firstNameInputBox,firstName);
        BrowserUtil.enterText(lastNameInputBox,lastName);
        BrowserUtil.enterText(emailBox, randomEmail);
        BrowserUtil.enterText(passwordBox,faker.internet().password());
        BrowserUtil.enterText(firstnameAddressBox,firstName);
        BrowserUtil.enterText(lastnameAddressBox,lastName);

        BrowserUtil.enterText(addressBox,faker.address().streetAddress());
        BrowserUtil.enterText(cityBox,faker.address().city());
        BrowserUtil.enterText(postcodeInputBox,faker.address().zipCode().substring(0,5));

        Select stateSelect = new Select(stateDropDown);
        stateSelect.selectByVisibleText(faker.address().state());
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByVisibleText("United States");

        BrowserUtil.enterText(phoneMobileInputBox,faker.phoneNumber().cellPhone());
        BrowserUtil.enterText(aliasInputBox,firstName+ " " + lastName + " Address");

        BrowserUtil.clickOnElement(registerBtn);
    }

    public void clickProceedToCheckOutButtonOnAddressTab() {
        BrowserUtil.clickOnElement(proceedToCheckOutAddressTab);
    }

    public void agreeToTermsOfService() {
        termOfServiceCheckBox.click();
    }

    public void clickOnProceedToCheckoutButtonOnShippingTab() {
        BrowserUtil.clickOnElement(proceedToCheckOutShippingTab);
    }

    public String getProductNameAtPaymentTab(){
        return productName.getText();
    }










}
