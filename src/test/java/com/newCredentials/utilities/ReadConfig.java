package com.newCredentials.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig(){


        File src=new File("Properties\\Config.properties");
        try
        {
            FileInputStream fis=new FileInputStream(src);
           pro=new Properties();
           pro.load(fis);

        }
        catch(Exception e){
            System.out.println("exception is "+ e.getMessage());

        }


    }
    public String getChromePath()

    {
        String chrome=pro.getProperty("chromePath");
        return chrome;
    }

    public String getfirefoxpath()
    {
        String firefox=pro.getProperty("firefoxPath");
        return firefox;
    }

    public String getiexplorePath()
    {
        String iexplore=pro.getProperty("iexplorePath");
       return iexplore;
    }
  public String getApplicationUrl()
  {
      String url=pro.getProperty("url");
      return url;
  }

    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }


    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }







}
