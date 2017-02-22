package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sharp on 18-Feb-17.
 */

public class CorrectTheSentencesUnit2 extends AppCompatActivity {
    Button next;
    TextView tv1;
    Animation animation;
    EditText ans1,ans2,ans3,ans4,ans5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_correct_sentence_simple);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        tv1=(TextView)findViewById(R.id.correctSentences);
        next=(Button)findViewById(R.id.button1);
        ans1=(EditText)findViewById(R.id.answer1);
        ans2=(EditText)findViewById(R.id.answer2);
        ans3=(EditText)findViewById(R.id.answer3);
        ans4=(EditText)findViewById(R.id.answer4);
        ans5=(EditText)findViewById(R.id.answer5);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);
        animation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.scale);
        tv1.setAnimation(animation);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(ans1.getText().toString().contains("eat lunch")))
                {
                    ans1.setError("Please Correct the Sentence");
                }
                else if(!(ans2.getText().toString().contains("drinks")))
                {
                    ans2.setError("Please Correct the Sentence");
                }
                else if(!(ans3.getText().toString().contains("plays")))
                {
                    ans3.setError("Please Correct the Sentence");
                }
                else if(!(ans4.getText().toString().contains("dances")))
                {
                    ans4.setError("Please Correct the Sentence");
                }
                else if(!(ans5.getText().toString().contains("give")))
                {
                    ans5.setError("Please Correct the Sentence");
                }
                else {
                    Intent i = new Intent(getApplicationContext(), DragDropCorrectSentence.class);
                    i.putExtra("ans1",ans1.getText().toString());
                    i.putExtra("ans2",ans2.getText().toString());
                    i.putExtra("ans3",ans3.getText().toString());
                    i.putExtra("ans4",ans4.getText().toString());
                    i.putExtra("ans5",ans5.getText().toString());
                    startActivity(i);
                }
            }
        });
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

