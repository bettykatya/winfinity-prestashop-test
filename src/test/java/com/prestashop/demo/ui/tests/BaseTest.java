package com.prestashop.demo.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    protected static final DecimalFormat df = new DecimalFormat("0.00");

    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        Configuration.baseUrl = "https://demo.prestashop.com/";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void openApp() {
        open("https://demo.prestashop.com/");
        switchTo().frame("framelive");
    }

    @AfterEach
    public void cleanup() throws IOException {
        clearBrowserCookies();
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

    protected double roundPrice(double price) {
        return Double.parseDouble(df.format(price));
    }
}
