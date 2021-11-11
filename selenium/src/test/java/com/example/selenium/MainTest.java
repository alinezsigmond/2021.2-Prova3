package com.example.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.assertj.core.api.Assertions;


public class MainTest {

    private WebDriver driver;

    private String alertMessage;
    private String id;

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
    void displaysContactWhenRegistere() {
        driver.get("http://localhost:3000");
        driver.findElement(By.id("listar")).click();
        Assertions.assertThat(driver.findElement(By.name("id")).isDisplayed());
//        Selenide.$(By.name("id")).shouldBe(Condition.visible);

//        driver.findElement(By.id("cadastrar")).click();
//        driver.findElement(By.name("name")).sendKeys("Selenide");
//        driver.findElement(By.name("email")).sendKeys("Selenide@teste.com");
//        driver.findElement(By.name("phone")).sendKeys("+1 666");
//        driver.findElement(By.id("cadastrar")).click();
//        Alert alert = driver.switchTo().alert();
//        alertMessage = alert.getText();
//        Assertions.assertThat(alertMessage).isEqualTo("Contato cadastrado com sucesso!");
    }

}
