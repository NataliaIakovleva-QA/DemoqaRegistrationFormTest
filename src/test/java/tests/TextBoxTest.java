package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillTextBoxForm() {
        textBoxPage.openPage()
                .removeBanners()
                .setFullName("Natalia Iakovleva")
                .setUserEmail("nata@ya.com")
                .setCurrentAddress("Lenina Street, 25")
                .setPermanentAddress("Lenina Street, 25")
                .submit();

        textBoxPage.checkResult("Natalia", "Natalia Iakovleva")
                .checkResult("Email", "nata@ya.com")
                .checkResult("Current Address", "Lenina Street, 25")
                .checkResult("Permananet Address", "Lenina Street, 25");
    }
}
