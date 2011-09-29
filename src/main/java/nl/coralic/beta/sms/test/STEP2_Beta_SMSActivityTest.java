package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import nl.coralic.beta.sms.*;

public class STEP2_Beta_SMSActivityTest extends
	ActivityInstrumentationTestCase2<Beta_SMS>
{
    private Solo solo;

    public STEP2_Beta_SMSActivityTest()
    {
	super("nl.coralic.beta.sms", Beta_SMS.class);
    }

    @Override
    protected void setUp() throws Exception
    {
	super.setUp();
	solo = new Solo(getInstrumentation(), getActivity());
    }
    
    @Override
    public void tearDown() throws Exception
    {

	try
	{
	    solo.finalize();
	}
	catch (Throwable e)
	{

	    e.printStackTrace();
	}
	getActivity().finish();
	super.tearDown();

    }

    public void testTurnScreen()
    {
	solo.setActivityOrientation(Solo.LANDSCAPE);
	//need to go back before testing because it loses activity
	solo.setActivityOrientation(Solo.PORTRAIT);
	assertTrue(solo.searchText("Beta-SMS"));
    }
    
    public void testSaldoShown() throws InterruptedException
    {
	wait(5);
	solo.searchText("Saldo:");
    }
    
    public void testPhoneNumberEmpty()
    {
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("Phone number can not be empty"));
    }
    
    
    public void testSMSTextEmpty()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtTo), "1234567890");
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("SMS text can not be empty"));
    }
    
    public void testSendSMS()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtTo), "1234567890");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtSmsText), "test");
	solo.clickOnButton("Send");
	assertTrue(solo.searchText("Sending SMS"));
    }
    
    //TODO: send sms correct, does the saldo change?
    //TODO: send sms fail?
}
