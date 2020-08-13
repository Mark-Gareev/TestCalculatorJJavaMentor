package com.company;

public class Calculations {
    private int result;
    public void Calculate(int a,int b, String operation)// simple Math perform there
    {
        switch (operation)
        {
            case ("Add"):
                result = a + b;
                break;
            case("Substract"):
                result = a - b;
                break;
            case ("Multiply"):
                result = a * b;
                break;
            case ("Divide"):
                result = a / b;

        }
    }
    public int getResult(){
        return result;
    }
}
