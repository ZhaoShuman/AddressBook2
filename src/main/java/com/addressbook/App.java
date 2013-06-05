package com.addressbook;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.Bean.Person;
import com.Service.*;

/**
 * Hello world!
 *
 */
public class App 
{	
		//ls,cd,cat, add, remove
		public static void main(String [] args)
		{
			JarUtil ju = new JarUtil(App.class);
	       // System.out.println("Jar name: " + ju.getJarName());
	        //System.out.println("Jar path: " + ju.getJarPath());
			System.out.print(ju.getJarName()+">");
			String jsonstr ="{\"entries\": {"
	            +"\"lilei\" : {"
	            +" \"age\": 27,"
	            +"\"mobile\" : \"13700000000\","
	            +"\"address\" : \"Earth somewhere\""
	            +"}," 
	            + "\"hanmeimei\" : {"
	            +"\"age\": 26,"
	            +"\"mobile\" : \"13700000001\","
	            +"\"address\" : \"Earth somewhere else\""
	            +" }"
	            +"}"
	            +"}";
			Jsonbuild test = new Jsonbuild();
			Map<String, Object> map = test.ParseJson(jsonstr);
			Object o = map;
			ServiceTool tool = new ServiceTool();
			Scanner in=new Scanner(System.in);
	        String str=in.nextLine();
	        str = str.replace("\n", "").replace("\t", "").replace("\r", "").trim();
	        while("!quit".equalsIgnoreCase(str)==false)
	        {
	        if("ls".equalsIgnoreCase(str))
	        {
	        	
			    o = tool.LS(o);
	        }else if("cd entries".equalsIgnoreCase(str))
	        {  
	        		o = tool.CD(o);
	        }else if("cat".equalsIgnoreCase(str.split(" ")[0]))
	        {  
	        	tool.CAT(o,str.split(" ")[str.split(" ").length-1].toString());
	        }else if("add".equalsIgnoreCase(str))
	        { 
	        	if(tool.ADD(o))
	        	{
	        	System.out.println("address entry added");
	        	}
	        }else if("remove".equalsIgnoreCase(str))
	        {  
	        	
	        	System.out.print("please give the key:");
	        	String strname =in.nextLine();
	        	
	        	if(tool.REMOVE(o,strname))
	        	{
	        	     System.out.println(strname +" was deleted from JSON");
	        	}
	        }else if("!help".equalsIgnoreCase(str))
	        {
	        	String help = "cd: go to the entry like go to a directory\n"
	                         +"lls: list the items in current position\n"
	                         +"cat item: display th item data\n"
	                         +"add: add new address entry to JSON\n"
	                         +"remove: get one or more address entries\n"
	                         +"!help: display help message\n"
	                         +"!quit: quit from the application\n";
	        	System.out.println(help);
	        }
	        else
	        	{
	        	System.out.println("Invalid command,input !help view the command");
	        	}
	        System.out.print(ju.getJarName()+">");
	        str=in.nextLine();
	        str = str.replace("\n", "").replace("\t", "").replace("\r", "").trim();
	        }	
		}
	}



