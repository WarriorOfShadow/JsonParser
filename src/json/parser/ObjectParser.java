package json.parser;

import json.Json;
import json.element.Impl.ObjectVal;
import json.element.base.Element;
import json.parser.all.ElemParser;

public class ObjectParser extends Parser {
    @Override
    public Element parse(Json json) {
        ObjectVal objectVal = new ObjectVal();
        while (true){
            json.skipBlank();
            if (isTheEndOfVal(json.currentChar()))
                break;
            StringParser stringParser = new StringParser();
            // 跳过开头的双引号
            json.indexMove();

            String key = stringParser.getNextVal(json);
            json.indexMove();

            json.skipBlank();
            //TODO: 到时需要添加格式错误的处理,暂时直接默认为‘:’并跳过
            json.indexMove();
            json.skipBlank();

            Element value = ElemParser.parse(json);

            json.skipBlank();
            //TODO: 到时需要添加格式错误的处理,暂时直接默认为‘,’并跳过
            if (json.currentChar()==','){
                json.indexMove();
            }

            objectVal.put(key, value);
        }
        // 跳过结束符
        json.indexMove();
        return objectVal;
    }

    @Override
    boolean isTheEndOfVal(char c) {
        return c == '}';
    }
}
