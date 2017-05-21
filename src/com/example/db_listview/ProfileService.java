package com.example.db_listview;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class ProfileService extends android.app.Service {
	//boolean bluet;
	AudioManager audio;
	WifiManager wifi;
	Context context=this;
	int mode=1;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		boolean bluet= intent.getExtras().getBoolean("bluet");
		boolean wif= intent.getExtras().getBoolean("wif");
		boolean mob= intent.getExtras().getBoolean("mob");
		boolean lou= intent.getExtras().getBoolean("lou");
		boolean vib= intent.getExtras().getBoolean("vib");
		boolean sil= intent.getExtras().getBoolean("sil");
		boolean air= intent.getExtras().getBoolean("air");
		boolean gps= intent.getExtras().getBoolean("gps");
		boolean low= intent.getExtras().getBoolean("low");
		boolean med= intent.getExtras().getBoolean("med");
		boolean hig= intent.getExtras().getBoolean("hig");


		if(bluet==true)
		{
			Toast.makeText(this, "bluet is true", 1000).show();
			Intent turnOn = new Intent(ProfileService.this,Enabled.class);
			turnOn.putExtra("bluet", bluet);
		    turnOn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK );
			startActivity(turnOn);
		}
		
		if(wif==true)
		{
		wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(true);
		}
	
		if(mob==true)
		{
			try
			{
			final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final Class<?> conmanClass = Class.forName(conman.getClass().getName());
            final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
            iConnectivityManagerField.setAccessible(true);
            final Object iConnectivityManager = iConnectivityManagerField.get(conman);
            final Class<?> iConnectivityManagerClass =  Class.forName(iConnectivityManager.getClass().getName());
            final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled",    Boolean.TYPE);
            setMobileDataEnabledMethod.setAccessible(true);
            setMobileDataEnabledMethod.invoke(iConnectivityManager, true);
			}
			catch(Exception e)
			{
			}
		}
		
		
		if(lou==true)
		{
			AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
           // myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			int streamMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
		    Toast.makeText(this, Integer.toString(streamMaxVolume), Toast.LENGTH_LONG).show(); //I got 7
		    audioManager.setStreamVolume(AudioManager.STREAM_RING, streamMaxVolume, AudioManager.FLAG_ALLOW_RINGER_MODES|AudioManager.FLAG_PLAY_SOUND);
		}
		
		if(vib==true)
		{
			AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		}
		
		if(sil==true)
		{	
			AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		}
		
		if(air==true)
		{
			boolean isEnabled = Settings.System.getInt(this.getContentResolver(),
					Settings.System.AIRPLANE_MODE_ON, 0) == 1;
			if (isEnabled == false) {
				Settings.System.putInt(getContentResolver(),
						Settings.System.AIRPLANE_MODE_ON, air ? 1 : 0);// Turning ON/OFF Airplane mode.
				
				Intent intentA = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);	
				intentA.putExtra("state", !air);// indicate the "state" of airplane mode is changed to ON/OFF
				sendBroadcast(intentA);
				Toast.makeText(getApplicationContext(), "Airplane Mode ON",	Toast.LENGTH_LONG).show();
			}
		}
		
		if (gps==true)
		{
			Intent intentG=new Intent("android.location.GPS_ENABLED_CHANGE");
			intentG.putExtra("enabled", true);
			sendBroadcast(intentG);
		}
		
		if(low==true)
		{
			 // ContentResolver cResolver = this.getApplicationContext().getContentResolver();
			   // Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, 0);
			
			   Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);


		}
		
		if(med==true)
		{			
			   Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 127);

		}
		if(hig==true)
		{			
			   Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);

		}
		
	
        return START_NOT_STICKY;
    }


}
