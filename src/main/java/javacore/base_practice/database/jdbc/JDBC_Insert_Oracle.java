package javacore.base_practice.database.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Insert_Oracle implements Runnable {

    @Override
    public void run() {
        String url = "jdbc:oracle:thin:@//55.14.63.174:1521/EA0DB100";
        String name = "oracle.jdbc.driver.OracleDriver";
        String user = "TEST";
        String password = "Lj08#123456";
        Connection conn = null;
        try {
            Class.forName(name);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 关闭自动提交，不然conn.commit()运行到这句会报错
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
        // 开始时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String sqlTemplate = "INSERT INTO TEST.STUDENT(ID, NAME, AGE) VALUES (?,?,?)";
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(sqlTemplate);
            String age = Double.toString(18 + (int) (Math.random() * ((25 - 18) + 1)));
            stmt.setBigDecimal(1, new BigDecimal("99"));
            stmt.setString(2, "test");
            stmt.setBigDecimal(3, new BigDecimal(age));
            stmt.addBatch();
            stmt.executeBatch();
            // 提交事务, 先关闭自动提交conn.setAutoCommit(false);
            conn.commit();
            // 关闭资源
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("线程" + Thread.currentThread().getName() + "数据插入耗时: " + (end - begin) + " ms");
    }

    /**
     * 批量写法 参考 spring-boot-oracle-batch-vs-jdbc 下的 com.oracle.vs.jdbc.T2_Run2_JDBC_Insert_Batch
     */
    public static void main(String[] args) {
        JDBC_Insert_Oracle myRunnable = new JDBC_Insert_Oracle();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
