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

public class MainActivity extends Activity {


	MyAsyncHttpClient myAsyncHttpClient;
	WebActivity webActivity = new WebActivity();
	Items items= new Items();

	Button B_soushin,B_check;
	Button B1_up,B2_up,B3_up,B4_up,B5_up;
	Button B1_down,B2_down,B3_down,B4_down,B5_down;
	EditText memo1,memo2,memo3,memo4,memo5;

	String table_items[] = {"1", "2", "3", "4"};
	String tanmatsu_items[] = {"1", "2", "3", "4","5"};
	int n=items.getN();
	String menu_items[] = new String[n];


	Spinner tableSpinner,tanmatsuSpinner;
	Spinner menuSpinner1,menuSpinner2,menuSpinner3,menuSpinner4,menuSpinner5;

	TextView kosuu1,kosuu2,kosuu3,kosuu4,kosuu5;

	private static final int MENU_ID_MENU1 = (Menu.FIRST + 1);
	private static final int MENU_ID_MENU2 = (Menu.FIRST + 2);
	private boolean visible = true;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myAsyncHttpClient = new MyAsyncHttpClient(getApplicationContext());


		menu_items[0]=("tap");
		//取得したn個で配列を初期化
		for(int i=0;i<n;i++){
			menu_items[i]=(items.getMenu_items(i));
		}

		
		
		tableSpinner = (Spinner)findViewById(R.id.spinner_table);
		tanmatsuSpinner = (Spinner)findViewById(R.id.spinner_tanmatsu);
		menuSpinner1 = (Spinner)findViewById(R.id.spinner1);
		menuSpinner2 = (Spinner)findViewById(R.id.spinner2);
		menuSpinner3 = (Spinner)findViewById(R.id.spinner3);
		menuSpinner4 = (Spinner)findViewById(R.id.spinner4);
		menuSpinner5 = (Spinner)findViewById(R.id.spinner5);


		ArrayAdapter<String> table = new ArrayAdapter<String>(this, R.layout.spinner_item, table_items); 
		table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tableSpinner.setAdapter(table);

		ArrayAdapter<String> tanmatsu = new ArrayAdapter<String>(this, R.layout.spinner_item, tanmatsu_items);  
		tanmatsu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tanmatsuSpinner.setAdapter(tanmatsu);

		ArrayAdapter<String> menu = new ArrayAdapter<String>(this, R.layout.spinner_item, menu_items);  
		menu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		menuSpinner1.setAdapter(menu);
		menuSpinner2.setAdapter(menu);
		menuSpinner3.setAdapter(menu);
		menuSpinner4.setAdapter(menu);
		menuSpinner5.setAdapter(menu);

