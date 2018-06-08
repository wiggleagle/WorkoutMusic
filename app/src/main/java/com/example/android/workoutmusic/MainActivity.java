package com.example.android.workoutmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        ImageView featured_playlist = (ImageView) findViewById(R.id.featured_playlist);

        featured_playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                playlistIntent.putExtra("playlist", "Featured");
                startActivity(playlistIntent);
            }
        });

        ArrayList<Playlist> playlists = new ArrayList<Playlist>();

        final String playlist_titles[] = {"Running", "Cycling", "Elliptical", "Boxing"};
        int playlist_images[] = {R.drawable.running, R.drawable.cycling, R.drawable.elliptical, R.drawable.boxing};

        for (int i = 0; i < playlist_titles.length; i++) {
            playlists.add(new Playlist(playlist_titles[i], playlist_images[i]));
        }

        RecyclerView recycler_view = findViewById(R.id.workout_list);
        PlaylistRecyclerViewAdapter adapter = new PlaylistRecyclerViewAdapter(playlists, this);
        LinearLayoutManager layout_manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recycler_view.setLayoutManager(layout_manager);
        recycler_view.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        recycler_view.setAdapter(adapter);

    }
}
