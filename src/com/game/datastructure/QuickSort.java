package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;

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

public class QuickSort extends Activity {
	int[] corsorid = new int[10];
	int[] buttonid = new int[10];
	int[] sbtn = new int[11];
	int fault = 0, pivot;
	ArrayList<View> click2 = new ArrayList<View>();
	ArrayList<Integer> buttons = new ArrayList<Integer>();
	ArrayList<Object> anumber = new ArrayList<Object>();
	private Context context = QuickSort.this;
	drawTextToBitmap dt = new drawTextToBitmap();
	ArrayList<Integer> anum, snum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_quick_sort);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		corsorid[0] = R.id.cursor;
		corsorid[1] = R.id.cursor2;
		corsorid[2] = R.id.cursor3;
		corsorid[3] = R.id.cursor4;
		corsorid[4] = R.id.cursor5;
		corsorid[5] = R.id.cursor6;
		corsorid[6] = R.id.cursor7;
		corsorid[7] = R.id.cursor8;
		corsorid[8] = R.id.cursor9;
		corsorid[9] = R.id.cursor10;
		buttonid[0] = R.id.btn1;
		buttonid[1] = R.id.btn2;
		buttonid[2] = R.id.btn3;
		buttonid[3] = R.id.btn4;
		buttonid[4] = R.id.btn5;
		buttonid[5] = R.id.btn6;
		buttonid[6] = R.id.btn7;
		buttonid[7] = R.id.btn8;
		buttonid[8] = R.id.btn9;
		buttonid[9] = R.id.btn10;
		newgame();
		event();
	}

	protected void newgame() {
		anum = rannum();
		for (int i = 0; i <= 9; i++) {
			((ImageView) findViewById(buttonid[i])).setImageBitmap(dt.draw(
					context, R.drawable.block32, anum.get(i).toString(),
					Color.WHITE));
			((ImageView) findViewById(corsorid[i]))
					.setBackgroundResource(R.drawable.cursorpivotb);
		}
		for(int i = 0; i < sbtn.length ; i=i+1) {
	         sbtn[i]=0;
	      }
		snum = new ArrayList<Integer>(anum);
		Collections.sort(snum);
		if (snum.equals(anum)) {
			newgame();
		}
		pivot = 4;
		((ImageView) findViewById(corsorid[pivot]))
				.setBackgroundResource(R.drawable.cursorpivot);
		fault = 0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : " + fault);
		click2.clear();
		buttons.clear();
	}

	protected void drawnew() {
		for (int i = 0; i <= 9; i++) {
			((ImageView) findViewById(buttonid[i])).setImageBitmap(dt.draw(
					context, R.drawable.block32, anum.get(i).toString(),
					Color.WHITE));
			((ImageView) findViewById(corsorid[i]))
					.setBackgroundResource(R.drawable.cursorpivotb);
		}
		for(int i = 0; i < sbtn.length ; i=i+1) {
	         sbtn[i]=0;
	      }
		((ImageView) findViewById(corsorid[pivot]))
				.setBackgroundResource(R.drawable.cursorpivot);
		click2.clear();
	}

	protected void event() {
		((Button) findViewById(R.id.btnswap))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {						
						buttons.clear();
							for(int i = 0; i < sbtn.length ; i++) {
								Log.i("sbtn",""+sbtn[i]);
				       	         if(sbtn[i]==1){
				       	        	buttons.add(i);	
				       	         }
				        		}
							if(buttons.size()==2){
								Collections.sort(buttons);
							int button1value=anum.get(buttons.get(0));
							int button2value=anum.get(buttons.get(1));
							int pivotvalue=anum.get(pivot);
							if(button1value>=pivotvalue && button2value<=pivotvalue){
								boolean min=true,max=true;
								
								for(int i=0;i<=pivot;i++){
				        			if(anum.get(i)>button1value){
				        				max=false;
				        				break;
				        			}
				        		}
								for(int i=pivot;i<anum.size();i++){
				        			if(anum.get(i)<button2value){
				        				min=false;
				        				break;
				        			}
				        		}
								if(min & max){
									int tmp=button1value;
									anum.set(buttons.get(0), button2value);
									anum.set(buttons.get(1), tmp);
								}else{
									fault++;
									((TextView) findViewById(R.id.txtfault))
									.setText("Faults : " + fault);
								}
							}else{
								fault++;
								((TextView) findViewById(R.id.txtfault))
								.setText("Faults : " + fault);
							}
							}else{
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
		((ImageView) findViewById(buttonid[0])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,0);
			}
		});
		((ImageView) findViewById(buttonid[1])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,1);
			}
		});
		((ImageView) findViewById(buttonid[2])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,2);
			}
		});
		((ImageView) findViewById(buttonid[3])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,3);
			}
		});
		((ImageView) findViewById(buttonid[4])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,4);
			}
		});
		((ImageView) findViewById(buttonid[5])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,5);
			}
		});
		((ImageView) findViewById(buttonid[6])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,6);
			}
		});
		((ImageView) findViewById(buttonid[7])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,7);
			}
		});
		((ImageView) findViewById(buttonid[8])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,8);
			}
		});
		((ImageView) findViewById(buttonid[9])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickbutton(v,9);
			}
		});
		((ImageView) findViewById(corsorid[0])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,0);
			}
		});
		((ImageView) findViewById(corsorid[1])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,1);
			}
		});
		((ImageView) findViewById(corsorid[2])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,2);
			}
		});
		((ImageView) findViewById(corsorid[3])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,3);
			}
		});
		((ImageView) findViewById(corsorid[4])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,4);
			}
		});
		((ImageView) findViewById(corsorid[5])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,5);
			}
		});
		((ImageView) findViewById(corsorid[6])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,6);
			}
		});
		((ImageView) findViewById(corsorid[7])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,7);
			}
		});
		((ImageView) findViewById(corsorid[8])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,8);
			}
		});
		((ImageView) findViewById(corsorid[9])).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickpivot(v,9);
			}
		});
	}

	public ArrayList<Integer> rannum() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers;
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
		} else if (snum.equals(anum)) {
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

	protected void clickbutton(View v, int id) {
		if (click2.contains(v)) {
			click2.remove(v);
			((ImageView) v).setImageBitmap(dt.draw(context, R.drawable.block32,
					anum.get(id).toString(), Color.WHITE));
			sbtn[id]=0;
		} else {
			if (click2.size() < 2) {

				((ImageView) v).setImageBitmap(dt.draw(context,
						R.drawable.blockp32, anum.get(id).toString(),
						Color.WHITE));
				click2.add(v);
				
			}
			sbtn[id]=1;

		}
	}

	protected void clickpivot(View v, int id) {
		for (int i = 0; i <= 9; i++) {
			((ImageView) findViewById(corsorid[i]))
					.setBackgroundResource(R.drawable.cursorpivotb);
		}
		((ImageView) v).setBackgroundResource(R.drawable.cursorpivot);
		pivot = id;

	}
}
