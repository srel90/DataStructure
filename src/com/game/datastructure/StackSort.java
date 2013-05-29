package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

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

public class StackSort extends Activity {
	int fault = 0;
	private Context context = StackSort.this;
	drawTextToBitmap dt = new drawTextToBitmap();
	Stack<Integer> scenter = new Stack<Integer>();
	Stack<Integer> sleft = new Stack<Integer>();
	Stack<Integer> sright = new Stack<Integer>();
	Stack<Integer> stemp = new Stack<Integer>();

	ArrayList<Integer> anum, snum,xnum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_stack_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		newgame();
		event();

	}

	protected void newgame() {
		anum = rannum();
		((ImageView) findViewById(R.id.btncenter1)).setImageBitmap(dt
				.draw(context, R.drawable.blockt, anum.get(0).toString(),
						Color.WHITE));
		((ImageView) findViewById(R.id.btncenter2)).setImageBitmap(dt
				.draw(context, R.drawable.blockt, anum.get(1).toString(),
						Color.WHITE));
		((ImageView) findViewById(R.id.btncenter3)).setImageBitmap(dt
				.draw(context, R.drawable.blockt, anum.get(2).toString(),
						Color.WHITE));
		((ImageView) findViewById(R.id.btncenter4)).setImageBitmap(dt
				.draw(context, R.drawable.blockt, anum.get(3).toString(),
						Color.WHITE));
		((ImageView) findViewById(R.id.btncenter5)).setImageBitmap(dt
				.draw(context, R.drawable.blockt, anum.get(4).toString(),
						Color.WHITE));
		((ImageView) findViewById(R.id.btnleft1)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft2)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft3)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft4)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft5)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright1)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright2)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright3)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright4)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright5)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btntemp)).setImageBitmap(dt.draw(
				context, R.drawable.blocktt, "", Color.WHITE));
		snum = new ArrayList<Integer>();
		snum.add(anum.get(0));
		snum.add(anum.get(1));
		snum.add(anum.get(2));
		snum.add(anum.get(3));
		snum.add(anum.get(4));
		Collections.sort(snum);
		((ImageView) findViewById(R.id.btnans1)).setImageBitmap(dt.draw(
				context, R.drawable.blockp, snum.get(0).toString(),
				Color.WHITE));
		((ImageView) findViewById(R.id.btnans2)).setImageBitmap(dt.draw(
				context, R.drawable.blockp, snum.get(1).toString(),
				Color.WHITE));
		((ImageView) findViewById(R.id.btnans3)).setImageBitmap(dt.draw(
				context, R.drawable.blockp, snum.get(2).toString(),
				Color.WHITE));
		((ImageView) findViewById(R.id.btnans4)).setImageBitmap(dt.draw(
				context, R.drawable.blockp, snum.get(3).toString(),
				Color.WHITE));
		((ImageView) findViewById(R.id.btnans5)).setImageBitmap(dt.draw(
				context, R.drawable.blockp, snum.get(4).toString(),
				Color.WHITE));

		scenter.clear();
		sleft.clear();
		sright.clear();
		stemp.clear();

		scenter.add(anum.get(4));
		scenter.add(anum.get(3));
		scenter.add(anum.get(2));
		scenter.add(anum.get(1));
		scenter.add(anum.get(0));

		if (snum.equals(scenter)) {
			newgame();
		}
		fault = 0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : " + fault);

	}

	public void drawnew() {
		((ImageView) findViewById(R.id.btncenter1)).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(R.id.btncenter2)).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(R.id.btncenter3)).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(R.id.btncenter4)).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(R.id.btncenter5)).setImageBitmap(dt.draw(
				context, R.drawable.blockt, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft1)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft2)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft3)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft4)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnleft5)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright1)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright2)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright3)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright4)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btnright5)).setImageBitmap(dt.draw(
				context, R.drawable.block, "", Color.WHITE));
		((ImageView) findViewById(R.id.btntemp)).setImageBitmap(dt.draw(
				context, R.drawable.blocktt, "", Color.WHITE));
		Iterator<Integer> itcenter = scenter.iterator();
		Iterator<Integer> itleft = sleft.iterator();
		Iterator<Integer> itright = sright.iterator();
		Iterator<Integer> ittemp = stemp.iterator();

		if (itcenter.hasNext()) {
			((ImageView) findViewById(R.id.btncenter5)).setImageBitmap(dt.draw(
					context, R.drawable.blockt, itcenter.next().toString(),
					Color.WHITE));
		}
		if (itcenter.hasNext()) {
			((ImageView) findViewById(R.id.btncenter4)).setImageBitmap(dt.draw(
					context, R.drawable.blockt, itcenter.next().toString(),
					Color.WHITE));
		}
		if (itcenter.hasNext()) {
			((ImageView) findViewById(R.id.btncenter3)).setImageBitmap(dt.draw(
					context, R.drawable.blockt, itcenter.next().toString(),
					Color.WHITE));
		}
		if (itcenter.hasNext()) {
			((ImageView) findViewById(R.id.btncenter2)).setImageBitmap(dt.draw(
					context, R.drawable.blockt, itcenter.next().toString(),
					Color.WHITE));
		}
		if (itcenter.hasNext()) {
			((ImageView) findViewById(R.id.btncenter1)).setImageBitmap(dt.draw(
					context, R.drawable.blockt, itcenter.next().toString(),
					Color.WHITE));
		}

		if (itleft.hasNext()) {
			((ImageView) findViewById(R.id.btnleft5)).setImageBitmap(dt.draw(
					context, R.drawable.block, itleft.next().toString(),
					Color.WHITE));
		}
		if (itleft.hasNext()) {
			((ImageView) findViewById(R.id.btnleft4)).setImageBitmap(dt.draw(
					context, R.drawable.block, itleft.next().toString(),
					Color.WHITE));
		}
		if (itleft.hasNext()) {
			((ImageView) findViewById(R.id.btnleft3)).setImageBitmap(dt.draw(
					context, R.drawable.block, itleft.next().toString(),
					Color.WHITE));
		}
		if (itleft.hasNext()) {
			((ImageView) findViewById(R.id.btnleft2)).setImageBitmap(dt.draw(
					context, R.drawable.block, itleft.next().toString(),
					Color.WHITE));
		}
		if (itleft.hasNext()) {
			((ImageView) findViewById(R.id.btnleft1)).setImageBitmap(dt.draw(
					context, R.drawable.block, itleft.next().toString(),
					Color.WHITE));
		}

		if (itright.hasNext()) {
			((ImageView) findViewById(R.id.btnright5)).setImageBitmap(dt.draw(
					context, R.drawable.block, itright.next().toString(),
					Color.WHITE));
		}
		if (itright.hasNext()) {
			((ImageView) findViewById(R.id.btnright4)).setImageBitmap(dt.draw(
					context, R.drawable.block, itright.next().toString(),
					Color.WHITE));
		}
		if (itright.hasNext()) {
			((ImageView) findViewById(R.id.btnright3)).setImageBitmap(dt.draw(
					context, R.drawable.block, itright.next().toString(),
					Color.WHITE));
		}
		if (itright.hasNext()) {
			((ImageView) findViewById(R.id.btnright2)).setImageBitmap(dt.draw(
					context, R.drawable.block, itright.next().toString(),
					Color.WHITE));
		}
		if (itright.hasNext()) {
			((ImageView) findViewById(R.id.btnright1)).setImageBitmap(dt.draw(
					context, R.drawable.block, itright.next().toString(),
					Color.WHITE));
		}

		if (ittemp.hasNext()) {
			((ImageView) findViewById(R.id.btntemp)).setImageBitmap(dt.draw(
					context, R.drawable.blocktt, ittemp.next().toString(),
					Color.WHITE));
		}
	}

	public void checkgame() {
		xnum = new ArrayList<Integer>(scenter);
		Collections.reverse(xnum);
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
		} else if (snum.equals(xnum)) {
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
		((Button) findViewById(R.id.btnpopcenter))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (scenter.iterator().hasNext()) {
							if (stemp.size() == 0) {
								stemp.push(scenter.pop());
							} else {
								fault++;
								((TextView) findViewById(R.id.txtfault))
										.setText("Faults : " + fault);
							}
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
						}

						drawnew();
						checkgame();
					}
				});
		((Button) findViewById(R.id.btnpushcenter))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (stemp.iterator().hasNext()) {
							if(scenter.iterator().hasNext()){
								if (scenter.peek() > stemp.iterator().next()) {
									scenter.push(stemp.pop());
								}
							}else{
								scenter.push(stemp.pop());
							}
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
						}

						drawnew();
						checkgame();
					}
				});
		((Button) findViewById(R.id.btnpopleft))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (sleft.iterator().hasNext()) {
							if (stemp.size() == 0) {
								stemp.push(sleft.pop());
							} else {
								fault++;
								((TextView) findViewById(R.id.txtfault))
										.setText("Faults : " + fault);
							}
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
						}

						drawnew();
						checkgame();
					}
				});
		((Button) findViewById(R.id.btnpushleft))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (stemp.iterator().hasNext()) {
							if(sleft.iterator().hasNext()){
								if (sleft.peek() > stemp.iterator().next()) {
									sleft.push(stemp.pop());
								}
							}else{
								sleft.push(stemp.pop());
							}
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
						}

						drawnew();
						checkgame();
					}
				});
		((Button) findViewById(R.id.btnpopright))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (sright.iterator().hasNext()) {
							if (stemp.size() == 0) {
								stemp.push(sright.pop());
							} else {
								fault++;
								((TextView) findViewById(R.id.txtfault))
										.setText("Faults : " + fault);
							}
						} else {
							fault++;
							((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
						}

						drawnew();
						checkgame();
					}
				});
		((Button) findViewById(R.id.btnpushright))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (stemp.iterator().hasNext()) {
							if(sright.iterator().hasNext()){
								if (sright.peek() > stemp.iterator().next()) {
									sright.push(stemp.pop());
								}
							}else{
								sright.push(stemp.pop());
							}
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
								.setMessage("°¥°¥°¥‡¢È“‰ª")
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
