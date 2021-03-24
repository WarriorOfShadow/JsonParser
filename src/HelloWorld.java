import json.Json;
import json.element.exception.ElementException;

public class HelloWorld {
    public static void main(String[] args) throws ElementException {
        Json json = new Json("{\"a\":[true,false,\"haha\",null],\"b\":true,\"c\":false,\"foo\":null,\"bar\":[1,2,3],\"subObj\":{\"xiaoming\":15,\"xiaogang\":13}}");
        // Element a = json.get("subObj");
        System.out.println(json.getRoot());
    }
}
