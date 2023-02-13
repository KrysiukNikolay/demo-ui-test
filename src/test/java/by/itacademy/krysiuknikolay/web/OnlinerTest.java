package by.itacademy.krysiuknikolay.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {
@Test
    public void testOpenOnliner(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        driver.findElements(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("© 2001—2023 Onlíner", driver.findElement(By.xpath(OnlinerPage.COPYRIGHT)).getText());

        driver.quit();
    }

}
