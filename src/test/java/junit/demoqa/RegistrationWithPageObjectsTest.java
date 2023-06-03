package junit.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTest extends TestBase {
    private final String FORM_URL = "/automation-practice-form";
    private final String pathPng = "src\\test\\resources\\png-clipart-cats-cats.png";
    private final String checkText = "Thanks for submitting the form";


    @Test
    void checkForm() {
        open(FORM_URL);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Антон");
        $("#lastName").setValue("Малов");
        $("#userEmail").setValue("sddgdfg@mail.ru");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8707123456");

        $("#dateOfBirth-wrapper").$("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").selectOption("October");
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("Biology").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File(pathPng));

        $("#currentAddress").setValue("Череповегас");

        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Антон Малов"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("sddgdfg@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8707123456"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("17 October,1988"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("png-clipart-cats-cats.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Череповегас"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
