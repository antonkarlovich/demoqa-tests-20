package junit.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextFullForm {
    private final String URL = "https://demoqa.com/automation-practice-form";
    private final String pathPng = "src\\test\\resources\\png-clipart-cats-cats.png";
    private final String checkText = "Thanks for submitting the form";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkForm() {
        open(URL);
        $("#firstName").setValue("Антон");
        $("#lastName").setValue("Малов");
        $("#userEmail").setValue("sddgdfg@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8707123456");
        $("#dateOfBirth-wrapper").$("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").click();
        $("#dateOfBirth-wrapper").$(byText("October")).click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").click();
        $("#dateOfBirth-wrapper").$(byText("1988")).click();
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("b");
        $(byText("Biology")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File(pathPng));
        $("#currentAddress").setValue("Череповегас");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(byText(checkText)).shouldBe(Condition.visible);
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
