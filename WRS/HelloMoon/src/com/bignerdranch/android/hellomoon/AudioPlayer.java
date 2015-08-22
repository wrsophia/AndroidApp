package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	
	private MediaPlayer mPlayer;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c) {
		stop();
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
				
			}
		});
		mPlayer.start();
	}
	
	public void pause() {

		mPlayer.pause();
	}
	
	public boolean isnull() {
		if (mPlayer != null) return false;
		else return true;
	}
	
	public boolean isPlaying() {
		if (mPlayer.isPlaying()) return true;
		else return false;
	}
	
	public void rePlay() {
		mPlayer.start();
	}

}

