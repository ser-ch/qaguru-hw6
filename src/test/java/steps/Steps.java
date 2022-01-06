package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class Steps {
    @Step("Open Github main page")
    public Steps openGithubMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий {repositoryName}")
    public Steps findAndOpenRepo(String repositoryName) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repositoryName).pressEnter();
        $(linkText(repositoryName)).click();
        return this;
    }

    @Step("Ссылка на Issue должна быть видна")
    public Steps issueShoudBeVisible() {
        $(partialLinkText("Issues")).should(Condition.visible);
        return this;
    }
}
