package net.jestrab.adevcamp.activities;

import java.util.ArrayList;

import net.jestrab.adevcamp.R;
import net.jestrab.adevcamp.adapters.MainAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        renderView();
        Log.d("ADEVCAMP", "volam onCreate()");
    }
    
    
    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("ADEVCAMP", "volam onResume()");
    }
    
    
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d("ADEVCAMP", "volam onPause()");
    }
    
    
    @Override
    public void onDestroy()
    {
        super.onPause();
        Log.d("ADEVCAMP", "volam onDestroy()");
    }
    
    
    private void renderView()
    {
    	ListView listView = (ListView) findViewById(R.id.main_listview);
    	
    	final ArrayList<String> list = new ArrayList<String>();
    	list.add("Pondeli");
    	list.add("Utery");
    	list.add("Streda");
    	list.add("Ctvrtek");
    	list.add("Patek");

		// naplneni seznamu
		if(listView.getAdapter()==null)
		{
			MainAdapter adapter = new MainAdapter(this, list);
			try
			{
				listView.setAdapter(adapter);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return;
			}
		} 
		else 
		{
			try
			{
				((MainAdapter) listView.getAdapter()).refill(list);
				BaseAdapter adapter = (BaseAdapter) listView.getAdapter();
				listView.requestLayout();
				adapter.notifyDataSetChanged();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return;
			}
		}
		
		listView.setItemsCanFocus(false);
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) 
			{
				//Toast.makeText(MainActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(MainActivity.this, DetailActivity.class);
				intent.putExtra(DetailActivity.EXTRA_TITLE, (String) list.get(position));
		        startActivity(intent);
			}
		});
    }
}