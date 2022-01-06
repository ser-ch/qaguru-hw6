import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

class SelenideWithListenerTest {
    private static final String REPOSITORY = "ser-ch/qaguru-homework";

    @Test
    void githubIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();

        $(partialLinkText("Issues")).should(Condition.visible);
    }
}
