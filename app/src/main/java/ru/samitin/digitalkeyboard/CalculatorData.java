package ru.samitin.digitalkeyboard;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorData implements Parcelable {
    private Double number=Double.NaN;
    public static final String PERCENT="%";
    public static final String PLUS="+";
    public static final String MINUS="-";
    public static final String MULTIPLY="*";
    public static final String DIVIDER="/";
    public String state="";
    public CalculatorData(){}


    public String clickSing(double number){
        if (!this.number.equals(Double.NaN)) {
            switch (state) {
                case PERCENT:
                    this.number = this.number % number;
                    break;
                case PLUS:
                    this.number = this.number + number;
                    break;
                case MINUS:
                    this.number = this.number - number;
                    break;
                case MULTIPLY:
                    this.number = this.number * number;
                    break;
                case DIVIDER:
                    this.number = this.number / number;
                    break;
            }
                return "";
        }else {
            this.number=number;
            return "";
        }
    }
    public String getEquals(double number){
        String numberEquals="";
        if (!this.number.equals(Double.NaN)) {
            switch (state) {
                case PERCENT: numberEquals= ""+(this.number % number);break;
                case PLUS: numberEquals= ""+(this.number + number);break;
                case MINUS: numberEquals= ""+(this.number - number);break;
                case MULTIPLY: numberEquals= ""+(this.number * number);break;
                case DIVIDER: numberEquals= ""+(this.number / number);break;
            }
            this.number=Double.NaN;
        }
         return numberEquals;
    }
    public void delite(){
        this.number=Double.NaN;
    }

    protected CalculatorData(Parcel in) {
        if (in.readByte() == 0) {
            number = null;
        } else {
            number = in.readDouble();
        }
        state = in.readString();
    }

    public static final Creator<CalculatorData> CREATOR = new Creator<CalculatorData>() {
        @Override
        public CalculatorData createFromParcel(Parcel in) {
            return new CalculatorData(in);
        }

        @Override
        public CalculatorData[] newArray(int size) {
            return new CalculatorData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (number == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(number);
        }
        parcel.writeString(state);
    }
}
