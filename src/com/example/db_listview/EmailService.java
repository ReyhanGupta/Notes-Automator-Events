package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class EmailService extends android.app.Service{
	Context context=this;
	final int  NOTIFICATION_ID = 1;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		String type=intent.getExtras().getString("type");
		String email=intent.getExtras().getString("name");
		String sub=intent.getExtras().getString("desc");
		String bod=intent.getExtras().getString("bod");
		Intent emailI = new Intent(Intent.ACTION_SEND);
		emailI.putExtra(Intent.EXTRA_EMAIL, new String[]{email});		  
		emailI.putExtra(Intent.EXTRA_SUBJECT, sub);
		emailI.putExtra(Intent.EXTRA_TEXT, bod);
		emailI.setType("message/rfc822");
	    emailI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK );
	    PendingIntent mypi= PendingIntent.getActivity(context, 0, emailI, 0);
		Intent buttonIntent = new Intent(context, ButtonReciever.class);
		buttonIntent.putExtra("notificationId",NOTIFICATION_ID);
		PendingIntent btPendingIntent = PendingIntent.getBroadcast(context, 0, buttonIntent,0);
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,Automator.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle(type)
		.setContentText(sub)
		.setContentInfo(email)
		.setTicker("Event Notification")
		.addAction(R.drawable.tick,"Okay", mypi)
		.addAction(R.drawable.close, "Dismiss", btPendingIntent);
		mBuilder.setContentIntent(notifIntent);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		NotificationManager mNot= (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNot.notify(1, mBuilder.build());
        return START_NOT_STICKY;
    }

}

