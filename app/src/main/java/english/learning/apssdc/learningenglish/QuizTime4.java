package english.learning.apssdc.learningenglish;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizTime4 extends AppCompatActivity {

    private TextView option1, option2, option3,option4,choice1, choice2, choice3,choice4,fullText;
    public CharSequence dragData;
    private Button reset;

    String data;
    MediaPlayer mp;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Quiz Time");

        setContentView(R.layout.activity_quiz_time4);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        //get both sets of text views
        //views to drag
        reset = (Button)findViewById(R.id.reset);

        option1 = (TextView)findViewById(R.id.option_1);
        option2 = (TextView)findViewById(R.id.option_2);
        option3 = (TextView)findViewById(R.id.option_3);
        option4 = (TextView)findViewById(R.id.option_4);

        //views to drop onto
        choice1 = (TextView)findViewById(R.id.choice_1);
        choice2 = (TextView)findViewById(R.id.choice_2);
        choice3 = (TextView)findViewById(R.id.choice_3);
        choice4 = (TextView)findViewById(R.id.choice_4);
        fullText = (TextView)findViewById(R.id.fullText);

        //set touch listeners
        option1.setOnTouchListener(new ChoiceTouchListener());
        option2.setOnTouchListener(new ChoiceTouchListener());
        option3.setOnTouchListener(new ChoiceTouchListener());
        option4.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();
            }
        });
    }

    public void check(View view) {

        String one=choice1.getText().toString();
        String two=choice2.getText().toString();
        String three=choice3.getText().toString();
        String four=choice4.getText().toString();
        data = one+" "+two+" "+three+" "+four;
        if(data.equalsIgnoreCase("My mother likes to lie on her mat and read"))
        {
            mp = MediaPlayer.create(getApplicationContext(),R.raw.claps);
            mp.start();
            new AlertDialog.Builder(QuizTime4.this,R.style.MyAlertDialogStyle)
                    .setTitle("Congratulations!")
                    .setMessage("Press Next to Continue!")
                    .setPositiveButton("NEXT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent in = new Intent(QuizTime4.this,QuizTime5.class);
                            startActivity(in);
                            // continue with delete
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing

                        }
                    })
                    .setIcon(R.drawable.download)
                    .show();
        }
        else
        {
            mp = MediaPlayer.create(getApplicationContext(),R.raw.error);
            mp.start();
            new AlertDialog.Builder(QuizTime4.this,R.style.MyAlertDialogStyleNo)
                    .setTitle("OOPS!!")
                    .setMessage("That's not the right answer! Try Again!")
                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            reset();
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
    }



    /**
     * ChoiceTouchListener will handle touch events on draggable views
     *
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            /*
             * Drag details: we only need default behavior
             * - clip data could be set to pass data as part of drag
             * - shadow can be tailored
             */
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * DragListener will handle dragged views being dropped on the drop area
     * - only the drop action will have processing added to it as we are not
     * - amending the default behavior for other parts of the drag process
     *
     */
    @SuppressLint("NewApi")
    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //checking whether first character of dropTarget equals first character of dropped
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.mmm);
                    mp.start();

                    //stop displaying the view where it was before it was dragged
                    view.setEnabled(false);
                    String text = fullText.getText().toString();
                    text+=" "+dropped.getText().toString();
                    fullText.setText(text);
                    //update the text in the target view to reflect the data being dropped
                    dropTarget.setText(dropped.getText().toString());
                    //make it bold to highlight the fact that an item has been dropped
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);

                    //if an item has already been dropped here, there will be a tag
                    Object tag = dropTarget.getTag();
                    //if there is already an item here, set it back visible in its original place
                    if(tag!=null)
                    {
                        //the tag is the view id already dropped here
                        int existingID = (Integer)tag;
                        //set the original view visible again
                        findViewById(existingID).setVisibility(View.VISIBLE);
                    }
                    //set the tag in the target view being dropped on - to the ID of the view being dropped
                    dropTarget.setTag(dropped.getId());
                    //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                    dropTarget.setOnDragListener(null);

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    public void reset()
    {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);


        choice1.setText("1");
        choice2.setText("2");
        choice3.setText("3");
        choice4.setText("4");

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);
        choice4.setTag(null);
        fullText.setText("");
        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);
        choice4.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());

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
