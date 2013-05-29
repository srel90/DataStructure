package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class InsertSort extends Activity {
	Matrix matrix = new Matrix();
	Point point1, point2, point3, point4, point5 = new Point();
	private Context context = InsertSort.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_insert_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		newgame();
		event();
	}

	public void newgame() {
		FrameLayout FrameLayout = (FrameLayout) findViewById(R.id.FrameLayout1);
		FrameLayout.removeAllViews();
		DrawView block = new DrawView(this);
		block.invalidate();
		FrameLayout.addView(block);
	}

	public ArrayList<Integer> rannum() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers;
	}

	public void event() {
		((Button) findViewById(R.id.btnback))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(context, MainMenu.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						finish();
					}
				});
		((Button) findViewById(R.id.btndirection))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
								context);
						alertDialogBuilder.setTitle("How to play");
						alertDialogBuilder
								.setMessage("¡´¡´¡´à¢éÒä»")
								.setCancelable(true)
								.setPositiveButton("Yes",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int id) {
												// do nothing
											}
										});
						AlertDialog alertDialog = alertDialogBuilder.create();
						alertDialog.show();
					}
				});
		((Button) findViewById(R.id.btnrefresh))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						newgame();
					}
				});
	}
	public void lose(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("YOU LOSE!");
		alertDialogBuilder
				.setMessage("Do you want to try again?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								newgame();
							}
						})
				.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								Intent intent = new Intent(context,
										MainMenu.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);
								dialog.cancel();
								finish();
							}
						});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
	public void win(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle("YOU WIN!");
		alertDialogBuilder
				.setMessage("Do you want to try again?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								newgame();
							}
						})
				.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								Intent intent = new Intent(context,
										MainMenu.class);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);
								dialog.cancel();
								finish();
							}
						});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert_sort, menu);
		return true;
	}

}
