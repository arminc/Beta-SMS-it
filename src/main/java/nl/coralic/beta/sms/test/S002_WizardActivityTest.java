package nl.coralic.beta.sms.test;

import android.widget.EditText;

public class S002_WizardActivityTest extends WizardActivityTest
{
    public void testPasswordEmpty()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Password can not be empty"));
    }
}
