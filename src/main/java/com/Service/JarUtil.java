package com.Service;

	public class JarUtil
	{
	    private String jarName;
	    private String jarPath;
	         
	    public JarUtil(Class clazz)
	    {
	        String path = clazz.getProtectionDomain().getCodeSource().getLocation()
	                .getFile();
	        try
	        {
	            path = java.net.URLDecoder.decode(path, "UTF-8");
	        }
	        catch (java.io.UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }
	        java.io.File jarFile = new java.io.File(path);
	        //this.jarName = jarFile.getName();
	        //this.jarName = jarFile.getAbsolutePath();
	        java.io.File jarFile1 = new java.io.File(jarFile.getAbsolutePath());
	        //this.jarName = jarFile1.getName();
	        java.io.File parent = jarFile.getParentFile();
	        if(!jarFile1.getName().isEmpty())
	        {
	        	int i = jarFile1.getName().lastIndexOf(".");
	        	if(i>-1&&i<jarFile1.getName().length())
	        	{
	        		this.jarName = jarFile1.getName().substring(0,i);
	        	}
	        	else 
	        	{
	        		this.jarName = jarFile1.getName();
	        	}
	        }
	        if (parent != null)
	        {
	            this.jarPath = parent.getName();
	        }
	    }
	    public String getJarName()
	    {
	        try
	        {
	            return java.net.URLDecoder.decode(this.jarName, "UTF-8");
	        }
	        catch (java.io.UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    public String getJarPath()
	    {
	        try
	        {   
	            return java.net.URLDecoder.decode(this.jarPath, "UTF-8");
	        }
	        catch (java.io.UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}


