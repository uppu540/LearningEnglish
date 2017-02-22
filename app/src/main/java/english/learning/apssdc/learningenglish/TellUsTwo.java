package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TellUsTwo extends AppCompatActivity {

    Button b1;
    EditText et1,et2,et3,et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_tell_us_two);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        b1=(Button)findViewById(R.id.tellusmorebutton2);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText1);
        et3 =(EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one, two, three, four;
                one = et1.getText().toString();
                two = et2.getText().toString();
                three = et3.getText().toString();
                four = et4.getText().toString();
                if (one.equals("") || two.equals("") || three.equals("") || four.equals("")) {

                    Toast.makeText(getApplicationContext(), "You cannot Leave the Fields Empty!!", Toast.LENGTH_SHORT).show();

                } else {


                    Intent i = new Intent(getApplicationContext(), Story_Time.class);
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
