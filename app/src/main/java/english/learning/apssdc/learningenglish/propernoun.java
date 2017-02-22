package english.learning.apssdc.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
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

public class propernoun extends Activity implements TextToSpeech.OnInitListener {

    ImageView iv;
    Button next;
    TextToSpeech tts;
    String definitionString,exampleString,eg1String,propernounString,propernounString2,exampleString1,exampleString2,exampleString3,exampleString4,exampleString5;
    static final int TTS_REQUEST_CODE = 1234;
    TextView definition,example,tv_eg1,tv_propernoun,tv_propernoun1,tv_eg2,tv_eg3,tv_eg4,tv_eg5,tv_eg6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.proper_noun);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        iv=(ImageView)findViewById(R.id.getVoice);
        definition=(TextView)findViewById(R.id.def_propernoun);
        example=(TextView)findViewById(R.id.Example);
        tv_eg1=(TextView)findViewById(R.id.eg1);
        tv_eg2=(TextView)findViewById(R.id.eg);
        tv_propernoun=(TextView)findViewById(R.id.propernoun2);
        tv_propernoun1=(TextView)findViewById(R.id.propernoun3);
        tv_eg3=(TextView)findViewById(R.id.eg3);
        tv_eg4=(TextView)findViewById(R.id.eg4);
        tv_eg5=(TextView)findViewById(R.id.eg5);
        tv_eg6=(TextView)findViewById(R.id.eg6);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),FirstScreen.class);
                startActivity(i);
            }
        });
        definitionString="Proper Nouns are the names of people,places,organisations and things";
        exampleString="Example";
        eg1String="She is Sonia.She comes from Visakhapatnam with her parents";
        propernounString="All proper nouns begin with a capital letter";
        propernounString2="If the proper noun has more than one word,each of the words begin with a capital letter";
        exampleString1=" Example";
        exampleString2=" Sonia visited the Taj Mahal at Agra with her  parents last year";
        exampleString3="Sonia is a Christian and celebrates Christmas on 25th December";
        exampleString4="Sonia likes to sing.Her favourite singer is P.Susheela";
        exampleString5="She wants to study hard and  join  the Indian Administrative Services";
        definition.setText(definitionString);
        example.setText(exampleString);
        tv_eg1.setText(eg1String);
        tv_propernoun.setText(propernounString);
        tv_propernoun1.setText(propernounString2);
        tv_eg2.setText(exampleString1);
        tv_eg3.setText(exampleString2);
        tv_eg4.setText(exampleString3);
        tv_eg5.setText(exampleString4);
        tv_eg6.setText(exampleString5);
        Intent i=new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, TTS_REQUEST_CODE);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] definition={"Proper","Nouns","are","the","names","of","people","places","organisations","and","things"," ","Example",
                        "She","is","Sonia","She comes","from","Visakhapatnam","with","her","parents"," ",
                        "All","proper","nouns","begin","with a","capital","letter",
                        "If the","proper noun","has","more","than","one","word","each","of the","words","begin with a","capital letter"," Example",
                        " Sonia","visited","the Taj Mahal","at","Agra","with her"," parents","last year",
                        "Sonia is","a Christian","and ","celebrates","Christmas","on 25th","December",
                        "Sonia likes","to sing"," ","Her","favourite","singer is","P.Susheela",
                        "She wants","to","study","hard"," and"," join"," the","Indian Administrative Services",""};
                for(int i=0;i<definition.length;i++)
                {
                    speak(definition[i]);
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
                        propernoun.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(utteranceId.equals("Proper"))
                                {
                                    String subString="Proper";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Nouns"))
                                {
                                    String subString="Nouns";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("are"))
                                {
                                    String subString="are";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("the"))
                                {
                                    String subString="the";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("names"))
                                {
                                    String subString="names";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("of"))
                                {
                                    String subString="of";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("people"))
                                {
                                    String subString="people";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("places"))
                                {
                                    String subString="places";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("organisations"))
                                {
                                    String subString="organisations";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("and"))
                                {
                                    String subString="and";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("things"))
                                {
                                    String subString="things";
                                    if(definitionString.contains(subString)) {
                                        int startIndex = definitionString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(definitionString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        definition.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Example"))
                                {
                                    definition.setText(definitionString);
                                    String subString="Example";
                                    if(exampleString.contains(subString)) {
                                        int startIndex = exampleString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        example.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("She"))
                                {
                                    example.setText(exampleString);
                                    String subString="She";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("is"))
                                {
                                    example.setText(exampleString);
                                    String subString="is";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Sonia"))
                                {
                                    String subString="Sonia";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("She comes"))
                                {
                                    String subString="She comes";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("from"))
                                {
                                    String subString="from";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Visakhapatnam"))
                                {
                                    String subString="Visakhapatnam";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("with"))
                                {
                                    String subString="with";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("her"))
                                {
                                    String subString="her";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("parents"))
                                {
                                    String subString="parents";
                                    if(eg1String.contains(subString)) {
                                        int startIndex = eg1String.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(eg1String);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("All"))
                                {
                                    tv_eg1.setText(eg1String);
                                    String subString="All";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("proper"))
                                {
                                    String subString="proper";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("nouns"))
                                {
                                    String subString="nouns";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("begin"))
                                {
                                    String subString="begin";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("with a"))
                                {
                                    String subString="with a";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("capital"))
                                {
                                    String subString="capital";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("letter"))
                                {
                                    String subString="letter";
                                    if(propernounString.contains(subString)) {
                                        int startIndex = propernounString.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("If the"))
                                {
                                    tv_propernoun.setText(propernounString);
                                    String subString="If the";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("proper noun"))
                                {
                                    String subString="proper noun";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("has"))
                                {
                                    String subString="has";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("more"))
                                {
                                    String subString="more";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("than"))
                                {
                                    String subString="than";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("one"))
                                {
                                    String subString="one";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("word"))
                                {
                                    String subString="word";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("each"))
                                {
                                    String subString="each";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("of the"))
                                {
                                    String subString="of the";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("words"))
                                {
                                    String subString="words";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("words"))
                                {
                                    String subString="words";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("begin with a"))
                                {
                                    String subString="begin with a";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("capital letter"))
                                {
                                    String subString="capital letter";
                                    if(propernounString2.contains(subString)) {
                                        int startIndex = propernounString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(propernounString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_propernoun1.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" Example"))
                                {
                                    tv_propernoun1.setText(propernounString2);
                                    String subString=" Example";
                                    if(exampleString1.contains(subString)) {
                                        int startIndex = exampleString1.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString1);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg2.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" Sonia"))
                                {
                                    tv_eg2.setText(exampleString1);
                                    String subString=" Sonia";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("visited"))
                                {
                                    String subString="visited";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("the Taj Mahal"))
                                {
                                    String subString="the Taj Mahal";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("at"))
                                {
                                    String subString="at";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Agra"))
                                {
                                    String subString="Agra";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("with her"))
                                {
                                    String subString="with her";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" parents"))
                                {
                                    String subString=" parents";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("last year"))
                                {
                                    String subString="last year";
                                    if(exampleString2.contains(subString)) {
                                        int startIndex = exampleString2.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString2);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg3.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Sonia is"))
                                {
                                    tv_eg3.setText(exampleString2);
                                    String subString="Sonia is";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("a Christian"))
                                {
                                    String subString="a Christian";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("and "))
                                {
                                    String subString="and ";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("celebrates"))
                                {
                                    String subString="celebrates";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Christmas"))
                                {
                                    String subString="Christmas";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("on 25th"))
                                {
                                    String subString="on 25th";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("December"))
                                {
                                    String subString="December";
                                    if(exampleString3.contains(subString)) {
                                        int startIndex = exampleString3.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString3);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg4.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Sonia likes"))
                                {
                                    tv_eg4.setText(exampleString3);
                                    String subString="Sonia likes";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("to sing"))
                                {
                                    String subString="to sing";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Her"))
                                {
                                    String subString="Her";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("favourite"))
                                {
                                    String subString="favourite";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("singer is"))
                                {
                                    String subString="singer is";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("P.Susheela"))
                                {
                                    String subString="P.Susheela";
                                    if(exampleString4.contains(subString)) {
                                        int startIndex = exampleString4.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString4);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#87CEFA")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg5.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("She wants"))
                                {
                                    tv_eg5.setText(exampleString4);
                                    String subString="She wants";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("to"))
                                {
                                    String subString="to";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("study"))
                                {
                                    String subString="study";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("hard"))
                                {
                                    String subString="hard";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" join"))
                                {
                                    String subString=" join";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" and"))
                                {
                                    String subString=" and";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals(" the"))
                                {
                                    String subString=" the";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
                                    }
                                }
                                if(utteranceId.equals("Indian Administrative Services"))
                                {
                                    String subString="Indian Administrative Services";
                                    if(exampleString5.contains(subString)) {
                                        int startIndex = exampleString5.indexOf(subString);
                                        int endIndex = startIndex + subString.length();
                                        SpannableString spannableString = new SpannableString(exampleString5);
                                        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#7CFC00")), startIndex, endIndex,
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                        tv_eg6.setText(spannableString);
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
