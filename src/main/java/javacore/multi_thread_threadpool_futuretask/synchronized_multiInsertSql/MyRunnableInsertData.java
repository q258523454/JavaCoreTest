package javacore.multi_thread_threadpool_futuretask.synchronized_multiInsertSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-21
 */

public class MyRunnableInsertData implements Runnable {
    private String name;

    public MyRunnableInsertData(String name) {
        this.name = name;
    }

    public void run() {
        insertData(name);
    }

    public void insertData(String threadName) {
        String url = "jdbc:mysql://localhost:3306/abs_4_data_youhua";
        String name = "com.mysql.cj.jdbc.Driver";
        String user = "youhua";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);    // 获取连接
            conn.setAutoCommit(false);                                  // 关闭自动提交，不然conn.commit()运行到这句会报错
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String prefix = "INSERT INTO student (name,age) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 1000; i++) {
                String age = Double.toString(18 + (int) (Math.random() * ((25 - 18) + 1)));
                // 构建SQL后缀
                suffix.append("('" + UUID.randomUUID().toString().replace("-", "") + "','" + age + "'),");
                // 每n条数据提交一次
                if (i % 100 == 0) {
                    //  Min + (int)(Math.random() * ((Max - Min) + 1))
                    String sql = prefix + suffix.substring(0, suffix.length() - 1); // 构建完整SQL, 去掉最后一个','
                    ps.addBatch(sql);   // 添加执行SQL
                    ps.executeBatch();  // 执行操作
                    conn.commit();      // 提交事务, 先关闭自动提交conn.setAutoCommit(false);
                    suffix = new StringBuffer("");      // 每次提交完, 清空
                }
            }
            // 关闭资源
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("线程" + threadName + "数据插入耗时: " + (end - begin) + " ms");
    }

    public static void main(String[] args) {
//        100万条数据插入耗时: 85888 ms
//        100万条数据插入耗时: 85 s

        for (int i = 0; i < 10; i++) {
            MyRunnableInsertData myRunnable = new MyRunnableInsertData(i + "");
            Thread thread = new Thread(myRunnable, ""); // 对同一个对象创建多线程
            thread.start();
        }

    }
}
