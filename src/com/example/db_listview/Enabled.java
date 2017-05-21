package com.example.db_listview;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Enabled extends Activity{
	boolean bluet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		bluet=getIntent().getExtras().getBoolean("bluet");
		Toast.makeText(this, "in enabled", 1000).show();
		if(bluet==true)
		{
		Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(turnOn, 0);
		}
		
        
	}
	

}
