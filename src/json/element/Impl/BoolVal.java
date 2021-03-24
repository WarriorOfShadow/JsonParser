package json.element.Impl;

import json.element.base.Element;

public class BoolVal extends Element {
    private boolean value;

    public BoolVal(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
