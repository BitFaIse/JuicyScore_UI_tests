package autotests.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));

    String name = fakerRu.name().fullName();
    String company = fakerRu.company().name();
    String phone = fakerRu.phoneNumber().subscriberNumber();
    String email = fakerEn.internet().emailAddress();
    String message = fakerRu.lorem().word();
}
