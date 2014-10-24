package com.jennifer.ui.chart;

import java.util.HashMap;
import java.util.List;

/**
 *
 *
 *
 *
 * Created by yuni on 2014-10-23.
 */
public abstract  class AbstractDraw {


    HashMap<String, Object> attrs = new HashMap<String, Object>();

    public abstract void drawBefore();
    public abstract Object draw();

    public void attr(String key, Object value) {
        attrs.put(key, value);
    }

    public Object attr(String key) {
        return attrs.get(key);
    }

    public HashMap<String, Object> attr() {
        return attrs;
    }

    public boolean has(String key) {
        return attrs.containsKey(key);
    }

    public int i(String key) {
        return Integer.valueOf((String)attrs.get(key)).intValue();
    }

    public long l(String key) {
        return Long.valueOf((String)attrs.get(key)).longValue();
    }

    public double d(String key) {
        return Double.valueOf((String)attrs.get(key)).doubleValue();
    }

    public List<Object> list(String key) {
        return (List<Object>)attrs.get(key);
    }

    public Object render() {

        this.drawBefore();

        return this.draw();
    }

}