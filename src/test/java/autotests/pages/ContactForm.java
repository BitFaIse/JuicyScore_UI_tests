package autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactForm {


    private final String TEXT_AFTER_SEND_FORM = "Спасибо за ваш запрос.\n" +
            "Вы получите ответ в течение двух рабочих дней.";
    private SelenideElement

            fullNameInput = $("[name=name]"),
            companyNameInput = $("[name=org]"),
            numberInput = $("[name=phone]"),
            emailInput = $("[name=email]"),
            messageInput = $("[name=message]"),
            agreementCheckbox = $("#agreement"),
            buttonSend = $(".btn--arrow");


    public ContactForm openPage() {
        open("/ru/ready-to-connect/");
        return this;
    }

    public ContactForm setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public ContactForm setCompanyName(String value) {
        companyNameInput.setValue(value);
        return this;
    }

    public ContactForm setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public ContactForm setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public ContactForm setMessage(String value) {
        messageInput.setValue(value);
        return this;
    }

    public ContactForm checkBoxAgreement() {
        agreementCheckbox.click();
        return this;
    }

    public ContactForm clickOnButton() {
        buttonSend.click();
        return this;
    }

    public ContactForm checkTextAfterSendForm() {
        $(".section_ready_to_connect").shouldHave(text(TEXT_AFTER_SEND_FORM));
        return this;
    }


}
