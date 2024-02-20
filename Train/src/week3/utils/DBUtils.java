package week3.utils;

import java.sql.*;

/**
 * @author fz
 */
public class DBUtils {
    /**
     * 获取数据库连接
     * @return 连接对象
     */
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/todo_util";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭连接
     *
     * @param pstmt PreparedStatement
     * @param conn  Connection
     * @throws SQLException SQL异常
     */
    public static void close(PreparedStatement pstmt, Connection conn) {
        if (pstmt != null) {
            try {
                pstmt.close();
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重载关闭方法
     *
     * @param pstmt PreparedStatement
     * @param conn  Connection
     * @throws Exception 异常
     */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
                if (pstmt != null) {
                    pstmt.close();
                    if (conn != null) {
                        conn.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
