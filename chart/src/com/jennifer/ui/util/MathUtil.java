package com.jennifer.ui.util;


import com.jennifer.ui.common.Point;

/**
 * Created by yuni on 2014-10-24.
 */
public class MathUtil {
    public static double rotateX(int x, int y, float radian) {
        return x * Math.cos(radian) - y * Math.sin(radian);
    }

    public static double rotateY(int x, int y, float radian) {
        return x * Math.sin(radian) + y * Math.cos(radian);
    }

    public static Point rotate(int x, int y, float radian) {
        return new Point(rotateX(x, y, radian), rotateY(x, y, radian));
    }

    public static double radian (double degree) {
        return degree * Math.PI / 180;
    }

    public static double degree(double radian) {
        return radian * 180 / Math.PI;
    }

    public static double interpolateNumber(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static double interpolateRound(double a, double b, double t) {
        return Math.round(interpolateNumber(a, b, t));
    }
}
