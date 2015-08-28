package com.tr.dagdem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ModelDBBuilder
{

    public static void main(String[] args) throws Exception
    {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext-ds-prod.xml"});
        System.out.println("sadasdas");
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
