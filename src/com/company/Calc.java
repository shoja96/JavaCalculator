package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Calc {
    private String left;
    private String operand;
    private String right;
    Map<Integer, String> map = new HashMap<Integer, String>();
    List<String> list = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");

    private String[] ss={"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private String ans;
    public Calc(String l,String o,String r){
        this.left=l;
        this.operand=o;
        this.right=r;
        for (int i = 0; i < 100; i++) {
            map.put(i + 1, list.get(i));
        }
        calculate(left,operand,right);
    }

    private void calculate(String left, String operand, String right) {
        if(checkA(left) && checkA(right)){
            this.ans=evaluateA(Integer.parseInt(left),Integer.parseInt(right),operand);
        }
        else if(checkB(left)&&checkB(right)){
            this.ans=evaluateR(getInt(left),getInt(right),operand);
        }
        else printError();
    }

    private String evaluateA(int a, int b, String operand) {
        int re=0;
        if(operand.equals("+"))
            re=a+b;
        else if(operand.equals("-"))
            re=a-b;
        else if(operand.equals("*"))
            re=a*b;
        else if(operand.equals("/"))
            re=a/b;
        else
            printError();
        return Integer.toString(re);
    }
    private String evaluateR(int a, int b, String operand) {
        int re=0;
        if(operand.equals("+"))
            re=a+b;
        else if(operand.equals("-"))
            re=a-b;
        else if(operand.equals("*"))
            re=a*b;
        else if(operand.equals("/"))
            re=a/b;
        else
            printError();
        return map.get(re);
    }
    private boolean checkA(String s) {
        if(s.equals("1")|| s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9"))
            return true;
        return false;
    }
    private boolean checkB(String s){
        for(int i=0;i<10;i++){
            if(s.equals(ss[i]))
                return true;
        }return false;
    }
    private int getInt(String s){
        for(int i=0;i<10;i++) {
            if (s.equals(ss[i]))
                return i + 1;
        }return 0;
    }
    private void printError() {
        System.out.println("Either operator or operand is incorrect");
    }
    public void print() {
        System.out.println(this.ans);
    }
}
