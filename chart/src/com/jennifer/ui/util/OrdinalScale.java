package com.jennifer.ui.util;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;

/**
 * Created by Jayden on 2014-10-24.
 */
public class OrdinalScale extends AbstractScale {

    String[] domain;

    public OrdinalScale() {
        super();
    }

    public OrdinalScale(String[] domain, double[] range) {
        super();
        this.range(range);
        this.domain = domain;
    }

    public String[] domainString() {
        return this.domain;
    }

    public OrdinalScale domainString(String[] domain) {
        this.domain = domain;
        return this;
    }

    public double get(String x) {
        int index = -1;
        for (int i = 0; i < this.domain.length; i++) {
            if (x.equals(this.domain[i])) {
                index = i;
                break;
            }
        }

        if (index > -1) {
            return _range[index];
        } else {
            return -1;
        }
    }

    public OrdinalScale rangePoints(double interval[], double padding) {

        int step = this.domain.length;
        double unit = (interval[1] - interval[0] - padding) / step;
        ArrayList<Double> range = new ArrayList<Double>();

        for(int i = 0, len = this.domain.length; i < len; i++) {
            if (i == 0) {
                range.add(Double.valueOf(interval[0] + padding/2 + unit/2));
            } else {
                range.add(range.get(i-1).doubleValue() + unit);
            }
        }

        this.range(ScaleUtil.convert(range));
        _rangeBand = unit;

        return this;
    }

    public OrdinalScale rangeBands(double interval[], double padding, double outerPadding) {

        int count = domain.length;
        int step = count - 1;
        double band = (interval[1] - interval[0]) / step;

        ArrayList<Double> range = new ArrayList<Double>();

        for(int i = 0, len = this.domain.length; i < len; i++) {
            if (i == 0) {
                range.add(Double.valueOf(interval[0]));
            } else {
                range.add(Double.valueOf(band + range.get(i - 1).doubleValue()));
            }
        }

        this.range(ScaleUtil.convert(range));
        _rangeBand = band;

        return this;
    }
}
