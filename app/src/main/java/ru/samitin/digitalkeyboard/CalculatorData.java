package ru.samitin.digitalkeyboard;

public class CalculatorData {
    private double numberOne=Double.NaN;
    private double numberTwo=Double.NaN;

    public static final String PERCENT="%";
    public static final String PLUS="+";
    public static final String MINUS="-";
    public static final String MULTIPLY="*";
    public static final String DIVIDER="/";
    public static final String EQUALS="=";
    public String state="";

    public void clickSing(double number){
        switch (state){
            case PERCENT:
                break;
            case PLUS:
                break;
            case MINUS:
                break;
            case MULTIPLY:
                break;
            case DIVIDER:
                break;
            case EQUALS:
                break;
        }
    }
    public void delite(){
        numberOne=Double.NaN;
        numberTwo=Double.NaN;
    }
}
