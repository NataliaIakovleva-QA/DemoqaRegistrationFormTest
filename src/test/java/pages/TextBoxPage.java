package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputComponent;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage extends BasePage {
    private final SelenideElement fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress");

    OutputComponent outputComponent = new OutputComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        this.removeBanners();
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    public void submit() {
        $("#submit").click();
    }

    public TextBoxPage checkResult(String key, String value) {
        outputComponent.checkOutputRow(key, value);
        return this;
    }

}
