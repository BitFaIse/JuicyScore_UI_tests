package autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AboutPage {

    private final String TITLE_TEXT = "О нас";
    private final String TITLE_VACANCY = "International business development manager";
    private SelenideElement

            menuNavigation = $(".header_container"),
            currentLanguage = $(".header_langs");


    public AboutPage goToAboutPage() {

        menuNavigation.$(byText(TITLE_TEXT)).click();
        return this;
    }

    public AboutPage changeLanguage() {

        currentLanguage.hover();
        $$(".anotherLanguage").findBy(visible).click();
        return this;
    }

    public AboutPage aboutVacancy() {

        $(".about_vacancy_item").click();
        return this;
    }

    public AboutPage verifyTitleVacancy() {

        $(".article-title").shouldHave(text(TITLE_VACANCY));
        return this;
    }
}
