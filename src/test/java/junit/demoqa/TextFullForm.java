package junit.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $(".custom-control-label").click();
        $("#userNumber").setValue("8707123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("October")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1988")).click();
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("b");
        $(byText("Biology")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File(pathPng));
        $("#currentAddress").setValue("Череповегас");
        $("#state").click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(byText(checkText)).shouldBe(Condition.visible);
        $(byText("Антон Малов")).shouldBe(Condition.visible);
        $(byText("sddgdfg@mail.ru")).shouldBe(Condition.visible);
        $(byText("Male")).shouldBe(Condition.visible);
        $(byText("8707123456")).shouldBe(Condition.visible);
        $(byText("17 October,1988")).shouldBe(Condition.visible);
        $(byText("Biology")).shouldBe(Condition.visible);
        $(byText("Reading, Music")).shouldBe(Condition.visible);
        $(byText("png-clipart-cats-cats.png")).shouldBe(Condition.visible);
        $(byText("Череповегас")).shouldBe(Condition.visible);
        $(byText("NCR Delhi")).shouldBe(Condition.visible);
    }
}
