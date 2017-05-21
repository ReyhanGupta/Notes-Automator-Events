package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class CallService extends android.app.Service{
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
		int phone=intent.getExtras().getInt("phone");
		String event=intent.getExtras().getString("desc");
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:"+phone));
	    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK );
		PendingIntent mypi= PendingIntent.getActivity(context, 0, callIntent, 0);
		Intent buttonIntent = new Intent(context, ButtonReciever.class);
		buttonIntent.putExtra("notificationId",NOTIFICATION_ID);
		PendingIntent btPendingIntent = PendingIntent.getBroadcast(context, 0, buttonIntent,0);
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,Automator.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.ic_launcher)
		.setContentTitle(type)
		.setContentText(event)
		.setContentInfo(""+phone)
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
