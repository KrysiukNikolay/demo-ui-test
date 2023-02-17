package by.itacademy.krysiuknikolay.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {
    WebDriver driver;

    @Before
    public void warmUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(AmazonPage.URL);
    }

    @Test
    public void testOpenAmazon() {
        String actualCopyrightText = driver.findElement(By.xpath(AmazonPage.COPYRIGHT_XPATH)).getText();
        Assert.assertEquals(AmazonPage.COPYRIGHT_EXPECTED_TEXT, actualCopyrightText);
    }

    @Test
    public void testOpenAmazonCart() {
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        String actualCartText = driver.findElement(By.xpath(AmazonPage.FORM_HEADER_TEXT_CART_IS_EMPTY_XPATH)).getText();
        Assert.assertEquals(AmazonPage.FORM_HEADER_TEXT_CART_IS_EMPTY_EXPECTED_TEXT, actualCartText);
    }

    @Test
    public void testOpenAmazonLoginForm() {
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_SIGN_IN_TO_YOUR_ACCOUNT)).click();
        String actualSignText = driver.findElement(By.xpath(AmazonPage.FORM_HEADER_TEXT_SIGN_IN_XPATH)).getText();
        Assert.assertEquals(AmazonPage.FORM_HEADER_TEXT_SIGN_IN_EXPECTED_TEXT, actualSignText);
    }

    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {
        driver.findElement(By.xpath(AmazonPage.BTN_CART)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_SIGN_IN_TO_YOUR_ACCOUNT)).click();
        driver.findElement(By.xpath(AmazonPage.BTN_CONTINUE)).click();
        String actualEmailText = driver.findElement(By.xpath(AmazonPage.FORM_EMPTY_YOUR_EMAIL_XPATH)).getText();
        Assert.assertEquals(AmazonPage.FORM_EMPTY_YOUR_EMAIL_EXPECTED_TEXT, actualEmailText);
    }

    @After
    public void out() {
        driver.quit();
    }

}
