package ua.lviv.lga.task02;

import java.util.Scanner;

public class ApplicationTask02  {


    public static void main(String[] args) throws MyException,IllegalAccessException{
        double a;
        double b;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть число a");
        sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            a = sc.nextDouble();

            System.out.println("Введіть число b");
        
            if (sc.hasNextDouble()) {
            b = sc.nextDouble();
            Methods ms = new Methods(a, b);
            ms.checkingVariables();
            System.out.println("a+b = " + ms.add());
            System.out.println("a-b = " + ms.minus());
            System.out.println("a*b = " + ms.multiplication());
            System.out.println("a/b = " + ms.divide());
        }
        else {throw new MyException("Введене число не є дійсним");}
        }
        else {throw new MyException("Введене число не є дійсним");}

    }



}
