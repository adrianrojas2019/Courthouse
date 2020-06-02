package main.java.tests.adminTests;

import main.java.pageObjects.FreeTrialPage;
import main.java.pageObjects.PayGoPage;
import main.java.selenium.SeleniumInitializer;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/5/2018.
 */
public class addPayGo extends SeleniumInitializer {
    @Parameters({"environment","payGoURL","firstNamePayGo","lastNamePayGo","emailUserNamePayGo","phoneNumberPayGo","organizationPayGo","userNamePayGo","numberOfUserPayGoToCreate",
            "address1","city","state","zipCode","legalNameCC","creditCardNumber","cvv","monthExpirationDate","yearExpirationDate"})
    @Test(groups = {"CH_Add_PayGo","Adding_Users"})

    public void addPayGo(String environment, String payGoURL, String firstNamePayGo, String lastNamePayGo, String emailUserNamePayGo, String phoneNumberPayGo, String organizationPayGo,String userNamePayGo, int numberOfUserPayGoToCreate,
                         String address1, String city, String state, String zipCode, String legalNameCC, String creditCardNumber, String cvv, String monthExpirationDate, String yearExpirationDate) throws InterruptedException {

        for(int numberOfUser=98; numberOfUser <= numberOfUserPayGoToCreate; numberOfUser++) {
            //Create page object
            PayGoPage newPayGoPage = new PayGoPage(driver);
            newPayGoPage.LoadNewURL(String.format(payGoURL,environment));
            Assert.assertTrue(newPayGoPage.waitForElementVisible(300), "Cannot login the PayGo Subscription Page");
            //Fill all information accordingly

            //Add First&Last Name
            newPayGoPage.insertUserName(String.format(userNamePayGo,numberOfUser));
            newPayGoPage.insertName(firstNamePayGo,lastNamePayGo);
            newPayGoPage.insertEmailUserName(String.format(emailUserNamePayGo,numberOfUser));
            newPayGoPage.insertPhoneNumber(phoneNumberPayGo);
            newPayGoPage.insertOrganization(organizationPayGo);

            newPayGoPage.insertAddress1(address1);
            newPayGoPage.insertCity(city);
            newPayGoPage.insertState(state);
            newPayGoPage.insertZipCode(zipCode);
            newPayGoPage.insertCardInfo(legalNameCC,creditCardNumber,cvv,monthExpirationDate,yearExpirationDate);

            //CheckBox Accept the Terms & Conditions
            newPayGoPage.checkConditions();
            //Click on Get Instant Access button
            newPayGoPage.clickOnGetAccessButton();
            Assert.assertTrue(newPayGoPage.waitForFreeTrialSubscriptionPopUpDisplayed(30), "Confirm Pay Go Subscription Pop Up");
            newPayGoPage.clickOnContinueButton();
            //Success Message
            Assert.assertTrue(newPayGoPage.waitForSuccessMessageDisplayed(30), "Pay Go User has not been created");
            //Click on Login button
            newPayGoPage.clickOnLoginButton();

        }
        //Assert.assertTrue(usersPage.isAllUserTitleDisplayed(), "The new users could not be added");
    }
}
