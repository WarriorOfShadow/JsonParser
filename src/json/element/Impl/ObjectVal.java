package json.element.Impl;

import json.element.base.Element;

import java.util.HashMap;
import java.util.Map;

public class ObjectVal extends Element {
    private static int printDepth;

    public Map<String, Element> getObjMap() {
        return objMap;
    }

    private Map<String, Element> objMap = new HashMap<>();

    public ObjectVal() {
    }

    @Override
    public Element get(String key) {
        return objMap.get(key);
    }

    public void put(String key, Element value) {
        this.objMap.put(key, value);
    }

    @Override
    public String toString() {
        return getString();
    }

    private String getString() {
        printDepth += 2;
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        boolean isFirst = true;
        for (String key : objMap.keySet()) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(",\n");
            }
            sb.append(" ".repeat(Math.max(0, printDepth)));
            sb.append("\"").append(key).append("\"").append(": ");
            Element value = objMap.get(key);
            sb.append(value.toString());
        }
        sb.append('\n');
        sb.append(" ".repeat(Math.max(0, printDepth - 2)));
        sb.append("}");

        printDepth -= 2;
        return sb.toString();
    }
}
