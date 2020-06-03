package com.red.shinigami.interactivecookbook;

import android.os.Parcel;
import android.os.Parcelable;

public class Baking_Model implements Parcelable {

    private String mName;
    private String mImage;
    private String mPrep;
    private String mCook;
    private String mTotal;

    Baking_Model(String Name, String Image, String Prep, String Cook, String Total){
        mName = Name;
        mImage = Image;
        mPrep = Prep;
        mCook = Cook;
        mTotal = Total;
    }

    protected Baking_Model(Parcel in) {
        mName = in.readString();
        mImage = in.readString();
        mPrep = in.readString();
        mCook = in.readString();
        mTotal = in.readString();
    }

    public static final Creator<Baking_Model> CREATOR = new Creator<Baking_Model>() {
        @Override
        public Baking_Model createFromParcel(Parcel in) {
            return new Baking_Model(in);
        }

        @Override
        public Baking_Model[] newArray(int size) {
            return new Baking_Model[size];
        }
    };

    String getmName(){return mName;}
    String getmImage(){return  mImage;}
    String getmPrep(){return mPrep;}
    String getmCook(){return mCook;}
    String getmTotal(){return mTotal;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(mName);
        parcel.writeString(mImage);
        parcel.writeString(mPrep);
        parcel.writeString(mCook);
        parcel.writeString(mTotal);
    }


}
