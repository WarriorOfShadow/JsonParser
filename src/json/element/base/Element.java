package json.element.base;

import json.element.exception.ElementException;
import json.element.exception.NotArrayException;
import json.element.exception.NotObjException;

public abstract class Element {
    public Element get(String key) throws ElementException {
        throw new NotObjException();
    }
    public Element at(int index) throws ElementException{
        throw new NotArrayException();
    }
}
