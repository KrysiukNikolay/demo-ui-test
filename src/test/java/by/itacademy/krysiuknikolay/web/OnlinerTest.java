package by.itacademy.krysiuknikolay.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    WebDriver driver;

    @Before
    public void warmUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(OnlinerPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        //Checking the display of the "copyright" element on the page
        String actualText = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.COPYRIGHT_EXPECTED_TEXT, actualText);

    }

    @Test
    public void testOpenOnlinerLoginForm() {
        //Checking the display of an element "Вход" on the next page
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        String actual = driver.findElement(By.xpath(OnlinerPage.FORM_HEADER_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.FORM_HEADER_EXPECTED_TEXT, actual);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        //Log in to the authorization page and enter empty values
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_NEW_PAGE)).click();
        String actualEmailErrorText = driver.findElement(By.xpath(OnlinerPage.EMPTY_EMAIL_ERROR_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.EMPTY_EMAIL_ERROR_EXPECTED_TEXT, actualEmailErrorText);
        String actualPasswordErrorText = driver.findElement(By.xpath(OnlinerPage.EMPTY_PASWORD_ERROR_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.EMPTY_PASWORD_ERROR_EXPECTED_TEXT, actualPasswordErrorText);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        //Log in to the authorization page and enter a value in the email and an empty value in the password
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        driver.findElement(By.xpath(OnlinerPage.LOGIN_ENTRY_WINDOW)).sendKeys("test@gmail.com");
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_NEW_PAGE)).click();
        String actualPasswordErrorText = driver.findElement(By.xpath(OnlinerPage.EMPTY_PASWORD_ERROR_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.EMPTY_PASWORD_ERROR_EXPECTED_TEXT,actualPasswordErrorText );
    }
    @Test
    public void testOnlinerPasswordWithEmptyLoginForm() {
        //Log in to the authorization page and enter a value in the email and an empty value in the password
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_BASIC)).click();
        driver.findElement(By.xpath(OnlinerPage.PASSWORD_ENTRY_WINDOW)).sendKeys("test");
        driver.findElement(By.xpath(OnlinerPage.BTN_AUTORIZATION_NEW_PAGE)).click();
        String actualPasswordErrorText = driver.findElement(By.xpath(OnlinerPage.EMPTY_EMAIL_ERROR_XPATH)).getText();
        Assert.assertEquals(OnlinerPage.EMPTY_EMAIL_ERROR_EXPECTED_TEXT,actualPasswordErrorText );
    }

    @After
    public void after() {
        driver.quit();
    }
}
