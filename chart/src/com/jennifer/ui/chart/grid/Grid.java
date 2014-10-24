package com.jennifer.ui.chart.grid;

import com.jennifer.ui.chart.AbstractDraw;
import com.jennifer.ui.chart.ChartBuilder;

import java.util.HashMap;

/**
 * Created by Jayden on 2014-10-24.
 */
public class Grid extends AbstractDraw {
    protected GridOrient orient;
    protected ChartBuilder chart;

    public Grid(ChartBuilder chart, GridOrient orient) {
        this.chart = chart;
        this.orient = orient;
    }

    @Override
    public void drawBefore() {

    }

    @Override
    public Object draw() {
        return null;
    }
}