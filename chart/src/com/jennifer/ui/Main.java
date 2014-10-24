package com.jennifer.ui;

import com.jennifer.ui.util.LinearScale;
import com.jennifer.ui.util.Time;
import com.jennifer.ui.util.TimeScale;
import com.jennifer.ui.util.TimeUtil;

import java.util.Date;

/**
 * Created by Jayden on 2014-10-24.
 */
public class Main {

    public static void main(String[] args) {
        LinearScale scale = new LinearScale(new double[] { 0, 100}, new double[] {0, 1000 });

        System.out.println(scale.get(0) + " : " + 0);
        System.out.println(scale.get(1) + " : " + 10);
        System.out.println(scale.get(100) + " : " + 1000);

        System.out.println(scale.invert(1000));
        System.out.println(scale.invert(100));
        System.out.println(scale.invert(10));
        System.out.println(scale.invert(0));

        System.out.println(scale.invert(99.9999));

        TimeScale tscale = new TimeScale();
        tscale.domain(new Date[] {
            new Date(),
            TimeUtil.add(new Date(), Time.HOURS, 5)
        });
        tscale.range(new double[] { 0, 1000 } );

        System.out.println(tscale.get(TimeUtil.add(new Date(), Time.HOURS, 1).getTime()));

        System.out.println(tscale.ticks(Time.HOURS, 1));

        System.out.println(tscale.realTicks(Time.HOURS, 1));



    }
}
