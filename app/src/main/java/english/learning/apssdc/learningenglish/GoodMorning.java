package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class GoodMorning extends AppCompatActivity implements TextToSpeech.OnInitListener {
    Button play1;
    private TextToSpeech tts;
    private ImageButton v_speak;
    private TextView v_gm1, v_gm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_good_morning);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);

        tts = new TextToSpeech(this, this);
        v_speak = (ImageButton) findViewById(R.id.speak1);
        v_speak = (ImageButton) findViewById(R.id.speak2);
        v_gm1 = (TextView) findViewById(R.id.gm);
        v_gm2 = (TextView) findViewById(R.id.gm1);
        play1 = (Button) findViewById(R.id.play1);
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), GoodMorningYoutube.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    public void m_speak(View v) {
        switch (v.getId()) {
            case R.id.speak1:
                String text = v_gm1.getText().toString();
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

                //Toast.makeText(getApplicationContext(),"Good Morning",Toast.LENGTH_SHORT).show();
                break;
            case R.id.speak2:
                String text1 = v_gm2.getText().toString();
                tts.speak(text1, TextToSpeech.QUEUE_FLUSH, null);

//            Toast.makeText(getApplicationContext(),"Hello!!Good Morning",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void next(View v) {
        Intent i = new Intent(getApplicationContext(), GoodAfternoon.class);
        startActivity(i);
    }


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                v_speak.setEnabled(true);
                //speakOut();

            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }



    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
