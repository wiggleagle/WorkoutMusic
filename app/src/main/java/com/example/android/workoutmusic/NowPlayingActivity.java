package com.example.android.workoutmusic;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        String title = getIntent().getExtras().getString("title");
        String artist = getIntent().getExtras().getString("artist");
        int image = getIntent().getExtras().getInt("image");

        TextView now_playing_song_title = (TextView) findViewById(R.id.now_playing_song_title);
        now_playing_song_title.setText(title);

        TextView now_playing_artist = (TextView) findViewById(R.id.now_playing_artist);
        now_playing_artist.setText(artist);

        ImageView now_playing_image = (ImageView) findViewById(R.id.now_playing_image);
        now_playing_image.setImageResource(R.drawable.feature);
        now_playing_image.setImageResource(image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
