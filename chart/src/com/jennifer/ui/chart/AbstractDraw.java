package com.jennifer.ui.chart;

import java.util.HashMap;

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

    public Object render() {

        this.drawBefore();

        return this.draw();
    }


}
