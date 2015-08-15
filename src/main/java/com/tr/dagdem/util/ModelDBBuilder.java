package com.tr.dagdem.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

public class ModelDBBuilder
{

    public static void main(String[] args) throws Exception
    {
        
       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext-ds-dev.xml"});
	   
	    try {
//            readData();
            Connection h2Connection = getH2Connection();
            System.out.println(h2Connection.toString());

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        
    }
	
	public static Connection getH2Connection() throws SQLException,ClassNotFoundException {

        String urlT = "jdbc:h2:tcp://localhost/~/satistakip;MODE=MySQL";

//        String urlT = "jdbc:h2:tcp://localhost/~/test";

        String user = "sa";

        String password = ""; // Create the properties object that holds all

        Properties props = new Properties();

        props.put("user", user);

        props.put("password", password);

        props.put("SetBigStringTryClob","true");

        DriverManager.registerDriver(new org.h2.Driver());

        Class.forName("org.h2.Driver");

        Connection conn = DriverManager.getConnection(urlT, props);

        return conn;

    }
}
