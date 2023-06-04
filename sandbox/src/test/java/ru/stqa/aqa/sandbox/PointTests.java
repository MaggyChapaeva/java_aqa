package ru.stqa.aqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

//Программа округляет результат до 10х

public class PointTests {

    @Test
    public void testDistance(){
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(3.0, 4.0);

        Assert.assertEquals(p1.distance(p2), 2.8);
    }

    @Test
    public void testDiffQuadrants(){
        Point p1 = new Point(2.0, -4.0);
        Point p2 = new Point(-3.0, 5.0);

        Assert.assertEquals(p1.distance(p2), 10.3);
    }

    @Test
    public void testEqualPoints(){
        Point p1 = new Point(2.0, 3.0);
        Point p2 = new Point(2.0, 3.0);

        Assert.assertEquals(p1.distance(p2), 0.0);
    }

    @Test
    public void testNullPoints(){
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(0.0, 0.0);

        Assert.assertEquals(p1.distance(p2), 0.0);
    }

    @Test
    public void testFractional(){
        Point p1 = new Point(1.5, 2.8);
        Point p2 = new Point(3.2, 4.5);

        Assert.assertEquals(p1.distance(p2), 2.4);
    }

    @Test
    public void testBigNumber(){

        Point p1 = new Point(123456789012345.0, 123456789012345.0);
        Point p2 = new Point(543210987654321.0, 543210987654321.0);

        Assert.assertEquals(p1.distance(p2), 593622080582532.6);
    }
}
