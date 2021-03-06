package com.example.oskar.mymusicplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.oskar.mymusicplayer.BandNames;

public class MyDialog extends Activity {
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        Intent intent = getIntent();
        if(intent != null){
            int imageId = intent.getIntExtra("bandImage", R.drawable.death64);
            String bandName = intent.getStringExtra("bandName");
            ImageView bandImage = (ImageView) findViewById(R.id.bandImage);
            bandImage.setImageResource(imageId);
            TextView band = (TextView) findViewById(R.id.bandText);
            band.setText("This logo belongs to " + bandName );
            BandNames bandNames = new BandNames();
            int songId = bandNames.bandNamesDictionary.get(bandName);
            mPlayer = MediaPlayer.create(MyDialog.this, songId);
            mPlayer.start();
        }
    }

    public void closeDialog(View v){
        mPlayer.stop();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_dialog, menu);
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
}
