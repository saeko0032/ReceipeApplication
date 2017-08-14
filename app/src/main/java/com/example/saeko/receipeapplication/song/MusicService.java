package com.example.saeko.receipeapplication.song;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.saeko.receipeapplication.R;

import java.io.IOException;

/**
 * Created by fukuisaeko on 2017-08-12.
 */

public class MusicService extends Service  implements MediaPlayer.OnPreparedListener {
    private static final String ACTION_PLAY = "com.media.action.PLAY";
    //MediaPlayer mMediaPlayer = null;
    MediaPlayer mediaPlayer = null;
    ImageButton playBtn, stopBtn, resetBtn;
    boolean play_reset = true;
    private SeekBar seekbar;

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(ACTION_PLAY)) {
            mediaPlayer = MediaPlayer.create(MusicService.this, R.raw.shapeofyou); // initialize it here
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync(); // prepare async to not block main thread
        }

        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        if (play_reset) {
            play_reset = false;
            playPause();
        } else {
            mediaPlayer.stop();
            playBtn.setImageResource(R.drawable.play);
            Toast.makeText(MusicService.this, "stopped", Toast.LENGTH_LONG).show();
            try {
                mediaPlayer.prepare();
            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        player.start();
    }

    private void playPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playBtn.setImageResource(R.drawable.play);
            Toast.makeText(MusicService.this, "paused", Toast.LENGTH_SHORT).show();
        } else {
            playBtn.setImageResource(R.drawable.pause);
            mediaPlayer.start();
            Toast.makeText(MusicService.this, "isPlaying", Toast.LENGTH_LONG).show();
        }
    }

}
