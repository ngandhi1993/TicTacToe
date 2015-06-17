package com.tictactoe.niravgandhi.tictactoe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by niravgandhi on 17/6/15.
 */

public class GameView extends View {
    //Properties
    private Paint paint;
    private Bitmap bitmap;
    private Point displaySize;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);

        // Get screen's width and height
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        displaySize = new Point();
        wm.getDefaultDisplay().getSize(displaySize);

        //Create BitMap as big as the entire screen of the phone.
        bitmap = Bitmap.createBitmap(displaySize.x, displaySize.y, Bitmap.Config.ARGB_8888);
        // Draw the BitMap
        canvas.drawBitmap(bitmap, 0, 0, null );

        canvas.drawLine(startX, startY, endX, endY, paint);
        invalidate();
    }


}
