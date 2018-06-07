package com.worth.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeclarationPage extends BasePage {
	public final By START_DECLARATION = By.cssSelector(".btn.btn-primary.btn-lg");
	public final By NEXT = By.cssSelector(".btn.btn-lg.btn-primary.visa-form__next-button");
	public final By REASON_1 = By.cssSelector("label[for=ResidenceReason-reason1]");
	public final By REASON_2 = By.cssSelector("label[for=ResidenceReason-reason2]");
	public final By REASON_3 = By.cssSelector("label[for=ResidenceReason-reason3]");
	public final By DROPDOWN_BTN = By.cssSelector(".btn.btn-primary.btn-dropdown");
	public final By ISSUE_COUNTRY = By.cssSelector("strong.suggestions__link");
	public final By START_DAY = By.cssSelector("#ResidingSince-day");
	public final By START_MONTH = By.cssSelector("#ResidingSince-month");
	public final By START_YEAR = By.cssSelector("#ResidingSince-year");
	public final By FINAL_DAY = By.cssSelector("#ResidingUntil-day");
	public final By FINAL_MONTH = By.cssSelector("#ResidingUntil-month");
	public final By FINAL_YEAR = By.cssSelector("#ResidingUntil-year");
	public final By ADDRESS1 = By.cssSelector("#AddressLine1");
	public final By ADDRESS2 = By.cssSelector("#AddressLine2");
	public final By ADDRESS3 = By.cssSelector("#AddressLine3");
	public final By ADDRESS4 = By.cssSelector("#AddressLine4");
	public final By POST_CODE = By.cssSelector("#AddressPostalCode");
	public final By CITY_TOWN = By.cssSelector("#AddressCityOrTown");
	public final By RADIO = By.cssSelector("[class='radio-custom']");
	public final By SURNAME = By.cssSelector("#Surname");
	public final By GIVEN_NAME = By.cssSelector("#GivenNames");
	public final By BIRTH_DAY = By.cssSelector("#DateOfBirth-day");
	public final By BIRTH_MONTH = By.cssSelector("#DateOfBirth-month");
	public final By BIRTH_YEAR = By.cssSelector("#DateOfBirth-year");
	public final By BIRTHPLACE = By.cssSelector("#PlaceOfBirth");
	public final By DOC_NUMBER= By.cssSelector("#DocumentNumber");
	public final By VALID_DAY = By.cssSelector("#DocumentNumberValidUntil-day");
	public final By VALID_MONTH = By.cssSelector("#DocumentNumberValidUntil-month");
	public final By VALID_YEAR = By.cssSelector("#DocumentNumberValidUntil-year");
	public final By COUNTRY_OF_BIRTH = By.cssSelector("#CountryOfBirth");
	public final By SUCCESS = By.xpath(".//*[text()='My applications']/following-sibling::span");
	
	public final By SUMMARY_REASON = By.xpath(".//*[text()=' Please select your reason for requesting a declaration of residence ']/following-sibling::div/ul/li");
	public final By SUMMARY_COUNTRYTOISSUE = By.xpath(".//*[text()=' Country to issue the declaration ']/following-sibling::div/ul/li");
	public final By SUMMARY_DOYOUSTILLLIVE = By.xpath(".//*[text()=' Do you still live in this country? ']/following-sibling::div/ul/li");
	public final By SUMMARY_STARTDATE = By.xpath(".//*[text()=' Start date ']/following-sibling::div/ul/li");
	public final By SUMMARY_ENDDATE = By.xpath(".//*[text()=' End date ']/following-sibling::div/ul/li");
	public final By SUMMARY_STREETANDHOUSENO = By.xpath(".//*[text()=' Street and house number ']/following-sibling::div/ul/li");
	public final By SUMMARY_CITYORTOWN = By.xpath(".//*[text()=' City or Town ']/following-sibling::div/ul/li");
	public final By SUMMARY_SURNAME = By.xpath(".//*[text()=' Surname ']/following-sibling::div/ul/li");
	public final By SUMMARY_GIVENNAME = By.xpath(".//*[text()=' Given name(s) ']/following-sibling::div/ul/li");
	public final By SUMMARY_GENDER = By.xpath(".//*[text()=' Gender ']/following-sibling::div/ul/li");
	public final By SUMMARY_DATEOFBIRTH = By.xpath(".//*[text()=' Date of birth ']/following-sibling::div/ul/li");
	public final By SUMMARY_PLACEOFBIRTH = By.xpath(".//*[text()=' Place of birth ']/following-sibling::div/ul/li");
	public final By SUMMARY_COUNTRYOFBIRTH = By.xpath(".//*[text()=' Country of birth ']/following-sibling::div/ul/li");
	public final By SUMMARY_DUTCHIDENTITYNO = By.xpath(".//*[text()=' Dutch identity document number ']/following-sibling::div/ul/li");
	public final By SUMMARY_DOCUMENTVALIDUNTIL = By.xpath(".//*[text()=' Document valid until ']/following-sibling::div/ul/li");
	public final By SUMMARY_NATIONALITYNEXTTOTHEDUTCH = By.xpath(".//*[text()=' Do you have any nationalities next to the Dutch nationality? ']/following-sibling::div/ul/li");
	public final By SUMMARY_ANOTHERRESIDENT = By.xpath(".//*[text()=' Add another resident to your declaration of residence ']/following-sibling::div/ul/li");
	
	
	public DeclarationPage(WebDriver driver) {
		super(driver);
	}

	
	public void clickToStartApplication() {
		System.out.println("Navigate to: Declaration Process is Starting...");
		getElement(START_DECLARATION).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickToNext() {
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WaitUntilElementIsPresent(NEXT);
		System.out.println("Navigate to next page...");
		getElement(NEXT).click();
	}
	
	/*
	 * select reason
	 */
	public void selectReason(int reasonId)
	{
		By currentReason;
		if(reasonId == 1) {
			currentReason = REASON_1;
		}
		else if(reasonId == 2) {
			currentReason = REASON_2;
		}
		else if(reasonId == 3) {
			currentReason = REASON_3;
		}
		else {
			return;
		}
		
		WaitUntilElementIsPresent(currentReason);
		System.out.println("Reason...");
		
		try {
			getElement(currentReason).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			getElement(currentReason).click();
		}
	}
	
	public void selectCountryToIssue() {
		WaitUntilElementIsPresent(DROPDOWN_BTN);
		System.out.println("Country to issue the declaration...");
		getElement(DROPDOWN_BTN).click();
		WaitUntilElementIsPresent(ISSUE_COUNTRY);
		getElement(ISSUE_COUNTRY).click();
	}
	
	public void enterStartDate(String day, String month, String year) {
		WaitUntilElementIsPresent(START_DAY);
		getElement(START_DAY).clear();
		getElement(START_DAY).sendKeys(day);
		WaitUntilElementIsPresent(START_MONTH);
		getElement(START_MONTH).clear();
		getElement(START_MONTH).sendKeys(month);
		WaitUntilElementIsPresent(START_YEAR);
		getElement(START_YEAR).clear();
		getElement(START_YEAR).sendKeys(year);
	}
	
	public void enterEndDate(String day, String month, String year) {
		WaitUntilElementIsPresent(FINAL_DAY);
		getElement(FINAL_DAY).clear();
		getElement(FINAL_DAY).sendKeys(day);
		WaitUntilElementIsPresent(FINAL_MONTH);
		getElement(FINAL_MONTH).clear();
		getElement(FINAL_MONTH).sendKeys(month);
		WaitUntilElementIsPresent(FINAL_YEAR);
		getElement(FINAL_YEAR).clear();
		getElement(FINAL_YEAR).sendKeys(year);
	}
	
	
	public void enterAddress(String address1) {
		WaitUntilElementIsPresent(ADDRESS1);
		getElement(ADDRESS1).clear();
		getElement(ADDRESS1).sendKeys(address1);
		
	}
	
	public void enterCityTown(String cityortown) {
		WaitUntilElementIsPresent(CITY_TOWN);
		getElement(CITY_TOWN).clear();
		getElement(CITY_TOWN).sendKeys(cityortown);
		}
	
	
	public void countryOfBirth(String a) { 		
		getElement(COUNTRY_OF_BIRTH).clear();
		getElement(COUNTRY_OF_BIRTH).sendKeys(a);
		WaitUntilElementIsPresent(ISSUE_COUNTRY);
		getElement(ISSUE_COUNTRY).click();
		}
	
	public void enterSurname(String surname) {
		WaitUntilElementIsPresent(SURNAME);
		getElement(SURNAME).clear();
		getElement(SURNAME).sendKeys(surname);
	}
	
	public void enterGivenName(String name) {
		WaitUntilElementIsPresent(GIVEN_NAME);
		getElement(GIVEN_NAME).clear();
		getElement(GIVEN_NAME).sendKeys(name);	
	}
	
	public void enterBirthDate(String day, String month, String year) {
		WaitUntilElementIsPresent(BIRTH_DAY);
		getElement(BIRTH_DAY).clear();
		getElement(BIRTH_DAY).sendKeys(day);
		WaitUntilElementIsPresent(BIRTH_MONTH);
		getElement(BIRTH_MONTH).clear();
		getElement(BIRTH_MONTH).sendKeys(month);
		WaitUntilElementIsPresent(BIRTH_YEAR);
		getElement(BIRTH_YEAR).clear();
		getElement(BIRTH_YEAR).sendKeys(year);
	}
	
	public void enterBirthPlace(String name) {
		WaitUntilElementIsPresent(BIRTHPLACE);
		getElement(BIRTHPLACE).clear();
		getElement(BIRTHPLACE).sendKeys(name);	
	}
	
	public void enterValidDate(String day, String month, String year) {
		WaitUntilElementIsPresent(VALID_DAY);
		getElement(VALID_DAY).clear();
		getElement(VALID_DAY).sendKeys(day);
		WaitUntilElementIsPresent(VALID_MONTH);
		getElement(VALID_MONTH).clear();
		getElement(VALID_MONTH).sendKeys(month);
		WaitUntilElementIsPresent(VALID_YEAR);
		getElement(VALID_YEAR).clear();
		getElement(VALID_YEAR).sendKeys(year);
	}
	

	public void enterDocNumber(String name) {
		WaitUntilElementIsPresent(DOC_NUMBER);
		getElement(DOC_NUMBER).clear();
		getElement(DOC_NUMBER).sendKeys(name);	
	}
	
	public void chooseRadioButton(int index) { 		
		clickToNthOfElement(RADIO, index); 	
		}
	
	public String checkSuccessMessage() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getElement(SUCCESS).getText();

	}
	
	public String checkSummaryReason() {
		return getElement(SUMMARY_REASON).getText();
	}
	
	public String checkSummaryCountryToIssue() {
		return getElement(SUMMARY_COUNTRYTOISSUE).getText();
	}
	
	public String checkSummaryDoYouStillLive() {
		return getElement(SUMMARY_DOYOUSTILLLIVE).getText();
	}
	
	public String checkSummaryStartDate() {
		return getElement(SUMMARY_STARTDATE).getText();
	}
	
	public String checkSummaryEndDate() {
		return getElement(SUMMARY_ENDDATE).getText();
	}

	public String checkSummaryStreetAndHouseNo() {
		return getElement(SUMMARY_STREETANDHOUSENO).getText();
	}
	
	public String checkSummaryCityOrTown() {
		return getElement(SUMMARY_CITYORTOWN).getText();
	}
	
	public String checkSummarySurname() {
		return getElement(SUMMARY_SURNAME).getText();
	}
	
	public String checkSummaryGivenName() {
		return getElement(SUMMARY_GIVENNAME).getText();
	}
	
	public String checkSummaryGender() {
		return getElement(SUMMARY_GENDER).getText();
	}
	
	public String checkSummaryDateOfBirth() {
		return getElement(SUMMARY_DATEOFBIRTH).getText();
	}
	
	public String checkSummaryPlaceOfBirth() {
		return getElement(SUMMARY_PLACEOFBIRTH).getText();
	}
	
	public String checkSummaryCountryOfBirth() {
		return getElement(SUMMARY_COUNTRYOFBIRTH).getText();
	}
	
	public String checkSummaryDutchIdentityNo() {
		return getElement(SUMMARY_DUTCHIDENTITYNO).getText();
	}
	
	public String checkSummaryDocumentValidUntil() {
		return getElement(SUMMARY_DOCUMENTVALIDUNTIL).getText();
	}
	
	public String checkSummaryNationalityNextToTheDutch() {
		return getElement(SUMMARY_NATIONALITYNEXTTOTHEDUTCH).getText();
	}
	
	public String checkSummaryAnotherResident() {
		return getElement(SUMMARY_ANOTHERRESIDENT).getText();
	}
	
}