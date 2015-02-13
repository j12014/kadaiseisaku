package com.example.order;


import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * AsyncTaskGetJson
 *
 * output example:
 * User : 鈴木　イチロー / Ichiro Suzuki
 * Item : PC
 * Item : Android Tablet
 *
 * User : 鈴木　ジロー / Jiro Suzuki
 * Item : iPhone
 */
public class AsyncTaskGetJson extends AsyncTask<Void, Void, String> {
	
	Items items;
	
	private final static String TAG = "AsyncTaskGetJson";

	/**
	 * API URL
	 */
	private final static String API_URL = "http://j12014.sangi01.net/cakephp/app/webroot/json_select.php";

	/**
	 * 呼び出し元のStartActivity
	 */
	private StartActivity activity;

	/**
	 * Constructor
	 *
	 * @param _activity: 呼び出し元のアクティビティ
	 */
	public AsyncTaskGetJson(StartActivity _activity) {
		Log.d(TAG+" constructor", "start");

		activity = _activity;
	}

	/**
	 * バックグラウンドで実行する処理
	 *
	 * @param _params: Activityから受け渡されるデータ
	 * @return onPostExecute method へ受け渡すデータ
	 */
	@Override
	protected String doInBackground(Void... _params) {
		Log.d(TAG+" doInBackground", "start");

		String result = new String();
		ArrayList<NameValuePair> postData = new ArrayList<NameValuePair>();

		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(API_URL);
			httpPost.setEntity(new UrlEncodedFormEntity(postData, "UTF-8"));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();


			
			if (responseEntity != null) {
				String data = EntityUtils.toString(responseEntity);
				Log.d(TAG+" json data", data);

				JSONObject rootObject = new JSONObject(data);

				JSONArray userArray = rootObject.getJSONArray("items");

				items = new Items();

				//配列の頭は　"tap"　にしておく！
				items.setMenu_items(0,"tap");
				for (int n = 0; n < userArray.length(); n++) {
					// User data
					JSONObject userObject = userArray.getJSONObject(n);

					// JSON data の確認
					Log.d(TAG+" user data", userObject.toString());

					String itemName = userObject.getString("item_name");
					result += "商品名: "+itemName;
					items.setMenu_items(n+1,itemName);
					items.setN(n+2);

//					items.setMenu_items(n+1,"aa");
					// output の途中経過の確認
					Log.d(TAG+" result", result);

					// User Item data
					//JSONArray userItemArray = userObject.getJSONArray("UserItem");
					//for (int i = 0; i < userItemArray.length(); i++) {
					//	JSONObject userItemObject = userItemArray.getJSONObject(i);

					// JSON data の確認
					//Log.d(TAG+" user item data", userItemObject.toString());

					//String item = userItemObject.getString("item_name");
					//result += "Item: "+item+"\r\n";
					//}
					result += "\r\n";
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * doInbackground method 後に実行する処理
	 *
	 * @param _result: doInBackground method から受け渡されるデータ
	 */
	@Override
	protected void onPostExecute(String _result) {
		Log.d(TAG+" onPostExecute", "start");

		activity.textView.setText("商品情報を取得しました。");
		

		
		return;
	}

}
