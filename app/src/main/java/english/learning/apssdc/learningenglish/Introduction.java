package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Introduction extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4;
    String one,two,three,four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_introduction);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);

        editText1 = (EditText)findViewById(R.id.blank);
        editText2 = (EditText)findViewById(R.id.blank1);
        editText3 = (EditText)findViewById(R.id.blank2);
        editText4 = (EditText)findViewById(R.id.blank3);
    }
    public void next(View v){
        one = editText1.getText().toString();
        two = editText2.getText().toString();
        three = editText3.getText().toString();
        four = editText4.getText().toString();
        if(one.equals("")||two.equals("")||three.equals("")||four.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Sorry, Please complete this!",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(getApplicationContext(), propernoun.class);
            startActivity(i);
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
