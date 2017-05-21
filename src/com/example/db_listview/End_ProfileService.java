package com.example.db_listview;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.widget.Toast;

public class End_ProfileService extends android.app.Service{
	WifiManager wifi;
	Context context;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		
		boolean wif= intent.getExtras().getBoolean("wif");
		boolean bluet= intent.getExtras().getBoolean("bluet");
		boolean mob= intent.getExtras().getBoolean("mob");

		if(wif==true)
		{
		wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(false);
		}
		
		if(bluet==true)
		{
			
			BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();    
			if (mBluetoothAdapter.isEnabled()) {
			    mBluetoothAdapter.disable(); 
			}
		}
		
		if(mob==true)
		{
			
			
			try{			
				
				boolean ena = false;

			 final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			    final Class conmanClass = Class.forName(conman.getClass().getName());
			    final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
			    iConnectivityManagerField.setAccessible(true);
			    final Object iConnectivityManager = iConnectivityManagerField.get(conman);
			    final Class iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
			    final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
			    setMobileDataEnabledMethod.setAccessible(true);

			    setMobileDataEnabledMethod.invoke(iConnectivityManager, ena);
			    
			}
			
			catch(Exception e)
			{
				
			}
			}
		
		
		
		
		
        return START_NOT_STICKY;
    }


}
