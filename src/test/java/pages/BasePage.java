package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {
    protected void removeBanners0() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
