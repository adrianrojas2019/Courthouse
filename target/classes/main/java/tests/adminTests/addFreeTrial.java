package main.java.tests.adminTests;

import main.java.pageObjects.FreeTrialPage;
import main.java.selenium.SeleniumInitializer;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 11/30/2018.
 */
public class addFreeTrial extends SeleniumInitializer {
    @Parameters({"environment","freeTrialURL","firstNameFreeTrial","lastNameFreeTrial","emailUserNameFreeTrial","phoneNumberFreeTrial","organizationFreeTrial","userNameFreeTrial","numberOfUserFreeTrialToCreate"})
    @Test(groups = {"CH_Add_FreeTrial","Adding_Users"})

    public void addFreeTrial(String environment, String freeTrialURL, String firstNameFreeTrial, String lastNameFreeTrial, String emailUserNameFreeTrial, String phoneNumberFreeTrial, String organizationFreeTrial,String userNameFreeTrial, int numberOfUserFreeTrialToCreate) throws InterruptedException {

        for(int numberOfUser=1; numberOfUser <= numberOfUserFreeTrialToCreate; numberOfUser++) {
            //Create page object
            FreeTrialPage newFreeTrialPage = new FreeTrialPage(driver);
            newFreeTrialPage.LoadNewURL(String.format(freeTrialURL,environment));
            Assert.assertTrue(newFreeTrialPage.waitForElementVisible(300), "Cannot login the FreeTrial Subscription Page");
            //Fill all information accordingly


            //Add First&Last Name
            newFreeTrialPage.insertUserName(String.format(userNameFreeTrial,numberOfUser));
            newFreeTrialPage.insertName(firstNameFreeTrial,lastNameFreeTrial);
            newFreeTrialPage.insertEmailUserName(String.format(emailUserNameFreeTrial,numberOfUser));
            newFreeTrialPage.insertPhoneNumber(phoneNumberFreeTrial);
            newFreeTrialPage.insertOrganization(organizationFreeTrial);

            //CheckBox Accept the Terms & Conditions
            newFreeTrialPage.checkConditions();
            //Click on Get Instant Access button
            newFreeTrialPage.clickOnGetAccessButton();
            Assert.assertTrue(newFreeTrialPage.waitForFreeTrialSubscriptionPopUpDisplayed(30), "Confirm Free trial Subscription Pop Up");
            newFreeTrialPage.clickOnContinueButton();
            //Success Message
            Assert.assertTrue(newFreeTrialPage.waitForSuccessMessageDisplayed(30), "Free Trial User has not been created");
            //Click on Login button
            newFreeTrialPage.clickOnLoginButton();
        }
        //Assert.assertTrue(usersPage.isAllUserTitleDisplayed(), "The new users could not be added");
    }
}
