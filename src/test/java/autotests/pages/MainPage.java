package autotests.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String TEXT_BUTTON = "Подписаться";
    private final String TEXT_NOTIFICATION = "Подписка оформлена";

    public MainPage openPage() {
        open("/ru");
        return this;
    }

    public MainPage scrollToFooter() {
        $(".footer_container").scrollTo();
        //страница не скроллится до футера за один раз, поэтому использую конструкцию со sleep
        sleep(1000);
        $(".footer_container").scrollTo();
        sleep(1000);
        $(".footer_container").scrollTo();
        return this;
    }

    public MainPage clickOnButtonSubscribe() {
        $("#footerSubscribe").$(byText(TEXT_BUTTON)).click();
        return this;
    }

    public MainPage verifySubscriptionNotification() {
        $(".success").$(TEXT_NOTIFICATION);
        return this;
    }
}
