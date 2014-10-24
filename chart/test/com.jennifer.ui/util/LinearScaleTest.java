package com.jennifer.ui.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LinearScaleTest {
    @Test
    public void testLinearScale() {
        LinearScale scale = new LinearScale();

        Assert.assertNotNull("domain null check", scale.domain());
        Assert.assertNotNull("range null check", scale.range());

        double d[] = new double[] { 0, 100 };
        scale.domain(d);
        Assert.assertArrayEquals("domain value check", scale.domain(), d, 0);

        scale.range(d);
        Assert.assertArrayEquals("domain value check", scale.range(), d, 0);


        Assert.assertEquals("domain value check", scale.get(0), scale.range()[0]);

    }
}