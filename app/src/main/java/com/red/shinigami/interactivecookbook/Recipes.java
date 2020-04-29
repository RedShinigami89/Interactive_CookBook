package com.red.shinigami.interactivecookbook;

class Recipes {

    private String mrecipeName;
    private String mPrepTime;
    private String mCookTime;
    private String mTotalTime;

    private int msampleImage;
    Recipes(String recipeName, int sampleImage, String PrepTime, String CookTime, String TotalTime){
      mrecipeName = recipeName;
      msampleImage = sampleImage;
      mPrepTime = PrepTime;
      mCookTime = CookTime;
      mTotalTime = TotalTime;


    }

     void changeText(String text){
      mrecipeName = text;
    }

    int getMsampleImage(){
      return msampleImage;
    }

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


}