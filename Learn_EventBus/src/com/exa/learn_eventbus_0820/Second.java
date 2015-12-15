package com.exa.learn_eventbus_0820;

import com.ypy.eventbus.EventBus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Second extends Activity {
	public Button btn_two = null;
	public Context mContext = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondlayout);
		mContext = this;
		btn_two = (Button) findViewById(R.id.btn_two);
		btn_two.setOnClickListener(TWOLISTEN);
	}

	OnClickListener TWOLISTEN = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			Intent int_two = new Intent();
//			int_two.setClass(mContext, MainActivity.class);
//			startActivity(int_two);
			//发送消息
			EventBus.getDefault().post(new FirstEvent("第二个传递"));
		}
	};
}
