package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String email = "TestingTelRan132@gmail.com";
        String password = "Qwe7Up!KGu6";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.navigate().to("http://selenium1py.pythonanywhere.com/en-gb/");
        Thread.sleep(5000);
        WebElement loginLink = driver.findElement(By.id("login_link"));
        System.out.println(loginLink.getText());
        loginLink.click();
        Thread.sleep(5000);


        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
        Thread.sleep(5000);

        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
        Thread.sleep(5000);

        WebElement registerButton = driver.findElement(By.name("registration_submit"));
        registerButton.click();
        Thread.sleep(50000);

        driver.close();
        driver.quit();
    }
}
