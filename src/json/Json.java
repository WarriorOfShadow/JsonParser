package json;

import json.element.base.Element;
import json.element.exception.ElementException;
import json.parser.all.ElemParser;

public class Json extends Element {
    private String jsonStr;
    private int index;
    private Element root;

    public Json(String jsonStr) {
        this.jsonStr = jsonStr;
        this.index = 0;
        root = ElemParser.parse(this);
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public int getIndex() {
        return index;
    }

    public Element at(int index) throws ElementException {
        return root.at(index);
    }

    public Element get(String key) throws ElementException {
        return root.get(key);
    }

    public Element getRoot(){
        return root;
    }

    public void indexMove(){
        this.index++;
    }

    public char currentChar(){
        return jsonStr.charAt(index);
    }

    public boolean atEnd(){
        return index == jsonStr.length();
    }

    public void skipBlank(){
        while (!atEnd() && (currentChar()==' ' || currentChar()=='\n')){
            indexMove();
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
