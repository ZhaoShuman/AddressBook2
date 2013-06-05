package com.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.Bean.Person;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class Jsonbuild {
	public Map ParseJson(String jsonString)
	{
     Map<String, Object> map = null;
	 map = new HashMap<String, Object>();
	 JSONObject jb = JSONObject.fromObject(jsonString);
	 Iterator<String> it = jb.keys();
	 while(it.hasNext()) {  
	     String key = (String) it.next();
	     List<Map> entries = new ArrayList<Map>();
	     JSONObject ja = JSONObject.fromObject(jb.get(key));
	   	 Iterator<String> p = ja.keys();
	   	 while(p.hasNext())
	   	 {
	   		String k = (String) p.next();
	   		Map<String, Object> map1 = null;
	   		map1 = new HashMap<String, Object>();
	   		if(!ja.get(k).toString().isEmpty())
	   		{
	   		Person person = (Person) JSONObject.toBean(  
	   		                 JSONObject.fromObject(ja.get(k)),  
	                         Person.class); 
	        map1.put(k, person);  
	        }
	        
	        entries.add(map1);
	   	 }
	   	 map.put(key, entries);
	        
	        }
    return map;  
	}

}
