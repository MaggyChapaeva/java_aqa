package ru.stqa.aqa.sandbox;

public class Equation {

    private double a;
    private double b;
    private double c;

    private int n;

    //вычисление количества корней квадратного уравнения
    public Equation(double a, double b, double c) {

        this.a = a;
        this.b = b;
        this.c = c;

        double d = b*b - 4*a*c;

        if (a != 0) {
            if(d > 0) {
                n = 2;
            }else if (d == 0){
                n = 1;
            } else {
                n = 0;
            }
        } else if (b != 0){
            n = 1;
        } else if (c != 0) {
                n = 0;
        } else {
            n = -1;
        }

        //я бы сделала так
        /*if (a == 0 && b == 0 && c == 0) {
            n = -1;
        } else if (a == 0) {
            if (b != 0) {
                n = 1;
            }
        } else {
            if (d > 0) {
                n = 2;
            } else if (d == 0) {
                n = 1;
            }
        }*/





    }

    public int rootNumber() {
        return n;
    }
}
