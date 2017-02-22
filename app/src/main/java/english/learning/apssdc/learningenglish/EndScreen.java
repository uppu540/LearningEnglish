package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.end_screen);

        ImageView iv = (ImageView) findViewById(R.id.imageya);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        iv.startAnimation(animation);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("lastActivity", "LoginActivity.class");
                editor.commit();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }

        }, 4000);
    }
}
