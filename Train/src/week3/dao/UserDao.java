package week3.dao;

import week3.entity.User;
import week3.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fz
 */
public class UserDao {

    /**
     * 注册用户
     */
    public boolean register(User user) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into user(name, password) values(?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(ps, conn);
        }
        return false;
    }

    /**
     * 登录功能
     */
    public User login(String name, String password) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where name = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()){
                int uid = rs.getInt("id");
                String username = rs.getString("name");
                String userPassword = rs.getString("password");
                User user = new User();
                user.setId(uid);
                user.setName(username);
                user.setPassword(userPassword);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, ps, conn);
        }
        return null;
    }

    public User findUserByName(String name) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()){
                int uid = rs.getInt("id");
                String username = rs.getString("name");
                String userPassword = rs.getString("password");
                User user = new User();
                user.setId(uid);
                user.setName(username);
                user.setPassword(userPassword);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, ps, conn);
        }
        return null;
    }
}
