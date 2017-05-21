package com.example.db_listview;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class News extends Activity {
	
	EditText et1, et2;
	Button back, save, reminder, delete;
	DBS myDb;
	long NewRow;
	int[] imageIDs = {R.drawable.a,R.drawable.b,R.drawable.c};
	int nextImageIndex = 0;
	View v;
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
		//	else
				
			setContentView(R.layout.news);
		//	String passedArg = getIntent().getExtras().getString("arg");
		//	long row=getIntent().getExtras().getLong("Prim");
		//	NewRow=row;
			et1=(EditText)findViewById(R.id.etEm2);
			et2=(EditText)findViewById(R.id.editText2);
		//	et1.setText(passedArg);
			//Toast.makeText(this, passedArg+""+row, 1000).show();
			
			
			
			
			
			
			
		//	back=(Button)findViewById(R.id.back);
		//	back.setOnClickListener(new OnClickListener() {
				
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					Intent i= new Intent(News.this, Functional.class);
//					startActivity(i);
//					finish();
//					//DBS myh;
//					
//				}

//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					
//				}
			//});
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
		
		public void share(View v)
		{
			et1=(EditText)findViewById(R.id.etEm2);
			et2= (EditText)findViewById(R.id.editText2);
			String title= et1.getText().toString();
			String note=et2.getText().toString();
			String finals= title.toUpperCase()+"\n \n"+note;
			Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
			sharingIntent.setType("text/plain");
			//String shareBody = "Here is the share content body";
			sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, finals);
			sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, finals);
			startActivity(Intent.createChooser(sharingIntent, "Share via"));
		}

		public void delete()
		{
			
			AlertDialog.Builder abs= new AlertDialog.Builder(News.this);
			
			abs.setMessage("Delete the Task?").setCancelable(true)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					//Toast.makeText(this, "about to delete"+NewRow, 1000).show();
			myDb=new DBS(News.this);
			//methodO.openDB();
			//myDb.deleteAll();
			myDb.open();
			//populateListViewFromDB();
			myDb.deleteRow(NewRow);
			//Toast.makeText(this, "Done deletion", 1000).show();
			
			Intent ii=new Intent(News.this, Functional.class);
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
			alert.setTitle("Confirm Delete?");
			alert.show();
			
			
			
			//
		
			
		}
		
		public void save()
		{
			int imageId = imageIDs[nextImageIndex];
			nextImageIndex = (nextImageIndex + 1) % imageIDs.length;
		
			et1=(EditText)findViewById(R.id.etEm2);
			String info=et1.getText().toString();
			
			et2=(EditText)findViewById(R.id.editText2);
			String note= et2.getText().toString();
			//Toast.makeText(this, info, Toast.LENGTH_LONG).show();
			// Add it to the DB and re-draw the ListView
			
			if(info.equals(" ") || info.equals("")|| info.equals("  ")|| info.equals("   "))
			
			{
				Toast.makeText(this, "Please enter text to save", Toast.LENGTH_LONG).show();
			}
			else
			{
				
				
				AlertDialog.Builder abs= new AlertDialog.Builder(News.this);
				
				abs.setMessage("Save?").setCancelable(true)
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						et1=(EditText)findViewById(R.id.etEm2);
						String info=et1.getText().toString();
						et2=(EditText)findViewById(R.id.editText2);
						String note= et2.getText().toString();
						int imageId = imageIDs[nextImageIndex];
						nextImageIndex = (nextImageIndex + 1) % imageIDs.length;
						myDb=new DBS(News.this);
						myDb.open();
					myDb.insertRow(info, imageId, note);
				Intent ii=new Intent(News.this, Functional.class);
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
				alert.setTitle("Save Task?");
				alert.show();
	
			
			}
			
		
			
			
		}
		
		
		public void saveNew()
		{
			et1=(EditText)findViewById(R.id.etEm2);
			String info=et1.getText().toString();
			et2=(EditText)findViewById(R.id.editText2);
			String note= et2.getText().toString();
			int imageId = imageIDs[nextImageIndex];
			nextImageIndex = (nextImageIndex + 1) % imageIDs.length;
			myDb=new DBS(News.this);
			myDb.open();
		myDb.insertRow(info, imageId, note);
		}
		public void reminder()
		{
			//Toast.makeText(this, "Dysfunctional Right Now", 1000).show();
			//String passedArg = getIntent().getExtras().getString("arg");
			//long row=getIntent().getExtras().getLong("Prim");
			
			saveNew();
			String info=et1.getText().toString();
			Intent iq= new Intent(News.this, Remind.class);
			iq.putExtra("arg", info);
		//	iq.putExtra("Prim", row);
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
							this,
		

	// Context



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
			blow.inflate(R.menu.menu_news, menu);
			return true;
		}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			
			switch(item.getItemId())
			{
			
			case R.id.cancel:
				Intent i= new Intent(News.this, Functional.class);
				startActivity(i);
				finish();
				break;
			
			case R.id.tick:
				
				save();
				break;
//				
			case R.id.remind:
				reminder();
//				
				break;
				

			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);

			
			break;

		//	case R.id.delete:
				
				//deleteNow(v);
				//break;
				
			
				
//			case R.id.exit:
//				finish();
//				break;
				
			}
			return false;
		}
		
		
		
		


}
