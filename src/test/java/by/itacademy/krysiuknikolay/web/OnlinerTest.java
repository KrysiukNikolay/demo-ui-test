package by.itacademy.krysiuknikolay.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
    @Test
    public void testOpenOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        Assert.assertEquals("© 2001—2023 Onlíner", driver.findElement(By.xpath(OnlinerPage.COPYRIGHT)).getText());

        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(OnlinerPage.URL);
    driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
    Assert.assertEquals("Вход",driver.findElement(By.xpath(OnlinerPage.FORM_HEADER_TEXT_ENTRANCE)).getText());

    driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_NEW_PAGE)).click();
        Thread.sleep(2000);
        Assert.assertEquals("Укажите ник или e-mail",driver.findElement(By.xpath(OnlinerPage.EMPTY_EMAIL_AND_LOGIN_ELEMENT)).getText());
        Assert.assertEquals("Укажите пароль",driver.findElement(By.xpath(OnlinerPage.EMPTY_PASWORD_ELEMENT)).getText());

        driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        driver.findElement(By.xpath(OnlinerPage.LOGIN_ENTRY_WINDOW)).sendKeys("test@gmail.com");
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_NEW_PAGE)).click();
        Thread.sleep(2000);
        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath(OnlinerPage.EMPTY_PASWORD_ELEMENT)).getText());
        Assert.assertTrue(driver.findElements(By.xpath(OnlinerPage.EMPTY_EMAIL_AND_LOGIN_ELEMENT)).size() == 0);

        driver.quit();
    }
}
