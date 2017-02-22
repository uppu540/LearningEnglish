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
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class GoodAfternoon extends AppCompatActivity implements TextToSpeech.OnInitListener{
private ImageButton Ib_speak_ga;
    private TextView tv_ga1,tv_ga2,tv_ga3,tv_ga4,tv_ga5,tv_ga6;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_good_afternoon);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        tts = new TextToSpeech(this, this);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib1_ga);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib2_ga);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib3_ga);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib4_ga);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib5_ga);
        Ib_speak_ga=(ImageButton)findViewById(R.id.ib6_ga);

        tv_ga1=(TextView)findViewById(R.id.ga);
        tv_ga2=(TextView)findViewById(R.id.ga1);
        tv_ga3=(TextView)findViewById(R.id.ga2);
        tv_ga4=(TextView)findViewById(R.id.ga3);
        tv_ga5=(TextView)findViewById(R.id.ga4);
        tv_ga6=(TextView)findViewById(R.id.ga5);
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
    public void m_speak(View v){
        switch (v.getId()){
            case R.id.ib1_ga:
                String text1=tv_ga1.getText().toString();
                tts.speak(text1,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib2_ga:
                String text2=tv_ga2.getText().toString();
                tts.speak(text2,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib3_ga:
                String text3=tv_ga3.getText().toString();
                tts.speak(text3,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib4_ga:
                String text4=tv_ga4.getText().toString();
                tts.speak(text4,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib5_ga:
                String text5=tv_ga5.getText().toString();
                tts.speak(text5,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib6_ga:
                String text6=tv_ga6.getText().toString();
                tts.speak(text6,TextToSpeech.QUEUE_FLUSH,null);
                break;

        }
    }
    public void next(View v){
        Intent i=new Intent(getApplicationContext(),GoodEvening.class);
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
                Ib_speak_ga.setEnabled(true);
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
