package com.exa.learn_eventbus_0820;

import com.ypy.eventbus.EventBus;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	public TextView tv_one = null;
	public Button btn_one =null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv_one = (TextView) findViewById(R.id.tv_one);
        btn_one = (Button) findViewById(R.id.btn_one);
        
        EventBus.getDefault().register(this); // ×¢²áeventbus
        
        btn_one.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				myIntent.setClass(MainActivity.this, Second.class);
				startActivity(myIntent);
			}
		});
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	EventBus.getDefault().unregister(this);//·´×¢²áeventbus
    }
    
    public void onEventMainThread(FirstEvent event){
    	String str = event.getMsg();
    	tv_one.setText(str);
    	Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }
    
}
