package nl.coralic.beta.sms.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import nl.coralic.beta.sms.*;

public class WizardActivityTest extends ActivityInstrumentationTestCase2<Wizard>
{
    private Solo solo;
    //TODO: username/password/provider not in the code?
    private static String username = "";
    private static String password = "";
    private static int provider = 31;

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

    public void testUserEmpty()
    {
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Username can not be empty"));
    }
    
    public void testPasswordEmpty()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Password can not be empty"));
    }
    
    public void testUserPassWrong()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Verifying account"));
	assertTrue(solo.searchText("please check your username and password"));
    }
    
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
    
    public void testXPressBackWhileConnecting()
    {
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), "test");
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), "test");
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Verifying account"));
	solo.goBack();
	assertTrue(solo.searchText("Username:"));
    }
    
    public void testUserPassCorrect()
    {
	solo.pressSpinnerItem(0, provider);	
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername), username);
	solo.enterText((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtPassword), password);
	solo.clickOnButton("Done");
	assertTrue(solo.searchText("Verifying account"));
	solo.sleep(10000);
	assertEquals("", ((EditText)solo.getView(nl.coralic.beta.sms.R.id.txtUsername)).getText().toString());
    }
}
