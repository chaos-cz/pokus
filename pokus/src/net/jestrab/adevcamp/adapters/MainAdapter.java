package net.jestrab.adevcamp.adapters;

import java.util.ArrayList;

import net.jestrab.adevcamp.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MainAdapter extends BaseAdapter
{
	private Context mContext;
	private ArrayList<String> mList;
	

    public MainAdapter(Context context, ArrayList<String> list)
    {
    	mContext = context;
        mList = list;
    }
    
    
    
    public View getView(int position, View convertView, ViewGroup parent)
    {
		View view = convertView;
		if (view == null) 
		{
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.main_listview_item, null);			
		}

		String str = (String) mList.get(position);
		
		TextView titleView = (TextView) view.findViewById(R.id.main_listview_item_title);
		titleView.setText(str);
		
		return view;
    }
    
    
	
	public int getCount() 
	{
		if(mList!=null) return mList.size();
		else return 0;
	}


	
	public Object getItem(int position) 
	{
		if(mList!=null) return mList.get(position);
		else return null;
	}


	
	public long getItemId(int position)
	{
		return position;
	}
	
	
	public void refill(ArrayList<String> list)
	{
		mList.clear();
		mList.addAll(list);
	    notifyDataSetChanged();
	}
}
