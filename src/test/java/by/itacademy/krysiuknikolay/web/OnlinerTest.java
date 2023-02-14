package by.itacademy.krysiuknikolay.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")).click();
    Assert.assertEquals("Вход",driver.findElement(By.xpath("//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']")).getText());

    driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")).click();
        driver.findElement(By.xpath("//div[@class='auth-form__control auth-form__control_condensed-additional']/button[@type='submit']")).click();
        Thread.sleep(2000);
        Assert.assertEquals("Укажите ник или e-mail",driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div")).getText());
        Assert.assertEquals("Укажите пароль",driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div")).getText());

        driver.quit();
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ник или e-mail']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//div[@class='auth-form__control auth-form__control_condensed-additional']/button[@type='submit']")).click();
        Thread.sleep(2000);
        Assert.assertEquals("Укажите пароль", driver.findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div")).getText());
        Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div")).size() == 0);

        driver.quit();
    }
}
