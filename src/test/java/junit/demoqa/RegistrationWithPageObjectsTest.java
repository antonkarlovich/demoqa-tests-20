package junit.demoqa;

import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjectsTest extends TestBase {
    private final String pathPng = "src\\test\\resources\\png-clipart-cats-cats.png";


    @Test
    void checkForm() {

        registrationPage.openPage()
                .setFirstName("Антон")
                .setLastName("Малов")
                .setEmail("fgdfgdf@yandex.ru")
                .setGender("Male")
                .setPhoneNumber("8707123456")
                .setBirthDay("17", "October", "1988")
                .setSubject("Biology")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadFile(pathPng)
                .setAddress("Череповегас")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickSubmit();

        registrationPage.checkVisibleTable()
                .verifyResult("Student Name", "Антон Малов")
                .verifyResult("Student Email", "fgdfgdf@yandex.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8707123456")
                .verifyResult("Date of Birth", "17 October,1988")
                .verifyResult("Subjects", "Biology")
                .verifyResult("Hobbies", "Reading, Music")
                .verifyResult("Picture", "png-clipart-cats-cats.png")
                .verifyResult("Address", "Череповегас")
                .verifyResult("State and City", "NCR Delhi");
   }
}
