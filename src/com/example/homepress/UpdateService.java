package com.example.homepress;

import android.app.KeyguardManager;
import android.app.Service;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.widget.Toast;

public class UpdateService extends Service {

	Context context;
	PowerManager powermanager;
	WakeLock wakeLock;
	KeyguardManager keyguardManager;
	KeyguardLock keyguardLock;
	BroadcastReceiver mReceiver;
	
    @Override
    public void onCreate() {
        super.onCreate();
        // register receiver that handles screen on and screen off logic
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mReceiver = new Receiver();
        registerReceiver(mReceiver, filter);
    }

    @Override
    public void onDestroy() {

        unregisterReceiver(mReceiver);
        Log.i("onDestroy Reciever", "Called");

        super.onDestroy();
    }
    
    @Override
    public void onStart(Intent intent, int startId) {
        boolean screenOn = intent.getBooleanExtra("screen_state", false);
        if (!screenOn) {
            // your code
        	 Toast.makeText(getBaseContext(), "Power Button Pressed", 
					  Toast.LENGTH_SHORT).show();
        
        	Intent i = new Intent(UpdateService.this, KS_home.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			
        } else {
            // your code
           
//        	 Toast.makeText(getBaseContext(), "Power Button Not Pressed", 
//					  Toast.LENGTH_SHORT).show();
        
        }
    }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}