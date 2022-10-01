package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

public class TestCase08_Verify_All_Products extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Products' button
    5. Verify user is navigated to ALL PRODUCTS page successfully
    6. The products list is visible
    7. Click on 'View Product' of first product
    8. User is landed to product detail page
    9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test() throws Exception {
        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

        //5
        WebElement allProducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertEquals(allProducts.getText(),"All Products");

        //6
        WebElement productList = driver.findElement(By.xpath("//*[@id='cartModal']"));
        Assert.assertTrue(productList.isDisplayed());

        //7
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]")).click();

        //8
        WebElement productDetailPage = driver.findElement(By.xpath("//div[@class='product-details']"));
        Assert.assertTrue(productDetailPage.isDisplayed());
    }
}
