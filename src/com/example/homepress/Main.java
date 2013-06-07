package com.example.homepress;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

public class Main extends Activity {

	Context context = this;
	ToggleButton btnToggleLock;
	Button btnMisc;
	Toast toast;
	PowerManager powermanager;
	WakeLock wakeLock;
	public static KeyguardManager _guard;
	public static KeyguardLock _keyguardLock;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

//		Intent service = new Intent(context, UpdateService.class);
//		context.startService(service);
	
		 	btnMisc = (Button) findViewById(R.id.button1);
		    btnToggleLock = (ToggleButton) findViewById(R.id.toggleButton1);

		    toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
		    
		   btnToggleLock.setOnClickListener(new OnClickListener() {

		        @Override
		        public void onClick(View v) {

		            if (btnToggleLock.isChecked()) {

		                toast.cancel();
		                toast.setText("Unlocked");
		                toast.show();

		                Log.i("Unlocked", "If");

		                Context context = getApplicationContext();
						
		                KeyguardManager _guard = (KeyguardManager) context
		                        .getSystemService(Context.KEYGUARD_SERVICE);
		                KeyguardLock _keyguardLock = _guard
		                        .newKeyguardLock("KeyguardLockWrapper");
		                _keyguardLock.disableKeyguard();
		                
		                Main.this.startService(new Intent(
		                        Main.this, UpdateService.class));
		                
		            } else {

		                toast.cancel();
		                toast.setText("Locked");
		                toast.show();

		                Context context = getApplicationContext();
		                KeyguardManager _guard = (KeyguardManager) context
		                        .getSystemService(Context.KEYGUARD_SERVICE);
		                KeyguardLock _keyguardLock = _guard
		                        .newKeyguardLock("KeyguardLockWrapper");
		                _keyguardLock.reenableKeyguard();
		                _keyguardLock = null;
		                
		                Log.i("Locked", "else");
						
		                Main.this.stopService(new Intent(Main.this,
		                        UpdateService.class));
		            }
		        }
		    });
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		    // Inflate the menu; this adds items to the action bar if it is present.
		    getMenuInflater().inflate(R.menu.main, menu);
		    return true;
		}

		@Override
		public void onConfigurationChanged(Configuration newConfig) {
		    // TODO Auto-generated method stub
		    super.onConfigurationChanged(newConfig);

		    Log.i("onConfigurationChanged", "Called");
		}
 
}
