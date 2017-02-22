package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CorrectTheSentences2 extends AppCompatActivity {

    Button prev;
    Button submit;
    EditText ans6,ans7,ans8,ans9,ans10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_correct_sentense_two);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        prev=(Button)findViewById(R.id.prev_button);
        submit=(Button)findViewById(R.id.submit_button);
        ans6=(EditText)findViewById(R.id.answer6);
        ans7=(EditText)findViewById(R.id.answer7);
        ans8=(EditText)findViewById(R.id.answer8);
        ans9=(EditText)findViewById(R.id.answer9);
        ans10=(EditText)findViewById(R.id.answer10);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),CorrectTheSentences.class);
                startActivity(i);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(ans6.getText().toString().contains("watch")))
                {
                    ans6.setError("Please Correct the Sentence");
                }
                else if(!(ans7.getText().toString().contains("does")))
                {
                    ans7.setError("Please Correct the Sentence");
                }
                else if(!(ans8.getText().toString().contains("reads")))
                {
                    ans8.setError("Please Correct the Sentence");
                }
                else if(!(ans9.getText().toString().contains("have")))
                {
                    ans9.setError("Please Correct the Sentence");
                }
                else if(!(ans10.getText().toString().contains("always comes")))
                {
                    ans10.setError("Please Correct the Sentence");
                }
                else {
                    Intent i=new Intent(getApplicationContext(),CelebrateBirthdayPhrase.class);
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
