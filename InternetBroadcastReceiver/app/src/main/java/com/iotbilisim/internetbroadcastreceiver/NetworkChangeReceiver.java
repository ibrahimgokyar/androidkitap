package com.iotbilisim.internetbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
	private static final String LOG_TAG = "Otomatik internet Kontrolü";


	@Override
	public void onReceive(final Context context, final Intent intent) {

		isNetworkAvailable(context);

	}

	private void isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager)
				context.getSystemService(Context.CONNECTIVITY_SERVICE);


		String networkType = null;
		networkType = getNetworkClass(context);


		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
		if (activeNetwork != null) {
			// connected to the internet
			if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
				Toast.makeText(context, "Wifi den bağlandınız", Toast.LENGTH_LONG).show();
			} else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
				networkType = getNetworkClass(context);
				Toast.makeText(context, networkType+" bağlandınız!", Toast.LENGTH_LONG).show();
			}
		} else {
			Toast.makeText(context, "İnternet yok", Toast.LENGTH_LONG).show();
		}





	}


	public String getNetworkClass(Context context) {
		TelephonyManager mTelephonyManager = (TelephonyManager)
				context.getSystemService(Context.TELEPHONY_SERVICE);
		int networkType = mTelephonyManager.getNetworkType();
		switch (networkType) {
			case TelephonyManager.NETWORK_TYPE_GPRS:
			case TelephonyManager.NETWORK_TYPE_EDGE:
			case TelephonyManager.NETWORK_TYPE_CDMA:
			case TelephonyManager.NETWORK_TYPE_1xRTT:
			case TelephonyManager.NETWORK_TYPE_IDEN:
				return "2G";
			case TelephonyManager.NETWORK_TYPE_UMTS:
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
			case TelephonyManager.NETWORK_TYPE_EVDO_A:
			case TelephonyManager.NETWORK_TYPE_HSDPA:
			case TelephonyManager.NETWORK_TYPE_HSUPA:
			case TelephonyManager.NETWORK_TYPE_HSPA:
			case TelephonyManager.NETWORK_TYPE_EVDO_B:
			case TelephonyManager.NETWORK_TYPE_EHRPD:
			case TelephonyManager.NETWORK_TYPE_HSPAP:
				return "3G";
			case TelephonyManager.NETWORK_TYPE_LTE:
				return "4G";
			default:
				return "Unknown";
		}
	}
}