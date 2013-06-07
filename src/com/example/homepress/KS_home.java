package com.example.homepress;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class KS_home extends Activity{
	LinearLayout ll;
	Button btn_1, btn_2, btn_3, btn_4, btn_cancel;
	Context CONTEXT = this;
	BroadcastReceiver br;
	Context context = getApplicationContext();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        
        
		final TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		PhoneStateListener phoneStateListener = new PhoneStateListener() {
			@Override
			public void onCallStateChanged(int state, String number) {
				switch (state) {
				case TelephonyManager.CALL_STATE_IDLE:
					finish();
				}
			}
		};
		telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
		
       	btn_1 = (Button) findViewById(R.id.Button01);
    	btn_1.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    			
	                KeyguardManager _guard = (KeyguardManager) context
	                        .getSystemService(Context.KEYGUARD_SERVICE);
	                KeyguardLock _keyguardLock = _guard
	                        .newKeyguardLock("KeyguardLockWrapper");
	                _keyguardLock.reenableKeyguard();
	                _keyguardLock = null;
	                
    				finish();
    			}
    		});
    		
     		
    		btn_2 = (Button) findViewById(R.id.Button02);
    		btn_2.setOnClickListener(new View.OnClickListener() {
     			@Override
    			public void onClick(View arg0) {
	                
     				KeyguardManager _guard = (KeyguardManager) context
	                        .getSystemService(Context.KEYGUARD_SERVICE);
	                KeyguardLock _keyguardLock = _guard
	                        .newKeyguardLock("KeyguardLockWrapper");
	                _keyguardLock.reenableKeyguard();
	                _keyguardLock = null;
	                
    				finish();
     			}
    		});
    		
    		btn_3 = (Button) findViewById(R.id.Button03);
    		btn_3.setOnClickListener(new View.OnClickListener() {
     			@Override
    			public void onClick(View arg0) {
     				
	                KeyguardManager _guard = (KeyguardManager) context
	                        .getSystemService(Context.KEYGUARD_SERVICE);
	                KeyguardLock _keyguardLock = _guard
	                        .newKeyguardLock("KeyguardLockWrapper");
	                _keyguardLock.reenableKeyguard();
	                _keyguardLock = null;
	                
    				finish();
     			}
    		});
    		
    		btn_4 = (Button) findViewById(R.id.Button04);
    		btn_4.setOnClickListener(new View.OnClickListener() {
     			@Override
    			public void onClick(View arg0) {
     				
	                KeyguardManager _guard = (KeyguardManager) context
	                        .getSystemService(Context.KEYGUARD_SERVICE);
	                KeyguardLock _keyguardLock = _guard
	                        .newKeyguardLock("KeyguardLockWrapper");
	                _keyguardLock.reenableKeyguard();
	                _keyguardLock = null;
	                
    				finish();
     			}
    		});
    		
    		btn_cancel = (Button) findViewById(R.id.Button07);
    		btn_cancel.setOnClickListener(new View.OnClickListener() {
     			@Override
    			public void onClick(View arg0) {
	                KeyguardManager _guard = (KeyguardManager) context
	                        .getSystemService(Context.KEYGUARD_SERVICE);
	                KeyguardLock _keyguardLock = _guard
	                        .newKeyguardLock("KeyguardLockWrapper");
	                _keyguardLock.reenableKeyguard();
	                _keyguardLock = null;
    				finish();
     			}
    		});
	} 	
    @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("Track", " &&&&&&&&&&&&&&&&&&&&&& --- Pause ----- &&&&&&&&&&&&&&&&&&&&& " );
		finish();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("Track", " &&&&&&&&&&&&&&&&&&&&--- Destroy----- &&&&&&&&&&&&&&&&&&&&& ");
		finish();
	}
	
}
