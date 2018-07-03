package de.smava.int_test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoanDetailsResult extends FluentWebDriverPage {

    public static final String PAGE_RESULT_TITLE = "Kredit beantragen | Kreditantrag in 4 Schritten | SMAVA";

    public LoanDetailsResult(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void goToPageResult(String currentURL) {
        get(currentURL);
        // Wait for page to load
        getDriverProvider().get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void verifyLoanDetail() {
        assertThat("The page is correctly load", getTitle().equals(PAGE_RESULT_TITLE));
    }
}