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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectSort extends Activity {
	int left = 0, round = 0,fault=0,minindex=1;
	
	int[] corsorid=new int[5];
	int[] buttonid=new int[5];
	private Context context=SelectSort.this;
	drawTextToBitmap dt=new drawTextToBitmap();
	ArrayList<View> click1 = new ArrayList<View>();

	ArrayList<Integer> anum, snum, xnum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_select_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		corsorid[0]=R.id.cursor;
		corsorid[1]=R.id.cursor2;
		corsorid[2]=R.id.cursor3;
		corsorid[3]=R.id.cursor4;
		corsorid[4]=R.id.cursor5;
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
		left = 0;		
		
		((ImageView) findViewById(corsorid[0])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[1])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[2])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[3])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[4])).setBackgroundResource(R.drawable.cursoroddb);
		for(int i=round;i<snum.size();i++){
			if(snum.get(i).equals(xnum.get(i))){
				round++;
			}else{
				break;
			}
		}
		if(round>=4){
			round=0;
		}
		((ImageView) findViewById(corsorid[round])).setBackgroundResource(R.drawable.cursorodd);
//		int min=xnum.get(round+1);
//		for(int i=round+1;i<xnum.size();i++){
//			if(min>xnum.get(i)){
//				min=xnum.get(i);
//				minindex=i;
//			}
//		}
//		((ImageView) findViewById(corsorid[minindex])).setBackgroundResource(R.drawable.cursorodd);
		

		if (snum.equals(xnum)) {
			newgame();
		}
		fault=0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);
		int j=0;
		for(Iterator<Integer> i = snum.iterator(); i.hasNext(); ) {
			  if(i.next().equals(xnum.get(j))){
				  ((ImageView) findViewById(buttonid[j])).setImageBitmap(dt.draw(context, R.drawable.blockt, xnum.get(j).toString(), Color.WHITE));
				  
			  }else{
				  break;
			  }
			  j++;
		}


	}

	public void drawnew() {
		((ImageView) findViewById(buttonid[0])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[1])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[2])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[3])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(buttonid[4])).setImageBitmap(dt.draw(context, R.drawable.block, xnum.get(4).toString(), Color.WHITE));		
		
		((ImageView) findViewById(corsorid[0])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[1])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[2])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[3])).setBackgroundResource(R.drawable.cursoroddb);
		((ImageView) findViewById(corsorid[4])).setBackgroundResource(R.drawable.cursoroddb);		
		if(round>=4){
			round=0;
		}
		for(int i=round;i<snum.size();i++){
			if(snum.get(i).equals(xnum.get(i))){
				round++;
			}else{
				break;
			}
		}
		if(round>=4){
			round=0;
		}


		((ImageView) findViewById(corsorid[round])).setBackgroundResource(R.drawable.cursorodd);

		int j=0;
		for(Iterator<Integer> i = snum.iterator(); i.hasNext(); ) {
			  if(i.next().equals(xnum.get(j))){
				  ((ImageView) findViewById(buttonid[j])).setImageBitmap(dt.draw(context, R.drawable.blockt, xnum.get(j).toString(), Color.WHITE));
				  
			  }else{
				  break;
			  }
			  j++;
		}
		click1.clear();

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

						if(click1.size()==0){
							fault++;
							((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);
							return;
						}
						int min=xnum.get(round+1);						
						for(int i=round+1;i<xnum.size();i++){
							if(min>xnum.get(i)){
								min=xnum.get(i);
							}
						}
						if(min!=xnum.get(minindex)){
							fault++;
							((TextView) findViewById(R.id.txtfault)).setText("Faults : "+fault);
						}
							int tmp = xnum.get(round);
							xnum.set(round, xnum.get(minindex));
							xnum.set(minindex, tmp);
							round++;
							drawnew();						
							checkgame();
						

					}
				});
		((Button) findViewById(R.id.btnnoswap))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						round++;
						drawnew();
						checkgame();
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
		((ImageView) findViewById(buttonid[0])).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(round>=0)return;
				if (click1.contains(v)) {
					click1.remove(v);
					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.block, String.valueOf(xnum.get(0)),
							Color.WHITE));
				} else {
					if (click1.size()==0) {
						((ImageView) v).setImageBitmap(dt.draw(context,
								R.drawable.blockp,
								String.valueOf(xnum.get(0)), Color.WHITE));
						click1.add(v);
						minindex=0;
						Log.i("minindex",""+minindex);
					}

				}
			}
		});
		((ImageView) findViewById(buttonid[1])).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(round>=1)return;
				if (click1.contains(v)) {
					click1.remove(v);
					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.block, String.valueOf(xnum.get(1)),
							Color.WHITE));
				} else {
					if (click1.size() ==0) {
						((ImageView) v).setImageBitmap(dt.draw(context,
								R.drawable.blockp,
								String.valueOf(xnum.get(1)), Color.WHITE));
						click1.add(v);
						minindex=1;
						Log.i("minindex",""+minindex);
					}

				}
			}
		});
		((ImageView) findViewById(buttonid[2])).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(round>=2)return;
				if (click1.contains(v)) {
					click1.remove(v);
					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.block, String.valueOf(xnum.get(2)),
							Color.WHITE));
				} else {
					if (click1.size() ==0) {
						((ImageView) v).setImageBitmap(dt.draw(context,
								R.drawable.blockp,
								String.valueOf(xnum.get(2)), Color.WHITE));
						click1.add(v);
						minindex=2;
						Log.i("minindex",""+minindex);
					}

				}
			}
		});
		((ImageView) findViewById(buttonid[3])).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(round>=3)return;
				if (click1.contains(v)) {
					click1.remove(v);
					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.block, String.valueOf(xnum.get(3)),
							Color.WHITE));
				} else {
					if (click1.size() ==0) {
						((ImageView) v).setImageBitmap(dt.draw(context,
								R.drawable.blockp,
								String.valueOf(xnum.get(3)), Color.WHITE));
						click1.add(v);
						minindex=3;
						Log.i("minindex",""+minindex);
					}

				}
			}
		});
		((ImageView) findViewById(buttonid[4])).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(round>=4)return;
				if (click1.contains(v)) {
					click1.remove(v);
					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.block, String.valueOf(xnum.get(4)),
							Color.WHITE));
				} else {
					if (click1.size() ==0) {
						((ImageView) v).setImageBitmap(dt.draw(context,
								R.drawable.blockp,
								String.valueOf(xnum.get(4)), Color.WHITE));
						click1.add(v);
						minindex=4;
						Log.i("minindex",""+minindex);
					}

				}
			}
		});
	}
}
