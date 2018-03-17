package com.example.zxw.playexo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ZXW23 on 2018/3/17.
 */

public class PhoneBean implements Parcelable {
    private String age;

    protected PhoneBean(Parcel in) {
        age = in.readString();
    }

    public static final Creator<PhoneBean> CREATOR = new Creator<PhoneBean>() {
        @Override
        public PhoneBean createFromParcel(Parcel in) {
            return new PhoneBean(in);
        }

        @Override
        public PhoneBean[] newArray(int size) {
            return new PhoneBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(age);
    }
}
