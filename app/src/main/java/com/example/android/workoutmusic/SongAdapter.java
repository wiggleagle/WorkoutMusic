package com.example.android.workoutmusic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song current_song = getItem(position);

        TextView title_text = (TextView) listItemView.findViewById(R.id.song_title);
        title_text.setText(current_song.getTitle());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.song_artist);
        defaultTextView.setText(current_song.getArtist());

        return listItemView;
    }
}
