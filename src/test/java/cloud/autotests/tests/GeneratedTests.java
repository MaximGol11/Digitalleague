package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.partialLinkText;


public class GeneratedTests extends TestBase {

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Открываем главную страницу: 'https://digitalleague.ru/'", () ->
            open("https://digitalleague.ru/")
        );

        step("Page title should have text 'Лига Цифровой Экономики'", () -> {
            String expectedTitle = "Лига Цифровой Экономики";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }
    @Test
    @DisplayName("Проверка участника лиги")
    void leaguePartnersCheck() {
        step("Открываем главную страницу: 'https://digitalleague.ru/'", () -> {
            open("https://digitalleague.ru/");
        });

        step("Нажать 'Участники лиги'", () -> {
                $(withText("Участники лиги")).click();
        });

        step("Переход на страницу участника: 'ИТ Философия'", () -> {
                $(".league__partners-wrapper").$(partialLinkText("fil-it")).click();
        });

        step("Проверка текущего URL", () -> {
            Assertions.assertEquals(url(), "https://www.fil-it.ru/");
        });
    }

}