package com.example.saeko.receipeapplication.song;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.saeko.receipeapplication.R;

import java.io.IOException;

/**
 * Created by fukuisaeko on 2017-08-12.
 */

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton playBtn, stopBtn, resetBtn;
    boolean play_reset = true;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_music);

        mediaPlayer = MediaPlayer.create(this, R.raw.shapeofyou);

        playBtn = (ImageButton) this.findViewById(R.id.play);
        stopBtn = (ImageButton) this.findViewById(R.id.stop);
        resetBtn = (ImageButton) this.findViewById(R.id.reset);
        seekbar = (SeekBar) findViewById(R.id.seekBar);

        playBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(play_reset) {
                    play_reset = false;
                    mediaPlayer.setLooping(false);
                }
                playPause();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, R.raw.shapeofyou);
                }
                if (!play_reset) {
                    mediaPlayer.stop();
                    playBtn.setImageResource(R.drawable.play);
                    Toast.makeText(MusicActivity.this, "stopped", Toast.LENGTH_LONG).show();
                    try {
                        mediaPlayer.prepare();
                    } catch (IllegalStateException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        resetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, R.raw.shapeofyou);
                }

                mediaPlayer.reset();
                playBtn.setImageResource(R.drawable.play);
                Toast.makeText(MusicActivity.this, "reset", Toast.LENGTH_SHORT).show();
                mediaPlayer.release();
                play_reset = true;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(MusicActivity.this, R.raw.shapeofyou);
        }

        mediaPlayer.reset();

        playBtn.setImageResource(R.drawable.play);
        Toast.makeText(MusicActivity.this, "reset", Toast.LENGTH_SHORT).show();
        mediaPlayer.release();
        mediaPlayer = null;
        play_reset = true;
    }

    private void playPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playBtn.setImageResource(R.drawable.play);
            Toast.makeText(MusicActivity.this, "paused", Toast.LENGTH_SHORT).show();
        } else {
            playBtn.setImageResource(R.drawable.pause);
            mediaPlayer.start();
            Toast.makeText(MusicActivity.this, "isPlaying", Toast.LENGTH_LONG).show();
        }
    }

}
