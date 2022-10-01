package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

public class TestCaseC07_Verify_Test_Cases_Page extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Test Cases' button
    5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void test() throws Exception {
        //2
        driver.get("http://automationexercise.com");

        //3
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4
        driver.findElement(By.xpath("//i[@class='fa fa-list']")).click();
        Thread.sleep(1500);

        //5
        WebElement testCaseText = driver.findElement(By.xpath("//h2/b"));
        Assert.assertTrue(testCaseText.isDisplayed());
    }
}
