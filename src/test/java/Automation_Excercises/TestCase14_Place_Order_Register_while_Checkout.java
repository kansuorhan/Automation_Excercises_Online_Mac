package Automation_Excercises;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestCaseBeforeAfterClass;

import javax.swing.*;

public class TestCase14_Place_Order_Register_while_Checkout extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Add products to cart
    5. Click 'Cart' button
    6. Verify that cart page is displayed
    7. Click Proceed To Checkout
    8. Click 'Register / Login' button
    9. Fill all details in Signup and create account
    10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    11. Verify ' Logged in as username' at top
    12.Click 'Cart' button
    13. Click 'Proceed To Checkout' button
    14. Verify Address Details and Review Your Order
    15. Enter description in comment text area and click 'Place Order'
    16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    17. Click 'Pay and Confirm Order' button
    18. Verify success message 'Your order has been placed successfully!'
    19. Click 'Delete Account' button
    20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void test() throws Exception {
        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        WebElement product1000 = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[5]"));
        String product1000Price = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[5]")).getText();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",product1000);
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();
        driver.findElement(By.partialLinkText("View Cart")).click();

        //5
        WebElement cart = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]"));
        cart.click();

        //6
        WebElement checkoutPageButton = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        Thread.sleep(2000);
        Assert.assertTrue(checkoutPageButton.isDisplayed());

        //7
        checkoutPageButton.click();

        //8
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

        //9
        WebElement signUpText = driver.findElement(By.xpath("//h2"));
        if (signUpText.getText().contains("New User Signup!")) {
            System.out.println("Sign Up testi PASSED");
        } else {
            System.out.println("Sign Up testi FAILED");
        }

        //6
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ali Ata1");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aliatabak2@gmail.com");

        //7
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8
        WebElement headerAccount = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        if (headerAccount.isDisplayed()) {
            System.out.println("Enter Account testi PASSED");
        } else {
            System.out.println("Enter Account testi FAILED");
        }

        //9
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[1]")).sendKeys("5");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[2]")).sendKeys("August");
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//select[@class='form-control'])[3]")).sendKeys("1986");
        Thread.sleep(1500);


        WebElement newsletterCheck = driver.findElement(By.xpath("//input[@id='newsletter']"));
        if (!newsletterCheck.isSelected()) {
            newsletterCheck.click();
        }


        WebElement offerCheck = driver.findElement(By.xpath("//input[@id='optin']"));
        if (!offerCheck.isSelected()) {
            offerCheck.click();
        }


        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Ali Ata1");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Bak1");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Ahmet Mah. Aslan Sokak");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("United States");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Arizona");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Arizona State");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("75052");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("+15123445655");
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        //10
        WebElement createText = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        if (createText.getText().contains("ACCOUNT CREATED!")) {
            System.out.println("Account Create testi PASSED");
        } else {
            System.out.println("Account Create testi FAILED");
        }

        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //11
        WebElement loggedIn = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        if (loggedIn.isDisplayed()) {
            System.out.println("Log In testi PASSED");
        } else {
            System.out.println("Log In testi FAILED");
        }

        //12
        cart.click();

        //13
        checkoutPageButton.click();

        //14
        WebElement devieryAddressPage = driver.findElement(By.xpath("//*[text()='Your delivery address']"));
        Assert.assertTrue(devieryAddressPage.isDisplayed());

        WebElement reviewOrderPage = driver.findElement(By.xpath("//*[text()='Review Your Order']"));
        Assert.assertTrue(reviewOrderPage.isDisplayed());

        //15
        WebElement descriptionArea = driver.findElement(By.xpath("//*[@name='message']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(descriptionArea).sendKeys("Merhaba Yeni Dunya");

        driver.findElement(By.xpath("//*[text()='Place Order']")).click();

        //16
        driver.findElement(By.xpath("/*[@name=‘name_on_card’]")).sendKeys("Orhan");

        driver.findElement(By.xpath("/*[@name=‘card_number’]")).sendKeys("1234567891011121");

        driver.findElement(By.xpath("//*[@name=‘cvc’]")).sendKeys("311");

        driver.findElement(By.xpath("//*[@name=‘expiry_month")).sendKeys("09");

        driver.findElement(By.xpath("//*[@name=‘expiry_year’]")).sendKeys("2026");

        //17
        driver.findElement(By.xpath("//*[@id=‘submit’]")).click();
        Thread.sleep(2000);

        //18
        WebElement successText = driver.findElement(By.xpath("(//*[@class='alert-success alert'])[1]"));
        Assert.assertTrue(successText.isDisplayed());

        //19
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //20
        driver.findElement(By.xpath("//*[text()='Delete']")).click();




    }
}
