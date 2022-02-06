package digatal_league.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.linkText;



public class DigitalLeagueTests extends TestBase {

    @BeforeEach
    void openSite() {
        step("Открываем главную страницу: 'https://digitalleague.ru/'", () -> {
            open("https://digitalleague.ru/");
        });
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Page title should have text 'Лига Цифровой Экономики'", () -> {
            String expectedTitle = "Лига Цифровой Экономики";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Проверка участника лиги")
    void leaguePartnersCheck() {
        step("Нажать 'Участники лиги'", () -> {
                $(withText("Участники")).click();
        });

        step("Переход на страницу участника: 'ИТ Философия'", () -> {
                $x("//a[@href='https://www.fil-it.ru/']").click();
        });

        step("Проверка текущего URL", () -> {
            switchTo().window(1);
            Assertions.assertEquals(url(), "https://www.fil-it.ru/");
        });
    }

}