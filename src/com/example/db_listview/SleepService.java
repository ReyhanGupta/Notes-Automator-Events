package com.example.db_listview;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class SleepService extends Service{
	
	MediaPlayer player;
	Context context=this;
	final int  NOTIFICATION_ID = 1;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Toast.makeText(this, "My Service Created", 2000).show();
		
		
		player=MediaPlayer.create(this, R.raw.relax);
		player.setLooping(true);
		player.start();
	}


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Toast.makeText(this, "My Service Stopped", 2000);
		player.stop();
	}
	
	public void pause()
	{
		player.pause();
	}


	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		
		Toast.makeText(this, "My Service Started", 2000);
		player.start();
	}


	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		
		Intent buttonIntent = new Intent(context, ButtonReciever.class);
		buttonIntent.putExtra("notificationId",NOTIFICATION_ID);
		PendingIntent btPendingIntent = PendingIntent.getBroadcast(context, 0, buttonIntent,0);
		
		
		Intent intent2= new Intent(context, TestNew.class);
		intent2.putExtra("sleep", "sleep");
		PendingIntent pi2= PendingIntent.getActivity(context, 0, intent2, 0);
		
		Intent intent3= new Intent(context, TestNews.class);
		intent2.putExtra("sleep", "sleep");

		PendingIntent mypi= PendingIntent.getActivity(context, 0, intent3, 0);
		
		PendingIntent notifIntent= PendingIntent.getActivity(context, 0,new Intent(context,TimerTasks.class), 0);
		NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.sleepingsmall)
		.setContentTitle("Sleep & Relaxation")
		.setContentText("Automated Music Playback Started")
		//.setContentInfo(desc)
		.setTicker("Sleep & Relaxation Music")
		
		.addAction(R.drawable.play,"Play", mypi)
		.addAction(R.drawable.pause, "Pause", pi2);
		//.addAction(R.drawable.close, "", btPendingIntent);
		
		mBuilder.setContentIntent(notifIntent);
		//mBuilder.setOngoing(true);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(false);
		
		NotificationManager mNot= (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNot.notify(1, mBuilder.build());
		
        return START_NOT_STICKY;
    }
	
	/*public class MyBinder extends Binder {
		 MeditationService getService() {
		 return MeditationService.this;
		 }
	}*/

}
