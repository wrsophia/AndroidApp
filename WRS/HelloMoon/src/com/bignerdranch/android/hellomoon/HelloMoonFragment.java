package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mStopButton;
	private Button mPauseButton;
	

	
	private void clickPause() {
		int messageResId = 0; 
		if (mPlayer.isnull() == false) {
			if (mPlayer.isPlaying()) {
				mPlayer.pause();
				mPauseButton.setText("Continue");
			}
			else {
				mPlayer.rePlay();
				mPauseButton.setText("Pause");
			}
		}
		else {
			messageResId = R.string.hellomoon_clickplay;
			Toast.makeText(getActivity().getBaseContext(), messageResId, Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		
		mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPlayer.play(getActivity());
			}
		});
		
		mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPlayer.stop();
			}
		});
		
		mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
		mPauseButton.setText("Pause");
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				clickPause();
			}
		});
		
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

}
