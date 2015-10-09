package com.punell.robin.knapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int currentRating = 0;
    private int currentPosRating = 0;
    private int currentNegRating = 0;
    private int ratingUpdateFreq = 3; //Updateringsfrekvens rating
    private int timesRated = 0;
    private int minTimesRated = 5; // Minsta antal gånger man blivit ratead för att se rating
    ProgressBar progressBar;
    Button yesButton;
    Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        ImageView bildView = (ImageView)findViewById(R.id.headView);
        bildView.setImageResource(R.drawable.shower_head_text);

        yesButton = (Button)findViewById(R.id.yesButton);
        yesButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //SEND incrementRating();to other user
                        //yesButton.setEnabled(false);

                        //test
                        //incPosRating();
                        //updateProgressBar();
                    }
                }
        );
        yesButton.setEnabled(false);

        noButton = (Button)findViewById(R.id.noButton);
        noButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //SEND decrementRating(); to other user

                        //test
                        incNegRating();
                        //updateProgressBar();
                    }
                }
        );

       Button closeButton = (Button)findViewById(R.id.showerCloseButton);
        closeButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) { //Vad som skall hända vid klick
                        finish();
                        //TextView numberView = (TextView) findViewById(R.id.nrTextView);
                        //numberView.setText(getPhoneNumber());
                    }
                }
        );




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void enableRatingButtons(){
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }
    public void disableRatingButtons(){
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }

    public void updateRatingBar(){

        int posRating = currentPosRating;
        int negRating = currentNegRating;
        int timesRated = posRating+negRating; //Gör en timesRated i Stats
        float posPercent = 0;

           posPercent = (float)posRating/timesRated*100;

        if(timesRated % ratingUpdateFreq == 0){ //just show new rating every X time
            //set progressbar to currentRaing/timesRated
            progressBar.setProgress((int)posPercent);
        }

    }
    public void incrementRating(){currentRating++;}
    public void decrementRating(){currentRating--;}
    public void incrementTimesRated(){timesRated++;}

    public void incPosRating(){currentPosRating++;}
    public void incNegRating(){currentNegRating++;}

}
