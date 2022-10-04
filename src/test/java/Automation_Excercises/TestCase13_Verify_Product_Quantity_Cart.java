package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestCaseBeforeAfterClass;

import java.util.List;

public class TestCase13_Verify_Product_Quantity_Cart extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'View Product' for any product on home page
    5. Verify product detail is opened
    6. Increase quantity to 4
    7. Click 'Add to cart' button
    8. Click 'View Cart' button
    9. Verify that product is displayed in cart page with exact quantity
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

        //5 - 6 - 7
        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@data-product-id='29'])[1]")).click();

        //8
        driver.findElement(By.partialLinkText("View Cart")).click();
        Thread.sleep(2000);

        //9
        String productQuantity = driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        String cartPrice = driver.findElement(By.xpath("//*[@class='cart_price']")).getText();


        Assert.assertEquals("4",productQuantity);

        Assert.assertEquals(product1000Price,cartPrice);

    }
}
