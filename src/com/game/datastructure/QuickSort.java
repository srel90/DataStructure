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
import android.view.Menu;
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
	int fault = 0, pivot = 4;
	ArrayList<View> click2 = new ArrayList<View>();
	ArrayList<Integer> buttons = new ArrayList<Integer>();
	ArrayList<Object> anumber = new ArrayList<Object>();
	private Context context = QuickSort.this;
	drawTextToBitmap dt = new drawTextToBitmap();
	ArrayList<Integer> anum, snum;
	private ButtonListener buttonListener;
	Quicksort sorter = new Quicksort();

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
		((ImageView) findViewById(buttonid[0])).setId(0);
		((ImageView) findViewById(buttonid[1])).setId(1);
		((ImageView) findViewById(buttonid[2])).setId(2);
		((ImageView) findViewById(buttonid[3])).setId(3);
		((ImageView) findViewById(buttonid[4])).setId(4);
		((ImageView) findViewById(buttonid[5])).setId(5);
		((ImageView) findViewById(buttonid[6])).setId(6);
		((ImageView) findViewById(buttonid[7])).setId(7);
		((ImageView) findViewById(buttonid[8])).setId(8);
		((ImageView) findViewById(buttonid[9])).setId(9);
		buttonListener = new ButtonListener();
		newgame();
		event();
	}

	protected void newgame() {
		anum = rannum();
		
		
		int[] numbers=new int[anum.size()];
		for(int i=0;i<anum.size();i++){
		numbers[i]=anum.get(i);
		}
		sorter.sort(numbers);
		for(int i=0;i<anumber.size();i++){
		Log.v("anumber",""+anumber.get(i).toString());	
		}
		

		((ImageView) findViewById(0)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(1)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(2)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(3)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(4)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(4).toString(), Color.WHITE));
		((ImageView) findViewById(5)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(5).toString(), Color.WHITE));
		((ImageView) findViewById(6)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(6).toString(), Color.WHITE));
		((ImageView) findViewById(7)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(7).toString(), Color.WHITE));
		((ImageView) findViewById(8)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(8).toString(), Color.WHITE));
		((ImageView) findViewById(9)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(9).toString(), Color.WHITE));
		((ImageView) findViewById(0))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(1))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(2))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(3))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(4))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(5))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(6))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(7))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(8))
				.setOnClickListener(buttonListener);
		((ImageView) findViewById(9))
				.setOnClickListener(buttonListener);

		snum = new ArrayList<Integer>(anum);
		Collections.sort(snum);
		if (snum.equals(anum)) {
			newgame();
		}

		((ImageView) findViewById(corsorid[0]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[1]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[2]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[3]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[4]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[5]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[6]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[7]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[8]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[9]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		
		((ImageView) findViewById(corsorid[pivot]))
		.setBackgroundResource(R.drawable.cursorpivot);

		fault = 0;
		((TextView) findViewById(R.id.txtfault)).setText("Faults : " + fault);
		
		click2.clear();
	}

	protected void drawnew() {
		((ImageView) findViewById(0)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(0).toString(), Color.WHITE));
		((ImageView) findViewById(1)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(1).toString(), Color.WHITE));
		((ImageView) findViewById(2)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(2).toString(), Color.WHITE));
		((ImageView) findViewById(3)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(3).toString(), Color.WHITE));
		((ImageView) findViewById(4)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(4).toString(), Color.WHITE));
		((ImageView) findViewById(5)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(5).toString(), Color.WHITE));
		((ImageView) findViewById(6)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(6).toString(), Color.WHITE));
		((ImageView) findViewById(7)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(7).toString(), Color.WHITE));
		((ImageView) findViewById(8)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(8).toString(), Color.WHITE));
		((ImageView) findViewById(9)).setImageBitmap(dt.draw(context,
				R.drawable.block32, anum.get(9).toString(), Color.WHITE));

		((ImageView) findViewById(corsorid[0]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[1]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[2]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[3]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[4]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[5]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[6]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[7]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[8]))
				.setBackgroundResource(R.drawable.cursorpivotb);
		((ImageView) findViewById(corsorid[9]))
				.setBackgroundResource(R.drawable.cursorpivotb);

		((ImageView) findViewById(corsorid[pivot]))
		.setBackgroundResource(R.drawable.cursorpivot);
		click2.clear();
	}

	protected void event() {
		((Button) findViewById(R.id.btnswap))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {						
						if (click2.size() == 2) {
							buttons.clear();
							buttons.add(click2.get(0).getId());
							buttons.add(click2.get(1).getId());
							Collections.sort(buttons);
							int button1value=anum.get(buttons.get(0));
							int button2value=anum.get(buttons.get(1));
							int pivotvalue=anum.get(pivot);

							if (button2value <= pivotvalue) {
								
//								Log.i("button1value",""+button1value);
//								Log.i("button2value",""+button2value);
//								Log.i("pivotvalue",""+pivotvalue);
//								if(button1value>=pivotvalue && button2value<=pivotvalue){
//									boolean min=true,max=true;
//									
//									for(int i=0;i<pivot;i++){
//					        			if(anum.get(i)>button1value){
//					        				max=false;
//					        				break;
//					        			}
//					        		}
//									for(int i=pivot;i<anum.size();i++){
//					        			if(anum.get(i)<button2value){
//					        				min=false;
//					        				break;
//					        			}
//					        		}
//									Log.i("min",""+min);
//									Log.i("max",""+max);
//									if(min & max){
										int tmp=anum.get(buttons.get(0));
										anum.set(buttons.get(0), anum.get(buttons.get(1)));
										anum.set(buttons.get(1), tmp);
//										if(buttons.get(0)==pivot){
//											pivot=buttons.get(1);
//										}else if(buttons.get(1)==pivot){
//											pivot=buttons.get(0);
//										}

										drawnew();
										checkgame();
//									}else{
//										fault++;
//										((TextView) findViewById(R.id.txtfault))
//												.setText("Faults : " + fault);
//									}
//								}else{
//									fault++;
//									((TextView) findViewById(R.id.txtfault))
//											.setText("Faults : " + fault);
//								}
								
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

	public ArrayList<Integer> rannum() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers;
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
		}else if(snum.equals(anum)) {
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

	class ButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (click2.contains(v)) {
				click2.remove(v);
				((ImageView) v).setImageBitmap(dt.draw(context,
						R.drawable.block32, anum.get(v.getId()).toString(),
						Color.WHITE));
			} else {
				if (click2.size() != 2) {

					((ImageView) v).setImageBitmap(dt.draw(context,
							R.drawable.blockp32,
							anum.get(v.getId()).toString(), Color.WHITE));
					click2.add(v);
				}

			}

		}
	}
	class Quicksort  {
		  public int[] numbers;
		  public int number;
		  public int pivots;

		  public void sort(int[] values) {
		    // Check for empty or null array
		    if (values ==null || values.length==0){
		      return;
		    }
		    this.numbers = values;
		    number = values.length;
		    quicksort(0, number - 1);
		    for (int i = 0; i < numbers.length; i++) {
		        Log.i("numbers",""+numbers[i]);
		      }

		  }

		  private void quicksort(int low, int high) {
		    int i = low, j = high;
		    // Get the pivot element from the middle of the list
		    int pivot = numbers[low + (high-low)/2];
		    pivots=low + (high-low)/2;
		    Log.i("pivots",""+pivots);

		    // Divide into two lists
		    while (i <= j) {
		      // If the current value from the left list is smaller then the pivot
		      // element then get the next element from the left list
		      while (numbers[i] < pivot) {
		        i++;
		      }
		      // If the current value from the right list is larger then the pivot
		      // element then get the next element from the right list
		      while (numbers[j] > pivot) {
		        j--;
		      }

		      // If we have found a values in the left list which is larger then
		      // the pivot element and if we have found a value in the right list
		      // which is smaller then the pivot element then we exchange the
		      // values.
		      // As we are done we can increase i and j
		      if (i <= j) {
		        exchange(i, j);
		        i++;
		        j--;
		      }
		    }
		    anumber.add(numbers);
		    // Recursion
		    if (low < j)
		      quicksort(low, j);
		    if (i < high)
		      quicksort(i, high);
		  }

		  private void exchange(int i, int j) {
		    int temp = numbers[i];
		    numbers[i] = numbers[j];
		    numbers[j] = temp;
		  }
		} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quick_sort, menu);
		return true;
	}

}
