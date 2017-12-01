package model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tan.nt on 12/1/17.
 */

public class MTemps extends MBase implements Parcelable{
    protected MTemps(Parcel in) {
    }

    public static final Creator<MTemps> CREATOR = new Creator<MTemps>() {
        @Override
        public MTemps createFromParcel(Parcel in) {
            return new MTemps(in);
        }

        @Override
        public MTemps[] newArray(int size) {
            return new MTemps[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
