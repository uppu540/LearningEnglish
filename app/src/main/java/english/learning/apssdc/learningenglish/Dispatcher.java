package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Dispatcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(prefs.getString("lastActivity", LoginActivity.class.getName()));
            Toast.makeText(getApplicationContext(), "Resuming your Progress", Toast.LENGTH_LONG).show();
        } catch(ClassNotFoundException ex) {
            activityClass = LoginActivity.class;
        }

        startActivity(new Intent(this, activityClass));
    }
}
