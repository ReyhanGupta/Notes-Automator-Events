package com.example.db_listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Transfer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transfer);
		
		int day= getIntent().getExtras().getInt("d");
		int mon= getIntent().getExtras().getInt("m");

		int year= getIntent().getExtras().getInt("y");

		TextView tv= (TextView)findViewById(R.id.tvDate);
		tv.setText(" "+day+" "+mon+" "+year);
	}

}
