package ru.stqa.aqa.sandbox;

    public class MyFirstProgram {
    public static void main(String[] args){
        hello("World");
        hello("Mariya");
        hello("Bobby");

        Square s = new Square(5.0);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4.0, 5.0);
        System.out.println("Площадь прямоуголника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

    public static void hello(String user){
        System.out.println("Hello " + user);
    }




}