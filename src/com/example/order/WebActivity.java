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
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

public class WebActivity extends Activity {
	/**
	 * �����o�ϐ�
	 */
	private WebView webView;

	/**
	 * �A�v���N�����ɍŏ��ɌĂ΂�郁�\�b�h(onCreate)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web); // main.xml���Z�b�g

		findViews(); // View�̓ǂݍ���
		webView.loadUrl("http://j12014.sangi01.net/cakephp/tests/"); // �T�C�g�̓ǂݍ���
	}

	/**
	 * View�̓ǂݍ���
	 */
	public void findViews() {
		// main.xml��webview��ID���擾���A
		// WebViewActivity��WebView�N���X�Ɋ֘A�t����
		webView = (WebView) findViewById(R.id.webview);
	}
}