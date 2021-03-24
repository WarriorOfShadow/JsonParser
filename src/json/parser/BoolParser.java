package json.parser;

import json.Json;
import json.element.Impl.BoolVal;
import json.element.base.Element;

public class BoolParser extends Parser {
    @Override
    public Element parse(Json json) {
        String nextVal = getNextVal(json);
        BoolVal ret = null;
        switch (nextVal){
            case "true":
                ret = new BoolVal(true);
                break;
            case "false":
                ret = new BoolVal(false);
                break;
        }
        return ret;
    }
}
