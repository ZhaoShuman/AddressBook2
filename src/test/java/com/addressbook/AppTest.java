package com.addressbook;

import java.util.Map;
import java.util.Scanner;

import com.Service.Jsonbuild;
import com.Service.ServiceTool;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	private String jsonstr ="{\"entries\": {"
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
	private Object o = null;
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Jsonbuild test = new Jsonbuild();
    	
    	Map<String, Object> map = test.ParseJson(jsonstr);
    	o = map;
        assertTrue( true );
    }
    public void testLs()
    {
    	testApp();
    	ServiceTool tool = new ServiceTool();
    	//System.out.println(o.getClass().toString());
        o = tool.LS(o);   
        
    }
    public void testCd()
    {
    	testApp();
    	ServiceTool tool = new ServiceTool();
    	o = tool.CD(o);
        
    }
    public void testCat()
    {
    	testApp();
    	ServiceTool tool = new ServiceTool();
    	tool.CAT(o,"lilei");
        
    }
    public void testAdd()
    {
    	testApp();
    	ServiceTool tool = new ServiceTool();
    	 //assertTrue(tool.ADD(o));
        
    }
    public void testRemove()
    {
    	testApp();
    	ServiceTool tool = new ServiceTool();
    	// assertTrue(tool.REMOVE(o,"lilei"));
        
    }
}
