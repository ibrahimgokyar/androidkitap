package com.iotbilisim.internetbroadcastreceiver;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;


 
public class Anasayfa extends Activity {
 

 private NetworkChangeReceiver receiver;
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_anasayfa);


  IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
  receiver = new NetworkChangeReceiver();
  registerReceiver(receiver, filter);
   
 }
 

 @Override
 protected void onDestroy() {
  //Activity Kapatıldığı zaman receiver durduralacak.Uygulama arka plana alındığı zamanda receiver çalışmaya devam eder
  super.onDestroy();
   
  unregisterReceiver(receiver);//receiver durduruluyor
 
 }
 
 

 
 
}