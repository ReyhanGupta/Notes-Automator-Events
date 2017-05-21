package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class NotService extends android.app.Service{
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
		String name=intent.getExtras().getString("name");
		String desc=intent.getExtras().getString("desc");
		
		Intent m= new Intent(context, TimerTasks.class);
		PendingIntent mypi=PendingIntent.getActivity(context, 0, m, 0);
		
		Intent buttonIntent = new Intent(context, ButtonReciever.class);
		buttonIntent.putExtra("notificationId",NOTIFICATION_ID);
		PendingIntent btPendingIntent = PendingIntent.getBroadcast(context, 0, buttonIntent,0);
		
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,TimerTasks.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.notify)
		.setContentTitle(type)
		.setContentText(name)
		.setContentInfo(desc)
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



