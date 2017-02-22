package english.learning.apssdc.learningenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TwoLetterThreeLetterWords extends AppCompatActivity {

    WebView webView1;
    TextView tv1;
    Animation animation;
    boolean flag2 = true;
    boolean flag3 = true;

    Button b1;
    String _s1,_s2,_s3,_s4,_s5,_s6,_s7,_s8,_s9;
    EditText _1,_2,_3,_4,_5,_6,_7,_8;
    EditText _r1,_r2,_r3,_r4,_r5,_r6,_r7,_r8,_r9,_r10,_r11,_r12,_r13,_r14,_r15;
    String twoLetterWord[] = {"it","at","by","hi"};
    String threeLetterWord[] = {"air","aid","bat","bad","bit","bay","dab","day","hit","hat","had","hay","rib","rid","rat","ray","tab","tar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_two_three_letter_words);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        webView1= (WebView) findViewById(R.id.web_view);
        tv1=(TextView)findViewById(R.id.happyBirthday);
        ConnectEditText();

        webView1.loadUrl("file:///android_asset/text.html");
        //webView1.setBackgroundResource(R.drawable.bg);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/tomnr.ttf");
        tv1.setTypeface(tf);
         animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.scale);
        tv1.setAnimation(animation);
        b1=(Button)findViewById(R.id.birthdayButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* getstringsfromuser();
                validatetheuser();*/

                Intent i = new Intent(getApplicationContext(), CorrectTheWords.class);
                startActivity(i);
            }
        });
    }

    private void validatetheuser() {

        int Count=0;

        for (int i = 0; i < twoLetterWord.length; i++) {
            if (twoLetterWord[i].equalsIgnoreCase(_s1) || twoLetterWord[i].equalsIgnoreCase(_s2) || twoLetterWord[i].equalsIgnoreCase(_s3) || twoLetterWord[i].equalsIgnoreCase(_s4)) {
                flag2 = true;
            } else {
                flag2 = false;
            }

        }
        for (int i = 0; i < threeLetterWord.length; i++)
        {

            if(threeLetterWord[i].equalsIgnoreCase(_s5) ||
                    threeLetterWord[i].equalsIgnoreCase(_s6) ||
                    threeLetterWord[i].equalsIgnoreCase(_s7) ||
                    threeLetterWord[i].equalsIgnoreCase(_s8) ||
                    threeLetterWord[i].equalsIgnoreCase(_s9))
            {
                flag3 = true;
                Count++;
            }
            else
            {
                flag3 = false;
            }
        }
        if(Count == 5)
        {
            flag3=true;
        }
        if(flag2&&flag3)
        {
            Intent in = new Intent(getApplicationContext(),CorrectTheWords.class);
            startActivity(in);
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("You are Wrong")
                    .setMessage("Sorry! Please try again! Flag 2 ,"+ flag2+" Flag3"+flag3+" \n"+_s5+" \n"+_s6+" \n"+_s7+" \n"+_s8+" \n"+_s9)
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



    private void getstringsfromuser() {



        _s1 = _1.getText().toString()+_2.getText().toString();
        _s2 = _3.getText().toString()+_4.getText().toString();
        _s3 = _5.getText().toString()+_6.getText().toString();
        _s4 = _7.getText().toString()+_8.getText().toString();
        _s5 = _r1.getText().toString()+_r2.getText().toString()+_r3.getText().toString();
        _s6 = _r4.getText().toString()+_r5.getText().toString()+_r6.getText().toString();
        _s7 = _r7.getText().toString()+_r8.getText().toString()+_r9.getText().toString();
        _s8 = _r10.getText().toString()+_r11.getText().toString()+_r12.getText().toString();
        _s9 = _r13.getText().toString()+_r14.getText().toString()+_r15.getText().toString();

    }

    private void ConnectEditText() {

        //EditText Boxes Connection
        _1 = (EditText) findViewById(R.id.one);
        _1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _2 = (EditText) findViewById(R.id.two);
        _2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _3 = (EditText) findViewById(R.id.one2);
        _3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _4 = (EditText) findViewById(R.id.two2);
        _4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _5 = (EditText) findViewById(R.id.one3);
        _5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _6 = (EditText) findViewById(R.id.two3);
        _6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _7 = (EditText) findViewById(R.id.one4);
        _7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _8 = (EditText) findViewById(R.id.two4);
        _8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        _r1 = (EditText) findViewById(R.id.oneR);
        _r1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r2 = (EditText) findViewById(R.id.twoR);
        _r2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r3 = (EditText) findViewById(R.id.threeR);
        _r3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r4 = (EditText) findViewById(R.id.oneR2);
        _r4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r5 = (EditText) findViewById(R.id.twoR2);
        _r5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r6 = (EditText) findViewById(R.id.threeR2);
        _r6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r7.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r7 = (EditText) findViewById(R.id.oneR3);
        _r7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r8.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r8 = (EditText) findViewById(R.id.twoR3);
        _r8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r9.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r9 = (EditText) findViewById(R.id.threeR3);
        _r9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r10.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r10 = (EditText) findViewById(R.id.oneR4);
        _r10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r11.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r11 = (EditText) findViewById(R.id.twoR4);
        _r11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r12.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r12 = (EditText) findViewById(R.id.threeR4);
        _r12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r13.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r13 = (EditText) findViewById(R.id.oneR5);
        _r13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r14.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r14 = (EditText) findViewById(R.id.twoR5);
        _r14.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i2==1)
                {
                    _r15.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _r15 = (EditText) findViewById(R.id.threeR5);

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
