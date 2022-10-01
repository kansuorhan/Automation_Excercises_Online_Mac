package Automation_Excercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

public class TestCase04_Logout_User extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Logout' button
    10. Verify that user is navigated to login page
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
        WebElement loginUI = driver.findElement(By.xpath("//*[@class='login-form']"));
        Assert.assertTrue(loginUI.isDisplayed());

        //6
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("aliatabak1@gmail.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        Thread.sleep(1500);

        //7
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //8
        WebElement loggedVision = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));

        //9
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //10
        WebElement signupLoginButton = driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        Assert.assertTrue(signupLoginButton.isDisplayed());
    }
}
