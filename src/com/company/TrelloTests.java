package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloTests {
    WebDriver driver;
    String password1 = "CFDSGvcds!v43_4";

    @BeforeMethod
    public void open() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://trello.com");

        driver.findElement(By.cssSelector("[class = 'btn btn-sm btn-link text-primary']")).click();
        Thread.sleep(2000);

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='user']"));
        emailLogin.click();
        emailLogin.sendKeys("andreev.s@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys(password1);
        password.submit();

    }

    @Test
    public void test(){


    }

    @AfterMethod(){
        driver.quit();
    }
}
