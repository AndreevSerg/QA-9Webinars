package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OscarShopTests extends TestBase{
    String email = "qwer" + System.currentTimeMillis() + "@gmail.com";
    // System.out.println(email);
    String password = "Qwe123123";

    @Test (priority =1)
    public void registrationTest() throws InterruptedException {


     //   Thread.sleep(2000);
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
       // Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.clear();
        emailField.sendKeys(email);
      //  Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
     //  Thread.sleep(2000);
        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
     //   Thread.sleep(2000);
        WebElement registerButton = driver.findElement(By.name("registration_submit"));
        registerButton.click();
     //   Thread.sleep(2000);

    }

    @Test(priority = 2, dependsOnMethods = "registrationTest")
    public void loginTest() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();

        WebElement loginEmailField = driver.findElement(By.xpath("//input[@id='id_login-username']"));

        loginEmailField.sendKeys(email);
        WebElement loginPasswordField = driver.findElement(By.id("id_login-password"));
        loginPasswordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));
        loginButton.click();
        Thread.sleep(5000);
       // loginButton.isDisplayed();
        driver.findElement(By.cssSelector(".alertinner.wicon .icon-ok-sign")).isDisplayed();

    }

}

