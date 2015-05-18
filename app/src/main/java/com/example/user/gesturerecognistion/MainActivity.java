package com.example.user.gesturerecognistion;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Detect touched area
        detector = new SimpleGestureFilter(this, this);
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        Intent intent;
        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT:
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, A.class);
                intent.putExtra("T", "Right");
                startActivity(intent);

                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;

            case SimpleGestureFilter.SWIPE_LEFT:
                Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, A.class);
                intent.putExtra("T", "Left");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, A.class);
                intent.putExtra("T", "Down");
                startActivity(intent);
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                break;
            case SimpleGestureFilter.SWIPE_UP:
                Toast.makeText(this, "UP", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, A.class);
                intent.putExtra("T", "UP");
                startActivity(intent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
                break;

        }
    }

    @Override
    public void onDoubleTap() {

    }
}
