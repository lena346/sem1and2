package com.company;

public class Main {
    public static void main(String[] args) throws Exception {
        //9
        System.out.println(sub21(22));
        //10
        System.out.println(armean(22, 24));
        //11
        System.out.println(geomean(9, 9));
        //12
        System.out.println(distance(5.5, 9.7, 10.5,20.7));
        //1
        System.out.println("Hello world!");
        //2
        int x = 10;
        System.out.println(x);
        //3
        System.out.println(++x);
        System.out.println(x++);
        //4
        int t = 20;
        int r = 8;
        int u = r;
        r = t;
        t = u;
        System.out.println("r=" + r + "; t=" + t);
        //5
        double z = 5;
        double b = 6;
        double f = Math.sqrt(Math.pow(z, 2) + Math.pow(b, 2));
        System.out.println(f);
        //6
        int s = 65789;
        int k = s % 10;
        System.out.println(k);
        //7
        int l = s % 100 / 10;
        System.out.println(l);
        //8
        int h = 34;
        System.out.println(h / 10);
        System.out.println();
    }

    //9
    public static int sub21(int a) {
        return a - 21;
    }

    //10
    public static int armean(int n, int m) {
        return (n + m) / 2;
    }

    //11
    public static double geomean(int d, int q) {
        return Math.sqrt(d * q);
    }

    // 12
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
}

