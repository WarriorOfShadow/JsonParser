package json.parser;

import json.Json;
import json.element.Impl.NumberVal;
import json.element.base.Element;

public class NumberParser extends Parser {
    @Override
    public Element parse(Json json) {
        String nextVal = getNextVal(json);
        float v = Float.parseFloat(nextVal);
        return new NumberVal(v);
    }

}
