package nl.coralic.beta.sms.test;

public class S001_WizardActivityTest extends WizardActivityTest
{
    public void testUserEmpty()
    {
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Username can not be empty"));
    }
}
