package nau.algorithms;

/**
 *
 * Created by maxi on 01.02.16.
 */

import java.util.Random;

public class Trapeze {
    private Point[] points;

    public Trapeze()
    {
        boolean done = false;
        Random rand = new Random();
        points = new Point[4];

        while(!done) {
            for (int i = 0; i < 4; i++) {
                points[i] = new Point(rand.nextInt(64)-32, rand.nextInt(64)-32);
            }
           done = validate();
        }

    }

    public double getSquare()
    {
        // getting height
        double height = Math.abs(points[0].y - points[3].y);
        // getting length of 2 parallel sides of trapeze
        double longer = Math.abs(points[2].x-points[3].x);
        double shorter = Math.abs(points[1].x-points[0].x);
        // square formulae
        return 0.5*(longer+shorter)*height;
    }

    public double getPerimeter()
    {
        double side_1_2, side_2_3, side_3_4, side_4_1;
        side_1_2 = Math.sqrt(Math.pow((points[1].x - points[0].x), 2)+ Math.pow(points[1].y - points[0].y, 2));
        side_2_3 = Math.sqrt(Math.pow((points[2].x - points[1].x), 2)+ Math.pow(points[2].y - points[1].y, 2));
        side_3_4 = Math.sqrt(Math.pow((points[3].x - points[2].x), 2)+ Math.pow(points[3].y - points[2].y, 2));
        side_4_1 = Math.sqrt(Math.pow((points[0].x - points[1].x), 2)+ Math.pow(points[0].y - points[1].y, 2));

        return (Math.round((side_1_2+side_2_3+side_3_4+side_4_1)*10.0) / 10.0);
    }

    private boolean validate()
    {
        float slope_1_2, slope_2_3, slope_3_4, slope_4_1;
        // check for parallelism
        try {
            slope_1_2 = (points[1].y - points[0].y) / (points[1].x - points[0].x);
            slope_2_3 = (points[2].y - points[1].y) / (points[2].x - points[1].x);
            slope_3_4 = (points[3].y - points[2].y) / (points[3].x - points[2].x);
            slope_4_1 = (points[0].y - points[3].y) / (points[0].x - points[3].x);
        } catch (ArithmeticException e) {
            // zero division e.g
            return false;
        }

        // MUST be true to validate object
        return (   (slope_1_2 == slope_3_4)
                && (   (slope_1_2 != slope_2_3)
                    && (slope_2_3 != slope_3_4)
                    && (slope_2_3 != slope_4_1)
                    && (slope_3_4 != slope_4_1)
                    && (slope_4_1 != slope_1_2)));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++)
        {
           builder.append("Point #").append(i+1).append(": ");
           builder.append("x -> ").append(points[i].x).append(", y -> ").append(points[i].y).append("; ");
        }
        builder.append("Perimeter: ").append(this.getPerimeter()).append("; ");
        builder.append("Square: ").append(this.getSquare()).append("; ");
        return builder.toString();
    }
}
