package com.example.order;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.order.AsyncTaskGetJson;
import com.example.order.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.content.Intent;

public class StartActivity extends Activity {

	Button Button;
	TextView textView;
	TextView textView2;

	Items items;
	
	private final static String TAG = "MainActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		items = new Items();
		textView = (TextView)findViewById(R.id.text);
		Button = (Button)findViewById(R.id.button);

		// 非同期処理の実行
		final AsyncTaskGetJson taskGetJson = new AsyncTaskGetJson(this);
		taskGetJson.execute();



		Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(textView.getText().equals("商品情報を取得しました。")){
					// インテントのインスタンス生成
					Intent intent = new Intent(StartActivity.this, MainActivity.class);
					// 次画面のアクティビティ起動
					startActivity(intent);
				}
				else{

				}

			}
		});
	}


}
