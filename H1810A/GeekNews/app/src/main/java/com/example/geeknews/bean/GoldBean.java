package com.example.geeknews.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class GoldBean implements Parcelable {

    private String name;
    private boolean selected;

    public GoldBean() {
        super();
    }

    @Override
    public String toString() {
        return "GoldBean{" +
                "name='" + name + '\'' +
                ", selected=" + selected +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public GoldBean(String name, boolean selected) {

        this.name = name;
        this.selected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeByte(this.selected ? (byte) 1 : (byte) 0);
    }

    protected GoldBean(Parcel in) {
        this.name = in.readString();
        this.selected = in.readByte() != 0;
    }

    public static final Parcelable.Creator<GoldBean> CREATOR = new Parcelable.Creator<GoldBean>() {
        @Override
        public GoldBean createFromParcel(Parcel source) {
            return new GoldBean(source);
        }

        @Override
        public GoldBean[] newArray(int size) {
            return new GoldBean[size];
        }
    };
}
