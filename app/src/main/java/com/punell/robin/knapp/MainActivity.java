package com.punell.robin.knapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bildView = (ImageView)findViewById(R.id.headView);
        bildView.setImageResource(R.drawable.utmakelse3);

        ImageView achBack = (ImageView)findViewById(R.id.achBack);
        achBack.setImageResource(R.drawable.achback);

        ImageView achFront = (ImageView)findViewById(R.id.achFront);
        achFront.setImageResource(R.drawable.achfront);

        ImageView knapp = (ImageView)findViewById(R.id.knapp);
        knapp.setImageResource(R.drawable.knapp2);
        //ImageButton imageButton = (ImageButton)findViewById(R.id.imgButton);
        //imageButton.setImageResource(R.drawable.knapp);

        //Referens till knappen
       // Button nrButton = (Button)findViewById(R.id.nrbutton);
        // Sätter upp listener med inbyggd händelse
        //nrButton.setOnClickListener(
        //        new Button.OnClickListener() {
        //            public void onClick(View v) { //Vad som skall hända vid klick
        //                TextView numberView = (TextView) findViewById(R.id.nrTextView);
        //                numberView.setText(getPhoneNumber());
        //            }
        //        }
        //);


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

    public String getPhoneNumber() {
        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String phoneNumber = tm.getLine1Number(); // Return null if it is unavailable.

        if (phoneNumber == null) {
            return "Number unavailable";
        }

        return phoneNumber;
    }
}
