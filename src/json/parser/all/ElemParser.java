package json.parser.all;

import json.Json;
import json.element.base.Element;
import json.parser.*;

public class ElemParser {
    static public Element parse(Json json){
        char c = json.currentChar();
        Parser parser = null;
        switch (c){
            case '[':
                parser = new ArrayParser();
                break;
            case 't':
            case 'f':
                parser = new BoolParser();
                break;
            case '\"':
                parser = new StringParser();
                break;
            case 'n':
                parser = new NullParser();
                break;
            case '{':
                parser = new ObjectParser();
                break;
            default:
                parser = new NumberParser();
                break;
        }
        return parser.parse(json);
    }
}
