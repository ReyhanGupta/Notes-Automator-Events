package com.example.db_listview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MessageRec extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		String type=arg1.getExtras().getString("type");
		int phone=arg1.getExtras().getInt("phone");
		
		
		
		Intent i= new Intent(arg0, MsgService.class);
		i.putExtra("type", type);
		i.putExtra("phone", phone);
		
		arg0.startService(i);
		
		//SmsManager smsManager = SmsManager.getDefault();
		//smsManager.sendTextMessage(""+phone, null, type, null, null);
	}

}
