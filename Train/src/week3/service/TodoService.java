package week3.service;

import week3.dao.TodoDao;
import week3.entity.Todo;

import java.util.ArrayList;

/**
 * @author fz
 */
public class TodoService {
    private TodoDao todoDao = new TodoDao();
    public boolean addTodo(Todo todo){
        return todoDao.addTodo(todo);
    }

    public boolean updateTodo(Todo todo){
        return todoDao.updateTodo(todo);
    }

    public boolean deleteTodo(int id){
        return todoDao.deleteTodo(id);
    }

    public ArrayList<Todo> queryTodoByUserId(int uid){
        return todoDao.queryTodoByUserId(uid);
    }

    public Todo queryTodoById(int id){
        return todoDao.queryTodoById(id);
    }
}
