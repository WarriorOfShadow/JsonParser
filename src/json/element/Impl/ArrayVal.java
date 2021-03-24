package json.element.Impl;

import json.element.base.Element;
import json.element.exception.ElementException;

import java.util.ArrayList;

public class ArrayVal extends Element {
    ArrayList<Element> elemArray = new ArrayList<>();

    public ArrayVal() {}

    @Override
    public Element at(int index) throws ElementException {
        return elemArray.get(index);
    }

    public void addElem(Element element){
        elemArray.add(element);
    }

    @Override
    public String toString() {
        return elemArray.toString();
    }
}
