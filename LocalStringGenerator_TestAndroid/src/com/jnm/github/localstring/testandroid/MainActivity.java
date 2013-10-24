package com.jnm.github.localstring.testandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Strs.setCurLanguageISO(getResources().getConfiguration().locale.getLanguage());
		
		TextView tv = (TextView) findViewById(R.id.localstring);
		tv.setText(Strs.Basic.Purchase.get());
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
}
