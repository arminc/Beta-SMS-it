package nl.coralic.beta.sms.test;

import android.test.ActivityInstrumentationTestCase2;
import nl.coralic.beta.sms.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<Beta_SMS> {

    public HelloAndroidActivityTest() {
        super(Beta_SMS.class);
    }

    public void testActivity() {
    	Beta_SMS activity = getActivity();
        assertNotNull(activity);
    }
}

