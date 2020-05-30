package com.red.shinigami.interactivecookbook;

import android.os.Parcel;
import android.os.Parcelable;

class Recipes implements Parcelable {

    public String mrecipeName;
    private String mPrepTime;
    private String mCookTime;
    private String mTotalTime;
    private String mRecipeImages;
    private String mYTURL;


    Recipes(String recipeName, String recipeImage, String PrepTime, String CookTime, String TotalTime, String YTURL){
      mrecipeName = recipeName;
      mRecipeImages = recipeImage;
      mPrepTime = PrepTime;
      mCookTime = CookTime;
      mTotalTime = TotalTime;
      mYTURL = YTURL;



    }

    public Recipes(Parcel in) {
        mrecipeName = in.readString();
        mPrepTime = in.readString();
        mCookTime = in.readString();
        mTotalTime = in.readString();
        mRecipeImages = in.readString();
        mYTURL = in.readString();
    }

    public static final Creator<Recipes> CREATOR = new Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };

    String getmRecipeImages(){return mRecipeImages;}

     String getmrecipeName(){
      return mrecipeName;
    }

   String getmPrepTime(){
        return mPrepTime;
    }

    String getmCookTime(){
      return mCookTime;
    }

    String getmTotalTime(){
      return mTotalTime;
    }

    String getmYTURL(){ return mYTURL;}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mrecipeName);
        parcel.writeString(mPrepTime);
        parcel.writeString(mCookTime);
        parcel.writeString(mTotalTime);
        parcel.writeString(mRecipeImages);
        parcel.writeString(mYTURL);
    }
}