package nl.coralic.beta.sms.test;

import android.widget.EditText;

public class S005_WizardActivityTest extends WizardActivityTest
{
    public void testPressBackWhileConnecting()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Verifying account"));
	solo.goBack();
	assertTrue(solo.searchText("Username:"));
    }
}
