package com.example.db_listview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.telephony.SmsManager;

public class MsgService extends android.app.Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		String type=intent.getExtras().getString("type");
		int phone=intent.getExtras().getInt("phone");

		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
	    smsIntent.setData(Uri.parse("smsto:"));
	    smsIntent.setType("vnd.android-dir/mms-sms");
	    smsIntent.putExtra("address"  , new String (""+phone));
	    smsIntent.putExtra("sms_body"  , type);
	    smsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK );
	      
	     startActivity(smsIntent);
	      
		
        return START_NOT_STICKY;
    }


}
