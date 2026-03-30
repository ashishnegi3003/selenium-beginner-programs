package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests {
    @Test
    public void testLoginFunctionality()  {

        WebDriver driver=new ChromeDriver();
        // WebDriver driver=new FirefoxDriver(); //We can use Firefox driver as well.
        //Open page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");

        //Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

        //Push the Submit button
        driver.findElement(By.id("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String expectedUrl="https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String expectedText="Congratulations student. You successfully logged in!";
        String pageSource=driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText));

        //Verify button Log out is displayed on the new page
        WebElement logoutButton=driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        driver.quit();
    }

}

/*
Notes-
1. The @Test annotation lets the method run as a test without a main() method.
2. Run the test class from the IntelliJ terminal with: mvn test. Example- mvn test
3. You can also run: mvn clean test to remove prior build artifacts and old test results before executing. Example mnv clean test
4. You can run test class from Command Prompt as well— navigate to the project folder and run: mvn clean test.
5. IDE vs. CMD-
    a. IDE: Best while developing, when you want fast feedback and easy debugging.
    b. Command line: Best for scheduled/automated runs in CI tools like Jenkins or GitLab.
6. TestNG executes tests in alphabetical order of test class and then method names
 */
