package com.example.ak.snapeventcalender;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Toast;

        import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add a on click listener to our buttons
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // we use switch case here because we know that each view that we attached an OnClickHandler
        // to has a unique ID attached to it so this is the most efficient way to have one OnClickHandler for multiple views
        switch (v.getId()) {
            case R.id.button: {

                // Create calender instance along with an intent
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", "A Test Event from android app");
                intent.putExtra("description", "Event Description");
                intent.putExtra("eventLocation", "ECE Building");
                startActivity(intent);

                // Show that the event successfully opened
                Toast.makeText(this, "Event successfully opened!", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}

