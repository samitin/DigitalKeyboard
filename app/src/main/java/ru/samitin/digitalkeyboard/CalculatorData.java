package ru.samitin.digitalkeyboard;

public class CalculatorData {
    private Double numberOne=Double.NaN;
    private double numberTwo=Double.NaN;

    public static final String PERCENT="%";
    public static final String PLUS="+";
    public static final String MINUS="-";
    public static final String MULTIPLY="*";
    public static final String DIVIDER="/";
    public String state="";

    public String clickSing(double number){
        if (!numberOne.equals(Double.NaN)) {
            switch (state) {
                case PERCENT:
                    numberOne = numberOne % number;
                    break;
                case PLUS:
                    numberOne = numberOne + number;
                    break;
                case MINUS:
                    numberOne = numberOne - number;
                    break;
                case MULTIPLY:
                    numberOne = numberOne * number;
                    break;
                case DIVIDER:
                    numberOne = numberOne / number;
                    break;
            }
                return "";
        }else {
            numberOne=number;
            return "";
        }
    }
    public String getEquals(double number){
        String numberEquals="";
        if (!numberOne.equals(Double.NaN)) {
            switch (state) {
                case PERCENT: numberEquals= ""+(numberOne % number);break;
                case PLUS: numberEquals= ""+(numberOne + number);break;
                case MINUS: numberEquals= ""+(numberOne - number);break;
                case MULTIPLY: numberEquals= ""+(numberOne * number);break;
                case DIVIDER: numberEquals= ""+(numberOne / number);break;
            }
            numberOne=Double.NaN;
        }
         return numberEquals;
    }


    public void delite(){
        numberOne=Double.NaN;
        numberTwo=Double.NaN;
    }
}
