package net.jestrab.adevcamp.activities;

import net.jestrab.adevcamp.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity
{
	public static final String EXTRA_TITLE = "title";
	
	private String mTitle;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        
        Bundle extras = getIntent().getExtras();
        handleExtras(extras, savedInstanceState);
    }
    
    
    private void handleExtras(Bundle extras, Bundle savedInstanceState)
	{
		if(extras!=null)
		{
			if(extras.containsKey(EXTRA_TITLE))
			{
				mTitle = extras.getString(EXTRA_TITLE);
				renderView(mTitle);
			}
		}
	}
    
    
    private void renderView(String title)
    {
    	TextView titleView = (TextView) findViewById(R.id.detail_title);
		titleView.setText(title);
    }
}