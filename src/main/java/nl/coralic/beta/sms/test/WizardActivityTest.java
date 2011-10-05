package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import nl.coralic.beta.sms.*;

//Using this as an starting point and having every Test in a separate class file it makes it easier to see what test has failed
public class WizardActivityTest extends ActivityInstrumentationTestCase2<Wizard>
{
    protected Solo solo;

    public WizardActivityTest()
    {
	super("nl.coralic.beta.sms", Wizard.class);
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
}
