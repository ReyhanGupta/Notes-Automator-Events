package com.example.db_listview;

//import com.example.database.DB_Helper;

//import com.example.database.DB_Helper;
//import com.example.database.R;

//import com.example.database.DB_Helper;

//import com.example.database.DB_Helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class TimerTasks extends Activity{
	DB_Helper db_helper_object;
	final Context context=this;
	int cid, phone;
	int newsPhone;
	String one, type, pic, radio, radVal, repeat, two, three, names, namesCR, repeatN;
	boolean on,tw,th,fo,fi,si;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_pick_old);
		DB_Helper db_helper_object= new DB_Helper(this);

		
		populateListViewFromDB();
		registerListClickCallback();
	}
	
	
	public void populateListViewFromDB() {

		DB_Helper db_helper_object= new DB_Helper(this);
		
		
		

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.PICTURE,DB_Helper.ONE, DB_Helper.PHONE_NO,
				DB_Helper.RADIO,DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
		//StringBuffer sb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

			
			cid= cursor.getInt(index_UID);
			type=cursor.getString(index_Type);
			pic=cursor.getString(index_Pic);
			one=cursor.getString(index_One);
			phone=cursor.getInt(index_Phone);
			radio=cursor.getString(index_Radio);
			radVal=cursor.getString(index_RadVal);
			repeat=cursor.getString(index_Repeat);

			int picid=Integer.parseInt(pic);
			//sb.append(" "+cid+" "+names+" "+adds+"\n");
			String[] fromFieldNames = new String[] 
					{DB_Helper.TYPE, DB_Helper.PHONE_NO, DB_Helper.ONE,DB_Helper.RADIO,DB_Helper.RADIO_VALUE,
					DB_Helper.REPEAT,DB_Helper.PICTURE};
			int[] toViewIDs = new int[]
					{R.id.type,R.id.phone, R.id.event,R.id.date,R.id.time,R.id.repeat,R.id.imageEvent};
			
			// ++++++Start
			
			// Create adapter to may columns of the DB onto elemesnt in the UI.
			SimpleCursorAdapter myCursorAdapter = 
					new SimpleCursorAdapter(
							this,		// Context
							R.layout.event_rel,	// Row layout template
							cursor,					// cursor (set of DB records to map)
							fromFieldNames,			// DB Column names
							toViewIDs				// View IDs to put information in
							);
//			
//			// Set the adapter for the list view 
			ListView myList = (ListView) findViewById(R.id.listView1);
			//Toast.makeText(this, ""+myCursorAdapter.toString(), 100000).show();
			myList.setAdapter(myCursorAdapter);
		}
		
		//String prints=sb.toString();
		//Toast.makeText(this, prints, 5000).show();
		
		
		
	}

	
	
	
	public void registerListClickCallback() {
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked, 
					int position, long idInDB) {
				
				
				Toast.makeText(TimerTasks.this, ""+idInDB, 1000).show();
				//displayToastForId(idInDB);
				search(idInDB);
				//Toast.makeText(List_MainActivity.this, ""+Row, 1000).show();
	/////			Intent intent = new Intent(TimerTasks.this, News.class); 
			//	intent.putExtra("arg", message);
			//	intent.putExtra("Prim", Row);							// getText() SHOULD NOT be static!!!
				//intent.putExtra("nota", notess);
	//////			startActivity(intent);
		//done at 11 11		finish();
				//Intent i=new Intent(List_MainActivity.this, Modify.class);
				//startActivity(i);
			}
		});
		
		
		
		myList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				Toast.makeText(TimerTasks.this, ""+arg3, 1000).show();
				
				return true;
			}
		});
		
		
		
		
	}
	
	/*public void displayToastForId(long idInDB) {
		
		
	
		Cursor cursor = db_helper_object.getRow(idInDB);
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
	}*/
	
	
	
	public void search(long id)
	{
		
		DB_Helper db_helper_object= new DB_Helper(this);

		String columns[]= {DB_Helper.UID, DB_Helper.TYPE, DB_Helper.ONE, DB_Helper.TWO, 
				DB_Helper.THREE, DB_Helper.PHONE_NO, DB_Helper.RADIO, DB_Helper.RADIO_VALUE,DB_Helper.REPEAT};
		
		SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
		
		
		Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, DB_Helper.UID + " = "+id+"", null, null, null, null); 

		StringBuffer sbb=new StringBuffer();
		while(cursor.moveToNext()==true)
		{
			
			int index_UID= cursor.getColumnIndex(DB_Helper.UID);
			int index_Type= cursor.getColumnIndex(DB_Helper.TYPE);
			//int index_Pic=cursor.getColumnIndex(DB_Helper.PICTURE);
			int index_One=cursor.getColumnIndex(DB_Helper.ONE);
			int index_Two=cursor.getColumnIndex(DB_Helper.TWO);

			int index_Three=cursor.getColumnIndex(DB_Helper.THREE);

			int index_Phone=cursor.getColumnIndex(DB_Helper.PHONE_NO);
			int index_Radio=cursor.getColumnIndex(DB_Helper.RADIO);
			int index_RadVal=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
			int index_Repeat=cursor.getColumnIndex(DB_Helper.REPEAT);

			
			cid= cursor.getInt(index_UID);
			type=cursor.getString(index_Type);
			//pic=cursor.getString(index_Pic);
			one=cursor.getString(index_One);			
			two=cursor.getString(index_Two);
			three=cursor.getString(index_Three);

			newsPhone=cursor.getInt(index_Phone);
			radio=cursor.getString(index_Radio);
			radVal=cursor.getString(index_RadVal);
			repeat=cursor.getString(index_Repeat);
		
			
			
			//sbb.append("\n"+cid+"\n"+type+"\n"+one+"\n"+two+"\n"+three+"\n"+phone+"\n"+radio+"\n"+radVal+"\n"+repeat+"\n");

		}
		
		String printss=sbb.toString();
		Toast.makeText(this, printss, 5000).show();
		
		if(type.equals("sms"))
		{
			//Toast.makeText(this, "phone: "+phone, 1000).show();

			Intent next= new Intent(TimerTasks.this, ModifyEvent.class);
			next.putExtra("uid", cid);
			next.putExtra("type", type);
			next.putExtra("one", one);
			next.putExtra("phonesss", newsPhone);
			next.putExtra("radio", radio);
			next.putExtra("radVal", radVal);
			next.putExtra("repeat", repeat);
			
			
			final Dialog dialogs = new Dialog(context);
			dialogs.setContentView(R.layout.sms_modify);
			dialogs.setTitle("Options");
			
			
			final TextView edits = (TextView) dialogs.findViewById(R.id.textView1);
			edits.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					final Dialog dialogED = new Dialog(context);
					dialogED.setContentView(R.layout.edit_choices);
					dialogED.setTitle("Edit");
					
					
					///////////////////////////
					final TextView crf = (TextView) dialogED.findViewById(R.id.tv55);
					crf.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							final Dialog dialogRpt = new Dialog(context);
							dialogRpt.setContentView(R.layout.rpt_events);
							dialogRpt.setTitle("Change Repetition Frequency");
							
							
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							String columns[]= {DB_Helper.REPEAT};
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							String where= DB_Helper.UID +" = " + cid;
							Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
							
							final RadioGroup	rg=(RadioGroup)dialogRpt.findViewById(R.id.rgRpt);
							
							RadioButton	onee=(RadioButton)dialogRpt.findViewById(R.id.one);
							RadioButton	twoo=(RadioButton)dialogRpt.findViewById(R.id.two);
							RadioButton	threee=(RadioButton)dialogRpt.findViewById(R.id.three);
							RadioButton	four=(RadioButton)dialogRpt.findViewById(R.id.four);
							RadioButton	five=(RadioButton)dialogRpt.findViewById(R.id.five);
							RadioButton	six=(RadioButton)dialogRpt.findViewById(R.id.six);
							
							
							
							while(cursor.moveToNext()==true)
							{
								//At the current row, get all details:
								
								int index_Rpt=cursor.getColumnIndex(DB_Helper.REPEAT);
								String repeat=cursor.getString(index_Rpt);
								//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
								
								
								if(repeat.equals("on"))
								{
									
								}
								else if(repeat.equals("tw"))
								{
									twoo.setChecked(true);
								}
								else if(repeat.equals("th"))
								{
									threee.setChecked(true);

								}
								else if(repeat.equals("fo"))
								{
									four.setChecked(true);

								}
								else if(repeat.equals("fi"))
								{
									five.setChecked(true);

								}
								else if(repeat.equals("si"))
								{
									six.setChecked(true);

								}

							}
							
							
							
							Button bSave=(Button)dialogRpt.findViewById(R.id.saveFN);
							bSave.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									
									
									String whereS=DB_Helper.UID + " = "	+cid;		
									DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
									SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
									
									
									
									
									
									  int selectedId = rg.getCheckedRadioButtonId();
						                
						                switch(selectedId)
						                {
						                case R.id.one:
						                	on=true;    
						                	repeatN="on";
						                	//repeatNew("on");
											break;
						                case R.id.two:
						                	tw=true;    
						                	repeatN="tw";
						                	//repeatNew("tw");


						                	break;
						                case R.id.three:
						                	th=true;    
						                	repeatN="th";
						                	//repeatNew("th");


						    				break;
						                case R.id.four:
						                	fo=true;    
						                	repeatN="fo";
						                	//repeatNew("fo");


						    				break;
						                case R.id.five:
						                	fi=true;  
						                	repeatN="fi";
						                	//repeatNew("fi");
//

						    				break;
						                case R.id.six:
						                	si=true; 
						                	repeatN="si";
						                //	repeatNew("si");


						    				break;

						                }
											  
									
				
														
									ContentValues content= new ContentValues();
									content.put(DB_Helper.REPEAT, repeatN);
									sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
									dialogRpt.dismiss();
									populateListViewFromDB();
									
									Intent intent = getIntent();
								    finish();
								    startActivity(intent);

								}
							});
							
							
							
							
							dialogRpt.show();
						}
					});
					
					
					
					////////////////////////////
					
					final TextView ct = (TextView) dialogED.findViewById(R.id.tv44);
					ct.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							final Dialog dialogTim = new Dialog(context);
							dialogTim.setContentView(R.layout.edit_dialog);
							dialogTim.setTitle("Change Event Time");
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							String columns[]= {DB_Helper.RADIO_VALUE};
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							String where= DB_Helper.UID +" = " + cid;
							Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
							while(cursor.moveToNext()==true)
							{
								//At the current row, get all details:
								
								int index_Tim=cursor.getColumnIndex(DB_Helper.RADIO_VALUE);
								String time=cursor.getString(index_Tim);
								//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
								TextView old=(TextView)dialogTim.findViewById(R.id.old);
								old.setText(time);
								

							}
							
							Button bSave=(Button)dialogTim.findViewById(R.id.bsaveED);
							bSave.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									EditText not=(EditText)dialogTim.findViewById(R.id.newss);
									String noted= not.getText().toString();
									
									String whereS=DB_Helper.UID + " = "	+cid;		
									DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
									SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
									
														
									ContentValues content= new ContentValues();
									content.put(DB_Helper.RADIO_VALUE, noted);
									sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
									dialogTim.dismiss();
									populateListViewFromDB();
									
									Intent intent = getIntent();
								    finish();
								    startActivity(intent);

								}
							});
							
							
							
							
							dialogTim.show();
							
						}
					});

					
					
					/////////////////////////////
					
					final TextView cd = (TextView) dialogED.findViewById(R.id.tv33);
					cd.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							
							final Dialog dialogDat = new Dialog(context);
							dialogDat.setContentView(R.layout.edit_dialog);
							dialogDat.setTitle("Change Event Date");
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							String columns[]= {DB_Helper.RADIO};
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							String where= DB_Helper.UID +" = " + cid;
							
							Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
							while(cursor.moveToNext()==true)
							{
								//At the current row, get all details:
								
								int index_Dat=cursor.getColumnIndex(DB_Helper.RADIO);
								String date=cursor.getString(index_Dat);
								//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
								TextView old=(TextView)dialogDat.findViewById(R.id.old);
								old.setText(date);
								

							}
							
							
							Button bSave=(Button)dialogDat.findViewById(R.id.bsaveED);
							bSave.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									EditText not=(EditText)dialogDat.findViewById(R.id.newss);
									String noted= not.getText().toString();
									
									String whereS=DB_Helper.UID + " = "	+cid;		
									DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
									SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
									
														
									ContentValues content= new ContentValues();
									content.put(DB_Helper.RADIO, noted);
									sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
									dialogDat.dismiss();
									populateListViewFromDB();
									
									Intent intent = getIntent();
								    finish();
								    startActivity(intent);

								}
							});
							
							
							
							
							
							dialogDat.show();
						}
					});


					
					/////////////////////////////
					
					final TextView ced = (TextView) dialogED.findViewById(R.id.tv22);
					ced.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							
							final Dialog dialogEve = new Dialog(context);
							dialogEve.setContentView(R.layout.edit_dialog);
							dialogEve.setTitle("Change Event Description");
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							String columns[]= {DB_Helper.ONE};
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							String where= DB_Helper.UID +" = " + cid;
							
							Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
							
							while(cursor.moveToNext()==true)
							{
								//At the current row, get all details:
								
								int index_Desc=cursor.getColumnIndex(DB_Helper.ONE);
								String desc=cursor.getString(index_Desc);
								//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
								TextView old=(TextView)dialogEve.findViewById(R.id.old);
								old.setText(desc);
								

							}
							Button bSave=(Button)dialogEve.findViewById(R.id.bsaveED);
							bSave.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									EditText not=(EditText)dialogEve.findViewById(R.id.newss);
									String noted= not.getText().toString();
									
									String whereS=DB_Helper.UID + " = "	+cid;		
									DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
									SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
									
														
									ContentValues content= new ContentValues();
									content.put(DB_Helper.ONE, noted);
									sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
									dialogEve.dismiss();
									populateListViewFromDB();
									
									Intent intent = getIntent();
								    finish();
								    startActivity(intent);

								}
							});
							
							
							
							dialogEve.show();
						}
					});

					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					///////////////////////////
					
					
					final TextView cpn = (TextView) dialogED.findViewById(R.id.tv11);
					cpn.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							final Dialog dialogPN = new Dialog(context);
							dialogPN.setContentView(R.layout.edit_dialog);
							dialogPN.setTitle("Change Phone Number");
							
							
							
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							String columns[]= {DB_Helper.PHONE_NO};
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							String where= DB_Helper.UID +" = " + cid;
							
							Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
							while(cursor.moveToNext()==true)
							{
								//At the current row, get all details:
								
								int index_Pho=cursor.getColumnIndex(DB_Helper.PHONE_NO);
								String phonesa=cursor.getString(index_Pho);
								//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
								TextView old=(TextView)dialogPN.findViewById(R.id.old);
								old.setText(phonesa);
								
								
								Button bSave=(Button)dialogPN.findViewById(R.id.bsaveED);
								bSave.setOnClickListener(new OnClickListener() {
									
									@Override
									public void onClick(View arg0) {
										// TODO Auto-generated method stub
										EditText not=(EditText)dialogPN.findViewById(R.id.newss);
										String noted= not.getText().toString();
										int ph=Integer.parseInt(noted);
										
										
										String whereS=DB_Helper.UID + " = "	+cid;		
										DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
										SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
										
															
										ContentValues content= new ContentValues();
										content.put(DB_Helper.PHONE_NO, ph);
										sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
										dialogPN.dismiss();
										populateListViewFromDB();
										
										Intent intent = getIntent();
									    finish();
									    startActivity(intent);

									}
								});
								
								
								Button bCan=(Button)dialogPN.findViewById(R.id.bcanED);
								bCan.setOnClickListener(new OnClickListener() {
									
									@Override
									public void onClick(View arg0) {
										// TODO Auto-generated method stub
										dialogPN.cancel();
									}
								});


							}
							
							dialogPN.show();
						}
					});
					
					
					

							
						
							dialogED.show();
							
							
							
								
						}
					});

					
					
			//	}
		//	});

			
			
			final TextView msg = (TextView) dialogs.findViewById(R.id.textView2);
			msg.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					msg.setBackgroundColor(Color.parseColor("#07bd53"));

					final Dialog dialogsN = new Dialog(context);
					dialogsN.setContentView(R.layout.save_note);
					dialogsN.setTitle("Save Note");
				//	msg.setBackgroundColor(Color.WHITE);

					DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
					String columns[]= {DB_Helper.MSG};
					SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
					String where= DB_Helper.UID +" = " + cid;

					
					Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
					while(cursor.moveToNext()==true)
					{
						//At the current row, get all details:
						
						int index_Msg=cursor.getColumnIndex(DB_Helper.MSG);
						String namesCR=cursor.getString(index_Msg);
						//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
						EditText not=(EditText)dialogsN.findViewById(R.id.Notedd);
						not.setText(namesCR);


					}
					//not.setText(namesCR);
					Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();

					Button bSave=(Button)dialogsN.findViewById(R.id.saveDD);
					bSave.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							EditText not=(EditText)dialogsN.findViewById(R.id.Notedd);
							String noted= not.getText().toString();
							
							String whereS=DB_Helper.UID + " = "	+cid;		
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							
												
							ContentValues content= new ContentValues();
							content.put(DB_Helper.MSG, noted);
							sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
							dialogsN.dismiss();
							populateListViewFromDB();
							
							Intent intent = getIntent();
						    finish();
						    startActivity(intent);

						}
					});
					
					Button bCan=(Button)dialogsN.findViewById(R.id.cancelDD);
					bCan.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							dialogsN.cancel();
						}
					});

					
					

					
				
					dialogsN.show();
					
					
				}
			});

			
			final TextView find = (TextView) dialogs.findViewById(R.id.textView3);
			find.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					find.setBackgroundColor(Color.parseColor("#07bd53"));
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.openme.com/ecards"));
					startActivity(browserIntent);
					//find.setBackgroundColor(Color.WHITE);


				}
			});

			
			
			
			final TextView delete = (TextView) dialogs.findViewById(R.id.textView4);
			delete.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					delete.setBackgroundColor(Color.parseColor("#e74e46"));
					
					
					AlertDialog.Builder abs= new AlertDialog.Builder(TimerTasks.this);
					
					abs.setMessage("Sure you want to delete Event?").setCancelable(true)
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							DB_Helper db_helper_object=new DB_Helper(TimerTasks.this);
							SQLiteDatabase sqlite= db_helper_object.getWritableDatabase();
							//ModifyEvent obj=new ModifyEvent();
							//Toast.makeText(TimerTasks.this, ""+cid, 5000).show();
							String whereD= DB_Helper.UID +" = " + cid;
							sqlite.delete(DB_Helper.TABLE_NAME, whereD, null);
							
							populateListViewFromDB();
							
							Intent intent = getIntent();
						    finish();
						    startActivity(intent);
							//obj.deleteNow(cid);
							
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
					alert.setTitle("Delete Event");
					alert.show();
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					dialogs.dismiss();
					
				

				}
			});
			
			
			
			dialogs.show();
				

		}
		
		
		else if(type.equals("Notification"))
		{
			Toast.makeText(TimerTasks.this, "not", 1000).show();
			final Dialog dialogs = new Dialog(context);
			dialogs.setContentView(R.layout.sms_modify);
			dialogs.setTitle("Options");
			
			
			final TextView msgN = (TextView) dialogs.findViewById(R.id.textView2);
			msgN.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					msgN.setBackgroundColor(Color.parseColor("#07bd53"));
					final Dialog dialogsNN = new Dialog(context);
					dialogsNN.setContentView(R.layout.save_note);
					dialogsNN.setTitle("Save Note");
					DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
					//String columns[]= {DB_Helper.MSG};
					String columns[]= {DB_Helper.ONE};

					SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
					String where= DB_Helper.UID +" = " + cid;
					Cursor cursor= sqlite.query(DB_Helper.TABLE_NAME, columns, null, null, null, null, null); 
					while(cursor.moveToNext()==true)
					{
						//At the current row, get all details:
						
						int index_Msg=cursor.getColumnIndex(DB_Helper.ONE);
						String namesCR=cursor.getString(index_Msg);
						//Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();
						TextView not=(TextView)dialogsNN.findViewById(R.id.Notedd);
						not.setText(namesCR);


					}
					
					Button bSave=(Button)dialogsNN.findViewById(R.id.saveDD);
					bSave.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							EditText not=(EditText)dialogsNN.findViewById(R.id.Notedd);
							String noted= not.getText().toString();
							
							String whereS=DB_Helper.UID + " = "	+cid;		
							DB_Helper db_helper_object= new DB_Helper(TimerTasks.this);
							SQLiteDatabase sqlite=	db_helper_object.getWritableDatabase();
							
												
							ContentValues content= new ContentValues();
							content.put(DB_Helper.MSG, noted);
							sqlite.update(DB_Helper.TABLE_NAME, content, whereS, null);
							dialogsNN.dismiss();
							populateListViewFromDB();
							
							Intent intent = getIntent();
						    finish();
						    startActivity(intent);

						}
					});
					
					
					dialogsNN.show();
				}
			});

		/*			
				//	msg.setBackgroundColor(Color.WHITE);

					

					
					
					//not.setText(namesCR);
					Toast.makeText(TimerTasks.this, "Message is: "+namesCR, 1000).show();

				
					
					Button bCan=(Button)dialogsN.findViewById(R.id.cancelDD);
					bCan.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							dialogsN.cancel();
						}
					});
					dialogsN.show();
					
					
				} 
			});

		*/
			
			
			
			final TextView find = (TextView) dialogs.findViewById(R.id.textView3);
			find.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					find.setBackgroundColor(Color.parseColor("#07bd53"));
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.openme.com/ecards"));
					startActivity(browserIntent);
					//find.setBackgroundColor(Color.WHITE);


				}
			});
			
			final TextView delete = (TextView) dialogs.findViewById(R.id.textView4);
			delete.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					delete.setBackgroundColor(Color.parseColor("#e74e46"));
					
					
					AlertDialog.Builder abs= new AlertDialog.Builder(TimerTasks.this);
					
					abs.setMessage("Sure you want to delete Event?").setCancelable(true)
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							DB_Helper db_helper_object=new DB_Helper(TimerTasks.this);
							SQLiteDatabase sqlite= db_helper_object.getWritableDatabase();
							//ModifyEvent obj=new ModifyEvent();
							//Toast.makeText(TimerTasks.this, ""+cid, 5000).show();
							String whereD= DB_Helper.UID +" = " + cid;
							sqlite.delete(DB_Helper.TABLE_NAME, whereD, null);
							
							populateListViewFromDB();
							
							Intent intent = getIntent();
						    finish();
						    startActivity(intent);
							//obj.deleteNow(cid);
							
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
					alert.setTitle("Delete Event");
					alert.show();
					
					
					dialogs.dismiss();
					
				

				}
			});
			
			
			
			
			dialogs.show();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addRem(View v)
	{
		Intent i= new Intent(TimerTasks.this, AddEvent.class);
		startActivity(i);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
