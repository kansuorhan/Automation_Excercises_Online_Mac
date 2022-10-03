package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

public class TestCase11_Verify_Subscription_Cart_Page extends TestCaseBeforeAfterClass {
    /*

    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Cart' button
    5. Scroll down to footer
    6. Verify text 'SUBSCRIPTION'
    7. Enter email address in input and click arrow button
    8. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test() throws Exception {
    //2
        driver.get("http://automationexercise.com");

    //3
    WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());


    //4
    driver.findElement(By.xpath(" //*[text()=' Cart']")).click();

    //5
    WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));

    JavascriptExecutor jse = (JavascriptExecutor) driver;

    jse.executeScript("arguments[0].scrollIntoView(true);",subscription);

    Thread.sleep(2000);

    //6
    Assert.assertTrue(subscription.isDisplayed());

    //7
    driver.findElement(By.cssSelector("#susbscribe_email")).sendKeys("aliatabak1@gmail.com" + Keys.ENTER);

    //8
    WebElement verifyMessage = driver.findElement(By.xpath("//*[@class='alert-success alert']"));
    Assert.assertEquals(verifyMessage.getText(),"You have been successfully subscribed!");


    }
}
