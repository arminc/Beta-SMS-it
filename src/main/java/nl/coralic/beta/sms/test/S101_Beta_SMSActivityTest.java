package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

public class S101_Beta_SMSActivityTest extends Beta_SMSActivityTest
{
    public void testTurnScreen()
    {
	solo.setActivityOrientation(Solo.LANDSCAPE);
	//need to go back before testing because it loses activity
	solo.setActivityOrientation(Solo.PORTRAIT);
	assertTrue(solo.searchText("Beta-SMS"));
    }
}
