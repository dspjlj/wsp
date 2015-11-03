package com.jlj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONHelper {

    /**
     * 将JSONObject对象转换成Map集合
     * @see JSONHelper#reflect(JSONArray)
     * @param json
     * @return
     */
    public static HashMap<String, Object> reflect(JSONObject json){
        HashMap<String, Object> map = new HashMap<String, Object>();
        Set keys = json.keySet();
        for(Object key : keys){
            Object o = json.get(key);
            if(o instanceof JSONArray)
                map.put((String) key, reflect((JSONArray) o));
            else if(o instanceof JSONObject)
                map.put((String) key, reflect((JSONObject) o));
            else
                map.put((String) key, o);
        }
        return map;
    }

    /**
     * 将JSONArray对象转换成List集合
     * @see JSONHelper#reflect(JSONObject)
     * @param json
     * @return
     */
    public static Object reflect(JSONArray json){
        List<Object> list = new ArrayList<Object>();
        for(Object o : json){
            if(o instanceof JSONArray)
                list.add(reflect((JSONArray) o));
            else if(o instanceof JSONObject)
                list.add(reflect((JSONObject) o));
            else
                list.add(o);
        }
        return list;
    }
}
