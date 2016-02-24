package com.mooroogen.getloc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SimpleLocation location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // construct a new instance of SimpleLocation
        location = new SimpleLocation(this);

        // if we can't access the location yet
        if (!location.hasLocationEnabled()) {
            // ask the user to enable location access
            SimpleLocation.openSettings(this);
        }

        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final double latitude = location.getLatitude();
                final double longitude = location.getLongitude();

                // TODO
                Toast.makeText(getApplicationContext(), latitude+"\n"+longitude, Toast.LENGTH_LONG).show();
            }

        });
    }@Override
     protected void onResume() {
        super.onResume();

        // make the device update its location
        location.beginUpdates();

        // ...
    }

    @Override
    protected void onPause() {
        // stop location updates (saves battery)
        location.endUpdates();

        // ...

        super.onPause();
    }


}
