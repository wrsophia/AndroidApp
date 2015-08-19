package com.bignerdranch.android.crimeinalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
	
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	
	public Crime(){
		mId = UUID.randomUUID();
		mDate = new Date();
		
	}
	
	@Override
	public String toString() {
		return mTitle;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public UUID getId() {
		return mId;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}
	
	@SuppressWarnings("static-access")
	public CharSequence getFormattedDate() {
	    android.text.format.DateFormat df = new android.text.format.DateFormat();
	    return df.format("yyyy-MM-dd", mDate);
	}
	
	@SuppressWarnings("static-access")
	public CharSequence getFormattedTime() {
	    android.text.format.DateFormat df = new android.text.format.DateFormat();
	    return df.format("kk:mm", mDate);
	}
	
	

}
