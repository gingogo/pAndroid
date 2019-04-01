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
import com.moilmoil.dial03.R;

//import android.view.Menu;
//按钮非常多的情况下 可以用这种方法写button的点击事件
public class MainActivity extends Activity implements OnClickListener {

	// 成员变量 ctrl+1快捷键
	private EditText etinphone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 加载一个布局
		setContentView(R.layout.activity_main);

		// [1]找到我们关心的按钮
		Button btn_call1 = (Button) findViewById(R.id.btndial);
		Button btn_call2 = (Button) findViewById(R.id.btndial2);
		Button btn_call3 = (Button) findViewById(R.id.btndial3);
		// [2]找到我们关心的空间
		etinphone = (EditText) findViewById(R.id.etinphone);

		// [3] 给button按钮 设置第3种点击事件 监听
		btn_call1.setOnClickListener(this);
		btn_call2.setOnClickListener(this);
		btn_call3.setOnClickListener(this);
	}

	// 自己定义一个类去实现方法需要的参数类型
	// 定义一个类去实现按钮需要的接口类型
	private void callPhone() {
		// [4]获取EditText 文本内容
		String phonenum = etinphone.getText().toString().trim();
		if ("".equals(phonenum)) {
			// context 上下文
			// 如果这里单单写this 表示的是MyClickListener 但是这个参数是一个Context上下文
			Toast.makeText(MainActivity.this, "电话号码不能为空", Toast.LENGTH_LONG)
					.show();
			return;
		}
		// System.out.println("按钮被点击"+phonenum);
		// [5]拿到phonenum后 进行拨打电话 意图Intent
		Intent intent = new Intent(); // 创建一个意图对象 打 是一个动作意图
		// [5.1]设置动作
		intent.setAction(Intent.ACTION_CALL);
		// 设置要拨打的数据 uri 统一资源标识符 自己定义的路径 想代表什么就代表什么
		intent.setData(Uri.parse("tel:" + phonenum));
		// [6]开启意图
		startActivity(intent);
	}

	// 当我点击按钮的时候执行
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// 当按钮点击的时候，我们具体去判断下是哪个按钮执行
		switch (v.getId()) {
		case R.id.btndial: // 代表点击第一个按钮
			callPhone();
			break;
		case R.id.btndial2: // 代表点击第2个按钮
			callPhone();
			break;
		case R.id.btndial3: // 代表点击第3个按钮
			callPhone();
			break;

		default:
			break;
		}
	}

}
