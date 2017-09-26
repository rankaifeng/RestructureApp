package restructure.com.restructureapp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParseUtil {

    /**
     * 将驼峰格式转为普通格式
     * 即 aBcDe--->a_bc_de
     */
    public static Object parseJsonStr_(Object obj) {
        if (obj == null)
            return obj;
        try {
            JSONObject jo = (JSONObject) JSON.toJSON(obj);
            if ((jo.toJSONString()).startsWith("[")
                    && (jo.toJSONString()).endsWith("]")) {
                JSONArray jarr = JSON.parseArray(obj.toString());
                JSONArray jsonarray = JSON.parseArray(obj.toString());
                for (Object o : jarr) {
                    JSONObject jsonobject = (JSONObject) o;
                    jsonarray.add(parseJsonObject2(jsonobject));
                }
                return jsonarray;
            } else {
                return parseJsonObject2(jo);
            }
        } catch (Exception e) {
        }
        try {
            JSONArray jarr = JSON.parseArray(obj.toString());
            JSONArray jsonarray = new JSONArray();
            for (Object o : jarr) {
                JSONObject jsonobject = (JSONObject) o;
                jsonarray.add(parseJsonObject2(jsonobject));
            }
            return jsonarray;
        } catch (Exception e) {
        }
        return obj;
    }

    private static JSONObject parseJsonObject2(JSONObject jo) {
        JSONObject jobj = new JSONObject();
        for (String key : jo.keySet()) {
            String newKey = switchLowCase(key);
            Object newValue = parseJsonStr_(jo.get(key));
            jobj.put(newKey, newValue);
        }
        return jobj;
    }

    private static String switchLowCase(String key) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (Character.isUpperCase(c)) {
                indexs.add(i);
            }
        }
        for (int i = 0; i < indexs.size(); i++) {
            int index = indexs.get(indexs.size() - 1 - i);
            char c = key.charAt(index);
//            key = key.replaceAll(String.valueOf(c), "_"
//                    + String.valueOf(c).toLowerCase());
            key = key.substring(0, index) + "_" + String.valueOf(c).toLowerCase() + key.substring(index + 1);
        }
        return key;
    }

    /**
     * 将普通格式的json转为带驼峰的
     * 即 a_bc_de ----》 aBcDe
     */
    public static Object parseJsonStr(Object obj) {
        Object str = null;
        if (obj != null && (obj instanceof String || obj instanceof JSONArray || obj instanceof JSONObject)) {
            if (obj.toString().startsWith("[") && obj.toString().endsWith("]")) {
                try {
                    JSONArray jsonArray = JSON.parseArray(obj.toString());
                    JSONArray jarray = new JSONArray();
                    for (Object o : jsonArray) {
                        JSONObject jsonObject = (JSONObject) o;
                        jsonObject = parseJsonObject(jsonObject);
                        jarray.add(jsonObject);
                    }
                    str = JSON.toJSON(jarray);
                } catch (Exception e) {
                    str = obj;
                }
            } else {
                try {
                    JSONObject json = (JSONObject) JSON.parseObject(obj
                            .toString());
                    json = parseJsonObject(json);
                    str = json;
                } catch (Exception e) {
                    str = obj;
                }
            }
        } else {
            return obj;
        }
        return str;
    }

    private static JSONObject parseJsonObject(JSONObject json) {
        JSONObject jsObj = new JSONObject();
        for (String key : json.keySet()) {
            String newKey = switchUpperCase(key);
            Object newValue = parseJsonStr(json.get(key));
            jsObj.put(newKey, newValue);
        }
        return jsObj;
    }

    private static String switchUpperCase(String key) {
        while (key.indexOf("_") >= 0) {
            char c = key.charAt(key.indexOf("_") + 1);
            key = key.replaceAll("_" + String.valueOf(c), String.valueOf(c)
                    .toUpperCase());
        }
        return key;
    }
}
