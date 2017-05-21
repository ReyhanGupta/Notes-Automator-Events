package com.example.db_listview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends ArrayAdapter<String>
{
Context context;
String titlesN[];
String descNew[];
int imgN[];
	public CustomAdapter(Context c, String[] titles, int images[],String[] desc) {
		super(c, R.layout.rel_identity, R.id.name, titles);
		// TODO Auto-generated constructor stub
		this.context=c;
		this.imgN=images;
		this.titlesN=titles;
		this.descNew=desc;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row=inflater.inflate(R.layout.rel_identity3, parent,false);

		ImageView img=(ImageView)row.findViewById(R.id.iv);
		TextView name=(TextView)row.findViewById(R.id.name);
		TextView descN=(TextView)row.findViewById(R.id.note);
		
		img.setImageResource(imgN[position]);
		name.setText(titlesN[position]);
		descN.setText(descNew[position]);
		return row;//super.getView(position, convertView, parent);
	}
	
	
	
	
	
	
}

	/*public CustomAdapter(Context context, int resource, int textViewResourceId,
			List<Music_Select> objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		//textviewresid is the id of the tv in which data needs to be put
		//resource is the name of the resource file which defines a single row in list
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(getContext());

		View v= inflater.inflate(R.layout.rel_identity, parent, false);
		return super.getView(position, convertView, parent);
	}
	*/
	
	


/*class CustomAdapter extends ArrayAdapter<Music_Select>
{
	private final Context context;
    private final ArrayList<Music_Select> data;
    private final int textViewResourceId;
	public CustomAdapter(Context context, int textViewResourceId,
			ArrayList<Music_Select> data) {
		super(context, textViewResourceId, data);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.data = data;
	        this.textViewResourceId = textViewResourceId;
	}

	
	 @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        ViewHolder holder = null;

	        if(row == null)
	        {
	            LayoutInflater inflater = LayoutInflater.from(getContext());//((Activity)context).getLayoutInflater();
	            row = inflater.inflate(textViewResourceId, parent, false);

	            holder = new ViewHolder();
	            holder.textView1 = (TextView)row.findViewById(R.id.note);
	            holder.textView2 = (TextView)row.findViewById(R.id.name);
	            
	          //  holder.textView3 = (TextView)row.findViewById(R.id.text3);

	            row.setTag(holder);
	        }
	        else
	        {
	            holder = (ViewHolder)row.getTag();
	        }

	        Music_Select person = data.get(position);

	        holder.textView1.setText(person.getName());
	        holder.textView2.setText(person.getAddress());
	        
	       // holder.textView3.setText(person.getEtc());

	        return row;
	    }

	    static class ViewHolder
	    {
	        TextView textView1;
	        TextView textView2;
	        
	        TextView textView3;
	    }


*/


/*class CustomAdapter extends ArrayAdapter<String>{
String get[]={};
	public CustomAdapter(Context context, String[] selections, String[] info) {
		
		super(context,R.layout.rel_identity ,selections);
		get=info;
		// TODO Auto-generated constructor stub
		
		
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflaters=LayoutInflater.from(getContext());
		View custom= inflaters.inflate(R.layout.rel_identity, parent,false);
		
		String single= getItem(position);
		TextView name=(TextView)custom.findViewById(R.id.name);
		TextView note=(TextView)custom.findViewById(R.id.note);
		ImageView iv=(ImageView)custom.findViewById(R.id.iv);
		
		name.setText(single);
		note.setText(single);
		iv.setImageResource(R.drawable.exit);
		return custom;
	}*/

//}
