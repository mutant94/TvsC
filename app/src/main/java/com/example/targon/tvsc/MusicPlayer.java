package com.example.targon.tvsc;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by Targon on 07.01.2016.
 */
public class MusicPlayer {
    static private MusicPlayer player;
    private static MediaPlayer mediaPlayer;
    private boolean onPause;
    AppCompatActivity parent;
    public static MusicPlayer getPlayer(AppCompatActivity activity) {
        if(player==null){
            player=new MusicPlayer(activity);
        }
        return player;
    }
    private MusicPlayer(AppCompatActivity parent){
        mediaPlayer = MediaPlayer.create(parent, R.raw.theme);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        });
    }
}
