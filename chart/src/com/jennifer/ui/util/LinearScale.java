package com.jennifer.ui.util;

import java.util.ArrayList;

/**
 * Linear Scale
 *
 * new LinearScale(domain, range)
 *
 *
 *
 * Created by yuni on 2014-10-24.
 */
public class LinearScale extends AbstractScale {
    private boolean _round = false ;
    public LinearScale() {
        super();
    }

    public LinearScale(double[] domain, double[] range) {
        super(domain, range);
    }

    public double get(double x) {
        int index = -1;
        int target;

        for (int i = 0, len = _domain.length; i < len; i++) {

            if (i == len - 1) {
                if (x == _domain[i]) {
                    index = i;
                    break;
                }
            } else {
                if (_domain[i] < _domain[i + 1]) {
                    if (x >= _domain[i] && x < _domain[i + 1]) {
                        index = i;
                        break;
                    }
                } else if (_domain[i] >= _domain[i + 1]) {
                    if (x <= _domain[i] && _domain[i + 1] < x) {
                        index = i;
                        break;
                    }
                }
            }
        }

        if (_range == null) {
            if (index == 0) {
                return 0;
            } else if (index == -1) {
                return 1;
            } else {
                double min = _domain[index - 1];
                double max = _domain[index];

                double pos = (x - min) / (max - min);

                return pos;
            }
        } else {

            if (_domain.length - 1 == index) {
                return _range[index];
            } else if (index == -1) {

                double max = max();
                double min = min();

                if (max < x) {

                    if (_clamp) return max;

                    double last = _domain[_domain.length -1];
                    double last2 = _domain[_domain.length -2];

                    double rlast = _range[_range.length -1];
                    double rlast2 = _range[_range.length -2];

                    double distLast = Math.abs(last - last2);
                    double distRLast = Math.abs(rlast - rlast2);

                    return rlast + Math.abs(x - max) * distRLast / distLast;

                } else if (min > x) {

                    if (_clamp) return min;

                    double first = _domain[0];
                    double first2 = _domain[1];

                    double rfirst = _range[0];
                    double rfirst2 = _range[1];

                    double distFirst = Math.abs(first - first2);
                    double distRFirst = Math.abs(rfirst - rfirst2);

                    return rfirst - Math.abs(x - min) * distRFirst / distFirst;
                }

                return _range[_range.length - 1];
            } else {

                double min = _domain[index];
                double max = _domain[index+1];

                double minR = _range[index];
                double maxR = _range[index + 1];

                double pos = (x - min) / (max - min);

                double scale = _round ? MathUtil.interpolateRound(minR, maxR, pos) : MathUtil.interpolateNumber(minR, maxR, pos);

                return scale;

            }
        }

    }

    public LinearScale rangeRound(double[] range) {
        _round = true;

        return (LinearScale)this.range(range);
    }

    public double invert(double y) {
        return new LinearScale(this.range(), this.domain()).get(y);
    }

    public double[] ticks() {
        return ticks(10, false, 1000000);
    }

    public double[] ticks(int count, boolean isNice, int intNumber) {
        ArrayList<Double> list = new ArrayList<Double>();

        if (_domain[0] == 0 && _domain[1] == 0) {
            return new double[0];
        }

        double[] arr = MathUtil.nice(_domain[0], _domain[1], count, isNice );

        double min = arr[0];
        double max = arr[1];
        double range = arr[2];
        double spacing = arr[3];

        double start = min * intNumber;
        double end = max * intNumber;
        while (start <= end) {
            list.add(Double.valueOf(start/intNumber));
            start += spacing * intNumber;
        }

        if (list.get(list.size()-1).doubleValue() * intNumber != end && start > end) {
            list.add(Double.valueOf(end / intNumber));
        }

        return ScaleUtil.convert(list);
    }
}
