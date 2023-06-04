package ru.stqa.aqa.sandbox;

    public class MyFirstProgram {
    public static void main(String[] args){
        hello("World");
        hello("Mariya");
        hello("Bobby");

        Square s = new Square();
        s.l = 5.0;
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

        Rectangle r = new Rectangle();
        r.a = 4.0;
        r.b = 5.0;
        System.out.println("Площадь прямоуголника со сторонами " + r.a + " и " + r.b + " = " + area(r));
    }

    public static void hello(String user){
        System.out.println("Hello " + user);
    }

    public static double area(Square s){
        return s.l * s.l;
    }

    public static double area(Rectangle r){
        return r.a * r.b;
    }
}