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
        driver.findElements(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("© 2001—2023 Onlíner", driver.findElement(By.xpath(OnlinerPage.COPYRIGHT)).getText());

        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(OnlinerPage.URL);
    driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")).click();
    Assert.assertEquals("Вход",driver.findElement(By.xpath("//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']")).getText());

    driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")).click();
        driver.findElement(By.xpath("//div[@class='auth-form__control auth-form__control_condensed-additional']/button[@type='submit']")).click();
        Assert.assertEquals("Укажите ник или e-mail",driver.findElement(By.xpath("//text()[contains(., 'Укажите ник или e-mail')]")).getText());
        Assert.assertEquals("Укажите пароль",driver.findElement(By.xpath("//text()[contains(., 'Укажите пароль')]")).getText());
        driver.quit();
    }
}
