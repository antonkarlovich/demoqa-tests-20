package junit.demoqa;

import com.codeborne.selenide.Configuration;
import junit.demoqa.pages.RegistrationPage;
import junit.demoqa.utils.TestData;
import org.junit.jupiter.api.BeforeAll;


public class RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
