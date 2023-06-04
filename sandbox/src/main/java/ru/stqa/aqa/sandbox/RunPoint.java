package ru.stqa.aqa.sandbox;

public class RunPoint {

    public static void main(String[] args){

        double x1 = 2.0;
        double y1 = 6.0;
        Point p1 = new Point(x1, y1);

        double x2 = -4.0;
        double y2 = 3.0;
        Point p2 = new Point(x2, y2);

//        String strFunction = String.format("Расстояние между точками А(%.1f;%.1f) и Б(%.1f;%.1f) = %.1f", x1, y1, x2, y2, distance(p1, p2));
        String strMethod = String.format("Расстояние между точками А(%.1f;%.1f) и Б(%.1f;%.1f) = %.1f", x1, y1, x2, y2, p1.distance(p2));
        System.out.println(strMethod);
    }

    public static double distance(Point p1, Point p2){

        double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));

        return  distance;
    }
}
