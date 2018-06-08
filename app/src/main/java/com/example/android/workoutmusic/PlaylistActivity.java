package com.example.android.workoutmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String featured_titles[] = {"Till I Collapse", "Rockstar", "Lose yourself", "Humble",
                "More Than You Know", "Mi Gente", "Havana", "You Don't Know Me", "New Rules", "Power"};
        String featured_artists[] = {"Eminem","Post Malone","Eminem", "Kendrick Lamar", "Axwell Ingrosso",
                "J Balvin","Camila Cabello", "Jax Jones", "Dua Lipa", "Kanye West"  };
        String running_titles[] = {"Fell In Love With A Girl", "Calypso", "American Idiot", "Blackbird - Remastered",
                "Blitzkieg Bop", "Little Wing", "We Will Rock You", "12:51", "I Walk The Line - Single Version", "Novella Ella Ella Eh"};
        String running_artists[] = {"The White Stripes", "CSpiderbaid", "Green Day", "The Beatles",
                "Ramones", "Jimi Hendrix", "Queen", "The Strokes", "Johnny Cash", "Chumped"};
        String elliptical_titles[] = {"This Is Love (Afrojack Remix)", "I Love it (Apocalypto Remix)",
                "Rain Over Me (DJ Shocker Remix)", "In the Ayer Meets Pret-a-porter (M.B. Remix)",
                "Play Hard (Albert Neve Remix)", "If I Lose Myself (Remixed)", "Beam Me Up (Kill Mode)"};
        String elliptical_artists[] = {"Will.i.am, Eva Simons", "Icona Pop, featuring Charli XCX",
                "DJ Shocker, Chani", "D'Mixmasters", "David Guetta, featuring Akon and Ne-Yo", "Ultimate Pop Hits", "Cazzette"};
        String cycling_titles[] = {"Indian Summer", "Don’t Stop the Music", "Obvs", "Samb-Adagio", "Échame la Culpa",
                "Tonight, Tonight", "My Holy Grail", "Hey Mamama – Club Mix", "Fade", "In My Head", "MIC Drop (feat. Desiinger, Steve Aoki Remix)"};
        String cycling_artists[] = {"Jai Wolf", "Rihanna","Jamie xx", "Safri Duo", "Luis Fonsi + Demi Lovato",
                "The Smashing Pumpkins", "Play-N-Skillz", "Tritonal", "Kanye West", "Galantis", "BTS" };
        String boxing_titles[] = {"Can’t Be Touched", "Remember The Name", "Till I Collapse", "The Warrior Pt 2",
                "Him 'Em Up", "Intro", "Heart Of A Champion", "Eye Of The Tiger", "We Will Rock You", "Hero"};
        String boxing_artists[] = {"Roy Jones Junior", "Fort Minor", "Eminem ft Nate Dogg",
                "Lloyd Banks, 50 Cent, Eminem and Nate Dogg", "Tupac", "DMX",
                "Nelly featuring Lincoln University Vocal Ensemble", "Survivor", "Queen", "Nas featuring Kelly Hilson"};

        ArrayList<Song> songs = new ArrayList<Song>();
        String playlist = getIntent().getExtras().getString("playlist");
        final ImageView playlist_image_in_song_list = (ImageView) findViewById(R.id.playlist_image_in_song_list);

        switch (playlist) {
            case "Featured":
                for (int i=0; i < featured_titles.length; i++) {
                    songs.add(new Song(featured_titles[i], featured_artists[i]));
                }
                playlist_image_in_song_list.setImageResource(R.drawable.feature);
                playlist_image_in_song_list.setTag(R.drawable.feature);
                break;

            case "Running":
                for (int i=0; i < running_titles.length; i++) {
                    songs.add(new Song(running_titles[i], running_artists[i]));
                }
                playlist_image_in_song_list.setImageResource(R.drawable.running);
                playlist_image_in_song_list.setTag(R.drawable.running);
                break;

            case "Elliptical":
                for (int i=0; i < elliptical_titles.length; i++) {
                    songs.add(new Song(elliptical_titles[i], elliptical_artists[i]));
                }
                playlist_image_in_song_list.setImageResource(R.drawable.elliptical);
                playlist_image_in_song_list.setTag(R.drawable.elliptical);
                break;

            case "Cycling":
                for (int i=0; i < cycling_titles.length; i++) {
                    songs.add(new Song(cycling_titles[i], cycling_artists[i]));
                }
                playlist_image_in_song_list.setImageResource(R.drawable.cycling);
                playlist_image_in_song_list.setTag(R.drawable.cycling);
                break;

            case "Boxing":
                for (int i=0; i < boxing_titles.length; i++) {
                    songs.add(new Song(boxing_titles[i], boxing_artists[i]));
                }
                playlist_image_in_song_list.setImageResource(R.drawable.boxing);
                playlist_image_in_song_list.setTag(R.drawable.boxing);
                break;

        }

        final SongAdapter adapter = new SongAdapter(this, songs);
        final ListView listView = (ListView) findViewById(R.id.list_in_song_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song_item = (Song) adapter.getItem(position);
                String title = song_item.getTitle();
                String artist = song_item.getArtist();
                int image = (Integer) playlist_image_in_song_list.getTag();

                Intent playlistIntent = new Intent(PlaylistActivity.this, NowPlayingActivity.class);
                playlistIntent.putExtra("title", title);
                playlistIntent.putExtra("artist", artist);
                playlistIntent.putExtra("image", image );

                startActivity(playlistIntent);
            }
        });

    }
}
