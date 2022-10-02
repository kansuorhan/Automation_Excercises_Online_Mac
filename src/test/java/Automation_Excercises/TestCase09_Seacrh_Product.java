package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

import java.security.Key;
import java.util.List;

public class TestCase09_Seacrh_Product extends TestCaseBeforeAfterClass {

    @Test
    public void test() throws Exception {
        /*
         Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Products' button
        5. Verify user is navigated to ALL PRODUCTS page successfully
        6. Enter product name in search input and click search button
        7. Verify 'SEARCHED PRODUCTS' is visible
        8. Verify all the products related to search are visible
         */

        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        //5
        WebElement allProducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertEquals(allProducts.getText(),"ALL PRODUCTS");

        //6
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("tshirt" + Keys.ENTER);

        //7
        WebElement searchProduct = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(searchProduct.getText() == "ALL PRODUCTS");

        //8
        List<WebElement> allInputNames = driver.findElements(By.xpath("//h2"));
        Assert.assertTrue(allInputNames.contains("tshirt"));


    }
}
