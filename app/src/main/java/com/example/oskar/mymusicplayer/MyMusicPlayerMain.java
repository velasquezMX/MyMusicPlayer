package com.example.oskar.mymusicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;


public class MyMusicPlayerMain extends Activity{
    GridView myGrid;
    ArrayList<Bands> bandsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music_player_main);
        myGrid = (GridView) findViewById(R.id.metalGrid);
        myGrid.setAdapter(new GridAdapter(this));

        myGrid.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(view.getContext(),MyDialog.class);
                ViewHolder holder = (ViewHolder) view.getTag();
                Bands temp = (Bands) holder.bandImageView.getTag(); // this gets a null
                Log.d("BAND", holder.bandImageView.getTag().getClass().toString());
                intent.putExtra("bandName", temp.bandName);
                intent.putExtra("bandImage", temp.imageId);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,MyDialog.class);
        ViewHolder holder = (ViewHolder) view.getTag();
        Bands temp = (Bands) holder.bandImageView.getTag();
        intent.putExtra("bandName",temp.bandName);
        intent.putExtra("bandImage",temp.imageId);
        startActivity(intent);
    } */

    public class Bands
    {
        String bandName;
        int imageId;
        Bands(int imageId, String bandName){
            this.bandName = bandName;
            this.imageId = imageId;
        }
    }
    class ViewHolder{
        ImageView bandImageView;
        ViewHolder(View v){

            bandImageView = (ImageView) v.findViewById(R.id.imageView);
        }

    }
    class GridAdapter extends BaseAdapter{

        //ArrayList<Bands> bandsArrayList;
        Context context;
        GridAdapter(Context context){
            this.context = context;
            bandsArrayList = new ArrayList<Bands>();
            Resources res = context.getResources(); //gets the string array
            String[] temp = res.getStringArray(R.array.metal_bands);
            int[] bandImages = {R.drawable.death120,R.drawable.slayer,R.drawable.behemoth,R.drawable.immortal,R.drawable.emperor,
                    R.drawable.morbidangel};
            for(int i = 0; i <= 5; i++){
                Bands tempBand = new Bands(bandImages[i],temp[i]);
                bandsArrayList.add(tempBand);
            }
        }

        @Override
        public int getCount() {
            return bandsArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return bandsArrayList.get(position);
        }

        @Override
        public long getItemId(int position) { // iused for database related apps
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // whenever wants to display the getview method
            View row = convertView;
            ViewHolder holder = null;
            if(row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_item, parent, false);
                holder = new ViewHolder(row);
                row.setTag(holder);
            }
            else{
                holder = (ViewHolder) row.getTag();
            }
            Bands temp = bandsArrayList.get(position);
            holder.bandImageView.setImageResource(temp.imageId);
            holder.bandImageView.setTag(temp);
            return row;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_music_player_main, menu);
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
