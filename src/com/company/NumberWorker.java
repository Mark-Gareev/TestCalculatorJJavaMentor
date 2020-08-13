package com.company;

import java.nio.channels.IllegalBlockingModeException;
import java.util.regex.Pattern;


public class NumberWorker {   //class to cast String to Numbers


    public NumberWorker(String numbers) throws IncorrectInputException
    {
        int a = 0, b = 0;
        boolean flag;
        String operation = "";
        String[] mas = new String[3];
        Pattern separator = Pattern.compile("\\s");
        Calculations count = new Calculations();


        try {
            mas = separator.split(numbers,-1);
        }
        catch (Exception e)                         //проверка на пустую строку и на правильность разбиения по пробелам
        {
            throw new IncorrectInputException();
        }
        if (numbers.length() == 0)
            throw  new IncorrectInputException();



        switch (String.valueOf(mas[0].charAt(0)))  // choose type of numbers, Roman or Arabian
        {
            case ("I"):
                flag = true;
                break;
            case ("V"):
                flag = true;
                break;
            case ("X"):
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        if (flag)//Roman type, Arabian numbers not allowed
        {
            a = castRomanToArabian(mas[0]);
            b = castRomanToArabian(mas[2]);
            operation = takeOperator(mas[1]);
            count.Calculate(a,b,operation);
            System.out.println(castArabianToRoman(count.getResult()));
        }
        else//Arabian type, Roman not allowed
        {
            try {
                a = Integer.parseInt(mas[0]);
                b = Integer.parseInt(mas[2]);
                operation = takeOperator(mas[1]);
            }
            catch (Exception e){
                throw new IncorrectInputException();
            }
            count.Calculate(a,b,operation);
            System.out.println(count.getResult());
        }
    }


    private int castRomanToArabian(String num) throws IncorrectInputException
    {
        int res = 0;
        String symbol;
        for(int i = 0; i < num.length();i++)
        {
            symbol = String.valueOf(num.charAt(i));
            switch (symbol)
            {
                case ("X"):
                    res += 10;
                    break;
                case ("I"):
                    res += 1;
                    break;
                case ("V"):
                    res += 5;
                    break;
                default:
                    throw new IncorrectInputException();
            }
        }
        return res;
    }
    private String takeOperator(String oper) throws IncorrectInputException
    {
        switch (oper)
        {
            case ("+"):
                return ("Add");
            case("-"):
                return ("Substract");
            case ("*"):
                return ("Multiply");
            case ("/"):
                return ("Divide");
            default:
                throw new IncorrectInputException();

        }
    }
    private String castArabianToRoman(int num)
    {
        String res = "";
            while(num>=500)
            {
                num -= 500;
                res += "D";
            }
            while(num >= 100)
            {
                num -= 100;
                res = "C";
            }
            while(num > 50)
            {
                num  -= 50;
                res += "L";
            }
            while(num >= 10)
            {
                num -= 10;
                res+= "X";
            }
            while(num >= 5)
            {
                num -= 5;
                res += "V";
            }
            while(num > 0)
            {
                num--;
                res += "I";
            }
        return res;
    }

}
