package com.luoyan;

import java.sql.*;

public class PrepareQueryTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.13:3306/tbj?useUnicode=true&characterEncoding=GBK", "XXX", "XXX");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from test.test where id = ?");

        preparedStatement.setLong(1, 1L);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getLong("id") + ",name : " + resultSet.getString("name"));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
