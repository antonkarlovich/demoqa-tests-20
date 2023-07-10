package junit.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import junit.demoqa.helpers.Attach;
import junit.demoqa.pages.RegistrationPage;
import junit.demoqa.utils.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.util.Map.of;


public class RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        Configuration.remote = System.getProperty("selenoidUrl");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
