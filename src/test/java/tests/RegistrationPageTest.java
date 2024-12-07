package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Natalia")
                .setLastName("Iakovleva")
                .setUserEmail("nata@ya.com")
                .selectGender("Female")
                .setUserNumber("6666666666")
                .setDateOfBirth("23", "November", "1993")
                .selectSubjectInput("English")
                .selectHobbies("Music")
                .setUserPicture("testPicture.jpg")
                .setCurrentAddress("Lenina Street, 25")
                .selectState("NCR")
                .selectCity("Delhi")
                .pressSubmit()

                .checkResult("Student Name", "Natalia Iakovleva")
                .checkResult("Student Email", "nata@ya.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "6666666666")
                .checkResult("Date of Birth", "23 November,1993")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "testPicture.jpg")
                .checkResult("Address", "Lenina Street, 25")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void minimalFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Natalia")
                .setLastName("Iakovleva")
                .setUserEmail("nata@ya.com")
                .selectGender("Female")
                .setUserNumber("6666666666")
                .setDateOfBirth("23", "November", "1993")
                .pressSubmit()

                .checkResult("Student Name", "Natalia Iakovleva")
                .checkResult("Student Email", "nata@ya.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "6666666666")
                .checkResult("Date of Birth", "23 November,1993");
    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Natalia")
                .setLastName("Iakovleva")
                .setUserEmail("nata@ya.com")
                .selectGender("Female")
                .setUserNumber("66666")
                .setDateOfBirth("23", "November", "1993")
                .pressSubmit()
                .verifyUserNumberFieldIsRed();

    }

}
