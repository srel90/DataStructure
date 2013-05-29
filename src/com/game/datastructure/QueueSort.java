package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

public class QueueSort extends Activity {
	int fault = 0;
	private Context context = QueueSort.this;
	drawTextToBitmap dt = new drawTextToBitmap();
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	Queue<Integer> q3 = new LinkedList<Integer>();
	int[] buttonid=new int[8];

	ArrayList<Integer> anum, snum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_queue_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		buttonid[0]=R.id.btn1;
		buttonid[1]=R.id.btn2;
		buttonid[2]=R.id.btn3;
		buttonid[3]=R.id.btn4;
		buttonid[4]=R.id.btn5;
		buttonid[5]=R.id.btn6;
		buttonid[6]=R.id.btn7;
		buttonid[7]=R.id.btn8;
		newgame();
		event();

	}

	protected void newgame() {
		anum = rannum();
		
		((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(context,
				R.drawable.block, anum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(context,
				R.drawable.block, anum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(context,
				R.drawable.block, anum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(context,
				R.drawable.block, anum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(context,
				R.drawable.block, anum.get(4).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[5])).setImageBitmap(dt.draw(context,
				R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(buttonid[6])).setImageBitmap(dt.draw(context,
				R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(buttonid[7])).setImageBitmap(dt.draw(context,
				R.drawable.blocktt, "", Color.WHITE));
		snum = new ArrayList<Integer>();
		snum.add(anum.get(0));
		snum.add(anum.get(1));
		snum.add(anum.get(2));
		snum.add(anum.get(3));
		snum.add(anum.get(4));
		Collections.sort(snum);
		q1.clear();
		q2.clear();
		q3.clear();

		q1.add(anum.get(0));
		q1.add(anum.get(1));
		q1.add(anum.get(2));
		q1.add(anum.get(3));
		q1.add(anum.get(4));
		if (snum.equals(q1)) {
			newgame();
		}
		fault = 0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : " + fault);

	}

	public void drawnew() {
		((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(
				context, R.drawable.block, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(
				context, R.drawable.block, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(
				context, R.drawable.block, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(
				context, R.drawable.block, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(
				context, R.drawable.block, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[5])).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[6])).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "",
				Color.WHITE));
		((ImageView) findViewById(buttonid[7])).setImageBitmap(dt.draw(
				context, R.drawable.blocktt, "",
				Color.WHITE));
		Iterator<Integer> it1 = q1.iterator();
		if (it1.hasNext()) {
			((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(
					context, R.drawable.block, it1.next().toString(),
					Color.WHITE));
		}
		if (it1.hasNext()) {
			((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(
					context, R.drawable.block, it1.next().toString(),
					Color.WHITE));
		}
		if (it1.hasNext()) {
			((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(
					context, R.drawable.block, it1.next().toString(),
					Color.WHITE));
		}
		if (it1.hasNext()) {
			((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(
					context, R.drawable.block, it1.next().toString(),
					Color.WHITE));
		}
		if (it1.hasNext()) {
			((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(
					context, R.drawable.block, it1.next().toString(),
					Color.WHITE));
		}
		Iterator<Integer> it2 = q2.iterator();
		if (it2.hasNext()) {
			((ImageView) findViewById(buttonid[5])).setImageBitmap(dt.draw(
					context, R.drawable.blockt, it2.next().toString(),
					Color.WHITE));
		}
		if (it2.hasNext()) {
			((ImageView) findViewById(buttonid[6])).setImageBitmap(dt.draw(
					context, R.drawable.blockt, it2.next().toString(),
					Color.WHITE));
		}
		Iterator<Integer> it3 = q3.iterator();
		if (it3.hasNext()) {
			((ImageView) findViewById(buttonid[7])).setImageBitmap(dt.draw(
					context, R.drawable.blocktt, it3.next().toString(),
					Color.WHITE));
		}
		int j=0;
		for(Iterator<Integer> i = q1.iterator(); i.hasNext(); ) {
			  if(i.next().equals(snum.get(j))){
				  ((ImageView) findViewById(buttonid[j])).setImageBitmap(dt.draw(context, R.drawable.blockp, snum.get(j).toString(), Color.WHITE));
				  
			  }
			  j++;
		}

	}

	public void checkgame() {
		if (fault == 3) {
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
		} else if (snum.equals(q1)) {
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
		((Button) findViewById(R.id.btndequeue))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (q1.iterator().hasNext()) {
							if (q3.size() <= 1) {
								q3.add(q1.poll());
							} else {
								fault++;
								((TextView) findViewById(R.id.txtfault))
										.setText("Faults : " + fault);
							}
						}
						drawnew();
						checkgame();

					}
				});
		((Button) findViewById(R.id.btnenqueue))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (q3.iterator().hasNext()) {
							q1.add(q3.poll());
							
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);

						}
						drawnew();
						checkgame();

					}
				});
		((Button) findViewById(R.id.btndequeuet))
		.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (q2.iterator().hasNext()) {
					if (q3.size() <= 1) {
						q3.add(q2.poll());
					} else {
						fault++;
						((TextView) findViewById(R.id.txtfault))
								.setText("Faults : " + fault);
					}
				}
				drawnew();
				checkgame();

			}
		});
		((Button) findViewById(R.id.btnenqueuet))
		.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (q3.iterator().hasNext()) {
					q2.add(q3.poll());
				} else {
					fault++;
					((TextView) findViewById(R.id.txtfault))
							.setText("Faults : " + fault);

				}
				drawnew();
				checkgame();

			}
		});
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

}
