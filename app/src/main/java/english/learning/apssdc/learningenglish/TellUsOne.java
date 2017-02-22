package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TellUsOne extends AppCompatActivity {

    TextView tv1;
    EditText et1,et2,et3,et4;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_tell_us_one);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        tv1=(TextView)findViewById(R.id.Tellusmoretv);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);

        b1=(Button)findViewById(R.id.tellusmorebutton1);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText1);
        et3 =(EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String one,two,three,four;
                one = et1.getText().toString();
                two = et2.getText().toString();
                three = et3.getText().toString();
                four = et4.getText().toString();
                if(one.equals("")||two.equals("")||three.equals("")||four.equals(""))
                {

                    Toast.makeText(getApplicationContext(), "You cannot Leave the Fields Empty!!", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent i = new Intent(getApplicationContext(), TellUsTwo.class);
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
}

