package com.jennifer.ui.chart.grid;

import com.jennifer.ui.chart.ChartBuilder;
import com.jennifer.ui.util.OrdinalScale;
import com.jennifer.ui.util.Scale;
import com.jennifer.ui.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * new BlockGrid().title().domain().target()
 *
 * Created by Jayden on 2014-10-24.
 */
public class BlockGrid extends Grid {

    private OrdinalScale scale = new OrdinalScale();

    public BlockGrid(ChartBuilder chart, GridOrient orient) {
        super(chart, orient);
    }

    public Scale getScale() {
        return scale;
    }

    public BlockGrid title(String title) {
        attr("title", title);
        return this;
    }

    public BlockGrid domain(String str) {
        return domain(str.split(","));
    }

    public BlockGrid domain(String[] str) {
        scale.domainString(str);
        attr("domain", StringUtil.join(str, ","));
        return this;
    }

    public Dom top(Dom g) {
        int full_height = chart.height();

        if (!this.has("line")) {
            g.append(this.axisLine(chart, {
                    x2 : chart.width()
            }))
        }

        for (int i = 0; i < this.points.length; i++) {

            String domain = (this.has("format")) ? this.execFormat(this.domain[i]) : this.domain[i];

            if ("".equals(domain)) {
                continue;
            }

            Dom axis = dom.group({
                    "transform" : "translate(" + this.points[i] + ", 0)"
            })

            axis.append(this.line(chart, {
                    x1 : -this.half_band,
                    y1 : 0,
                    x2 : -this.half_band,
                    y2 : (this.has("line")) ? full_height : this.bar
            }));

            axis.append(chart.text({
                    x : 0,
                    y : -20,
                    "text-anchor" : "middle"
            }, (grid.format) ? grid.format(this.domain[i]) : this.domain[i]))

            g.append(axis);
        }

        if (!this.has("full")) {
            var axis = dom.group({
                    "transform" : "translate(" + chart.width() + ", 0)"
            })

            axis.append(this.line(chart, {
                    y2 : (grid.line) ? full_height : this.bar
            }));

            g.append(axis);
        }

        return g;
    }

    public void drawBefore() {
        initDomain();

        int width = chart.width();
        int height = chart.height();
        int max = (orient == GridOrient.LEFT || orient == GridOrient.RIGHT) ? height : width;

        // scale 도메인 설정
        this.domain((String) attr("domain"));
        double range[] = new double[] { 0, (double)max };

        if (this.full()) {
            this.scale.rangeBands(range, 0, 0);
        } else {
            this.scale.rangePoints(range, 0);
        }

        this.points = this.scale.range();
        this.domain = this.scale.domain();
        this.band = this.scale.rangeBand();
        this.hafl_band = (this.full()) ? 0 : this.band / 2;
        this.bar = 6;
        this.reverse = this.reverse();
    }

    private void initDomain() {

        if (this.hasTarget() && !this.hasDomain()) {

            List<String> domains = new ArrayList<String>();
            ChartData data = chart.data();

            int start = 0;
            int end = data.length() - 1;
            int step = 1;

            if (this.reverse()) {
                start = data.length() - 1;
                end = 0;
                step = -1;
            }

            for (int i = start; ((this.reverse()) ? i >= end : i <=end); i += step) {
                domain.add(data.get(i, this.target()));
            }

            this.domain(domain);
            grid.step = grid.step || 10;
            grid.max = grid.max || 100;
        }
    }

    public Object draw() {
        return this.drawGrid();
    }
}
