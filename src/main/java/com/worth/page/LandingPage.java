package com.worth.page;

import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String URL) {
    navigateToURL(URL);

    }

}