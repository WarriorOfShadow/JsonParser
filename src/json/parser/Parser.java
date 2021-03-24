package json.parser;

import json.Json;
import json.element.base.Element;

public abstract class Parser {
    public abstract Element parse(Json json);

    boolean isTheEndOfVal(char c) {
        return c == ' ' || c == ',' || c == '}' || c == ']';
    }

    String getNextVal(Json json) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char c = json.currentChar();
            if (isTheEndOfVal(c))
                break;
            sb.append(c);
            json.indexMove();
        }
        return sb.toString();
    }
}
