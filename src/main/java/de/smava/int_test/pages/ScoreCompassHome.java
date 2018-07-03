package de.smava.int_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.xpath;

public class ScoreCompassHome {

    private static final String SCORECOMPASS_ADRESS_WEB_SITE = "https://ostdteam:ostdteam@test.scorecompass.ostdlabs.com/";

    public static final String SCORECOMPASS_TEXT = "Mein Kontoscore";

    private FirefoxDriver webDriverFirefoxDriver;

    private By meinKontoscoreXPATH = xpath("//a[@href='" + "/#!kontoscore" + "']");

    public ScoreCompassHome() {
    }

    /*
     * Go directly to this page which is loaded ignoring self signed SSL
     * certificate without manual authentication input
     */
    public void go() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAssumeUntrustedCertificateIssuer(false);
        this.webDriverFirefoxDriver = new FirefoxDriver(profile);
        this.webDriverFirefoxDriver.get(SCORECOMPASS_ADRESS_WEB_SITE);
        this.webDriverFirefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifyLoadedPage() {
        WebElement meinKontoscore = webDriverFirefoxDriver.findElement(meinKontoscoreXPATH);
        assertThat("The element Mein Kontoscore of the page is correctly load", meinKontoscore.getText().equals(SCORECOMPASS_TEXT));
        this.webDriverFirefoxDriver.close();
    }
}
