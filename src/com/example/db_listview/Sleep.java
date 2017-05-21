package com.example.db_listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Sleep extends Activity{
	
	AudioManager audioManager;

	TextView mains;
	ImageView mainsIV;
	SeekBar sb;
	//TextView start,end;
	MediaPlayer mp;
	View v;
	MeditationService obj;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.song_player);
			mains=(TextView)findViewById(R.id.Main);
			mainsIV=(ImageView)findViewById(R.id.MainIV);
			 
			mains.setText("Sleep & Relaxation");
			mainsIV.setImageResource(R.drawable.maxresdefault);
			sb=(SeekBar)findViewById(R.id.seekBar1);
		
			
			  initControls();
				
				



		}
		
		
		public void reduce(View v)
		{
			AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
		int newVol= currentVolume -1;
		audio.setStreamVolume(AudioManager.STREAM_MUSIC, newVol, 0);


		 sb.setProgress(audioManager
	             .getStreamVolume(AudioManager.STREAM_MUSIC));   

		}
		
		public void increase(View v)
		{
			
			AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
			int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
			int newVol= currentVolume +1;
			audio.setStreamVolume(AudioManager.STREAM_MUSIC, newVol, 0);

			 sb.setProgress(audioManager
	                 .getStreamVolume(AudioManager.STREAM_MUSIC));   
			
		}
		
		 private void initControls()
		    {
		        try
		        {
		            sb = (SeekBar)findViewById(R.id.seekBar1);
		            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		            sb.setMax(audioManager
		                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		            sb.setProgress(audioManager
		                    .getStreamVolume(AudioManager.STREAM_MUSIC));   


		            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
						@Override
						public void onStopTrackingTouch(SeekBar arg0)
						
						{
						
						}
						
						@Override
						public void onStartTrackingTouch(SeekBar arg0)
						{
							
						}
						
						@Override
						public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
							//start.setText(""+sb.getProgress());

							 audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
									 arg1, 0);
						}
					});
		        }
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		        
		    }
		
		
		
	/*	
		//@Override
		//public ServiceConnection myConnection = new ServiceConnection() {
		 public void onServiceConnected(ComponentName name, IBinder service) {
		 MyBinder myBinder = (MyBinder) service;
		 obj = myBinder.getService();
		// mServiceBound = true;
		 }*/
		
		public void play(View v)
		{
			startService(new Intent(Sleep.this, SleepService.class));

		}
		
		public void pause(View v)
		{
			stopService(new Intent(Sleep.this, SleepService.class));

		}
		
		public void ffwd(View v)
		{
			//MeditationService obj= new MeditationService();
			//obj.player.pause();
			//mp.pause();
		}
		
		public void automate(View v)
		{
			Intent i= new Intent(Sleep.this,Meditation_AutomatorNew.class);
			startActivity(i);
		}
		
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			 super.onCreateOptionsMenu(menu);
			MenuInflater blow= getMenuInflater();
			blow.inflate(R.menu.menu_song, menu);
			return true;
		}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			
			switch(item.getItemId())
			{
			
			
			case R.id.Settings:
				automate(v);
//				
				break;
				

		//	case android.R.id.home:
			//	NavUtils.navigateUpFromSameTask(this);

			
			//break;

			}
			return false;
		}

}
