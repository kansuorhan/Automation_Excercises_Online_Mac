package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        //5
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Ali Ata10");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aliatabak10@gmail.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
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


        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Ali Ata5");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Bak");
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
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("+15123445656");
        Thread.sleep(1500);

        WebElement clickCreateAccountButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",clickCreateAccountButton);
        Thread.sleep(2000);

        clickCreateAccountButton.click();

        //6
        WebElement createText = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        Assert.assertTrue(createText.getText().contains("ACCOUNT CREATED!"));

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //7
        WebElement loggedIn = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(loggedIn.isDisplayed());

        //8
        WebElement product1000 = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[5]"));
        String product1000Price = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[5]")).getText();
        jse.executeScript("arguments[0].scrollIntoView(true);",product1000);
        Thread.sleep(2000);

        //9
        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();
        driver.findElement(By.partialLinkText("View Cart")).click();

        //10
        WebElement checkoutPageButton = driver.findElement(By.xpath("//*[@class='btn btn-default check_out']"));
        Thread.sleep(2000);
        Assert.assertTrue(checkoutPageButton.isDisplayed());

        //11
        checkoutPageButton.click();

        //12
        WebElement devieryAddressPage = driver.findElement(By.xpath("//*[text()='Your delivery address']"));
        Assert.assertTrue(devieryAddressPage.isDisplayed());

        WebElement reviewOrderPage = driver.findElement(By.xpath("//*[text()='Review Your Order']"));
        Assert.assertTrue(reviewOrderPage.isDisplayed());

        //13
        WebElement descriptionArea = driver.findElement(By.xpath("//*[@name='message']"));
        Actions actions = new Actions(driver);
        jse.executeScript("arguments[0].scrollIntoView(true);",descriptionArea);
        Thread.sleep(1000);
        actions.moveToElement(descriptionArea).sendKeys("Merhaba Yeni Dunya");

        driver.findElement(By.xpath("//*[text()='Place Order']")).click();

        //14
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='name-on-card']")).sendKeys("Orhan");

        driver.findElement(By.xpath("//*[@data-qa='card-number']")).sendKeys("1234567891011121");

        driver.findElement(By.xpath("//*[@data-qa='cvc']")).sendKeys("311");

        driver.findElement(By.xpath("//*[@data-qa='expiry-month']")).sendKeys("09");

        driver.findElement(By.xpath("//*[@data-qa='expiry-year']")).sendKeys("2026");

        //15
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        Thread.sleep(5000);

        //16
        WebElement successText = driver.findElement(By.xpath("(//*[@class='alert-success alert'])[1]"));
        Assert.assertTrue(successText.isDisplayed());
        Thread.sleep(5000);

        //17
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //18
        driver.findElement(By.xpath("//*[text()='Delete']")).click();


    }
}
