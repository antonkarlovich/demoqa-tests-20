package junit.demoqa;

import com.codeborne.selenide.Configuration;
import junit.demoqa.pages.RegistrationPage;
import junit.demoqa.utils.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    String firstName;
    String lastName;
    String gender;
    String userEmail;
    String phoneNumber;
    String dayOfBirth;
    String monthOfBirth;
    String yearOfBirth;
    String subject;
    String hobby;
    String address;
    String state;
    String city;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void beforeEach() {
        firstName = testData.firstName;
        lastName = testData.lastName;
        gender = testData.gender;
        userEmail = testData.userEmail;
        phoneNumber = testData.phoneNumber;
        dayOfBirth = testData.dayOfBirth;
        monthOfBirth = testData.monthOfBirth;
        yearOfBirth = testData.yearOfBirth;
        subject = testData.subject;
        hobby = testData.hobby;
        address = testData.address;
        state = testData.state;
        city = testData.getRandomCity(state);
    }
}
