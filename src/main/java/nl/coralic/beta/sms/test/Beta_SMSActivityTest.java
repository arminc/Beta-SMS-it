package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import nl.coralic.beta.sms.*;

public class Beta_SMSActivityTest extends
	ActivityInstrumentationTestCase2<Beta_SMS>
{
    protected Solo solo;

    public Beta_SMSActivityTest()
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
    protected void tearDown() throws Exception
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
    
    //TODO: Some tests should be run manually:
    //Send sms correctly. Does the saldo change?
    //Send sms failed. Is there a notification? Clicking notification does Beta-SMS open with the failed sms?
}
