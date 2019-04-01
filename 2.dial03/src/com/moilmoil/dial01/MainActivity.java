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
//��ť�ǳ��������� ���������ַ���дbutton�ĵ���¼�
public class MainActivity extends Activity implements OnClickListener {

	// ��Ա���� ctrl+1��ݼ�
	private EditText etinphone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����һ������
		setContentView(R.layout.activity_main);

		// [1]�ҵ����ǹ��ĵİ�ť
		Button btn_call1 = (Button) findViewById(R.id.btndial);
		Button btn_call2 = (Button) findViewById(R.id.btndial2);
		Button btn_call3 = (Button) findViewById(R.id.btndial3);
		// [2]�ҵ����ǹ��ĵĿռ�
		etinphone = (EditText) findViewById(R.id.etinphone);

		// [3] ��button��ť ���õ�3�ֵ���¼� ����
		btn_call1.setOnClickListener(this);
		btn_call2.setOnClickListener(this);
		btn_call3.setOnClickListener(this);
	}

	// �Լ�����һ����ȥʵ�ַ�����Ҫ�Ĳ�������
	// ����һ����ȥʵ�ְ�ť��Ҫ�Ľӿ�����
	private void callPhone() {
		// [4]��ȡEditText �ı�����
		String phonenum = etinphone.getText().toString().trim();
		if ("".equals(phonenum)) {
			// context ������
			// ������ﵥ��дthis ��ʾ����MyClickListener �������������һ��Context������
			Toast.makeText(MainActivity.this, "�绰���벻��Ϊ��", Toast.LENGTH_LONG)
					.show();
			return;
		}
		// System.out.println("��ť�����"+phonenum);
		// [5]�õ�phonenum�� ���в���绰 ��ͼIntent
		Intent intent = new Intent(); // ����һ����ͼ���� �� ��һ��������ͼ
		// [5.1]���ö���
		intent.setAction(Intent.ACTION_CALL);
		// ����Ҫ��������� uri ͳһ��Դ��ʶ�� �Լ������·�� �����ʲô�ʹ���ʲô
		intent.setData(Uri.parse("tel:" + phonenum));
		// [6]������ͼ
		startActivity(intent);
	}

	// ���ҵ����ť��ʱ��ִ��
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// ����ť�����ʱ�����Ǿ���ȥ�ж������ĸ���ťִ��
		switch (v.getId()) {
		case R.id.btndial: // ��������һ����ť
			callPhone();
			break;
		case R.id.btndial2: // ��������2����ť
			callPhone();
			break;
		case R.id.btndial3: // ��������3����ť
			callPhone();
			break;

		default:
			break;
		}
	}

}
