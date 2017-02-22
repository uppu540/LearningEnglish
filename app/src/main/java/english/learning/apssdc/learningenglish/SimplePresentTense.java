package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

public class SimplePresentTense extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextToSpeech tts;
    static final int TTS_REQUEST_CODE = 1234;
    String string_spt1,string_spt2,string_spt3,string_spt4,string_spt5;
    WebView webView1;
    TextView tv1,spt1,spt2,spt3,spt4,spt5;
    Button b1;
    String[] spt_ex1,spt_ex2,spt_ex3,spt_ex4,spt_ex5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_simple_present_tense);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        webView1= (WebView) findViewById(R.id.web_view);
        tv1=(TextView)findViewById(R.id.simplePresent);
        spt1=(TextView)findViewById(R.id.spt1);
        spt2=(TextView)findViewById(R.id.spt2);
        spt3=(TextView)findViewById(R.id.spt3);
        spt4=(TextView)findViewById(R.id.spt4);
        spt5=(TextView)findViewById(R.id.spt5);
string_spt1="I take the bus to school every day.";
        string_spt2="I wake up at 7:30 in the morning.";
        string_spt3="I like to eat dosa and chutney.";
        string_spt4="My mother helps me with my homework in the evening.";
        string_spt5="I cut a cake on my birthday.";
        spt1.setText(string_spt1);
        spt2.setText(string_spt2);
        spt3.setText(string_spt3);
        spt4.setText(string_spt4);
        spt5.setText(string_spt5);
        webView1.loadUrl("file:///android_asset/text2.html");
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);
        b1=(Button)findViewById(R.id.SimplePresentButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CorrectTheSentences.class);
                startActivity(i);
            }
        });

        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, TTS_REQUEST_CODE);
    }
    public void getVoice(View v) {
        spt_ex1 = new String[]{"I take"," the bus", "to school","every day","" };
        spt_ex2 = new String[]{"I wake up"," at 7:30"," in the ","morning","" };
        spt_ex3 = new String[]{"I like"," to eat"," dosa"," and chutney","" };
        spt_ex4 = new String[]{"My mother"," helps me ","with"," my homework"," in the evening" ,""};
        spt_ex5 = new String[]{"I cut"," a cake"," on"," my birthday","" };

        for (int i = 0; i < spt_ex1.length; i++) {
            speak(spt_ex1[i]);
        }
        for (int i = 0; i < spt_ex2.length; i++) {
            speak(spt_ex2[i]);
        }
        for (int i = 0; i < spt_ex3.length; i++) {
            speak(spt_ex3[i]);
        }
        for (int i = 0; i < spt_ex4.length; i++) {
            speak(spt_ex4[i]);
        }
        for (int i = 0; i < spt_ex5.length; i++) {
            speak(spt_ex5[i]);
        }


    }

    private void speak(String s) {
        HashMap<String, String> params = new HashMap<String, String>();
        //use the actual text as the key to ID the utterance
        params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, s);
        tts.speak(s, TextToSpeech.QUEUE_ADD, params);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.US);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (TTS_REQUEST_CODE == requestCode) {
            if (TextToSpeech.Engine.CHECK_VOICE_DATA_PASS == resultCode) {
                tts = new TextToSpeech(this, this);
                tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                    @Override
                    public void onStart(final String utteranceId) {
SimplePresentTense.this.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < spt_ex1.length; i++) {
            if (utteranceId.equals(spt_ex1[i])) {
                String subString = spt_ex1[i];
                if (string_spt1.contains(subString)) {
                    int startIndex1 = string_spt1.indexOf(subString);
                    int endIndex1 = startIndex1 + subString.length();
                    SpannableString spannableString = new SpannableString(string_spt1);
                    spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spt1.setText(spannableString);
                }
            }
        }
        for (int i = 0; i < spt_ex2.length; i++) {
            if (utteranceId.equals(spt_ex2[i])) {
                String subString = spt_ex2[i];
                if (string_spt2.contains(subString)) {
                    int startIndex2 = string_spt2.indexOf(subString);
                    int endIndex2 = startIndex2 + subString.length();
                    SpannableString spannableString = new SpannableString(string_spt2);
                    spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex2, endIndex2,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spt2.setText(spannableString);
                }
            }
        }
        for (int i = 0; i < spt_ex3.length; i++) {
            if (utteranceId.equals(spt_ex3[i])) {
                String subString = spt_ex3[i];
                if (string_spt3.contains(subString)) {
                    int startIndex3 = string_spt3.indexOf(subString);
                    int endIndex3 = startIndex3 + subString.length();
                    SpannableString spannableString = new SpannableString(string_spt3);
                    spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex3, endIndex3,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spt3.setText(spannableString);
                }
            }
        }
        for (int i = 0; i < spt_ex4.length; i++) {
            if (utteranceId.equals(spt_ex4[i])) {
                String subString = spt_ex4[i];
                if (string_spt4.contains(subString)) {
                    int startIndex4 = string_spt4.indexOf(subString);
                    int endIndex4 = startIndex4 + subString.length();
                    SpannableString spannableString = new SpannableString(string_spt4);
                    spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex4, endIndex4,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spt4.setText(spannableString);
                }
            }
        }
        for (int i = 0; i < spt_ex5.length; i++) {
            if (utteranceId.equals(spt_ex5[i])) {
                String subString = spt_ex5[i];
                if (string_spt5.contains(subString)) {
                    int startIndex5 = string_spt5.indexOf(subString);
                    int endIndex5 = startIndex5 + subString.length();
                    SpannableString spannableString = new SpannableString(string_spt5);
                    spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex5, endIndex5,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spt5.setText(spannableString);
                }
            }
        }

        }
});
                    }

                    @Override
                    public void onDone(String utteranceId) {

                    }

                    @Override
                    public void onError(String utteranceId) {

                    }
                });
            }
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
    public void onDestroy() {
        // Don't forget to shutdown!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
