package com.red.shinigami.interactivecookbook;

class Recipes {

    String mrecipeName;
    String mPrepTime;
    String mCookTime;
    String mTotalTime;

    int msampleImage;

  public  Recipes(String recipeName, int sampleImage, String PrepTime, String CookTime, String TotalTime){
      mrecipeName = recipeName;
      msampleImage = sampleImage;
      mPrepTime = PrepTime;
      mCookTime = CookTime;
      mTotalTime = TotalTime;


    }

    public void changeText(String text){
      mrecipeName = text;
    }

    public int getMsampleImage(){

      return msampleImage;
    }

    public String getmrecipeName(){

      return mrecipeName;
    }

    public String getmPrepTime(){
      return mPrepTime;
    }

    public String getmCookTime(){
      return mCookTime;
    }

    public String getmTotalTime(){
      return mTotalTime;
    }


}