package junit.demoqa;

import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjectsTest extends TestBase {
    private final String pathPng = "src\\test\\resources\\png-clipart-cats-cats.png";


    @Test
    void checkForm() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadFile(pathPng)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();

        registrationPage.checkVisibleTable()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "png-clipart-cats-cats.png")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
   }
}
