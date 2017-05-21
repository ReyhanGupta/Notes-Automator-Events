package com.example.db_listview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class Send  extends Activity{
int p;
String pp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//int p=getIntent().getExtras().getInt("phone");
	//	String pp=getIntent().getExtras().getString("type");
	//	String notea= getIntent().getExtras().getString("type");

		go();
	}

	private void go() {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "Hello", 1999).show();
		
		
		Toast.makeText(this, ""+p, 1999).show();
		Toast.makeText(this, pp, 1999).show();

		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
	      
	      smsIntent.setData(Uri.parse("smsto:"));
	      smsIntent.setType("vnd.android-dir/mms-sms");
	      smsIntent.putExtra("address"  , new String ("01234"));
	      smsIntent.putExtra("sms_body"  , "Test ");
	      
	         startActivity(smsIntent);
	}
	
	

}
