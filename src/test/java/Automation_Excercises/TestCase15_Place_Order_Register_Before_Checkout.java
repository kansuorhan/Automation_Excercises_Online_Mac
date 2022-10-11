package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

public class TestCase15_Place_Order_Register_Before_Checkout extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill all details in Signup and create account
    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'Cart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify Address Details and Review Your Order
    13. Enter description in comment text area and click 'Place Order'
    14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    15. Click 'Pay and Confirm Order' button
    16. Verify success message 'Your order has been placed successfully!'
    17. Click 'Delete Account' button
    18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
    @Test
    public void test() throws Exception {
        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();


    }
}
