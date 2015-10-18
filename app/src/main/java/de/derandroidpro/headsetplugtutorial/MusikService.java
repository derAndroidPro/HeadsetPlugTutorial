package de.derandroidpro.headsetplugtutorial;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusikService extends Service{

    MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent.getIntExtra("plugged_in", -1) == 1){

            mediaPlayer = MediaPlayer.create(this, R.raw.music1);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopSelf();
                }
            });

        } else if ( intent.getIntExtra("plugged_in", -1) == 0 && mediaPlayer != null){
            mediaPlayer.stop();
            stopSelf();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
