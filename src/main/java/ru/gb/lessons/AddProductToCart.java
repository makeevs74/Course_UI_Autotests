package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AddProductToCart {
    public static void main(String[] args) throws InterruptedException {
        String productName = "Сноуборд Jones Flagship";

        WebDriver webDriver = WebDriverManager.chromedriver() .create();

        webDriver.get("https://www.kant.ru/");
        webDriver.manage().window().setSize(new Dimension(1200, 800));
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//*[@class=\"kant__header-catalog-item mobile-hidden\"]//*[text()=\"Сноуборды\"]")).click();


        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"kant__catalog__item\"]"));
        WebElement selectedProduct = products.stream()
                .filter(product -> product.findElement(By.xpath(".//*[@class='kant__catalog__item__content ']"))
                        .getText().equals("Сноуборд Jones Flagship"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(productName));
        selectedProduct.findElement(By.className("kant__button")).click();



        //webDriver.findElement(By.xpath("//*[@class=\"kant__product__buy__button--new\"]")).click();
        webDriver.quit();
    }
}
