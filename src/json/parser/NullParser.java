package json.parser;

import json.Json;
import json.element.Impl.NullVal;
import json.element.base.Element;

public class NullParser extends Parser {
    @Override
    public Element parse(Json json) {
        getNextVal(json);
        return new NullVal();
    }
}
