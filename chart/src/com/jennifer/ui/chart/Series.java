package com.jennifer.ui.chart;

/**
 * Created by Jayden on 2014-10-24.
 */
public class Series extends AbstractDraw {

    private String target;
    private String title;
    private String color;
    private double min;
    private double max;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public void drawBefore() {

    }

    @Override
    public Object draw() {
        return null;
    }
}
