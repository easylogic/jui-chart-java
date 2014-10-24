package com.jennifer.ui.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jayden on 2014-10-24.
 */
public class DomUtil {

    private HashMap<String, String> attrs;
    private String tagName;
    private ArrayList<DomUtil> children;

    public static DomUtil el(String tagName) {
        return new DomUtil(tagName);
    }

    public static DomUtil el(String tagName, String[] attr) {
        return new DomUtil(tagName, attr);
    }

    public DomUtil(String tagName) {
        attrs = new HashMap<String, String>();
        this.tagName = tagName;
        children = new ArrayList<DomUtil>();
    }

    public DomUtil(String tagName, String[] attr) {
        this(tagName);
        this.attr(attr);
    }

    public void attr(String args[]) {
        for(int i = 0, len = args.length; i < len; i += 2) {
            attr(args[i], args[i+1]);
        }
    }
    public void attr(String key, String value) {
        attrs.put(key, value);
    }

    public void attr(String key, int value) {
        attrs.put(key, Integer.toString(value));
    }

    public DomUtil append(String tagName) {
        return append(new DomUtil(tagName));
    }

    public DomUtil append(String tagName, String[] attr) {
        return append(new DomUtil(tagName, attr));
    }

    public DomUtil append(DomUtil eu) {
        children.add(eu);

        return eu;
    }

    public String collapseAttr() {
        StringBuffer str = new StringBuffer();
        Set<String> keys = attrs.keySet();

        for(String key : keys) {
            String value = attrs.get(key);
            str.append(" " + key + "=\"" + value + "\" ");
        }

        return str.toString();
    }

    public String collapseChildren() {
        StringBuffer str = new StringBuffer();
        for(DomUtil eu : children) {
            str.append(eu.render() + "\n");
        }

        return str.toString();
    }

    public String render() {
        StringBuffer str = new StringBuffer();

        str.append("<" + tagName + " ");
        if (children.size() == 0) {
            str.append(collapseAttr());
            str.append(" />");
        } else {
            str.append(collapseAttr());
            str.append(">\n");
            str.append(collapseChildren());
            str.append("</" + tagName + ">");
        }

        return str.toString();
    }

    public String toString() {
        return render();
    }

    public String toXml() {
        // xml 리턴 
        return "";
    }

    public void save(String path) {
        // 파일 저장 
    }

}
