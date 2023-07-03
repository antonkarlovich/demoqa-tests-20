package junit.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class RegistrationRemoteTest extends TestBase {

    @Test
    @Tag("remote")
    void checkForm() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setBirthDay(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadFile(testData.pathPng)
                .setAddress(testData.address)
                .selectState(testData.state)
                .selectCity(testData.city)
                .clickSubmit();

        registrationPage.checkVisibleTable()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.gender)
                .verifyResult("Mobile", testData.phoneNumber)
                .verifyResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth +
                        "," + testData.yearOfBirth)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.pathPng)
                .verifyResult("Address", testData.address)
                .verifyResult("State and City", testData.state + " " + testData.city);
   }
}
