package week3.dao;

import week3.entity.Todo;
import week3.utils.DBUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author fz
 */
public class TodoDao {

    /**
     * 添加待办事项
     * @param todo 待办事项对象，包含待办事项的userid，title，content，ddl，create_time，update_time这些属性值。
     * @return 返回true表示添加成功，返回false表示添加失败。
     */
    public boolean addTodo(Todo todo) {
        Connection conn = DBUtils.getConnection();
        String sql = "insert into todo(u_id, title, content, ddl, create_time, update_time) values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, todo.getUserId());
            ps.setString(2, todo.getTitle());
            ps.setString(3, todo.getContent());
            ps.setTimestamp(4, Timestamp.valueOf(todo.getDdl()));
            ps.setTimestamp(5, Timestamp.valueOf(todo.getCreateTime()));
            ps.setTimestamp(6, Timestamp.valueOf(todo.getUpdateTime()));
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(ps, conn);
        }
        return false;
    }

    /**
     * 修改待办事项
     * @param todo 待办事项对象，包含待办事项的id，title，content，ddl，update_time这些属性值。
     * @return   返回true表示修改成功，返回false表示修改失败。
     */
    public boolean updateTodo(Todo todo) {
        Connection conn = DBUtils.getConnection();
        String sql = "update todo set title = ?, content = ?, ddl = ?, update_time = ? where t_id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, todo.getTitle());
            ps.setString(2, todo.getContent());
            ps.setTimestamp(3, Timestamp.valueOf(todo.getDdl()));
            ps.setTimestamp(4, Timestamp.valueOf(todo.getUpdateTime()));
            ps.setInt(5, todo.gettId());
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(ps, conn);
        }
        return false;
    }

    /**
     * 删除待办事项，根据id删除待办事项。
     * @param id   待办事项的id。
     * @return     返回true表示删除成功，返回false表示删除失败。
     */
    public boolean deleteTodo(int id) {
        Connection conn = DBUtils.getConnection();
        String sql = "delete from todo where t_id = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(ps, conn);
        }
        return false;
    }

    /**
     * 根据用户id查询待办事项。
     * @param uid   用户id
     * @return      返回待办事项的集合。
     */
    public ArrayList<Todo> queryTodoByUserId(int uid) {
        Connection conn = DBUtils.getConnection();
        ArrayList<Todo> todos = new ArrayList<>();
        String sql = "select t_id,title,content,ddl,create_time,update_time from todo where u_id= ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int tId = rs.getInt("t_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                LocalDateTime ddl = rs.getTimestamp("ddl").toLocalDateTime();
                LocalDateTime createTime = rs.getTimestamp("create_time").toLocalDateTime();
                LocalDateTime updateTime = rs.getTimestamp("update_time").toLocalDateTime();
                Todo todo = new Todo();
                todo.settId(tId);
                todo.setTitle(title);
                todo.setContent(content);
                todo.setDdl(ddl);
                todo.setCreateTime(createTime);
                todo.setUpdateTime(updateTime);
                todos.add(todo);
            }
            return todos;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, ps, conn);
        }
        return null;
    }

    /**
     * 根据待办事项的id查询待办事项。
     * @param id   待办事项的id。
     * @return     返回待办事项对象。
     */
    public Todo queryTodoById(int id) {
        Connection conn = DBUtils.getConnection();
        String sql = "select * from todo where t_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int tid = rs.getInt("t_id");
                int uid = rs.getInt("u_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                LocalDateTime ddl = rs.getTimestamp("ddl").toLocalDateTime();
                LocalDateTime createTime = rs.getTimestamp("create_time").toLocalDateTime();
                LocalDateTime updateTime = rs.getTimestamp("update_time").toLocalDateTime();
                Todo todo = new Todo(uid,title,content,ddl,createTime,updateTime);
                todo.settId(tid);
                return todo;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, ps, conn);
        }
        return null;
    }
}
