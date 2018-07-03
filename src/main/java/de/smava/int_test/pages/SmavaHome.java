package de.smava.int_test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SmavaHome extends FluentWebDriverPage {

    private static final String SMAVA_ADRESS_WEB_SITE = "http://www.smava.de";

    /*
     * Define page elements
     */
    private By amountSelector = id("myselect");

    private By durationSelector = id("myselect2");

    private By purposeSelector = id("myselect3");

    private By buttonNext = xpath(
            "/html/body/div[5]/div[1]/div/div[3]/div/div[1]/div[2]/div[1]/div[1]/div[6]/a/button");

    /**
     * Default constructor
     *
     * @param webDriverProvider
     */
    public SmavaHome(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go() {
        get(SMAVA_ADRESS_WEB_SITE);
        // wait for page to load
        getDriverProvider().get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void searchAmount(int amount) {
        WebElement filterAmount = findElement(amountSelector);
        filterAmount.click();
        filterAmount.findElement(searchByDataValue(amount)).click();
    }

    public void selectDuration(int duration) {
        WebElement filterDuration = findElement(durationSelector);
        filterDuration.click();
        filterDuration.findElement(searchByDataValue(duration)).click();
    }

    public void selectPurpose(String purpose) {
        WebElement filterPurpose = findElement(purposeSelector);
        filterPurpose.click();
        filterPurpose.findElement(searchByDataValue(getPurposeDataValue(purpose))).click();
    }

    public void pressNext() {
        WebElement buttonWeiter = findElement(buttonNext);
        buttonWeiter.click();
        getDriverProvider().get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private int getPurposeDataValue(String purpose) {
        PurposeOption option = PurposeOption.valueOf(purpose);
        int purposeDataValue = option.value();
        return purposeDataValue;
    }

    private By searchByDataValue(int dataValue) {
        return xpath("//div[@data-value='" + dataValue + "']");
    }
}