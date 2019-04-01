package com.moilmoil.dial04;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void callphone(View v){
    	EditText n = (EditText)findViewById(R.id.et_input);
    	String num = n.getText().toString().trim();
    	System.out.println(num);
    	
    	if("".equals(num)){
    		Toast.makeText(this, "²»ÄÜÎª¿Õ", Toast.LENGTH_SHORT).show();
    	}
    	
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_CALL);
    	intent.setData(Uri.parse("tel:" + num));
    	startActivity(intent);
    	
    }
}
