package com.asp.aspproject.request;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.os.AsyncTask;

public class RequestHandler extends AsyncTask<HttpRequestBase, String,  Object>{

	private static final String LOG_TAG = "RequestHandler";

	private String mRequestingUrl;

	private Activity mCallingActivity;

	private Method mPostExecutionMethod = null;

	private Object mCallingObject;

	private Object mParams;



	public RequestHandler(String url, Object params, Object callingObjet, String postExecutionMethodName, Activity activity) {
		super();
		mRequestingUrl = url;
		mParams = params;
		mCallingObject= callingObjet;
		mCallingActivity = activity;
		if(postExecutionMethodName != null)
		{
			initPostExecutionMethod(postExecutionMethodName);
		}
	}

	private void initPostExecutionMethod(String methodName){

		try {
			mPostExecutionMethod = mCallingObject.getClass().getDeclaredMethod(methodName, Class.forName("java.lang.Object"));
		} catch(Exception e){
			e.printStackTrace();
		}

	}




	@Override
	protected  Object doInBackground(HttpRequestBase... params) {
		try{
			DefaultHttpClient client = new DefaultHttpClient();

			HttpResponse response = client.execute(params[0]);

			if (response == null) {
				return null;
			}

			final int code = response.getStatusLine().getStatusCode();

			if (code != 200) {
				return null;
			}

			// Read in the response
			String aResponse = null;
			BufferedInputStream aBufferedInputStream = new BufferedInputStream(response.getEntity().getContent());
			ByteArrayBuffer aByteArrayBuffer = new ByteArrayBuffer(50);// Read bytes to the Buffer until there is nothing more to read(-1)
			int current = 0;

			try {
				while((current = aBufferedInputStream.read()) != -1){
					aByteArrayBuffer.append((byte)current);
				}
				aResponse = new String(aByteArrayBuffer.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}

			aBufferedInputStream.close();			

			return aResponse;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	protected void onPostExecute(Object result) {
		super.onPostExecute(result);
		if(mCallingObject != null && mPostExecutionMethod != null) {
			try {
				mPostExecutionMethod.invoke(mCallingObject, result);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		this.mPostExecutionMethod = null;
		this.mCallingObject = null;
		this.mCallingActivity = null;
		this.cancel(true);
	}


	public void getData(){

		HttpRequestBase request =  new HttpGet(mRequestingUrl);

		//HashMap<String, String> paramsToPost = (HashMap<String, String>)mParams;
		//cast params and add them to the post

		//add parameters to the request
		this.execute(request);
	}


	public void postData(){

		//HashMap<String, String> paramsToPost = (HashMap<String, String>)mParams;
		//cast params and add them to the post

		HttpRequestBase request =  new HttpPost(mRequestingUrl);

		//add parameters to the request
		this.execute(request);
	}





}
