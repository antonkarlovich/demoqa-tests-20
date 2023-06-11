package junit.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import junit.demoqa.pages.components.CalendarComponent;
import junit.demoqa.pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderValue = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirth-wrapper").$("#dateOfBirthInput"),
            addressInput = $("#currentAddress"),
            subjectsInput = $("#subjectsInput"),
            hobbiesValue = $("#hobbiesWrapper"),
            fileUpload = $("#uploadPicture"),
            stateSelect = $("#stateCity-wrapper").$("#state"),
            citySelect = $(byText("Select City")),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog"),
            textInModalDialog = $("#example-modal-sizes-title-lg");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        closeAdvertisementBanners();
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderValue.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesValue.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String filePath) {
        fileUpload.uploadFromClasspath(filePath);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String value) {
        stateSelect.click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage selectCity(String value) {
        citySelect.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkVisibleTable() {
        modalDialog.should(appear);
        textInModalDialog.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        tableResultComponent.tableValueVerify(key, value);
        return this;
    }

    private void closeAdvertisementBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
