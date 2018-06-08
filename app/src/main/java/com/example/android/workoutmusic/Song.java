package com.example.android.workoutmusic;

public class Song {
    private String song_title;
    private String song_artist;

    public Song(String title, String artist) {
        song_title = title;
        song_artist = artist;
    }

    public String getTitle() {
        return song_title;
    }
    public String getArtist() {
        return song_artist;
    }
}
