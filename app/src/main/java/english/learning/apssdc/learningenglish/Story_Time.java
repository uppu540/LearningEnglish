package english.learning.apssdc.learningenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Story_Time extends YouTubeBaseActivity {
    Button play,home;
    private YouTubePlayerView yt;
    private YouTubePlayer.OnInitializedListener lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.story__time);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        yt=(YouTubePlayerView)findViewById(R.id.story_view);
        play=(Button)findViewById(R.id.yt_storyTime);
        home=(Button)findViewById(R.id.go_home);
        lst= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("IhQt_fxGOcw");
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

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),BasicSplashunit3.class);
                startActivity(i);

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
