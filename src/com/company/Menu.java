package com.company;

import java.util.Scanner;

public class Menu {  //there will be a menu or GUI if it will be necessary
    public void run(){
        try {
            System.out.println("Put your math");
            Scanner scan = new Scanner(System.in);
            NumberWorker converter = new NumberWorker(scan.nextLine());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }

    }
}
