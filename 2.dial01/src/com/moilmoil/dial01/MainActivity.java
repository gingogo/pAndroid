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

	//��Ա����  ctrl+1��ݼ�
	private EditText etinphone;
	private Button btndial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����һ������
		setContentView(R.layout.activity_main);

		etinphone = (EditText) findViewById(R.id.etinphone);

		btndial = (Button) findViewById(R.id.btndial);

		// [3]��button��ť����һ������¼�
		// �������һ�������ǽӿ����ͣ����������ַ���ȥ���ݲ���
		// ��һ�� ����һ����ȥʵ������ӿ�����
		//�ڲ���
		btndial.setOnClickListener(new MyClickListener());
		
		
		
	}

	//�Լ�����һ����ȥʵ�ַ�����Ҫ�Ĳ�������
	// ����һ����ȥʵ�ְ�ť��Ҫ�Ľӿ�����
	private class MyClickListener implements OnClickListener {
		//Called when a view has been clicked.
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//[4]��ȡEditText �ı�����
			String phonenum = etinphone.getText().toString().trim();
			if("".equals(phonenum)){
				//context ������
				//������ﵥ��дthis ��ʾ����MyClickListener  �������������һ��Context������
				Toast.makeText(MainActivity.this, "�绰���벻��Ϊ��", Toast.LENGTH_LONG).show();
				return;
			}
			//System.out.println("��ť�����"+phonenum);
			//[5]�õ�phonenum�� ���в���绰   ��ͼIntent
			Intent intent = new Intent();  //����һ����ͼ����    �� ��һ��������ͼ
			//[5.1]���ö���
			intent.setAction(Intent.ACTION_CALL);
			//����Ҫ���������   uri ͳһ��Դ��ʶ��  �Լ������·��  �����ʲô�ʹ���ʲô
			intent.setData(Uri.parse("tel:"+phonenum));
			//[6]������ͼ
			startActivity(intent);
		}
	}

}
