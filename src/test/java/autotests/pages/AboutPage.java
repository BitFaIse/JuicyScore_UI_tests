package autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {

    private final String TITLE_TEXT = "О нас";
    private final String DESCRIPTION_TEXT = "Мы даем рынку доступ к инструментам снижения рисков " +
            "и повышения уровня доступности финансовых продуктов через интернет за счет " +
            "технологий аутентификации устройства, сбора и анализа данных об устройстве.";
    private SelenideElement

            menuNavigation = $(".header_nav"),
            titleAbout = $(".section_title-title"),
            descriptionAbout = $(".section_title--about");


    public AboutPage goToAboutPage() {

        menuNavigation.$(byText(TITLE_TEXT)).click();
        return this;
    }

    public AboutPage verifyDescriptionOnAboutPage() {

        titleAbout.shouldHave(text(TITLE_TEXT));
        descriptionAbout.
                shouldHave(text(DESCRIPTION_TEXT));
        return this;
    }
}
