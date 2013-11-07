package com.example.exam;

import com.example.exam.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CoffeeList extends ListActivity {
	
	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    
	    final String[] arCoffee = getResources().getStringArray(R.array.coffee);
	    
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, arCoffee);
	    
	    setListAdapter(adapter);
	  }
	
	
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//Toast.makeText(this, "Clicked row " + position, Toast.LENGTH_SHORT).show();
		Intent retData=new Intent();
		retData.putExtra("selectedCoffee", l.getItemAtPosition(position).toString());
		setResult(RESULT_OK, retData);
		finish();
	}
	
		
}
