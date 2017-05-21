package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class Alarm_Rec extends BroadcastReceiver{
	// String news;
	@Override
	public void onReceive(Context context, Intent intent) {
		String passedArg=intent.getExtras().getString("arg");
		Intent iii= new Intent(context, Stop.class);
		createNotification(context, "Did You Complete The Task?", passedArg, "ToDo Task Alarm");
		String get=intent.getExtras().getString("extra");
		Intent ii= new Intent(context, RingtonePlayingService.class);
		ii.putExtra("extra", get);
		context.startService(ii);
	}
	private void createNotification(Context context, String msg,
		String msgText, String msgAlert) {
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,Stop.class), 0);
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
