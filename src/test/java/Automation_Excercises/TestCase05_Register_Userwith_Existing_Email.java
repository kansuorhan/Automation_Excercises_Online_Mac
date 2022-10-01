package Automation_Excercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestCaseBeforeAfterClass;

import java.io.DataInput;

import static utilities.TestCaseBeforeAfterClass.driver;

public class TestCase05_Register_Userwith_Existing_Email extends TestCaseBeforeAfterClass {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and already registered email address
    7. Click 'Signup' button
    8. Verify error 'Email Address already exist!' is visible
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
    WebElement newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
    Assert.assertTrue(newUser.isDisplayed());

    //6
    driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Ali Ata");

    driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("aliatabak1@gmail.com");
    Thread.sleep(1500);

    //7
    driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

    //8
    WebElement errorMessage = driver.findElement(By.xpath("//*[@style='color: red;']"));
    Assert.assertEquals("Email Address already exist!", errorMessage.getText());

    }
}
