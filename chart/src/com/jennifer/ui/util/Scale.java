package com.jennifer.ui.util;

/**
 * Created by yuni on 2014-10-24.
 */
public interface Scale {
    public Scale domain(double[] domain);
    public Scale range(double[] range);
    public double[] domain();
    public double[] range();
    public double max();
    public double min();
    public double rangeBand();
    public double rate(double value, double max);
    public double invert(double y);
}
