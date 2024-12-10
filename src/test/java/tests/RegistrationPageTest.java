package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .selectGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .selectSubjectInput(testData.subject)
                .selectHobbies(testData.hobbies)
                .setUserPicture(testData.picture)
                .setCurrentAddress(testData.userAddress)
                .selectState(testData.userState)
                .selectCity(testData.userCity)
                .pressSubmit()

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.telephoneNumber)
                .checkResult("Date of Birth", testData.userBirthDay + " " +  testData.userBirthMonth + "," + testData.userBirthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.userAddress)
                .checkResult("State and City", testData.userState + " " + testData.userCity);

    }

    @Test
    void minimalFillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .selectGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .pressSubmit()

                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.telephoneNumber)
                .checkResult("Date of Birth", testData.userBirthDay + " " +  testData.userBirthMonth + "," + testData.userBirthYear);
    }

    @Test
    void negativeFillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(" ")
                .selectGender(testData.gender)
                .setUserNumber(testData.telephoneNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .pressSubmit()
                .verifyEmailFieldIsRed();

    }

}