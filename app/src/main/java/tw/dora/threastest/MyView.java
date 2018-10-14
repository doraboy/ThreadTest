package tw.dora.threastest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {
    private Resources res;
    private float viewW, viewH, ballW, ballH, ballX, ballY, dx, dy;
    private boolean isInit;
    private Bitmap ballBmp;
    private Timer timer;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        res = context.getResources();
        timer = new Timer();
        timer.schedule(new BallTask(),1000,16);
    }

    private void init(){
        isInit = !isInit;
        viewW = getWidth(); viewH = getHeight();
        //Log.v("brad",viewW + " x "+viewH);
        ballW = viewW / 8; ballH = ballW;
        dx = viewW / 64; dy = dx;


        ballBmp = BitmapFactory.decodeResource(res, R.drawable.ball);

        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postScale(ballW/ballBmp.getWidth(),
                        ballH/ballBmp.getHeight());

        ballBmp = Bitmap.createBitmap(ballBmp, 0, 0,
                    ballBmp.getWidth(),ballBmp.getHeight(),
                    matrix,false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isInit) init();

        canvas.drawBitmap(ballBmp, ballX, ballY, null);

    }

    private class BallTask extends TimerTask {
        @Override
        public void run() {
            if(ballX<0 || ballX+ballW>viewW){
                dx *= -1;
            }
            if(ballY<0 || ballY+ballH>viewH){
                dy *= -1;
            }

            ballX += dx;
            ballY += dy;
            invalidate();
        }
    }

}