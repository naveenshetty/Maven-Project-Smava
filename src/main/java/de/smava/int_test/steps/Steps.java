package de.smava.int_test.steps;

import de.smava.int_test.pages.LoanDetailsResult;
import de.smava.int_test.pages.PageFactory;
import de.smava.int_test.pages.ScoreCompassHome;
import de.smava.int_test.pages.SmavaHome;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Steps {

    private SmavaHome smava;

    private LoanDetailsResult result;

    private ScoreCompassHome scoreCompass;

    public Steps(PageFactory pageFactory) {
        smava = pageFactory.newHome();
        result = pageFactory.newResult();
        scoreCompass = pageFactory.newScoreCompass();
    }

    @Given("The user navegates on smava")
    public void homepageOnSmavaDotCom() {
        smava.go();
    }

    @When("The user selectes <amount>")
    public void selectAmount(@Named("amount") int amount) {
        smava.searchAmount(amount);
    }

    @When("The user selectes <duration>")
    public void selectDuration(@Named("duration") int duration) {
        smava.selectDuration(duration);
    }

    @When("The user selectes <purpose>")
    public void selectPurpose(@Named("purpose") String purpose) {
        smava.selectPurpose(purpose);
    }

    @When("The user presses the button next")
    public void pressNext() {
        smava.pressNext();
    }

    @Then("The application is redirected to the result loan detail page")
    public void goDetailPage() {
        result.verifyLoanDetail();
    }

    @Given("The user accesses to Score Compass Home with basic authentication handling")
    public void browseToTheFeaturedVideosPage() {
        scoreCompass.go();
    }

    @Then("The page is loaded correctly")
    public void thereAreVideosListed() {
        scoreCompass.verifyLoadedPage();
    }
}
