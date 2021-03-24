package json.parser;

import json.Json;
import json.element.Impl.ArrayVal;
import json.element.base.Element;
import json.parser.all.ElemParser;

public class ArrayParser extends Parser {
    @Override
    public Element parse(Json json) {
        ArrayVal arrayVal = new ArrayVal();
        while (true){
            json.skipBlank();
            if (isTheEndOfVal(json.currentChar()))
                break;
            Element oneElement = ElemParser.parse(json);
            arrayVal.addElem(oneElement);
            // TODO: 完善时加上是否是‘,’的判断，暂时默认是‘,’
            if (json.currentChar()==','){
                json.indexMove();
            }
        }
        // 没有使用getNext函数需要手动跳过结束符、
        // 即‘]’
        json.indexMove();
        return arrayVal;
    }

    @Override
    boolean isTheEndOfVal(char c) {
        return c == ']';
    }
}
