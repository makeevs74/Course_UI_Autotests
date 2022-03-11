package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginAndLogout
{
    public static void main( String[] args ) throws InterruptedException {

        WebDriver webDriver = WebDriverManager.chromedriver() .create();

        webDriver.get("https://trial-sport.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 800));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //By loginLocator = By.xpath("//*[@id=\"asc\"]//*[text()=\"Вход / регистрация\"]");
        //new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(loginLocator));

        webDriver.findElement(By.xpath("//*[@id=\"asc\"]//*[text()=\"Вход / регистрация\"]")).click();

        //By authPopupLocator = By.xpath("//*[@class=\"profile_popup\"]");
        //new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authPopupLocator));

        WebElement authPopup = webDriver.findElement(By.xpath("//*[@class=\"profile_popup\"]"));

        authPopup.findElement(By.name("email")).sendKeys("em4ilforstudy@yandex.ru");
        authPopup.findElement(By.name("password")).sendKeys("123456");
        authPopup.findElement(By.xpath("//*[@value=\"войти\"]")).click();

        //Thread.sleep(5000);

        webDriver.findElement(By.xpath("//*[@id=\"asc\"]//*[@title=\"Выйти\"]")).click();
        //Thread.sleep(3000);

        webDriver.quit();
    }
}
