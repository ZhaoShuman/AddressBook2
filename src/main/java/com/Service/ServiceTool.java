package com.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.addressbook.*;
import com.Bean.Person;


public class ServiceTool {

	//JarUtil ju = new JarUtil(App.class);
	public Object LS(Object o)
	{	JarUtil ju = new JarUtil(App.class);
		System.out.print(ju.getJarName()+">");
		if(o.getClass().equals(HashMap.class))
		{
			Iterator p = (Iterator)((Map) o).keySet().iterator();
			while(p.hasNext())
			{
				String key = (String) p.next();
				List<Map<String, Object>> person = (List<Map<String, Object>>) ((Map) o).get(key);
                System.out.println(key);
			}	
		}else if(o.getClass().equals(ArrayList.class))
		{
			Iterator<Map<String, Object>> k=((List<Map<String,Object>>) o).iterator();
			while(k.hasNext())
			{
				Map per = k.next();
				Iterator it=per.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry = (Map.Entry)it.next();
					String kk=(String) entry.getKey();
					System.out.print(kk+" ");
				}
			}
			System.out.println(" ");
		}
		return o;
	}
	
	public Object CD(Object o)
	{
		if(o.getClass().equals(HashMap.class))
		{
			Iterator p = (Iterator)((Map) o).keySet().iterator();
			while(p.hasNext())
			{
				String key = (String) p.next();
				List<Map<String, Object>> person = (List<Map<String, Object>>) ((Map) o).get(key);
				o = person;
			}
			
		}else if(o.getClass().equals(ArrayList.class))
		{
			Iterator<Map<String, Object>> k=((List<Map<String,Object>>) o).iterator();
			while(k.hasNext())
			{
				Map per = k.next();
				Iterator it=per.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry = (Map.Entry)it.next();
					String kk=(String) entry.getKey();
				}
			}
		}
		return o;
	}
	public boolean CAT(Object o,String path)
	{
		JarUtil ju = new JarUtil(App.class);
		System.out.print(ju.getJarName()+">");
		if(o.getClass().equals(HashMap.class))
		{
			System.out.println("entries is not item.");
			return false;
			
		}else if(o.getClass().equals(ArrayList.class))
		{
			Iterator<Map<String, Object>> k=((List<Map<String,Object>>) o).iterator();
			while(k.hasNext())
			{
				Map per = k.next();
				Iterator it=per.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry = (Map.Entry)it.next();
					String kk=(String) entry.getKey();
					if(path.equals(kk))
					{
					Person value=(Person) entry.getValue();
					System.out.println("\""+kk+"\""+":{\"age\":"+value.getAge()+",\"mobile\":\""+value.getMobile()+"\",\"address\":\""+value.getAddress()+"\"}");
				    return true;
				    }
				}
			}
			if(!k.hasNext())
			{
				System.out.println(path+" didn't exist");
				return false;
			}
		}
		return false;
	}
	public boolean ADD(Object o)
	{
		if(o.getClass().equals(HashMap.class))
		{
            System.out.println("can't add items in current position");
			return false;
			
		}else if(o.getClass().equals(ArrayList.class))
		{
			 Scanner in=new Scanner(System.in);
			 System.out.print("key:");
        	 String strname =in.nextLine();
        	 System.out.print("value:");
        	 String strvalue =in.nextLine();
			 String [] values = strvalue.split(",");
			 String regexage ="^(?:[1-9]?\\d|100)$";
			 String regexmobile="^[1][3-8]+\\d{9}";
			 if(strname.length()>100)
			 {
				 System.out.println("the length for name too long(0-100)!");
				 return false;
			 }
			 if(!Pattern.matches(regexage,values[0].split(":")[1].replace(" ", "")))
			 {
				 System.out.println("age error(0-100)!");
				 return false;
			 }
			 if(!Pattern.matches(regexmobile,values[1].split(":")[1].replace(" ", "")))
			 {
				 //System.out.println("mobile error!");
				// return false;
			 }
			 Iterator<Map<String, Object>> k=((List<Map<String,Object>>) o).iterator();
				while(k.hasNext())
				{
					Map per = k.next();
					Iterator it=per.entrySet().iterator();
					while(it.hasNext())
					{
						Map.Entry entry = (Map.Entry)it.next();
						String kk=(String) entry.getKey();
						if(strname.equals(kk))
						{
							System.out.println(strname+" has exists!");
							return false;
					    }
					}
				}
				String age =(values[0].split(":")[1].replace(" ", ""));
				String mobile = values[1].split(":")[1];
				String address = values[2].split(":")[1];
				Person per = new Person();
				per.setAge(age);
				per.setMobile(mobile);
				per.setAddress(address);			
				Map<String, Object> map = null;
		   		map = new HashMap<String, Object>();
		   		map.put(strname, per);
		   		((List<Map<String,Object>>) o).add(map);
		   		return true;
		}
		return false;
		
	}
	public boolean REMOVE(Object o,String name)
	{
		if(o.getClass().equals(HashMap.class))
		{
			System.out.println("can't remove items in current position");
			return false;
			
		}else if(o.getClass().equals(ArrayList.class))
		{
			Iterator<Map<String, Object>> k=((List<Map<String,Object>>) o).iterator();
			while(k.hasNext())
			{
				Map per = k.next();
				Iterator it=per.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry = (Map.Entry)it.next();
					String kk=(String) entry.getKey();
					if(name.equals(kk))
					{
						per.remove(name);
						return true;
				    }
				}
				
			}
			if(!k.hasNext())
			{
				System.out.println(name+" didn't exist");
				return false;
			}
		}
		return true;
	}
}

