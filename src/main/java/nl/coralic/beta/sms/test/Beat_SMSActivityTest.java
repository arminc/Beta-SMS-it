package nl.coralic.beta.sms.test;

import android.test.ActivityInstrumentationTestCase2;
import nl.coralic.beta.sms.*;

public class Beat_SMSActivityTest extends
	ActivityInstrumentationTestCase2<Beta_SMS>
{

    Beta_SMS activity;

    public Beat_SMSActivityTest()
    {
	super("nl.coralic.beta.sms", Beta_SMS.class);
    }

    @Override
    protected void setUp() throws Exception
    {
	super.setUp();
	activity = this.getActivity();
    }

    public void testActivity()
    {
	Beta_SMS activity = getActivity();
	assertNotNull(activity);
    }
}
