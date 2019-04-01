package com.moilmoil.dial01;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

//import android.view.Menu;

public class MainActivity extends Activity {

	//成员变量  ctrl+1快捷键
	private EditText etinphone;
	private Button btndial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 加载一个布局
		setContentView(R.layout.activity_main);

		etinphone = (EditText) findViewById(R.id.etinphone);

		btndial = (Button) findViewById(R.id.btndial);

		// [3]给button按钮设置一个点击事件
		// 如果遇到一个参数是接口类型，我们有两种方法去传递参数
		// 第一种 定义一个类去实现这个接口类型
		//内部类
		btndial.setOnClickListener(new MyClickListener());
		
		
		
	}

	//自己定义一个类去实现方法需要的参数类型
	// 定义一个类去实现按钮需要的接口类型
	private class MyClickListener implements OnClickListener {
		//Called when a view has been clicked.
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//[4]获取EditText 文本内容
			String phonenum = etinphone.getText().toString().trim();
			if("".equals(phonenum)){
				//context 上下文
				//如果这里单单写this 表示的是MyClickListener  但是这个参数是一个Context上下文
				Toast.makeText(MainActivity.this, "电话号码不能为空", Toast.LENGTH_LONG).show();
				return;
			}
			//System.out.println("按钮被点击"+phonenum);
			//[5]拿到phonenum后 进行拨打电话   意图Intent
			Intent intent = new Intent();  //创建一个意图对象    打 是一个动作意图
			//[5.1]设置动作
			intent.setAction(Intent.ACTION_CALL);
			//设置要拨打的数据   uri 统一资源标识符  自己定义的路径  想代表什么就代表什么
			intent.setData(Uri.parse("tel:"+phonenum));
			//[6]开启意图
			startActivity(intent);
		}
	}

}
