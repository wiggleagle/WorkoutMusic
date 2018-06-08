package com.example.android.workoutmusic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaylistRecyclerViewAdapter extends RecyclerView.Adapter<PlaylistRecyclerViewAdapter.PlaylistViewHolder> {
    private List<Playlist> horizontal_playlist_list;
    Context context;

    public PlaylistRecyclerViewAdapter(List<Playlist> horizontal_playlist_list, Context context){
        this.horizontal_playlist_list= horizontal_playlist_list;
        this.context = context;
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View playlist_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
        return (new PlaylistViewHolder(playlist_view));
    }
    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, final int position) {
        holder.playlist_image.setImageResource(horizontal_playlist_list.get(position).getPlaylistImage());
        holder.playlist_title.setText(horizontal_playlist_list.get(position).getPlaylistTitle());
        holder.playlist_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playlist_title = horizontal_playlist_list.get(position).getPlaylistTitle().toString();

                Intent playlistIntent = new Intent(context, PlaylistActivity.class);
                playlistIntent.putExtra("playlist", playlist_title);
                context.startActivity(playlistIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontal_playlist_list.size();
    }

    public class PlaylistViewHolder extends RecyclerView.ViewHolder {
        ImageView playlist_image;
        TextView playlist_title;
        public PlaylistViewHolder(View view) {
            super(view);
            playlist_image = view.findViewById(R.id.playlist_image);
            playlist_title = view.findViewById(R.id.playlist_title);
        }
    }
}
