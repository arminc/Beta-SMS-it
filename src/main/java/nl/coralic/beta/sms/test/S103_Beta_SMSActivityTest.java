package nl.coralic.beta.sms.test;

public class S103_Beta_SMSActivityTest extends Beta_SMSActivityTest
{
    public void testPhoneNumberEmpty()
    {
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("Phone number can not be empty"));
    }
}
