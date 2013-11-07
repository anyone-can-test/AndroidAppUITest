package com.example.exam.test;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Button;

import com.example.exam.CoffeeList;
import com.example.exam.MainActivity;
import com.example.exam.R;


public class ActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private Button mCoffeeButton;
	
	private static final String TAG = "MyActivity";
	
	
	public ActivityTest() {
	    super("com.example.exam", MainActivity.class);
	  } // end of SpinnerActivityTest constructor definition
	
	 public void testSelectCoffeeUI() {

		 //Instrumentation instrumentation = getInstrumentation();
     	ActivityMonitor activityMonitor = getInstrumentation().addMonitor(CoffeeList.class.getName(), null, false);
     	ActivityMonitor activityMonitor2 = getInstrumentation().addMonitor(MainActivity.class.getName(), null, false);
     	
		    mActivity.runOnUiThread(
		      new Runnable() {
		        public void run() {
		          
		        	mCoffeeButton.requestFocus();
		        	mCoffeeButton.callOnClick();
		        			        	
		        	//ListActivity coffee_list = (ListActivity)mActivity.get
		        } // end of run() method definition
		      } // end of anonymous Runnable object instantiation
		    ); // end of invocation of runOnUiThread
		    
		    final CoffeeList coffee_list = (CoffeeList)getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
		    
		    assertNotNull(coffee_list);
		    
		    coffee_list.getListView().getItemIdAtPosition(0);
        	String coffee = coffee_list.getListView().getItemAtPosition(0).toString();
        	assertTrue(coffee.compareTo("Filer") == 0);
        	
        	
        	coffee = coffee_list.getListView().getItemAtPosition(1).toString();
        	assertTrue(coffee.compareTo("Americano") == 0);
        	
        	coffee = coffee_list.getListView().getItemAtPosition(2).toString();
        	assertTrue(coffee.compareTo("Latte") == 0);
        	
        	
		    
		    coffee_list.runOnUiThread(
				      new Runnable() {
				        public void run() {
				          
				        	coffee_list.getListView().setItemChecked(0, true);
				        	//coffee_list.getListView().callOnClick();			
				        	coffee_list.getListView().performItemClick(coffee_list.getListView(),  1, coffee_list.getListView().getItemIdAtPosition(1));
				        	
				        	//coffee_list.getListView().getItemAtPosition(0)
				        } // end of run() method definition
				      } // end of anonymous Runnable object instantiation
				    ); // end of invocation of runOnUiThread
		    
		    getInstrumentation().waitForMonitorWithTimeout(activityMonitor2, 5000);
		    
		    //String selectedCoffee = mActivity.data.getExtras().get("selectedCoffee").toString();
		    
		    try {
		    	Field f = MainActivity.class.getDeclaredField("selectedCoffee");
		    	f.setAccessible(true);
		    	String actualResult = (String)f.get(mActivity);
		    	
		    	Log.v(TAG, actualResult);
		    	
		    	
		    	assertTrue(actualResult.compareTo("Americano") == 0);
		    	
		    } catch(Exception e) {
		    	throw new RuntimeException(e);
		    }
		    
	 }
		    
	
	
	@Override
	  protected void setUp() throws Exception {
	    super.setUp();

	    setActivityInitialTouchMode(false);

	    mActivity = getActivity();
	    
	    mCoffeeButton = (Button)mActivity.findViewById(com.example.exam.R.id.btnSelectCoffee);
	    

	  } // end of setUp() method definition
	
	public void testPreConditions() {
	    assertTrue(mActivity.test.compareTo("hello") == 0);
	  } // end of testPreConditions() method definition
	
	
	//public void testPreConditions2() {
	  //  assertTrue(mActivity.test.compareTo("hello2") == 0);
	  //} // end of testPreConditions() method definition
	
}
