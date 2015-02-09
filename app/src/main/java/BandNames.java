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

import com.example.oskar.mymusicplayer.R;

import java.util.HashMap;

/**
 * Created by Oskar on 2/8/2015.
 */
public class BandNames {
    HashMap<String, Integer> bandNamesDictionary = new HashMap<String, Integer>();

    public BandNames() {
        bandNamesDictionary.put("Death",R.raw.death);
        bandNamesDictionary.put("Slayer",R.raw.slayer);
        bandNamesDictionary.put("Behemoth",R.raw.behemoth);
        bandNamesDictionary.put("Morbid Angel",R.raw.morbidangel);
        bandNamesDictionary.put("Immortal",R.raw.immortal);
        bandNamesDictionary.put("Emperor",R.raw.emperor);

    }

}
