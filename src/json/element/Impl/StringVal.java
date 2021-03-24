package json.element.Impl;

import json.element.base.Element;

public class StringVal extends Element {
    String value;

    public StringVal(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
