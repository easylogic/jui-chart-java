package com.jennifer.ui.util;

/**
 * Created by yuni on 2014-10-23.
 */
public class Color {

    private final String color;

    public Color(String color) {
        this.color = color;
    }
    public Color parseColor() {

        return this;
    }

    public static Color parse(String color) {
        return new Color(color).parseColor();
    }
}
