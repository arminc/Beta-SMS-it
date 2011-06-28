package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.EditText;
import nl.coralic.beta.sms.*;

public class WizardActivityTest extends ActivityInstrumentationTestCase2<Wizard>
{

    //TODO: be able to run this from eclipse
    //test if it fails with wrong password
    //test if it works with correct password
    private Solo solo;

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

    @Smoke
    public void testUserEmpty()
    {
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Username can not be empty"));
    }
    
    @Smoke
    public void testPasswordEmpty()
    {
	solo.clickOnButton("Done");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	assertTrue(solo.searchText("Password can not be empty"));
    }
    
    @Smoke
    public void testUserPassWrong()
    {
	solo.clickOnButton("Done");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), "test");
	assertTrue(solo.searchText("Verifying account"));
	assertTrue(solo.searchText("please check your username and password"));
    }
}
