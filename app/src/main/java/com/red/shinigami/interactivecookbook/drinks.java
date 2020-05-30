package com.red.shinigami.interactivecookbook;

import android.os.Parcel;
import android.os.Parcelable;

public class drinks implements Parcelable {
    private String mDrinksImage;
    private String mDrinksTitle;
    private String mDrinksDescription;
    private String mDrinksIngredient1;
    private String mDrinksIngredient2;
    private String mDrinksIngredient3;
    private String mSteps1;
    private String mSteps2;


    drinks(String DrinksImage, String DrinksTitle, String Drinks_Description, String Ingredient1, String Ingredient2, String Ingredient3, String Steps1, String Steps2) {
        mDrinksImage = DrinksImage;
        mDrinksTitle = DrinksTitle;
        mDrinksDescription = Drinks_Description;
        mDrinksIngredient1 = Ingredient1;
        mDrinksIngredient2 = Ingredient2;
        mDrinksIngredient3 = Ingredient3;
        mSteps1 = Steps1;
        mSteps2 = Steps2;
    }

    private drinks(Parcel in) {
        mDrinksImage = in.readString();
        mDrinksTitle = in.readString();
        mDrinksDescription = in.readString();
        mDrinksIngredient1 = in.readString();
        mDrinksIngredient2 = in.readString();
        mDrinksIngredient3 = in.readString();
        mSteps1 = in.readString();
        mSteps2 = in.readString();
    }

    public static final Creator<drinks> CREATOR = new Creator<drinks>() {
        @Override
        public drinks createFromParcel(Parcel in) {
            return new drinks(in);
        }

        @Override
        public drinks[] newArray(int size) {
            return new drinks[size];
        }
    };



    String getmDrinksImage() {
        return mDrinksImage;
    }
    String getmDrinksTitle() {
        return mDrinksTitle;
    }
    String getmDrinksDescription(){
        return mDrinksDescription;
    }
    String getmDrinksIngredient1(){return mDrinksIngredient1;}
    String getmDrinksIngredient2(){return mDrinksIngredient2;}
    String getmDrinksIngredient3(){return mDrinksIngredient3;}
    String getmSteps1(){return mSteps1;}
    String getmSteps2(){return mSteps2;}



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mDrinksImage);
        parcel.writeString(mDrinksTitle);
        parcel.writeString(mDrinksDescription);
        parcel.writeString(mDrinksIngredient1);
        parcel.writeString(mDrinksIngredient2);
        parcel.writeString(mDrinksIngredient3);
        parcel.writeString(mSteps1);
        parcel.writeString(mSteps2);
    }
}
