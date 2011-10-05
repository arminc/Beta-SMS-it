package nl.coralic.beta.sms.test;

import android.widget.EditText;

public class S105_Beta_SMSActivityTest extends Beta_SMSActivityTest
{
    public void testSendSMS()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtTo), "1234567890");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtSmsText), "test");
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("Sending SMS"));
    }
}
