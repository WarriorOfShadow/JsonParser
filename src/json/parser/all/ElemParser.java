package json.parser.all;

import json.Json;
import json.element.base.Element;
import json.parser.*;

public class ElemParser {
    static public Element parse(Json json){
        char c = json.currentChar();
        Parser parser = null;
        boolean needJump = true;
        switch (c){
            case '[':
                parser = new ArrayParser();
                break;
            case 't':
            case 'f':
                parser = new BoolParser();
                needJump = false;
                break;
            case '\"':
                parser = new StringParser();
                break;
            case 'n':
                parser = new NullParser();
                needJump = false;
                break;
            case '{':
                parser = new ObjectParser();
                break;
            default:
                parser = new NumberParser();
                needJump = false;
                break;
        }
        // 跳过 '前缀'
        if (needJump){
            json.indexMove();
        }
        return parser.parse(json);
    }
}
