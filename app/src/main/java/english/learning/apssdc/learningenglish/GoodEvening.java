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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class GoodEvening extends AppCompatActivity implements TextToSpeech.OnInitListener{
private TextToSpeech tts;
    private ImageButton ib_ge;

  private  TextView tv_ge,tv_ge1,tv_ge2,tv_ge3,tv_ge4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_good_evening);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        tts = new TextToSpeech(this, this);
        ib_ge=(ImageButton)findViewById(R.id.ib1_ge);
        ib_ge=(ImageButton)findViewById(R.id.ib2_ge);
        ib_ge=(ImageButton)findViewById(R.id.ib3_ge);
        ib_ge=(ImageButton)findViewById(R.id.ib4_ge);
        tv_ge=(TextView)findViewById(R.id.ge);
        tv_ge1=(TextView)findViewById(R.id.ge1);
        tv_ge2=(TextView)findViewById(R.id.ge2);
        tv_ge3=(TextView)findViewById(R.id.ge3);

    }
    public void m_speak(View v){
        switch (v.getId()){
            case R.id.ib1_ge:
                String text1=tv_ge.getText().toString();
                tts.speak(text1,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib2_ge:
                String text2=tv_ge1.getText().toString();
                tts.speak(text2,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib3_ge:
                String text3=tv_ge2.getText().toString();
                tts.speak(text3,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.ib4_ge:
                String text4=tv_ge3.getText().toString();
                tts.speak(text4,TextToSpeech.QUEUE_FLUSH,null);
                break;
        }
    }
    public void next(View v){

        Intent i=new Intent(getApplicationContext(),Introduction.class);
        startActivity(i);
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
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                ib_ge.setEnabled(true);
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
