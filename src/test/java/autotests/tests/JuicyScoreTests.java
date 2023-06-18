package autotests.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class JuicyScoreTests extends TestBase {


    @Test
    @Tag("remote")
    @Severity(SeverityLevel.TRIVIAL)
    void checkDescriptionOnAboutPage() {

        step("Открыть сайт juicyscore.com", () -> {
            mainPage.openPage();
        });
        step("Перейти в меню на страницу О нас", () -> {
            aboutPage.goToAboutPage();
        });
        step("Сменить язык содержимого сайта на английский (EN)", () -> {
            aboutPage.changeLanguage();
        });
        step("Перейти на страницу с открытыми вакансиями", () -> {
            aboutPage.aboutVacancy();
        });
        step("Проверить описание на странице", () -> {
            aboutPage.verifyTitleVacancy();
        });
    }

    @Test
    @Tag("remote")
    @Severity(SeverityLevel.BLOCKER)
    void fillContactForm() {

        step("Открыть страницу с формой для связи", () -> {
            contactForm.openPage();
        });
        step("Заполнить и отправить форму", () -> {
            contactForm.setFullName(testData.name)
                    .setCompanyName(testData.company)
                    .setNumber(testData.phone)
                    .setEmail(testData.email)
                    .setMessage(testData.message)
                    .checkBoxAgreement();
            //после нажатия чекбокса с согласием, нужно время для перехода кнопки подписаться в активное состояние
            //поэтому используется sleep
            sleep(5000);
            contactForm.clickOnButton();

        });
        step("Проверить что форма отправлена", () -> {
            contactForm.checkTextAfterSendForm();
        });
    }

    @Test
    @Tag("remote")
    @Severity(SeverityLevel.CRITICAL)
    void downloadPricePolicy() {

        step("Перейти на страницу juicyscore.com/ru/downloads/", () -> {
            downloadsPage.openDownloadsPage();
        });
        step("Проверить что скачанный файл содержит текст Базовые принципы ценообразования", () -> {
            downloadsPage.verifyDownloadedFileContainsText();
        });
    }


    @Test
    @Tag("remote")
    @Severity(SeverityLevel.MINOR)
    void subscribeEmail() {

        step("Открыть сайт juicyscore.com и спуститься в футер", () -> {
            mainPage.openPage();
            mainPage.scrollToFooter();
        });
        step("Cпуститься в футер", () -> {
            mainPage.scrollToFooter();
        });
        step("Ввести почту и подписаться на рассылку", () -> {
            contactForm.setEmail(testData.email)
                    .checkBoxAgreement();
            mainPage.clickOnButtonSubscribe();
        });
        step("Проверить что подписка оформлена", () -> {
            mainPage.verifySubscriptionNotification();
        });
    }
}
