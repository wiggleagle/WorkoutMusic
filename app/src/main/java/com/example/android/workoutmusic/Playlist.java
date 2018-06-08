package com.example.android.workoutmusic;

public class Playlist {
    private String playlist_title;
    private int playlist_image_id;

    public Playlist(String title, int id) {
        playlist_title = title;
        playlist_image_id = id;
    }

    public String getPlaylistTitle() {
        return playlist_title;
    }
    public int getPlaylistImage() {
        return playlist_image_id;
    }

}
