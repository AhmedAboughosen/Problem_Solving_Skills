/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meeting;

import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class Meeting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);

        int xa = in.nextInt();
        int ya = in.nextInt();
        int xb = in.nextInt();
        int yb = in.nextInt();
        int radiators = in.nextInt(), count = 0;
        Radiators[] arr = new Radiators[radiators];
        for (int i = 0; i < radiators; ++i) {
            Radiators obj = new Radiators();
            obj.x = in.nextInt();
            obj.y = in.nextInt();
            obj.r = in.nextInt();
            arr[i] = obj;
        }

        int minx = Math.min(xa, xb);
        int max_x = Math.max(xa, xb);
        int maxy = Math.max(ya, yb);
        int miny = Math.min(ya, yb);

        for (int i = minx; i <= max_x; ++i) {

            Point general = new Point();
            general.x = i;
            general.y = miny;
            Point general_2 = new Point();
            general_2.x = i;
            general_2.y = maxy;
            count += check(general, arr) + check(general_2, arr);
        }

        for (int i = miny + 1 ; i < maxy; i++) {
            Point general = new Point();
            general.x = xa;
            general.y = i;
            Point general_2 = new Point();
            general_2.x = xb;
            general_2.y = i;
            
            count += check(general, arr) + check(general_2, arr);
        }

        System.out.println(count);
    }

    public static int distance(Point general, Point radiator) {
        return (general.x - radiator.x) * (general.x - radiator.x) + (general.y - radiator.y) * (general.y - radiator.y);
    }

    public static int check(Point general, Radiators[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Point radiator = new Point();
            radiator.x = arr[i].x;
            radiator.y = arr[i].y;
            if (distance(general, radiator) <= arr[i].r * arr[i].r) {
                return 0;
            }
        }
        return 1;
    }
}

class Radiators {

    public int x;
    public int y;
    public int r;
}

class Point {

    int x;
    int y;
}
