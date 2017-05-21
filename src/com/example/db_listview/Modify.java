package com.example.db_listview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.db_listview.*;
//import com.example.tts.R;
public class Modify extends Activity {
EditText et1, et2;
Button back, save, reminder, delete;
DBS myDb;
long NewRow;
String passedArg, notea;
View v;
TextToSpeech t1;


//DBS myDb=new DBS(this);
List_MainActivity methodO=new List_MainActivity();
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		call();
  
		
		 
		
		if (android.os.Build.VERSION.SDK_INT >= 11)

		
			
			getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.intent_final);
		String passedArg = getIntent().getExtras().getString("arg");
		String notea= getIntent().getExtras().getString("nota");
		long row=getIntent().getExtras().getLong("Prim");
		NewRow=row;
		et1=(EditText)findViewById(R.id.etEm2);
		et1.setText(passedArg);
		et2= (EditText)findViewById(R.id.editText2);
		et2.setText(notea);
		//Toast.makeText(this, passedArg+""+row, 1000).show();
		
		
		 t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	         @Override
	         public void onInit(int status) {
	            if(status != TextToSpeech.ERROR) {
	               t1.setLanguage(Locale.UK);
	            }
	         }
	      });

		
		
		
		
//		back=(Button)findViewById(R.id.back);
//		back.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent i= new Intent(Modify.this, Functional.class);
//				startActivity(i);
//				finish();
//				//DBS myh;
//				
//			}
//		});
		//delete=(Button)findViewById(R.id.delete);
		//delete.setOnClickListener(new OnClickListener() {
			
		//	@Override
			//public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			//	=new DBS(this);myDb.deleteRow(NewRow);
				//Toast.makeText(Modify.this, "Done deletion", 1000).show();	
		//	}
		//});
		
		
		//save=(Button)findViewById(R.id.save);
		//save.setOnClickListener(new OnClickListener() {
		//	
		
			
			//@Override
		//	public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
		//	}
	//	});
		
		
	}
	
	public void read(View v)
	{
		et2= (EditText)findViewById(R.id.editText2);
		String note=et2.getText().toString();

        t1.speak(note, TextToSpeech.QUEUE_FLUSH, null);

	}
	
	
	public void export(View v)
	{
		AlertDialog.Builder abs= new AlertDialog.Builder(Modify.this);
		abs.setMessage("Continue?").setCancelable(false)
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				try {
					
					et1=(EditText)findViewById(R.id.etEm2);
					et2= (EditText)findViewById(R.id.editText2);

					String title=et1.getText().toString();
					String note=et2.getText().toString();
					
		            //File myFile = new File("/sdcard/mysdfile.txt");
		            
		            File myFile = new File("/sdcard/"+title+".txt");

		            myFile.createNewFile();
		            FileOutputStream fOut = new FileOutputStream(myFile);
		            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
		            myOutWriter.append(title+"\n"+"\n"+note);
		            myOutWriter.close();
		            fOut.close();
		            Toast.makeText(getBaseContext(),"Exported to SD card: "+title+".txt",Toast.LENGTH_SHORT).show();
		        } 
				catch (Exception e) {
		            Toast.makeText(getBaseContext(), e.getMessage(),
		                    Toast.LENGTH_SHORT).show();
		        }
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		AlertDialog alert= abs.create();
		alert.setTitle("Export To SD Card");
		alert.show();
		
		
		
		
		/*try {
			
			et1=(EditText)findViewById(R.id.etEm2);
			et2= (EditText)findViewById(R.id.editText2);

			String title=et1.getText().toString();
			String note=et2.getText().toString();
			
            //File myFile = new File("/sdcard/mysdfile.txt");
            
            File myFile = new File("/sdcard/"+title+".txt");

            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = 
                                    new OutputStreamWriter(fOut);
            

            myOutWriter.append(title+"\n"+"\n"+note);
            myOutWriter.close();
            fOut.close();
            Toast.makeText(getBaseContext(),"Exported to SD card: "+title+".txt",Toast.LENGTH_SHORT).show();
        } 
		
		catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }*/
	}
	
	public void shares(View v)
	{
		share();
	}
	
	private void call() {
		// TODO Auto-generated method stub
		SharedPreferences getPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getPref.getBoolean("check", false); //if nothing has been set yet, set default value as true
		if(music==true)
			{requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			}
		else
			Toast.makeText(this, "false", 1000);
	}

	
	public void delete(View v)
	{
		
		AlertDialog.Builder abs= new AlertDialog.Builder(Modify.this);
		
		abs.setMessage("Delete Now?").setCancelable(false)
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(this, "about to delete"+NewRow, 1000).show();
		myDb=new DBS(Modify.this);
		//methodO.openDB();
		//myDb.deleteAll();
		myDb.open();
		//populateListViewFromDB();
		myDb.deleteRow(NewRow);
		//Toast.makeText(this, "Done deletion", 1000).show();
		
		Intent ii=new Intent(Modify.this, Functional.class);
		startActivity(ii);
		finish();
				
			}
		})
		
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				dialog.cancel();
			}
		});
		AlertDialog alert= abs.create();
		alert.setTitle("Done With The Task?");
		alert.show();
		
		
		
		//
	
		
	}
	
	public void share()
	{
		et1=(EditText)findViewById(R.id.etEm2);
		et2= (EditText)findViewById(R.id.editText2);
		
		String title= et1.getText().toString();
		String note=et2.getText().toString();
		
		String finals= title.toUpperCase()+"\n \n"+note;
		
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
		sharingIntent.setType("text/plain");
		
		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, finals);
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, finals);
		
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
	}
	
	public void deleteNow()
	{
		
		AlertDialog.Builder abs= new AlertDialog.Builder(Modify.this);
		
		abs.setMessage("Delete").setCancelable(false)
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(this, "about to delete"+NewRow, 1000).show();
		myDb=new DBS(Modify.this);
		//methodO.openDB();
		//myDb.deleteAll();
		myDb.open();
		//populateListViewFromDB();
		myDb.deleteRow(NewRow);
		//Toast.makeText(this, "Done deletion", 1000).show();
		
		Intent ii=new Intent(Modify.this, Functional.class);
		startActivity(ii);
		finish();
				
			}
		})
		
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				dialog.cancel();
			}
		});
		AlertDialog alert= abs.create();
		alert.setTitle("Delete The Task?");
		alert.show();
		
		
		
		//
	
		
	}
	
	
	
	
	
	
	public void save()
	{
		AlertDialog.Builder abss= new AlertDialog.Builder(Modify.this);
		abss.setMessage("Update And Save New Task?").setCancelable(false)
		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {	
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				myDb=new DBS(Modify.this);
				myDb.open();
				String infoo=et1.getText().toString();
				String newNote= et2.getText().toString();
				myDb.updateRow(NewRow, infoo, 11, newNote);
				et1.setText(infoo);
				Intent iii=new Intent(Modify.this, Functional.class);
				startActivity(iii);
				finish();
				}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent iii=new Intent(Modify.this, List_MainActivity.class);
				startActivity(iii);
				finish();
			}
		});
		AlertDialog alert= abss.create();
		alert.setTitle("Save?");
		alert.show();
		
		
		
		
	}
	public void reminder()
	{
		//Toast.makeText(this, "Dysfunctional Right Now", 1000).show();
		String passedArg = getIntent().getExtras().getString("arg");
		long row=getIntent().getExtras().getLong("Prim");
		Intent iq= new Intent(Modify.this, Remind.class);
		iq.putExtra("arg", passedArg);
		iq.putExtra("Prim", row);
		startActivity(iq);
		
		finish();
	}

	private void populateListViewFromDB() {
		// TODO Auto-generated method stub
Cursor cursor = myDb.getAllRows();
		
		// Allow activity to manage lifetime of the cursor.
		// DEPRECATED! Runs on the UI thread, OK for small/short queries.
		startManagingCursor(cursor);
		
		// Setup mapping from cursor to view fields:
		String[] fromFieldNames = new String[] 
				{DBS.KEY_NAME};//, DBS.KEY_STUDENTNUM, DBS.KEY_FAVCOLOUR, DBS.KEY_STUDENTNUM};
		int[] toViewIDs = new int[]
				{R.id.name};//,     R.id.iv,           R.id.colour,     R.id.no};
		
		// Create adapter to may columns of the DB onto elemesnt in the UI.
		SimpleCursorAdapter myCursorAdapter = 
				new SimpleCursorAdapter(
						this,		// Context
						R.layout.rel_identity,	// Row layout template
						cursor,					// cursor (set of DB records to map)
						fromFieldNames,			// DB Column names
						toViewIDs				// View IDs to put information in
						);
		
		// Set the adapter for the list view
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setAdapter(myCursorAdapter);
	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blow= getMenuInflater();
		blow.inflate(R.menu.menu_modify, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		case R.id.done:
			save();
			break;
		
		
//			
		case R.id.remind:
			reminder();
//			
			break;
			
		case R.id.delete:
			
			deleteNow();
			break;
			
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);

		
		break;
		
			
		//case R.id.share:
		//	share();
		//	break;
			
		}
		return false;
	}
	
	

}
