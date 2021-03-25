package json.parser;

import json.Json;
import json.element.Impl.StringVal;
import json.element.base.Element;

public class StringParser extends Parser {
    @Override
    public Element parse(Json json) {
        // 跳过前缀 ‘"’
        json.indexMove();
        String nextVal = getNextVal(json);
        // 跳过最后的 ‘"’
        json.indexMove();
        return new StringVal(nextVal);
    }

    @Override
    boolean isTheEndOfVal(char c) {
        return c == '\"';
    }
}
