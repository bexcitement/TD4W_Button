package com.rbruggman.td4w;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private Button btnTD4W;
	private ImageView ivTD4W;
	private AudioPlayer mPlayer = new AudioPlayer();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// removes actionbar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		btnTD4W = (Button) findViewById(R.id.ivBtn);
		ivTD4W = (ImageView) findViewById(R.id.imageView4);
		btnTD4W.setOnClickListener(playAudioButtonListener);
		
	}
	
	public OnClickListener playAudioButtonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			mPlayer.play(getApplicationContext());
			
		}
	};
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
