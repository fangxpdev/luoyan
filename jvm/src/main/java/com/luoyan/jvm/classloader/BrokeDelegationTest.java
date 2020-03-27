package com.luoyan.jvm.classloader;

import java.sql.*;

public class BrokeDelegationTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.13:3306/tbj?useUnicode=true&characterEncoding=GBK", "tbj", "tbj900900");




    }

}
