package english.learning.apssdc.learningenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class IntroduceYourself extends YouTubeBaseActivity {
    Button play,next;
    private YouTubePlayerView yt;
    EditText et1;
    private YouTubePlayer.OnInitializedListener lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_intoduce_yourself);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        yt=(YouTubePlayerView)findViewById(R.id.hello_view);
        play=(Button)findViewById(R.id.youtube_introduce_button);
        next=(Button)findViewById(R.id.hello_next_btn);
        et1 = (EditText) findViewById(R.id.editText2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intro = et1.getText().toString();
                if(intro.equals("")) {

                    new AlertDialog.Builder(IntroduceYourself.this,R.style.MyAlertDialogStyleNo)
                            .setTitle("OOPS!!")
                            .setMessage("That's not the right answer! Try Again!")
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {


                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing

                                }
                            })
                            .setIcon(R.drawable.images)
                            .show();

                }
                else {
                    Intent i = new Intent(getApplicationContext(), TwoLetterThreeLetterWords.class);
                    startActivity(i);
                }
            }
        });
        lst= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("tZOgdnKJ5Sc");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yt.initialize("AIzaSyCmuIGB3ZVoUlUUZtcjea4-AtZzIJpMjTk",lst);
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
