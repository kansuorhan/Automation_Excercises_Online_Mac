package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestCaseBeforeAfterClass;

import java.util.List;

public class TestCase12_Add_Products_in_Cart extends TestCaseBeforeAfterClass {
    @Test
    public void test() throws Exception {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'Products' button
        5. Hover over first product and click 'Add to cart'
        6. Click 'Continue Shopping' button
        7. Hover over second product and click 'Add to cart'
        8. Click 'View Cart' button
        9. Verify both products are added to Cart
        10. Verify their prices, quantity and total price
         */

        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5
        WebElement product1 = driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[1]"));
        WebElement productSelect = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[2]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",product1);

        Actions actions = new Actions(driver);
        actions.moveToElement(product1).perform();
        String product1Price = driver.findElement(By.xpath("(//h2)[4]")).getText();
        Thread.sleep(2000);
        actions.moveToElement(productSelect).click().perform();

        //6
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //7
        WebElement product2 = driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[2]"));
        WebElement productSelect2 = driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[4]"));
        actions.moveToElement(product2).perform();
        String product2Price = driver.findElement(By.xpath("(//h2)[6]")).getText();
        Thread.sleep(2000);
        actions.moveToElement(productSelect2).click().perform();

        //8
        driver.findElement(By.partialLinkText("View Cart")).click();
        Thread.sleep(2000);

        //9
        List<WebElement> productList = driver.findElements(By.xpath("//img[@class='product_image']"));
        Assert.assertEquals(2,productList.size());

        //10
        String cart1Price = driver.findElement(By.xpath("(//td[3]/p)[1]")).getText();
        String cart2Price = driver.findElement(By.xpath("(//td[3]/p)[2]")).getText();

        System.out.printf(product1Price);
        System.out.println(cart1Price);

        Assert.assertEquals(product1Price,cart1Price);
        Assert.assertEquals(product2Price,cart2Price);

    }
}
