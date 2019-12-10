package com.msb.mediaplayerservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MediaService extends Service {
    MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Çalınmasını istediğimiz ses dosyasını seçtik.
        //Ses dosyaları raw isimli klasörde tutulur.
        mediaPlayer = MediaPlayer.create(this, R.raw.allowdance);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            //eğer herhangi bir çalma işlemi mevcut değilse,
            //servisin başladığı mesajı verilir ve mediaplayer başlatılır.
            Toast.makeText(this, "Servis başlatıldı.", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
        }
        //START_STICKY sayısal ve sabit bir değerdir.
        //bu servis durdurulana kadar çalışmasına devam edecktir.
        return START_STICKY;
    }
    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            //çalınan bir ses dosyası varsa bu durdurulur.
            mediaPlayer.stop();
        }
        //servisin bittiği mesajı verilir.
        Toast.makeText(this, "Servis yok edildi.", Toast.LENGTH_SHORT).show();
        //mediaplayer nesnesine bağlı kaynaklar serbest bırakılır.
        mediaPlayer.release();
    }
}
