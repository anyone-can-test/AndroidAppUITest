package com.example.exam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	public Button btnSelectCoffee;
	public String test = "hello";
	public String selectedCoffee = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSelectCoffee = (Button)findViewById(R.id.btnSelectCoffee);
		btnSelectCoffee.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
				Intent intent = new Intent(MainActivity.this, CoffeeList.class);
				int requestCode = 0;
				startActivityForResult(intent, requestCode); 
			}
			
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                // A contact was picked.  Here we will just display it
                // to the user.
            	
            	String selectedCoffee = data.getExtras().get("selectedCoffee").toString();
            	this.selectedCoffee = selectedCoffee;
            	Toast.makeText(this, "ordered: " + selectedCoffee, Toast.LENGTH_SHORT).show();
            	
            }
        }
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
