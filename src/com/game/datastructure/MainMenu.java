package com.game.datastructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_menu);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		((Button)findViewById(R.id.mainbtn1)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,BubbleSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		((Button)findViewById(R.id.mainbtn2)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,SelectSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		((Button)findViewById(R.id.mainbtn3)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,InsertSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		((Button)findViewById(R.id.mainbtn4)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,QuickSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		((Button)findViewById(R.id.mainbtn5)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,StackSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		((Button)findViewById(R.id.mainbtn6)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				new Handler().postDelayed(new Runnable() {
                    public void run() {
                            Intent newActivity = new Intent(MainMenu.this,QueueSort.class);
                            startActivity(newActivity);
                            finish();
                    }
                }, 100);
			}		
	    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
