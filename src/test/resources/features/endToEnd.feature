Feature: end to end Scenario
Scenario: the user should be able to add a product to the cart, register a new user account and check out
  Given the user located at `automationpractice.com`
  When user Select to "Women" and select "Summer Dresses" from the Menu
  And user Mouse over "Printed Summer Dress" and click 'Quick view' button
  And Select "S" size from the drop down and click on Add to Cart button
  And Click on "Continue shopping" button

  When user Hover over to `Cart` section and click `Check Out` button
  And Click `Proceed to checkout` button

  When user enter an email and click on `create an Account` button
  And user fill in mandatory fields and click `Register` button

  When Click `Proceed to checkout` button on Address tab
  And Agree to `Terms of service` and Click on `Proceed to checkout` button on Shipping tab
  Then Confirm the correct order on `Payment` tab






