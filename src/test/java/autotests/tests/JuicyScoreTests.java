package autotests.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JuicyScoreTests extends TestBase {



    @Test
    @Tag("remote")
    @Severity(SeverityLevel.TRIVIAL)
    void checkDescriptionOnAboutPage() {
        step("Открыть сайт 'https://juicyscore.com'", () -> {
            open("/ru");
        });
        step("Перейти в меню на страницу 'О нас'", () -> {
            $(".header_nav").$(byText("О нас")).click();
        });
        step("Проверить описание на странице", () -> {
            $(".section_title-title").shouldHave(text("О нас"));
            $(".section_title--about").
                    shouldHave(text("Мы даем рынку доступ к инструментам снижения рисков " +
                            "и повышения уровня доступности финансовых продуктов через интернет за счет " +
                            "технологий аутентификации устройства, сбора и анализа данных об устройстве."));
        });
    }

    @Test
    @Tag("remote")
    @Severity(SeverityLevel.BLOCKER)
    void fillContactForm() {

        Faker fakerEn = new Faker(new Locale("en"));
        Faker fakerRu = new Faker(new Locale("ru"));

        String name = fakerRu.name().fullName();
        String company = fakerRu.company().name();
        String phone = fakerRu.phoneNumber().subscriberNumber();
        String email = fakerEn.internet().emailAddress();
        String message = fakerRu.lorem().word();


        step("Открыть страницу с формой для связи", () -> {
            open("/ru/ready-to-connect/");
        });
        step("Заполнить и отправить форму", () -> {
            $("[name=name]").setValue(name);
            $("[name=org]").setValue(company);
            $("[name=phone]").setValue(phone);
            $("[name=email]").setValue(email);
            $("[name=message]").setValue(message);
            $("#agreement").click();
            sleep(5000);
            $(".btn--arrow").click();

        });
        step("Проверить что форма отправлена", () -> {
            $(".section_ready_to_connect").shouldHave(text(
                    "Спасибо за ваш запрос.\n" +
                            "Вы получите ответ в течение двух рабочих дней."));
        });
    }

    @Test
    @Tag("remote")
    @Severity(SeverityLevel.MINOR)
    void subscribeEmail() {
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();

        step("Открыть сайт 'https://juicyscore.com' и спуститься в футер", () -> {
            open("/ru");
            $(".footer_container").scrollTo();
            sleep(1000);
            $(".footer_container").scrollTo();
            sleep(1000);
            $(".footer_container").scrollTo();
        });
        step("Ввести почту и подписаться на рассылку", () -> {
            $("[name=email]").setValue(email);
            $("#agreement").click();
            $("#footerSubscribe").$(byText("Подписаться")).click();
        });
        step("Проверить что подписка оформлена", () -> {
            $(".success").$("Подписка оформлена");
        });
    }

}
