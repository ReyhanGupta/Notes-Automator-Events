package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Profile_Rec extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
		String passedArg=arg1.getExtras().getString("arg");
		Intent iii=new Intent(arg0, AutomatorNew.class);
		createNotification(arg0, "Home Profile On", passedArg, "ToDo Task Alarm");


		Intent ii= new Intent(arg0, ProfileService.class);

		
		ii.putExtra("extra", passedArg);
		arg0.startService(ii);
		
	}
	
	
	private void createNotification(Context context, String msg,
			String msgText, String msgAlert) {
		// TODO Auto-generated method stub
		
		//Intent iii= new Intent(context, Stop.class);
		//iii.putExtra("args",news );
		
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,AutomatorNew.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.td)
		.setContentTitle(msg)
		.setContentText(msgText)
		.setTicker(msgAlert);
		
		mBuilder.setContentIntent(notifIntent);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		NotificationManager mNot= (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNot.notify(1, mBuilder.build());
		
		
		
	}

}
