package de.smava.int_test.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public SmavaHome newHome() {
        return new SmavaHome(webDriverProvider);
    }

    public LoanDetailsResult newResult() {
        return new LoanDetailsResult(webDriverProvider);
    }

    public ScoreCompassHome newScoreCompass() {
        return new ScoreCompassHome();
    }
}
