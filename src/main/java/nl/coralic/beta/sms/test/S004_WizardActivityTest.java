package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.widget.EditText;

public class S004_WizardActivityTest extends WizardActivityTest
{
    public void testTurnScreenWhileConnecting()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Verifying account"));
	solo.setActivityOrientation(Solo.LANDSCAPE);
	//need to go back before testing because it loses activity
	solo.setActivityOrientation(Solo.PORTRAIT);
	assertTrue(solo.searchText("please check your username and password"));
    }
}
