package nl.coralic.beta.sms.test;

import android.widget.EditText;

public class S104_Beta_SMSActivityTest extends Beta_SMSActivityTest
{
    public void testSMSTextEmpty()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtTo), "1234567890");
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("SMS text can not be empty"));
    }
}
