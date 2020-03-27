package com.luoyan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BatchExecuteTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.13:3306/tbj?useUnicode=true&characterEncoding=GBK", "tbj", "XXX");

        String sql = "insert into test.test (name) values (?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        // 普通循环执行
        for (int i = 0; i < 1000; i++) {
            statement.setObject(1, i);
            statement.executeUpdate();
        }

        long end = System.currentTimeMillis();

        System.out.printf("cost time %d\n", end - start);

        statement.close();

        statement = connection.prepareStatement(sql);

        start = System.currentTimeMillis();
        // 使用Batch执行
        for (int i = 1001; i < 2000; i++) {
            statement.setObject(1, i);
            statement.addBatch();
        }
        statement.executeBatch();
        end = System.currentTimeMillis();

        System.out.printf("cost time %d\n", end - start);

        statement.close();
        connection.close();

    }

}
