package english.learning.apssdc.learningenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText uname,pass;
    RadioButton teacher,student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.login_screen);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        uname = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        teacher = (RadioButton) findViewById(R.id.teacher);
        student = (RadioButton) findViewById(R.id.student);
    }

    public void doRegister(View view) {
        Toast.makeText(getApplicationContext(),"Registration Page Will get Updated soon",Toast.LENGTH_LONG).show();
    }

    public void doLogin(View view) {

        String user = uname.getText().toString();
        String pwd = pass.getText().toString();
        boolean tStatus = teacher.isChecked();
        boolean sStatus = student.isChecked();

        if(tStatus)
        {
            Toast.makeText(getApplicationContext(),"You are trying to Login as Teacher",Toast.LENGTH_LONG).show();
            if(user.equalsIgnoreCase("teacher")&&pwd.equalsIgnoreCase("teacher"))
            {
                Toast.makeText(getApplicationContext(),"Teacher Module is Still Building",Toast.LENGTH_LONG).show();
            }
            else
            {
                new AlertDialog.Builder(this)
                        .setTitle("Error!")
                        .setMessage("Please Check the user name and password")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }

        }
        else if(sStatus)
        {
            Toast.makeText(getApplicationContext(),"You are trying to Login as Student",Toast.LENGTH_LONG).show();
            if(user.equalsIgnoreCase("student")&&pwd.equalsIgnoreCase("student"))
            {
                Intent in = new Intent(getApplicationContext(),FirstScreen.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"Successful!",Toast.LENGTH_LONG).show();
            }
            else
            {
                new AlertDialog.Builder(this)
                        .setTitle("Error!")
                        .setMessage("Please Check the user name and password")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
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
}
