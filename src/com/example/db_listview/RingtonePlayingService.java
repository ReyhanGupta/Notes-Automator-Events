package com.example.db_listview;

import java.security.Provider.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RingtonePlayingService extends android.app.Service{
	
	MediaPlayer mp;
	int startId;
	boolean isRunning;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

    

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        
        
        String state=intent.getExtras().getString("extra");
        
        assert state!=null;
        
        
        if(state.equals("alarm on"))
        {
        	startId=1;
        }
        else if(state.equals("alarm off"))
        {
        	startId=0;
        }
        else
        {
        	startId=0;
        }
        
        
        
        
        if(!this.isRunning && startId==1)
        {
        	mp=MediaPlayer.create(this, R.raw.bell);
            mp.start();
            this.isRunning=true;
            this.startId=0;
        }
        else if(this.isRunning && startId==0)
        {
        	mp.stop();
        	mp.reset();
        	this.isRunning=false;
        	this.startId=0;
        }
        else if(!this.isRunning && startId==0)
        {
        	this.isRunning=false;
        	this.startId=0;
        }
        else if(this.isRunning && startId==1)
        {
        	this.isRunning=true;
        	this.startId=1;
        }
        else
        {
        	
        }
        
        
        
        
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Cancel the persistent notification.
       // mNM.cancel(NOTIFICATION);

        // Tell the user we stopped.
    	super.onDestroy();
    	this.isRunning=false;
    	
        Toast.makeText(this, "On Destroy Called", Toast.LENGTH_SHORT).show();
    }

	
	
}
