package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            userPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    @Step("Открываем страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Убираем баннер")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполняем имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполняем электронную почту")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage selectGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Заполняем телефон")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем предмет")
    public RegistrationPage selectSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage selectHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage setUserPicture(String value) {
        userPictureInput.uploadFromClasspath(value);
        return this;
    }

    @Step("Заполняем фактический адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage selectState(String value) {
        stateInput.scrollTo();
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage selectCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Submit'")
    public RegistrationPage pressSubmit() {
        submitButton.pressEnter();
        return this;
    }

    @Step("Проверяем поле {key} с ведёнными данными {value}")
    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }

    @Step("Проверяе, что граница поля электронной почты красного цвета")
    public RegistrationPage verifyEmailFieldIsRed() {
        userEmailInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }


}