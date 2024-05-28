package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’
 * <p>
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();
        // Get the Text after clicking on Sign In
        String expectedText = "Welcome Back!";
        // x-Path with tagName and attributes
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        // Verify the Text
        Assert.assertEquals("Text didn't match!", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {

        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();
        // Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("prime123@gmail.com");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Prime123");
        // Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        // Verify the error message
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

























