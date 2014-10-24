package com.jennifer.ui.util;

/**
 * Created by yuni on 2014-10-24.
 */
public abstract class AbstractScale implements Scale {
    protected double[] _domain;
    protected double[] _range;
    protected double _rangeBand;

    protected boolean _clamp;

    protected AbstractScale() {
        _domain = new double[] {0, 1 };
        _range = new double[] { 0, 1 };
    }

    protected AbstractScale(double[] domain, double[] range) {
        _domain = domain;
        _range = range;
    }

    public void clamp(boolean clamp) {
        _clamp = clamp;
    }

    public Scale domain(double[] domain) {
        _domain = domain;
        return this;
    }
    public Scale range(double[] range) {
        _range = range;
        return this;
    }
    public double[] domain() {
        return _domain;
    }
    public double[] range() {
        return _range;
    }

    public double get(double x) {
        return 0;
    }

    @Override
    public double max() {
        return Math.max(_domain[0], _domain[_domain.length - 1]);
    }

    @Override
    public double min() {
        return Math.min(_domain[0], _domain[_domain.length - 1]);
    }

    @Override
    public double rangeBand() {
        return _rangeBand;
    }

    @Override
    public double rate(double value, double max) {
        return get(max() * (value / max));
    }

    @Override
    public double invert(double y) {
        return 0;
    }
}
