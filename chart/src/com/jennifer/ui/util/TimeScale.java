package com.jennifer.ui.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jayden on 2014-10-24.
 */
public class TimeScale extends LinearScale {
    public TimeScale() {
        super();
    }

    public TimeScale(double[] domain, double[] range) {
        super(domain, range);
    }

    public TimeScale(Date[] domain) {
        this.domain(domain);
    }

    public TimeScale(Date[] domain, double[] range) {
        this.domain(domain);
        this.range(range);
    }

    public Scale domain(Date[] domain) {

        for(int i = 0, len = domain.length; i < len; i++) {
            _domain[i] = domain[i].getTime();
        }

        return this;
    }

    public double get(Date d) {
        return get((double)d.getTime());
    }

    public double get(long time) {
        return get((double)time);
    }

    public ArrayList<Date> ticks(Time type, int step) {
        long start = (long)this.min();
        long end = (long)this.max();

        ArrayList<Date> times = new ArrayList<Date>();
        while(start < end) {
            Date d = new Date();
            d.setTime(start);

            times.add(d);

            start = TimeUtil.add(d, type, step).getTime();
        }

        Date d = new Date();
        d.setTime(start);

        times.add(d);

        double first = this.get(times.get(0).getTime());
        double second = this.get(times.get(1).getTime());

        _rangeBand = second - first;

        return times;

    }

    public ArrayList<Date> realTicks(Time type, int step) {
        long start = (long)this.min();
        long end = (long)this.max();

        ArrayList<Date> times = new ArrayList<Date>();
        Calendar c = Calendar.getInstance();

        Date date = new Date();
        date.setTime(start);
        Date realStart = null;

        c.setTime(date);
        if (type == Time.YEARS) {
            c.set(c.get(Calendar.YEAR), 1, 1, 0, 0, 0);
        } else if (type == Time.MONTHS) {
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1, 0, 0, 0);
        } else if (type == Time.DAYS) {
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
        } else if (type == Time.HOURS) {
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), 0, 0);
        } else if (type == Time.MINUTES) {
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), 0);
        } else if (type == Time.SECONDS) {
            c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
        }

        realStart = c.getTime();

        long start2 = realStart.getTime();
        while (start2 < end) {

            Date d = new Date();
            d.setTime(start2);

            times.add(d);

            start2 = TimeUtil.add(d, type, step).getTime();
        }

        double first = this.get(times.get(1).getTime());
        double second = this.get(times.get(2).getTime());

        _rangeBand = second - first;

        return times;
    }

    public Date invert(long time) {
        Date d = new Date();
        d.setTime((long)super.invert((double)time));

        return d;
    }
}
