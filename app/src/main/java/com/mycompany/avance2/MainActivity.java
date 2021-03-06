package com.mycompany.avance2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ViewFlipper;


public class MainActivity extends Activity {
    private ViewFlipper viewFlipper;
    private float InitialX;
    private float FinalX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch(touchevent.getAction() )
        {
            case MotionEvent.ACTION_DOWN:
                InitialX=touchevent.getX();
                break;

            case MotionEvent.ACTION_UP:
                FinalX=touchevent.getX();
                if(InitialX<FinalX)
                {
                    viewFlipper.showPrevious();
                }
                if(InitialX>FinalX)
                {
                    viewFlipper.showNext();
                }
                break;
            default:
        }

        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
