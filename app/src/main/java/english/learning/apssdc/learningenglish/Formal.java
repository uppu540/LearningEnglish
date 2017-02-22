package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

public class Formal extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextToSpeech tts;
    static final int TTS_REQUEST_CODE = 1234;
    Button b;
    ImageView sp;
    String[] t1,t2,t3,t4,t5,t6,t7,t8,t9;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    String tView1,tView2,tView3,tView4,tView5,tView6,tView7,tView8,tView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_formal);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        b=(Button)findViewById(R.id.formal_next_btn);
        tv1=(TextView)findViewById(R.id.textView11);
        tv2=(TextView)findViewById(R.id.textView12);
        tv3=(TextView)findViewById(R.id.textView13);
        tv4=(TextView)findViewById(R.id.textView14);
        tv5=(TextView)findViewById(R.id.textView15);
        tv6=(TextView)findViewById(R.id.textView16);
        tv7=(TextView)findViewById(R.id.textView17);
        tv8=(TextView)findViewById(R.id.textView32);
        tv9=(TextView)findViewById(R.id.textView19);

        tView1="You greet people older than you formally. These include parents, uncles, aunts, teachers, parents of friends.";
        tView2="The formal way of greeting is more polite and well mannered.";
        tView3="Phrases used for formal greetings are:";
        tView4="Good morning (for the morning, up to 12 o’clock)";
        tView5="Good afternoon (from the afternoon, up to 5 o’clock)";
        tView6="Good evening (for the rest of the evening)";
        tView7="If you are meeting someone for the first time,it is important to introduce yourself after the greeting.";
        tView8="To introduce yourself, you can use phrases like:";
        tView9="My name is ….";

        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, TTS_REQUEST_CODE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),GoodMorning.class);
                startActivity(i);
            }
        });
        sp=(ImageView)findViewById(R.id.speak);
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1=new String[]{"You greet","people","older than you","formally","These include","parents","uncles","aunts","teachers","parents of friends",""};
                t2=new String[]{"The formal way of","greeting","is","more polite","and","well mannered","",};
                t3=new String[]{"Phrases","used for","formal greetings","are",""};
                t4=new String[]{"Good morning","for the morning","up to 12 o’clock",""};
                t5=new String[]{"Good afternoon","from the afternoon","up to 5 o’clock",""};
                t6=new String[]{"Good evening","for the","rest of the evening",""};
                t7=new String[]{"If you are","meeting","someone","for the first time","it is important","to introduce","yourself","after the greeting",""};
                t8=new String[]{"To","introduce yourself","you can","use","phrases","like",""};
                t9=new String[]{"My name is",""};

                for(int i=0;i<t1.length;i++)
                {
                    speak(t1[i]);
                }
                for(int i=0;i<t2.length;i++)
                {
                    speak(t2[i]);
                }
                for(int i=0;i<t3.length;i++)
                {
                    speak(t3[i]);
                }
                for(int i=0;i<t4.length;i++)
                {
                    speak(t4[i]);
                }
                for(int i=0;i<t5.length;i++)
                {
                    speak(t5[i]);
                }
                for(int i=0;i<t6.length;i++)
                {
                    speak(t6[i]);
                }
                for(int i=0;i<t7.length;i++)
                {
                    speak(t7[i]);
                }
                for(int i=0;i<t8.length;i++)
                {
                    speak(t8[i]);
                }
                for(int i=0;i<t9.length;i++)
                {
                    speak(t9[i]);
                }
            }
        });
    }
    public void speak(String msg)
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,msg);
        tts.speak(msg, TextToSpeech.QUEUE_ADD, params);
    }


    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS)
        {
            tts.setLanguage(Locale.US);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(TTS_REQUEST_CODE==requestCode)
        {
            if(TextToSpeech.Engine.CHECK_VOICE_DATA_PASS==resultCode)
            {
                tts=new TextToSpeech(this,this);
                tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                    @Override
                    public void onStart(final String utteranceId) {
                        Formal.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                for (int i = 0; i < t1.length; i++) {
                                    if (utteranceId.equals(t1[i])) {
                                        String subString = t1[i];
                                        if (tView1.contains(subString)) {
                                            int startIndex1 = tView1.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView1);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv1.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < t2.length; i++) {
                                    if (utteranceId.equals(t2[i])) {
                                        String subString = t2[i];
                                        if (tView2.contains(subString)) {
                                            int startIndex1 = tView2.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView2);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv2.setText(spannableString);
                                        }
                                    }
                                }
                                for (int i = 0; i < t3.length; i++) {
                                    if (utteranceId.equals(t3[i])) {
                                        String subString = t3[i];
                                        if (tView3.contains(subString)) {
                                            int startIndex1 = tView3.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView3);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv3.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t4.length; i++) {
                                    if (utteranceId.equals(t4[i])) {
                                        String subString = t4[i];
                                        if (tView4.contains(subString)) {
                                            int startIndex1 = tView4.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView4);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv4.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t5.length; i++) {
                                    if (utteranceId.equals(t5[i])) {
                                        String subString = t5[i];
                                        if (tView5.contains(subString)) {
                                            int startIndex1 = tView5.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView5);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv5.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t6.length; i++) {
                                    if (utteranceId.equals(t6[i])) {
                                        String subString = t6[i];
                                        if (tView6.contains(subString)) {
                                            int startIndex1 = tView6.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView6);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv6.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t7.length; i++) {
                                    if (utteranceId.equals(t7[i])) {
                                        String subString = t7[i];
                                        if (tView7.contains(subString)) {
                                            int startIndex1 = tView7.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView7);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv7.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t8.length; i++) {
                                    if (utteranceId.equals(t8[i])) {
                                        String subString = t8[i];
                                        if (tView8.contains(subString)) {
                                            int startIndex1 = tView8.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView8);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv8.setText(spannableString);
                                        }
                                    }
                                }

                                for (int i = 0; i < t9.length; i++) {
                                    if (utteranceId.equals(t9[i])) {
                                        String subString = t9[i];
                                        if (tView9.contains(subString)) {
                                            int startIndex1 = tView9.indexOf(subString);
                                            int endIndex1 = startIndex1 + subString.length();
                                            SpannableString spannableString = new SpannableString(tView9);
                                            spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex1, endIndex1,
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                            tv9.setText(spannableString);
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
    public void onDestroy()
    {
        if (tts != null)
        {
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




