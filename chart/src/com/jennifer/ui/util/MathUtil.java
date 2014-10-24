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

    private static double niceNum(double range, boolean round) {
        double exponent = Math.floor(Math.log10(range));
        double fraction = range / Math.pow(10, exponent);
        double nickFraction;

        if (round) {
            if (fraction < 1.5)
                nickFraction = 1;
            else if (fraction < 3)
                nickFraction = 2;
            else if (fraction < 7)
                nickFraction = 5;
            else
                nickFraction = 10;
        } else {
            if (fraction <= 1)
                nickFraction = 1;
            else if (fraction <= 2)
                nickFraction = 2;
            else if (fraction <= 5)
                nickFraction = 5;
            else
                nickFraction = 10;
        }

        return nickFraction * Math.pow(10, exponent);
    }

    private static double niceNum(double range) {
      return niceNum(range, false);
    }

    public static double[] nice(double min, double max, double ticks, boolean isNice) {

        double _max;
        double _min;

        if (min > max) {
            _max = min;
            _min = max;
        } else {
            _min = min;
            _max = max;
        }

        double _ticks = ticks;
        double _tickSpacing = 0;
        double _range;
        double _niceMin;
        double _niceMax;


        _range = (isNice) ? niceNum(_max - _min, false) : _max - _min;
        _tickSpacing = (isNice) ? niceNum(_range / _ticks, true) : _range / _ticks;
        _niceMin = (isNice) ? Math.floor(_min / _tickSpacing) * _tickSpacing : _min;
        _niceMax = (isNice) ? Math.floor(_max / _tickSpacing) * _tickSpacing : _max;


        return new double[] { _niceMin, _niceMax, _range, _tickSpacing };
    }
}
