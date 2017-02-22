package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.Timer;
import java.util.TimerTask;

public class BasicSplashTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_basic_splash_two);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {

                Intent i =new Intent(getApplicationContext(),IntroduceYourself.class);
                startActivity(i);
            }

        }, 1500);
    }

    /*@Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
