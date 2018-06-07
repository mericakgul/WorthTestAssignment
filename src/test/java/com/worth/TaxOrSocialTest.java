package com.worth;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.worth.page.DeclarationPage;
import com.worth.page.LandingPage;

public class TaxOrSocialTest extends BaseTest {
	LandingPage onLandingPage;
	DeclarationPage onDeclarationPage;

	public TaxOrSocialTest() {
		super();
	}

	
	/*
	 * Navigating to test page "https://nomad-test-spa.azurewebsites.net/declaration-residence".
	 * Landing Page URL is retrieved from 'worth.properties' file.
	 */
	@Test
	public void checkLandingPage() {
		onLandingPage = new LandingPage(driver);
		onDeclarationPage = new DeclarationPage(driver);
		System.out.println("Navigating to Landing Page: " + LOGIN_URL);
		onLandingPage.navigateToHomePage(LOGIN_URL);
		String actualTitle1=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle1);
		Assert.assertEquals(actualTitle1, "Declaration of Residence - Ministry of Foreign Affairs");
	}
	
	
	/*
	 * This method tests if the application form is started or not.
	 */
	@Test
	public void startYourApplication() {
		System.out.println("Starting Declaration...");
		onDeclarationPage.clickToStartApplication();
		String actualTitle2=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle2);
		Assert.assertEquals(actualTitle2, "Declaration of Residence - Reason for declaration - Ministry of Foreign Affairs");
	
	}
	
	/*
	 * Select Reason In connection with tax or social security contributions = Reason 1
	 */
	@Test
	public void selectTaxSocialSecurityContributions() {
		System.out.println("Selecting Reason...");
		onDeclarationPage.selectReason(1);
		System.out.println("Next is clicking...");
		onDeclarationPage.clickToNext();
		String actualTitle3=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle3);
		Assert.assertEquals(actualTitle3, "Declaration of Residence - Country and Residence - Ministry of Foreign Affairs");
	
	}
	
	
	/*
	 * This method fills Country and Residence form and navigates user to next page.
	 */
	@Test
	public void fillForumCountryResidence() {
		onDeclarationPage.selectCountryToIssue();
		onDeclarationPage.chooseRadioButton(1);
		onDeclarationPage.enterStartDate("23","3","1990");
		onDeclarationPage.enterEndDate("23","3","2000");
		onDeclarationPage.enterAddress("Cay Yolu 2");
		onDeclarationPage.enterCityTown("Ankara");
		onDeclarationPage.clickToNext();
		String actualTitle4=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle4);
		Assert.assertEquals(actualTitle4, "Declaration of Residence - Personal information - Ministry of Foreign Affairs");
		
	}	
	
	
	/*
	 * This method fills Personal Information form and navigates user to next page.
	 */
	@Test
	public void fillForumPersonalInformation() {
		onDeclarationPage.enterSurname("Akgul");
		onDeclarationPage.enterGivenName("Meric");
		onDeclarationPage.chooseRadioButton(0);
		onDeclarationPage.enterBirthDate("22","8","1989");
		onDeclarationPage.enterBirthPlace("Ankara");
		onDeclarationPage.countryOfBirth("Turkey");
		System.out.println("next in the nationality");
		onDeclarationPage.clickToNext();		
		String actualTitle5=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle5);
		Assert.assertEquals(actualTitle5, "Declaration of Residence - Nationality - Ministry of Foreign Affairs");
	}
	
	
	/*
	 * This method fills Nationality form and navigates user to next page.
	 */
	@Test
	public void fillForumNationality() {
		  
		onDeclarationPage.enterDocNumber("11145252757");
		onDeclarationPage.enterValidDate("11","8","2020");
		onDeclarationPage.chooseRadioButton(1);
		onDeclarationPage.chooseRadioButton(3);
		onDeclarationPage.clickToNext();
		String actualTitle6=driver.getTitle();
		System.out.println("Comparing Titles: " + actualTitle6);
		Assert.assertEquals(actualTitle6, "Declaration of Residence - Review application - Ministry of Foreign Affairs");
	}
	
	/*
	 * This method compares displayed summary info and expected info.
	 */
	@Test
	public void checkSummaryInfo() {
		Assert.assertEquals(onDeclarationPage.checkSummaryReason(), "In connection with tax or social security contributions");
		Assert.assertEquals(onDeclarationPage.checkSummaryCountryToIssue(), "Germany");
		Assert.assertEquals(onDeclarationPage.checkSummaryDoYouStillLive(), "No");
		Assert.assertEquals(onDeclarationPage.checkSummaryStartDate(), "23-03-1990");
		Assert.assertEquals(onDeclarationPage.checkSummaryEndDate(), "23-03-2000");
		Assert.assertEquals(onDeclarationPage.checkSummaryStreetAndHouseNo(), "Cay Yolu 2");
		Assert.assertEquals(onDeclarationPage.checkSummaryCityOrTown(), "Ankara");
		Assert.assertEquals(onDeclarationPage.checkSummarySurname(), "Akgul");
		Assert.assertEquals(onDeclarationPage.checkSummaryGivenName(), "Meric");
		Assert.assertEquals(onDeclarationPage.checkSummaryGender(), "Male");
		Assert.assertEquals(onDeclarationPage.checkSummaryDateOfBirth(), "22-08-1989");
		Assert.assertEquals(onDeclarationPage.checkSummaryPlaceOfBirth(), "Ankara");
		Assert.assertEquals(onDeclarationPage.checkSummaryCountryOfBirth(), "Turkey");
		Assert.assertEquals(onDeclarationPage.checkSummaryDutchIdentityNo(), "11145252757");
		Assert.assertEquals(onDeclarationPage.checkSummaryDocumentValidUntil(), "11-08-2020");
		Assert.assertEquals(onDeclarationPage.checkSummaryNationalityNextToTheDutch(), "No");
		Assert.assertEquals(onDeclarationPage.checkSummaryAnotherResident(), "No");
		
	}
	
	/*
	 * This method tests successful completion of Declaration and Residence application.
	 * It tests whether the completed application is saved under "my applications" or not
	 */
	@Test
	public void completeYourApplication() {
		onDeclarationPage.clickToNext();
		Assert.assertEquals(onDeclarationPage.checkSuccessMessage(), "1");
		System.out.println("Application is completing with Application number " + onDeclarationPage.checkSuccessMessage() );
	}
	
	
}
