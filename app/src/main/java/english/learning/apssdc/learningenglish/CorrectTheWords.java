package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CorrectTheWords extends AppCompatActivity {

    WebView webView1;
    TextView tv1;
    Animation animation;
    Button b1;
    EditText word1, word2, word3, word4, word5, word6, word7, word8, word9, word10, word11, word12, word13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_correct_words);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        webView1 = (WebView) findViewById(R.id.web_view);
        tv1 = (TextView) findViewById(R.id.correctWords);
        word1 = (EditText) findViewById(R.id.word1);
        word2 = (EditText) findViewById(R.id.word2);
        word3 = (EditText) findViewById(R.id.word3);
        word4 = (EditText) findViewById(R.id.word4);
        word5 = (EditText) findViewById(R.id.word5);
        word6 = (EditText) findViewById(R.id.word6);
        word7 = (EditText) findViewById(R.id.word7);
        word8 = (EditText) findViewById(R.id.word8);
        word9 = (EditText) findViewById(R.id.word9);
        word10 = (EditText) findViewById(R.id.word10);
        word11 = (EditText) findViewById(R.id.word11);
        word12 = (EditText) findViewById(R.id.word12);
        word13 = (EditText) findViewById(R.id.word13);


        webView1.loadUrl("file:///android_asset/text1.html");
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);
        animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.scale);
        tv1.setAnimation(animation);
        b1 = (Button) findViewById(R.id.CorrectWordsButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(word1.getText().toString().equalsIgnoreCase("Chocolates"))) {
                    word1.setError("Please Correct the Spelling");
                } else if (!(word2.getText().toString().equalsIgnoreCase("Candle"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word3.getText().toString().equalsIgnoreCase("Wishes"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word4.getText().toString().equalsIgnoreCase("Blessings"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word5.getText().toString().equalsIgnoreCase("Balloons"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word6.getText().toString().equalsIgnoreCase("Presents"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word7.getText().toString().equalsIgnoreCase("Friends"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word8.getText().toString().equalsIgnoreCase("Ribbons"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word9.getText().toString().equalsIgnoreCase("Invitation"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word10.getText().toString().equalsIgnoreCase("Celebrate"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word11.getText().toString().equalsIgnoreCase("Family"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word12.getText().toString().equalsIgnoreCase("Games"))) {
                    word2.setError("Please Correct the Spelling");
                } else if (!(word13.getText().toString().equalsIgnoreCase("Party"))) {
                    word2.setError("Please Correct the Spelling");
                }
                else
                {
                    Log.d("helooooooooooooooooo","jdajsdjsadkljalksjd");
                    Toast.makeText(getApplicationContext(),"Congratulations!!!",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), SimplePresentTense.class);
                    startActivity(i);
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }

}
