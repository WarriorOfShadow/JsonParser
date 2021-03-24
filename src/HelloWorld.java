import json.Json;
import json.element.Impl.ArrayVal;
import json.element.Impl.ObjectVal;
import json.element.base.Element;
import json.element.exception.ElementException;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class HelloWorld {

    static String getJsonStr(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader jsonFile = new FileReader(path);
        BufferedReader bf = new BufferedReader(jsonFile);
        String line = null;
        while ((line= bf.readLine())!=null){
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws ElementException, IOException {
        // test1();
    }

    @Test
    public void test1() throws IOException {
        String jsonStr = getJsonStr("json/test1.json");
        Json json = new Json(jsonStr);
        System.out.println(json);
    }

    @Test
    public void test2() throws IOException {
        String jsonStr = getJsonStr("json/test2.json");
        Json json = new Json(jsonStr);
        ObjectVal root = (ObjectVal) json.getRoot();
        Map<String, Element> allGrades = root.getObjMap();
        for (String key: allGrades.keySet()){
            System.out.println(key+": ");
            ArrayList<Element> gradeSubjects = ((ArrayVal)allGrades.get(key)).getElemArray();
            for (Element gradeSubject : gradeSubjects) {
                System.out.println(gradeSubject);
            }
        }
        System.out.println(json);
    }
}
