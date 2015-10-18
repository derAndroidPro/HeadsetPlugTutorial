package de.derandroidpro.headsetplugtutorial;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class HeadsetBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent musicIntent = new Intent(context, MusikService.class);

        switch (intent.getIntExtra("state", -1)){

            case 0:{ // Headset ausgesteckt
                musicIntent.putExtra("plugged_in", 0);
                Toast.makeText(context, "Kopfhörer ausgesteckt", Toast.LENGTH_SHORT).show();

                break;
            }case 1: { //Headset angeschlossen
                musicIntent.putExtra("plugged_in", 1);
                Toast.makeText(context, "Kopfhörer angeschlossen", Toast.LENGTH_SHORT).show();
                break;
            }

        }

        context.startService(musicIntent);


    }
}
