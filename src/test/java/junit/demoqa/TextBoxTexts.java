package junit.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTexts {


    @Test
    void fillFormTest() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        String URL = "https://demoqa.com/text-box";
        open(URL);
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("Антон");
        $("#userEmail").setValue("dfgfdg@mail.ru");
        $("#currentAddress").setValue("sdflgjdfgkjdfkgjdfklgjfd");
        $("#permanentAddress").setValue("sdflgjdfgkjdfkgjdfklgjfd");
        $("#submit").click();
        $("#output").shouldBe(visible);

    }
}
