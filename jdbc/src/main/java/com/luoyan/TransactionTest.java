package com.luoyan;

import java.sql.*;

public class TransactionTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.13:3306/tbj?useUnicode=true&characterEncoding=GBK", "tbj", "XXXX");

        connection.setAutoCommit(false);

        PreparedStatement statement = connection.prepareStatement("insert into test.test (id,name) values (?,?) ");

        statement.setLong(1, 6);
        statement.setObject(2, "wojngxs");
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement("select * from test.test where id = ?");

        statement1.setLong(1, 6);
        ResultSet rs = statement1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getLong("id") + " : " + rs.getString("name"));
        }

        connection.commit();

        ResultSet rs1 = statement1.executeQuery();
        while (rs1.next()) {
            System.out.println(rs1.getLong("id") + " : " + rs1.getString("name"));
        }

        connection.setAutoCommit(true);


    }

}
