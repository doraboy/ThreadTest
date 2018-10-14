package tw.dora.threastest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }

    public void doThread1(View view) {
        for (int i=0;i<20;i++){
            Log.v("brad","i = "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
