
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1450х950";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    public void selectDate(String day, String month, String year) {
        // Открываем календарь, если он не открыт
        $("#dateOfBirthInput").click();

        SelenideElement monthDropdown = $(".react-datepicker__month-select");
        // Выбираем месяц
        monthDropdown.click();
        monthDropdown.find(byText(month)).click();

        // $("option").find(byText(month)).click();

        SelenideElement yearDropdown = $(".react-datepicker__year-select");
        // Выбираем год
        yearDropdown.click();

        $$("option").find(Condition.text(year)).click();

        // Выбираем нужный день
        SelenideElement dayElement = $$("div.react-datepicker__day").find(Condition.text(day));
        dayElement.click();
    }

    public void selectEnglishFromAutoComplete() {

        SelenideElement inputField = $("#subjectsInput");
        inputField.setValue("Eng");

        $$(".subjects-auto-complete__menu").find(Condition.text("English")).shouldBe(Condition.visible);
        $$(".subjects-auto-complete__menu").find(Condition.text("English")).click();
    }

    public void selectStateFromAutoComplete() {

        $("#state").click();
        SelenideElement inputField = $("#react-select-3-input");
        inputField.setValue("Har");

        // $$(".css-1hwfws3").find(Condition.text("Haryana")).shouldBe(Condition.visible);
        $("#react-select-3-option-2").click();
    }

    public void selectCityFromAutoComplete() {
        SelenideElement inputField = $("#city");
        inputField.click();
        $("#react-select-4-option-0").click();
    }

    private SelenideElement geTableValueByTitle(String title) {
        return $$("table.table tr td").find(text(title)).parent().lastChild();
    }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");
        $("#firstName").setValue("Natalia");
        $("#lastName").setValue("Iakovleva");
        $("#userEmail").setValue("nata@test.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("6666666666");
        selectDate("22", "May", "1990");
        selectEnglishFromAutoComplete();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath(("testPicture.jpg"));
        $("#currentAddress").setValue("Lenina st., 45");
        $("#submit").scrollTo();
        selectStateFromAutoComplete();
        selectCityFromAutoComplete();
        $("#submit").click();

        geTableValueByTitle("Student Name").shouldHave(Condition.text("Natalia Iakovleva"));
        geTableValueByTitle("Student Email").shouldHave(Condition.text("nata@test.com"));
        geTableValueByTitle("Gender").shouldHave(Condition.text("Female"));
        geTableValueByTitle("Mobile").shouldHave(Condition.text("6666666666"));
        geTableValueByTitle("Date of Birth").shouldHave(Condition.text("22 May,1990"));
        geTableValueByTitle("Subjects").shouldHave(Condition.text("English"));
        geTableValueByTitle("Hobbies").shouldHave(Condition.text("Music"));
        geTableValueByTitle("Picture").shouldHave(Condition.text("testPicture.jpg"));
        geTableValueByTitle("Address").shouldHave(Condition.text("Lenina st., 45"));
        geTableValueByTitle("State and City").shouldHave(Condition.text("Haryana Karnal"));
    }
}
