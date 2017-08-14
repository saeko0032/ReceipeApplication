package com.example.saeko.receipeapplication.song;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saeko.receipeapplication.R;

import java.util.ArrayList;

/**
 * Created by fukuisaeko on 2017-08-12.
 */

public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> songList;
    private LayoutInflater layoutInflater;

    public SongAdapter(Context context, ArrayList<Song> songList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.songList = songList;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LinearLayout songLayout = (LinearLayout) layoutInflater.inflate(R.layout.song, parent, false);
        TextView songView = (TextView) songLayout.findViewById(R.id.song_title);
        TextView artistView = (TextView) songLayout.findViewById(R.id.song_artist);

        Song currentSong = songList.get(position);
        songView.setText(currentSong.getTitle());
        artistView.setText(currentSong.getArtist());

        songLayout.setTag(position);

        return songLayout;
    }
}