		// リスナーを登録
		tableSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){  
			//　アイテムが選択された時  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  
				String item = (String)spinner.getSelectedItem();  
			}  
			//　アイテムが選択されなかった
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});

		tanmatsuSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});

		menuSpinner1.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});
		menuSpinner2.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});
		menuSpinner3.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});
		menuSpinner4.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});
		menuSpinner5.setOnItemSelectedListener(new OnItemSelectedListener(){  
			public void onItemSelected(AdapterView<?> parent, View viw, int arg2, long arg3) {  
				Spinner spinner = (Spinner)parent;  String item = (String)spinner.getSelectedItem();  
			}  
			public void onNothingSelected(AdapterView<?> parent) {  
			}
		});

		B_check = (Button)findViewById(R.id.button1);
		B_soushin = (Button)findViewById(R.id.button2);

		B1_up = (Button)findViewById(R.id.b1_up);
		B2_up = (Button)findViewById(R.id.b2_up);
		B3_up = (Button)findViewById(R.id.b3_up);
		B4_up = (Button)findViewById(R.id.b4_up);
		B5_up = (Button)findViewById(R.id.b5_up);

		B1_down = (Button)findViewById(R.id.b1_down);
		B2_down = (Button)findViewById(R.id.b2_down);
		B3_down = (Button)findViewById(R.id.b3_down);
		B4_down = (Button)findViewById(R.id.b4_down);
		B5_down = (Button)findViewById(R.id.b5_down);

		memo1 = (EditText)findViewById(R.id.memo1);
		memo2 = (EditText)findViewById(R.id.memo2);
		memo3 = (EditText)findViewById(R.id.memo3);
		memo4 = (EditText)findViewById(R.id.memo4);
		memo5 = (EditText)findViewById(R.id.memo5);

		kosuu1 = (TextView)findViewById(R.id.Kazu1);
		kosuu2 = (TextView)findViewById(R.id.Kazu2);
		kosuu3 = (TextView)findViewById(R.id.Kazu3);
		kosuu4 = (TextView)findViewById(R.id.Kazu4);
		kosuu5 = (TextView)findViewById(R.id.Kazu5);

		B_soushin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String moji1 = tableSpinner.getSelectedItem().toString();
				String moji2 = tanmatsuSpinner.getSelectedItem().toString();
				String moji3 = menuSpinner1.getSelectedItem().toString();
				String moji4 = kosuu1.getText().toString();
				String moji5 = memo1.getText().toString();

				final Calendar calendar = Calendar.getInstance();

				final int year = calendar.get(Calendar.YEAR);
				final int month = calendar.get(Calendar.MONTH)+1;
				final int day = calendar.get(Calendar.DAY_OF_MONTH);
				final int hour = calendar.get(Calendar.HOUR_OF_DAY);
				final int minute = calendar.get(Calendar.MINUTE);
				final int second = calendar.get(Calendar.SECOND);
				final int ms = calendar.get(Calendar.MILLISECOND);

				String moji6=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;

				for(int i=0;i<5;i++){

					if(i==1){
						moji3 = menuSpinner2.getSelectedItem().toString();
						moji4 = kosuu2.getText().toString();
						moji5 = memo2.getText().toString();
					}
					else if(i==2){
						moji3 = menuSpinner3.getSelectedItem().toString();
						moji4 = kosuu3.getText().toString();
						moji5 = memo3.getText().toString();
					}
					else if(i==3){
						moji3 = menuSpinner4.getSelectedItem().toString();
						moji4 = kosuu4.getText().toString();
						moji5 = memo4.getText().toString();
					}
					else if(i==4){
						moji3 = menuSpinner5.getSelectedItem().toString();
						moji4 = kosuu5.getText().toString();
						moji5 = memo5.getText().toString();
					}
					if(moji3.equals("tap")){
					}
					else{
						myAsyncHttpClient.newRequestParams();
						myAsyncHttpClient.setParams("aa",moji1);	//送るファイルを設定
						myAsyncHttpClient.setParams("bb",moji2);	//送るファイルを設定
						myAsyncHttpClient.setParams("cc",moji3);	//送るファイルを設定
						myAsyncHttpClient.setParams("dd",moji4);	//送るファイルを設定
						myAsyncHttpClient.setParams("ee",moji5+" ");	//送るファイルを設定
						myAsyncHttpClient.setParams("ff",moji6);	//送るファイルを設定
						myAsyncHttpClient.access();
					}
				}
			}
		});
		B_check.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// インテントのインスタンス生成
				Intent intent = new Intent(MainActivity.this, WebActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);

			}
		});

		B1_up.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =1+Integer.parseInt((String)kosuu1.getText());
				kosuu1.setText(""+i);
			}
		});
		B2_up.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =1+Integer.parseInt((String)kosuu2.getText());
				kosuu2.setText(""+i);
			}
		});
		B3_up.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =1+Integer.parseInt((String)kosuu3.getText());
				kosuu3.setText(""+i);
			}
		});
		B4_up.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =1+Integer.parseInt((String)kosuu4.getText());
				kosuu4.setText(""+i);
			}
		});
		B5_up.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =1+Integer.parseInt((String)kosuu5.getText());
				kosuu5.setText(""+i);
			}
		});

		B1_down.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =Integer.parseInt((String)kosuu1.getText())-1;
				if(i<0)
					i=0;
				kosuu1.setText(""+i);
			}
		});
		B2_down.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =Integer.parseInt((String)kosuu2.getText())-1;
				if(i<0)
					i=0;
				kosuu2.setText(""+i);
			}
		});
		B3_down.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =Integer.parseInt((String)kosuu3.getText())-1;
				if(i<0)
					i=0;
				kosuu3.setText(""+i);
			}
		});
		B4_down.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =Integer.parseInt((String)kosuu4.getText())-1;
				if(i<0)
					i=0;
				kosuu4.setText(""+i);
			}
		});
		B5_down.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				int i =Integer.parseInt((String)kosuu5.getText())-1;
				if(i<0)
					i=0;
				kosuu5.setText(""+i);
			}
		});
	}


	// オプションメニューが最初に呼び出される時に1度だけ呼び出されます
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューアイテムを追加します
		menu.add(Menu.NONE, MENU_ID_MENU1, Menu.NONE, "Menu1");
		menu.add(Menu.NONE, MENU_ID_MENU2, Menu.NONE, "Menu2");
		return super.onCreateOptionsMenu(menu);
	}

	// オプションメニューが表示される度に呼び出されます
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.findItem(MENU_ID_MENU2).setVisible(visible);
		visible = !visible;
		return super.onPrepareOptionsMenu(menu);
	}

	// オプションメニューアイテムが選択された時に呼び出されます
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean ret = true;
		switch (item.getItemId()) {
		default:
			ret = super.onOptionsItemSelected(item);
			break;
		case MENU_ID_MENU1:
			ret = true;
			break;
		case MENU_ID_MENU2:
			ret = true;
			break;
		}
		return ret;
	}
}
