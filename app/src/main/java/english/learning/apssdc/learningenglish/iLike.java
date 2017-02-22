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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Sharp on 18-Feb-17.
 */

public class iLike  extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextToSpeech tts;
    static final int TTS_REQUEST_CODE = 1234;
    String string_like,string_like1,string_like2,string_like3,string_like4,string_like5,string_like6,string_like7,string_like8;
    WebView webView1;
    TextView tv1,ilike1,ilike2,ilike3,ilike4,ilike5,ilike6,ilike7,ilike8;
    Button b1;
    String[] ilike_ex1,ilike_ex2,ilike_ex3,ilike_ex4,ilike_ex5,ilike_ex6,ilike_ex7,ilike_ex8,ilike_ex9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_simple_present_tense);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        webView1= (WebView) findViewById(R.id.web_view);
        tv1=(TextView)findViewById(R.id.ilike);
        ilike1=(TextView)findViewById(R.id.ilike1);
        ilike2=(TextView)findViewById(R.id.ilike2);
        ilike3=(TextView)findViewById(R.id.ilike3);
        ilike4=(TextView)findViewById(R.id.ilike4);
        ilike5=(TextView)findViewById(R.id.ilike5);
        ilike6=(TextView)findViewById(R.id.ilike6);
        ilike7=(TextView)findViewById(R.id.ilike7);
        ilike8=(TextView)findViewById(R.id.ilike8);

        string_like="When we like something we say,";
        string_like1="I Like....";
        string_like2="When we don’t like something we say,";
        string_like3="I don’t like . . .";
        string_like4="For instance :";
        string_like5="I like to wear skirt and top";
        string_like6="I don’t like to wear salwar kameez.";
        string_like7="I like to eat mutton biryani.";
        string_like8="I don’t like to eat chicken.";

        ilike1.setText(string_like);
        ilike2.setText(string_like1);
        ilike3.setText(string_like2);
        ilike4.setText(string_like3);
        ilike5.setText(string_like4);
        ilike6.setText(string_like5);
        ilike7.setText(string_like6);
        ilike8.setText(string_like7);


        webView1.loadUrl("file:///android_asset/text2.html");
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);
        b1=(Button)findViewById(R.id.SimplePresentButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),EndScreen.class);
                startActivity(i);
            }
        });

        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, TTS_REQUEST_CODE);
    }
    public void getVoice(View v) {
        ilike_ex1 = new String[]{"When we","like something", "we say","" };
        ilike_ex2 = new String[]{"I like","" };
        ilike_ex3 = new String[]{"When we"," don’t like"," something"," we say","" };
        ilike_ex4 = new String[]{"I don’t","like" ,""};
        ilike_ex5 = new String[]{"For"," instance","" };
        ilike_ex6 = new String[]{"I don’t like","to wear","skirt and","top","" };
        ilike_ex7 = new String[]{"I like","to wear","salwar","kameez","" };
        ilike_ex8 = new String[]{"I like","to eat","Mutton","Biryani","" };
        ilike_ex9 = new String[]{"I don’t like","to eat","Chicken","Biryani","" };


        for (int i = 0; i < ilike_ex1.length; i++) {
            speak(ilike_ex1[i]);
        }
        for (int i = 0; i < ilike_ex2.length; i++) {
            speak(ilike_ex2[i]);
        }
        for (int i = 0; i < ilike_ex3.length; i++) {
            speak(ilike_ex3[i]);
        }
        for (int i = 0; i < ilike_ex4.length; i++) {
            speak(ilike_ex4[i]);
        }
        for (int i = 0; i < ilike_ex5.length; i++) {
            speak(ilike_ex5[i]);
        }
        for (int i = 0; i < ilike_ex6.length; i++) {
            speak(ilike_ex6[i]);
        }
        for (int i = 0; i < ilike_ex7.length; i++) {
            speak(ilike_ex7[i]);
        }
        for (int i = 0; i < ilike_ex8.length; i++) {
            speak(ilike_ex8[i]);
        }
        for (int i = 0; i < ilike_ex9.length; i++) {
            speak(ilike_ex9[i]);
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
                        iLike.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < ilike_ex1.length; i++) {
                                    if (utteranceId.equals(ilike_ex1[i])) {
                                        String subString = ilike_ex1[i];
                                        if (string_like.contains(subString)) {
                                            int startIndex1 = string_like.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(string_like);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            ilike1.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < ilike_ex2.length; i++) {
                                    if (utteranceId.equals(ilike_ex2[i])) {
                                        String subString = ilike_ex2[i];
                                        if (string_like1.contains(subString)) {
                                            int startIndex2 = string_like1.indexOf(subString);
                                            int endIndex2 = startIndex2 + subString.length();
                                            SpannableString spannableString = new SpannableString(string_like1);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex2, endIndex2,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            ilike2.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < ilike_ex3.length; i++) {
                                    if (utteranceId.equals(ilike_ex3[i])) {
                                        String subString = ilike_ex3[i];
                                        if (string_like2.contains(subString)) {
                                            int startIndex3 = string_like2.indexOf(subString);
                                            int endIndex3 = startIndex3 + subString.length();
                                            SpannableString spannableString = new SpannableString(string_like2);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex3, endIndex3,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            ilike3.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < ilike_ex4.length; i++) {
                                    if (utteranceId.equals(ilike_ex4[i])) {
                                        String subString = ilike_ex4[i];
                                        if (string_like3.contains(subString)) {
                                            int startIndex4 = string_like3.indexOf(subString);
                                            int endIndex4 = startIndex4 + subString.length();
                                            SpannableString spannableString = new SpannableString(string_like3);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex4, endIndex4,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            ilike4.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < ilike_ex5.length; i++) {
                                    if (utteranceId.equals(ilike_ex5[i])) {
                                        String subString = ilike_ex5[i];
                                        if (string_like4.contains(subString)) {
                                            int startIndex5 = string_like4.indexOf(subString);
                                            int endIndex5 = startIndex5 + subString.length();
                                            SpannableString spannableString = new SpannableString(string_like4);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex5, endIndex5,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            ilike5.setText(spannableString);
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

