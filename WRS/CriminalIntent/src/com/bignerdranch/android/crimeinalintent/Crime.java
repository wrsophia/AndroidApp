package com.bignerdranch.android.crimeinalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Crime {
	
	private static final String JSON_ID = "id";
	private static final String JASON_TITLE = "title";
	private static final String JASON_SOLVED = "solved";
	private static final String JASON_DATE = "date";
	
	
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	
	public Crime(){
		mId = UUID.randomUUID();
		mDate = new Date();
		
	}
	
	public Crime(JSONObject json) throws JSONException {
		mId = UUID.fromString(json.getString(JSON_ID));
		if (json.has(JASON_TITLE)) {
			mTitle = json.getString(JASON_TITLE);
		}
		mSolved = json.getBoolean(JASON_SOLVED);
		mDate = new Date(json.getLong(JASON_DATE));
	}
	
	public JSONObject toJSON() throws JSONException {
	
		JSONObject json = new JSONObject();
		json.put(JSON_ID, mId.toString());
		json.put(JASON_TITLE, mTitle);
		json.put(JASON_SOLVED, mSolved);
		json.put(JASON_DATE, mDate.getTime());
		
		return json;
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
