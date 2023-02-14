package by.itacademy.krysiuknikolay.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
    @Test
    public void testOpenAmazon() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates", driver.findElement(By.xpath(AmazonPage.COPYRIGHT)).getText());

        driver.quit();
    }
    @Test
    public void testOpenAmazonCart() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        Thread.sleep(2000);
        Assert.assertEquals("Your Amazon Cart is empty", driver.findElement(By.xpath(AmazonPage.FORM_HEADER_TEXT_CART_IS_EMPTY)).getText());

        driver.quit();
    }
    @Test
    public void testOpenAmazonLoginForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_SIGN_IN_TO_YOUR_ACCOUNT)).click();
        Thread.sleep(2000);
        Assert.assertEquals("Sign in", driver.findElement(By.xpath(AmazonPage.FORM_HEADER_TEXT_SIGN_IN)).getText());

        driver.quit();
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AmazonPage.URL);
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_SIGN_IN_TO_YOUR_ACCOUNT)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_CONTINUE)).click();
        Thread.sleep(2000);
        Assert.assertEquals("Enter your email or mobile phone number",driver.findElement(By.xpath(AmazonPage.FORM_EMPTY_YOUR_EMAIL)).getText());

    }

}
