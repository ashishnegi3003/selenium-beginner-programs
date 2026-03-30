package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests {
    @Test
    public void incorrectUsernameTest(){
        WebDriver driver=new ChromeDriver();

        //Open page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username incorrectUser into Username field
        driver.findElement(By.id("username")).sendKeys("IncorrectUser1");

        //Type password Password123 into Password field
        driver.findElement(By.id("password")).sendKeys("Password123");

        //Push Submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        //Verify error message text is Your username is invalid!
        String actualError= errorMessage.getText();
        String expectedError="Your username is invalid!";
        Assert.assertEquals(actualError,expectedError);

        driver.quit();

    }
    @Test
    public void incorrectPasswordTest(){

        //Open page
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(By.id("username")).sendKeys("student");

        //Type password incorrectPassword into Password field
        driver.findElement(By.id("password")).sendKeys("WrongPassword1");

        //Push Submit button
        driver.findElement(By.id("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Verify error message is displayed
        Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());

        //Verify error message text is Your password is invalid!
        Assert.assertEquals(driver.findElement(By.id("error")).getText(),"Your password is invalid!");

        driver.quit();
    }
}
