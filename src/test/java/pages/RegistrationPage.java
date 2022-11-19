package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

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
        $("#userEmail").setValue(value); // todo move to Selenide elements
        return this;
    }
    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText("Male")).click(); // todo move to Selenide elements
        return this;
    }
    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressTab();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText("Sports")).click();;
        return this;
    }
    public RegistrationPage setUpFile(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage curAdress(String value) {
        $("#currentAddress").setValue(value);
        return this;}


    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Agra")).click();
        return this;
    }
    public RegistrationPage setSubmit() {
        $("#submit").click();
        return this;
    }
    public RegistrationPage verifyResultModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
