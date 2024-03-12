
/*
 * Copyright (C) 2016 lovdream.com
 *
 */

package com.example.webcamprojecttest.test;

import android.os.IBinder;
import android.util.Log;

import com.example.webcamprojecttest.CreService;

import java.lang.reflect.Method;
public class LovUtility{

	private static final String TAG = "LovUtility";

	private static CreService mService;
	

	private LovUtility(){
	}

	private static IBinder getServiceBinder(){
		IBinder binder = null;
		try{
			Class<?> ServiceManager = Class.forName("android.os.ServiceManager");
			Method m = ServiceManager.getMethod("getService",String.class);
			binder = (IBinder) m.invoke(null,"CreService");
		}catch(Exception e){
			e.printStackTrace();
			Log.e(TAG,"can not get system service,is System ready?");
		}
		return binder;
	}

	public static CreService getService(){

		if(mService == null){
			IBinder binder = getServiceBinder();
			mService = CreService.Stub.asInterface(binder);
		}

		return mService;
	}
}
