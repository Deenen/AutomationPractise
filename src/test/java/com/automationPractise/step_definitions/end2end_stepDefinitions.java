package com.automationPractise.step_definitions;

import com.automationPractise.pages.HomePage;
import com.automationPractise.pages.ShoppingCartPage;
import com.automationPractise.pages.SelectedItemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class end2end_stepDefinitions {

    HomePage homePage = new HomePage();
    SelectedItemPage selectedItem = new SelectedItemPage();
    ShoppingCartPage shoppingCart = new ShoppingCartPage();
    String selectedItemName;

    @Given("the user located at `automationpractice.com`")
    public void theUserLocatedAtAutomationPracticePage() {
        homePage.goToUrlPage();
    }

    @When("user Select to {string} and select {string} from the Menu")
    public void user_select_to_and_select_from_the_menu(String string, String string2) {
        homePage.userSelectToAndSelectFromTheMenu(string,string2);
    }

    @And("user Mouse over {string} and click 'Quick view' button")
    public void user_mouse_over_and_click_button(String string) {
        selectedItem.userMouseOveAndClickButton(string);
        selectedItemName = string;
    }

    @And("Select {string} size from the drop down and click on Add to Cart button")
    public void select_size_from_the_drop_down_and_click_on_button(String string) {
        selectedItem.selectSizeFromDropDownAndClickOnButton(string);
    }

    @And("Click on {string} button")
    public void click_on_button(String string) {
        selectedItem.clickOnButton(string);
    }

    @When("user Hover over to `Cart` section and click `Check Out` button")
    public void user_hover_over_to_cart_section_and_click_check_out_button() {
        homePage.userHoverOverToSectionAndClickOnButton();
    }

    @And("Click `Proceed to checkout` button")
    public void click_proceed_to_checkout_button() {
        shoppingCart.clickProceedToCheckOutButton();
    }

    @When("user enter an email and click on `create an Account` button")
    public void user_enter_an_email_and_click_on_button() {
        shoppingCart.userEnterEmailAndClickOnButton();
    }

    @And("user fill in mandatory fields and click `Register` button")
    public void user_fill_in_mandatory_fields_and_click_register_button() {
        shoppingCart.userFillInMandatoryFieldsAndClickRegisterButton();
    }

    @When("Click `Proceed to checkout` button on Address tab")
    public void click_proceed_to_checkout_button_on_address_tab() {
        shoppingCart.clickProceedToCheckOutButtonOnAddressTab();
    }

    @And("Agree to `Terms of service` and Click on `Proceed to checkout` button on Shipping tab")
    public void agree_to_terms_of_service_and_click_on_proceed_to_checkout_button_on_shipping_tab() {
        shoppingCart.agreeToTermsOfService();
        shoppingCart.clickOnProceedToCheckoutButtonOnShippingTab();
    }

    @Then("Confirm the correct order on `Payment` tab")
    public void confirm_the_correct_order_on_payment_tab() {
        System.out.println();
        String expectedResult = selectedItemName;
        System.out.println("expectedResult = " + expectedResult);
        String actualResult = shoppingCart.getProductNameAtPaymentTab();
        System.out.println("actualResult = " + actualResult);
        Assert.assertEquals("expectedResult doesnt match with actualResult",expectedResult,actualResult);
    }

}
