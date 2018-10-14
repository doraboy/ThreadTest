package tw.dora.threastest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Resources res;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        res = context.getResources();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bmp = BitmapFactory.decodeResource(
                res, R.drawable.ball);

        canvas.drawBitmap(bmp, 0, 0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }
}