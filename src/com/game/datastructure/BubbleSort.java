package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BubbleSort extends Activity {
	int left = 0, round = 0,fault=0,rcount=0;
	int[] cursor=new int[4];
	private Context context=BubbleSort.this;
	drawTextToBitmap dt=new drawTextToBitmap();
	int[] buttonid=new int[5];

	ArrayList<Integer> anum, snum, xnum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bubble_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		cursor[0]=R.drawable.cursor1;
		cursor[1]=R.drawable.cursor2;
		cursor[2]=R.drawable.cursor3;
		cursor[3]=R.drawable.cursor4;
		buttonid[0]=R.id.btn1;
		buttonid[1]=R.id.btn2;
		buttonid[2]=R.id.btn3;
		buttonid[3]=R.id.btn4;
		buttonid[4]=R.id.btn5;
		newgame();
		event();

	}

	protected void newgame() {
		anum = rannum();
		((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(context, R.drawable.block, anum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(context, R.drawable.block, anum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(context, R.drawable.block, anum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(context, R.drawable.block, anum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(context, R.drawable.block, anum.get(4).toString(), Color.WHITE));
		snum = new ArrayList<Integer>();
		snum.add(anum.get(0));
		snum.add(anum.get(1));
		snum.add(anum.get(2));
		snum.add(anum.get(3));
		snum.add(anum.get(4));
		Collections.sort(snum);
		xnum = new ArrayList<Integer>();
		xnum.add(anum.get(0));
		xnum.add(anum.get(1));
		xnum.add(anum.get(2));
		xnum.add(anum.get(3));
		xnum.add(anum.get(4));
		round = 0;
		rcount=0;
		((TextView) findViewById(R.id.txtround)).setText("Round : "+rcount);
		left = 0;
		((ImageView) findViewById(R.id.cursor)).setBackgroundResource(cursor[left]);
		if (snum.equals(xnum)) {
			newgame();
		}
		fault=0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);

	}

	public void drawnew() {
		((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(4).toString(), Color.WHITE));
		int j=0;
		for(Iterator<Integer> i = snum.iterator(); i.hasNext(); ) {
			  if(i.next().equals(xnum.get(j))){
				  ((ImageView) findViewById(buttonid[j])).setImageBitmap(dt.draw(context, R.drawable.blockp, xnum.get(j).toString(), Color.WHITE));
				  
			  }
			  j++;
		}
	}

	public void checkgame() {
		if(fault==3){
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
		}else if(snum.equals(xnum)) {
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
		((Button) findViewById(R.id.btnswap))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if(xnum.get(round)<=xnum.get(round+1)){
							fault++;
							((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);
						}
						int tmp = xnum.get(round);
						xnum.set(round, xnum.get(round + 1));
						xnum.set(round + 1, tmp);
						drawnew();
						
						checkgame();
						movecursor();

					}
				});
		((Button) findViewById(R.id.btnnoswap))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if(xnum.get(round)>=xnum.get(round+1)){
							fault++;
							((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);
						}
						checkgame();
						movecursor();
					}
				});
		((Button) findViewById(R.id.btnback))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(context,
								MainMenu.class);
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
												//do nothing
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

	public void movecursor() {
		left++;
		if (left >= 4) {
			left = 0;
		}
		round++;
		if (round >= 4) {
			round = 0;
		}
		rcount++;
		((TextView) findViewById(R.id.txtround)).setText("Round : "+rcount);
		((ImageView) findViewById(R.id.cursor)).setBackgroundResource(cursor[left]);
	}

}
