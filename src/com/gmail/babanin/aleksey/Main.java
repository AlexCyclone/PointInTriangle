package com.gmail.babanin.aleksey;

import java.util.Scanner;

public class Main {

    private static Scanner sc;
    
    public static void main(String[] args) {
        Triangle triangle = new Triangle(0, 0, 4, 4, 6, 1);

        double x;
        double y;

        sc = new Scanner(System.in);

        /* request coordinate */
        System.out.println("Enter X coordinate");
        x = sc.nextDouble();

        System.out.println("Enter Y coordinate");
        y = sc.nextDouble();

        /* check point coordinate */
        if (triangle.pointInside(x, y)) {
            System.out.println("Your point inside");
        } else {
            System.out.println("Your point outside");
        }
    }

}
