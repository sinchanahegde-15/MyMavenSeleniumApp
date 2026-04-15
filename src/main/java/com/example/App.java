package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();

        // 🔥 Required for Linux / VirtualBox
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 🔥 MUST for VM (fixes Chrome crash)
        options.addArguments("--headless=new");

        // Optional safety
        options.addArguments("--remote-allow-origins=*");

        // Launch browser
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.saucedemo.com/");

            // Perform actions
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Print page title
            System.out.println("Title: " + driver.getTitle());

            // Success message
            System.out.println("Login successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
