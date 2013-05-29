package com.game.datastructure;

import java.util.ArrayList;
import java.util.Collections;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class DrawView extends View {
	private ColorBall[] colorballs = new ColorBall[5];
	private int balID = 0;
	Rect[] destinationRect = new Rect[5];
	Point source = new Point();
	Point target = new Point();
	Point point1 = new Point();
	Point point2 = new Point();
	Point point3 = new Point();
	Point point4 = new Point();
	Point point5 = new Point();
	int fault = 0;
	ArrayList<Integer> anum = new ArrayList<Integer>();
	ArrayList<Integer> xnum = new ArrayList<Integer>();
	ArrayList<Integer> snum = new ArrayList<Integer>();
	boolean moved = false;

	public DrawView(Context context) {
		super(context);
		setFocusable(true);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
	    Display display = wm.getDefaultDisplay();
	    @SuppressWarnings("deprecation")
		int width = display.getWidth();
        int xoffset=(width-350)/2;


		point1.x = xoffset;
		point1.y = 100;

		point2.x = xoffset+70;
		point2.y = 100;

		point3.x = xoffset+140;
		point3.y = 100;

		point4.x = xoffset+210;
		point4.y = 100;

		point5.x = xoffset+280;
		point5.y = 100;

		snum = ((InsertSort) getContext()).rannum();
		anum.add(snum.get(0));
		anum.add(snum.get(1));
		anum.add(snum.get(2));
		anum.add(snum.get(3));
		anum.add(snum.get(4));

		xnum.add(snum.get(0));
		xnum.add(snum.get(1));
		xnum.add(snum.get(2));
		xnum.add(snum.get(3));
		xnum.add(snum.get(4));
		Collections.sort(xnum);

		if (anum.equals(xnum)) {
			drawnew();
		}

		drawTextToBitmap dt = new drawTextToBitmap();
		ColorBall.count = 1;
		colorballs[0] = new ColorBall(context, dt.draw(context,
				R.drawable.block, anum.get(0).toString(), Color.WHITE), point1);
		colorballs[1] = new ColorBall(context, dt.draw(context,
				R.drawable.block, anum.get(1).toString(), Color.WHITE), point2);
		colorballs[2] = new ColorBall(context, dt.draw(context,
				R.drawable.block, anum.get(2).toString(), Color.WHITE), point3);
		colorballs[3] = new ColorBall(context, dt.draw(context,
				R.drawable.block, anum.get(3).toString(), Color.WHITE), point4);
		colorballs[4] = new ColorBall(context, dt.draw(context,
				R.drawable.block, anum.get(4).toString(), Color.WHITE), point5);

		TextView txtfault = (TextView) ((InsertSort) getContext())
				.findViewById(R.id.txtfault);
		txtfault.setText("Faults : " + fault);

	}

	private void drawnew() {
		// anum=((InsertSort)getContext()).rannum();
		// fault=0;
		// drawTextToBitmap dt=new drawTextToBitmap();
		// ColorBall.count=1;
		// colorballs[0] = new ColorBall(getContext(),dt.draw(getContext(),
		// R.drawable.block, anum.get(0).toString(), Color.WHITE), point1);
		// colorballs[1] = new ColorBall(getContext(),dt.draw(getContext(),
		// R.drawable.block, anum.get(1).toString(), Color.WHITE), point2);
		// colorballs[2] = new ColorBall(getContext(),dt.draw(getContext(),
		// R.drawable.block, anum.get(2).toString(), Color.WHITE), point3);
		// colorballs[3] = new ColorBall(getContext(),dt.draw(getContext(),
		// R.drawable.block, anum.get(3).toString(), Color.WHITE), point4);
		// colorballs[4] = new ColorBall(getContext(),dt.draw(getContext(),
		// R.drawable.block, anum.get(4).toString(), Color.WHITE), point5);
		invalidate();

	}

	// the method that draws the balls
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
	    Display display = wm.getDefaultDisplay();
	    @SuppressWarnings("deprecation")
		int width = display.getWidth();
        int xOffset=(width-350)/2;
        
		int squareWidth = 70;
		int squareHeight = 65;

		//int xOffset = 70;
		int yOffset = 100;
//		Paint myPaint = new Paint();
//        myPaint.setColor(Color.GREEN);
//        myPaint.setStrokeWidth(3);        
//        myPaint.setStyle(Paint.Style.STROKE);

		for (int i = 0; i < 5; i++) {
			destinationRect[i] = new Rect();
			destinationRect[i].set(0, 0, squareWidth, squareHeight);
			destinationRect[i].offsetTo(xOffset, yOffset);
//			canvas.drawRect(destinationRect[i], myPaint);
			xOffset += squareWidth;
		}

		for (ColorBall ball : colorballs) {
			canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(), null);
		}
	}

	// events when touching the screen
	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();

		int X = (int) event.getX();
		int Y = (int) event.getY();

		switch (eventaction) {

		case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on
										// a ball
			balID = 0;

			for (ColorBall ball : colorballs) {

				// check all the bounds of the ball (square)
				if (X > ball.getX() && X < ball.getX() + 70 && Y > ball.getY()
						&& Y < ball.getY() + 65) {
					balID = ball.getID();
					source.x = ball.getX();
					source.y = ball.getY();
					break;
				}
			}

			break;

		case MotionEvent.ACTION_MOVE: // touch drag with the ball
			// move the balls the same as the finger
			if (balID > 0) {
				// Log.i("ballID",""+balID);
				colorballs[balID - 1].setX(X - 35);
				colorballs[balID - 1].setY(Y - 32);
				target.x = X - 35;
				target.y = Y - 32;
				moved = true;
			}

			break;

		case MotionEvent.ACTION_UP:
			// touch drop - just do things here after dropping
			if (balID > 0 && moved) {
				for (int i = 0; i < destinationRect.length; i++) {
					if (target.x >= destinationRect[i].left
							&& target.x <= destinationRect[i].right
							&& target.y >= destinationRect[i].top
							&& target.y <= destinationRect[i].bottom) {

						if (i != 0) {
							if (anum.get(i - 1) > anum.get(balID - 1)) {
								fault = fault + 1;
								TextView txtfault = (TextView) ((InsertSort) getContext())
										.findViewById(R.id.txtfault);
								txtfault.setText("Faults : " + fault);
								if (fault >= 3) {
									((InsertSort) getContext()).lose();
								}
								// Log.i("faults",String.valueOf(fault));

							}
						}else{
						if (anum.get(balID - 1) != xnum.get(0)) {
							fault = fault + 1;
							TextView txtfault = (TextView) ((InsertSort) getContext())
									.findViewById(R.id.txtfault);
							txtfault.setText("Faults : " + fault);
							if (fault >= 3) {
								((InsertSort) getContext()).lose();
							}
						}
						}

						int tmp = anum.get(balID - 1);
						anum.remove(balID - 1);
						anum.add(i, tmp);
						ColorBall.count = 1;
						drawTextToBitmap dt = new drawTextToBitmap();
						colorballs[0] = new ColorBall(getContext(), dt.draw(
								getContext(), R.drawable.block, anum.get(0)
										.toString(), Color.WHITE), point1);
						colorballs[1] = new ColorBall(getContext(), dt.draw(
								getContext(), R.drawable.block, anum.get(1)
										.toString(), Color.WHITE), point2);
						colorballs[2] = new ColorBall(getContext(), dt.draw(
								getContext(), R.drawable.block, anum.get(2)
										.toString(), Color.WHITE), point3);
						colorballs[3] = new ColorBall(getContext(), dt.draw(
								getContext(), R.drawable.block, anum.get(3)
										.toString(), Color.WHITE), point4);
						colorballs[4] = new ColorBall(getContext(), dt.draw(
								getContext(), R.drawable.block, anum.get(4)
										.toString(), Color.WHITE), point5);
						break;

					} else {
						colorballs[balID - 1].setX(source.x);
						colorballs[balID - 1].setY(source.y);

					}
				}
			}
			moved = false;
			if (anum.equals(xnum)) {
				((InsertSort) getContext()).win();
			}
			break;
		}
		// redraw the canvas
		invalidate();
		return true;

	}
}
