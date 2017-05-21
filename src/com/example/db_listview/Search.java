package com.example.db_listview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Activity {
	long  i,Row;
	 DBS myDb;
	 Cursor fret;
	String s;
	String message, note, notess;
	// String note=getIntent().getExtras().getString("two");
	// int g=getIntent().getExtras().getInt("id");
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		call();
		
		
		
		if (android.os.Build.VERSION.SDK_INT >= 11)

			
			
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.search);
		String s=getIntent().getExtras().getString("one");
		Toast.makeText(this, "done"+s, 1000);
	//	String note=getIntent().getExtras().getString("two");
	//	long i2= getIntent().getExtras().getLong("three");
		//TextView et=(TextView)findViewById(R.id.name);
		//TextView et2=(TextView)findViewById(R.id.note);
		//et.setText(s);
		//et2.setText(note);
	
		
		
		
//		myDb = new DBS(this);
//		myDb.open();
//	fret= myDb.retID(s);
		populateListViewFromDB(s);
		registerListClickCallback();
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
//	
	private void populateListViewFromDB(String s) {

		myDb = new DBS(this);
		myDb.open();
	fret= myDb.retID(s);
		
		// Allow activity to manage lifetime of the cursor.
		// DEPRECATED! Runs on the UI thread, OK for small/short queries.
		startManagingCursor(fret);
		
		// Setup mapping from cursor to view fields:
		String nam= fret.getString(1);
		long id=fret.getLong(0);
		String tti=fret.getString(3);
		
		
		
		String[] fromFieldNames = new String[]
				//{nam,tti};
				{DBS.KEY_NAME,DBS.KEY_FAVCOLOUR};
		int[] toViewIDs = new int[]
				{R.id.name,           R.id.note};
		
		
		
		// Create adapter to may columns of the DB onto elemesnt in the UI.
		SimpleCursorAdapter myCursorAdapter = 
				new SimpleCursorAdapter(
						this,		// Context
						R.layout.rel_identity,	// Row layout template
						fret,					// cursor (set of DB records to map)
						fromFieldNames,			// DB Column names
						toViewIDs				// View IDs to put information in
						);
		
		// Set the adapter for the list view
		ListView myList = (ListView) findViewById(R.id.lv11);
		myList.setAdapter(myCursorAdapter);

	}


	public void registerListClickCallback() {
		ListView myList = (ListView) findViewById(R.id.lv11);
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, 
					int position, long idInDB) {
				//Row=idInDB;
				//updateItemForId(idInDB);
				
				displayToastForId(idInDB);
				//Toast.makeText(List_MainActivity.this, ""+Row, 1000).show();
				Intent intent = new Intent(Search.this, Modify.class); 
				intent.putExtra("arg", message);
				intent.putExtra("Prim", Row);							// getText() SHOULD NOT be static!!!
				intent.putExtra("nota", notess);
				startActivity(intent);
				finish();
				//Intent i=new Intent(List_MainActivity.this, Modify.class);
				//startActivity(i);
			}

//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				
//			}
		});
	}
	
	
	public void displayToastForId(long idInDB) {
		Cursor cursor = myDb.getRow(idInDB);
		if (cursor.moveToFirst()) {
			long idDB = cursor.getLong(DBS.COL_ROWID);
			String name = cursor.getString(DBS.COL_NAME);
			int studentNum = cursor.getInt(DBS.COL_STUDENTNUM);
			String fac = cursor.getString(DBS.COL_FAVCOLOUR);
			
			message=name;
			
			String message = "ID: " + idDB + "\n" 
					+ "Name: " + name + "\n"
					+ "Std#: " + studentNum + "\n"
					+ "FavColour: " + fac;
			//Toast.makeText(List_MainActivity.this, message, Toast.LENGTH_LONG).show();
			Row=idDB;
			notess=fac;
			//message=name;
		}
		cursor.close();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		MenuInflater blow= getMenuInflater();
		blow.inflate(R.menu.menu_search, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch(item.getItemId())
		{
		
		case R.id.cancel:
			Intent i= new Intent(Search.this,Functional.class);
			startActivity(i);
			break;
			

			
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);

		
		break;

			
		}
		return false;
	}

















}
