package com.jennifer.ui.util;

import java.util.ArrayList;

/**
 * Created by Jayden on 2014-10-24.
 */
public class ScaleUtil {

    public static double[] convert(ArrayList<Double> list) {
        double[] a  = new double[list.size()];
        for(int i =0, len = a.length; i < len; i++) a[i] = list.get(i).doubleValue();

        return a ;
    }

}
