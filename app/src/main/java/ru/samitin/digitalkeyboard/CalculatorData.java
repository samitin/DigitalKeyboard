package ru.samitin.digitalkeyboard;

public class CalculatorData {
    private Double number=Double.NaN;


    public static final String PERCENT="%";
    public static final String PLUS="+";
    public static final String MINUS="-";
    public static final String MULTIPLY="*";
    public static final String DIVIDER="/";
    public String state="";

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
}
