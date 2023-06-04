package ru.stqa.aqa.sandbox;

    public class MyFirstProgram {
    public static void main(String[] args){
        hello("World");
        hello("Mariya");
        hello("Bobby");

        double l = 5;
        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

        double a = 4;
        double b = 5;
        System.out.println("Площадь прямоуголника со сторонами " + a + " и " + b + " = " + area(a, b));
    }

    public static void hello(String user){
        System.out.println("Hello " + user);
    }

    public static double area(double l){
        return l * l;
    }

    public static double area(double a, double b){
        return a * b;
    }
}