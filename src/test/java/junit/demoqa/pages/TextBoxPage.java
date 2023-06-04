package junit.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("div.pattern-backgound").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage setFullName(String firstName, String lastName) {
        fullNameInput.setValue(firstName + " " + lastName);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void verifyResult(String fullName, String email, String currentAddress, String permanentAddress) {
        resultName.shouldHave(text(fullName));
        resultEmail.shouldHave(text(email));
        resultCurrentAddress.shouldHave(text(currentAddress));
        resultPermanentAddress.shouldHave(text(permanentAddress));
    }
}
