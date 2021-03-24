package json.element.Impl;

import json.element.base.Element;

public class NumberVal extends Element {
    private float num;

    public NumberVal(float num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return Float.toString(num);
    }
}
