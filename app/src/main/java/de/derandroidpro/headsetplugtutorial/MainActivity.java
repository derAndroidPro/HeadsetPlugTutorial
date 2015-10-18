package de.derandroidpro.headsetplugtutorial;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    HeadsetBroadcastReceiver headsetBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headsetBroadcastReceiver = new HeadsetBroadcastReceiver();
        registerReceiver(headsetBroadcastReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(headsetBroadcastReceiver);
        stopService(new Intent(this, MusikService.class));

    }
}
