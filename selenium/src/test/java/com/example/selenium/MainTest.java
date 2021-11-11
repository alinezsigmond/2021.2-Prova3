package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MainTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new OperaDriver();
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }

    @Test
    void createContact() {
        driver.get("http://localhost:3000");
        driver.findElement(By.id("cadastrar")).click();
        driver.findElement(By.name("name")).sendKeys("Selenide");
        driver.findElement(By.name("email")).sendKeys("Selenide@teste.com");
        driver.findElement(By.name("phone")).sendKeys("+1 666");
        driver.findElement(By.id("cadastrar")).click();
    }

}
