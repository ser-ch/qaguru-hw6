import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Steps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

class AllureLambdaAndAnnotatedStepTest {
    private static final String REPOSITORY = "ser-ch/qaguru-homework";
    private Steps steps = new Steps();

    @Test
    @DisplayName("Issue link should be visible, allure lambda steps")
    void githubIssueTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем и переходим в репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
            $(linkText(REPOSITORY)).click();
        });
        step("Проверяем, чтобы ссылка на Issues была видна", () -> {
            $(partialLinkText("Issues")).should(Condition.visible);
        });
    }

    @Test
    @DisplayName("Issue link should be visible, allure steps in test w/o lambda")
    void githubIssueTest2() {
        step("Открываем главную страницу");
        open("https://github.com");

        step("Ищем и переходим в репозиторий " + REPOSITORY);
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();

        step("Проверяем, чтобы ссылка на Issues была видна");
        $(partialLinkText("Issues")).should(Condition.visible);
    }

    @Test
    @DisplayName("Issue link should be visible, allure annotated steps")
    void IssueLinkShouldBeVisibleInRepo() {
        steps.openGithubMainPage()
                .findAndOpenRepo(REPOSITORY)
                .issueShoudBeVisible();
    }
}
