package week3.view;

import week3.entity.Todo;
import week3.entity.User;
import week3.service.TodoService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author fz
 */
public class TodoView {
    Scanner sc = new Scanner(System.in);
    TodoService todoService = new TodoService();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public void showMainMenu(User user){
        System.out.println("欢迎您，" + user.getName());
        String choice = null;
        while (true) {
            System.out.println("--------------主菜单--------------");
            System.out.println("           1：添加待办事项");
            System.out.println("           2：修改待办事项");
            System.out.println("           3：删除待办事项");
            System.out.println("           4：查询待办事项");
            System.out.println("           5：退出");
            choice = sc.next();
            switch (choice) {
                case "1":
                    addTodo();
                    break;
                case "2":
                    updateTodo();
                    break;
                case "3":
                    deleteTodo();
                    break;
                case "4":
                    queryTodo();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }


    public void addTodo() {
        System.out.println("添加待办事项页面");
        System.out.println("请输入用户id：");
        int userId = sc.nextInt();
        System.out.println("请输入标题：");
        String title = sc.next();
        System.out.println("请输入内容：");
        String content = sc.next();
        LocalDateTime createTime = LocalDateTime.now();
        System.out.println("请输入截止时间：");
        sc.nextLine();
        LocalDateTime deadline = LocalDateTime.parse(sc.next(),dtf);
        if (deadline.isBefore(createTime)){
            System.out.println("截止时间不能早于创建时间");
            return;
        }
        LocalDateTime updateTime = LocalDateTime.now();
        Todo todo = new Todo(userId, title, content, deadline, createTime, updateTime);
        if(todoService.addTodo(todo)){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

        try {
            System.out.println("输入回车继续：");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateTodo() {
        System.out.println("请输入想要修改的待办事项的id：");
        int id = sc.nextInt();
        Todo todo = todoService.queryTodoById(id);
        if (todo  == null) {
            System.out.println("没有该待办事项");
            return;
        }
        System.out.println("是否修改标题(y/n)");
        String choice = sc.next();
        if ("y".equals(choice)) {
            System.out.println("请输入新的标题：");
            String title = sc.next();
            todo.setTitle(title);
        }

        System.out.println("是否修改内容(y/n)");
        choice = sc.next();
        if ("y".equals(choice)) {
            System.out.println("请输入新的内容：");
            String content = sc.next();
            todo.setContent(content);
        }

        System.out.println("是否修改截止日期(y/n)：");
        choice = sc.next();
        if ("y".equals(choice)) {
            System.out.println("请输入新的截止日期：");
            sc.nextLine();
            LocalDateTime deadline = LocalDateTime.parse(sc.nextLine(),dtf);
            if (deadline.isBefore(todo.getCreateTime())) {
                System.out.println("截止时间不能早于创建时间");
                return;
            }
            todo.setDdl(deadline);
        }

        todo.setUpdateTime(LocalDateTime.now());

        if(todoService.updateTodo(todo)){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }

        try {
            System.out.println("输入回车继续：");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTodo() {
        System.out.println("请输入想要删除的待办事项的id：");
        int id = sc.nextInt();
        if (todoService.queryTodoById(id) == null) {
            System.out.println("没有该待办事项");
            return;
        }
        System.out.println("确认要删除吗(y/n)");
        String choice = sc.next();
        if ("y".equals(choice)) {
            if (todoService.deleteTodo(id)) {
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        }else {
            System.out.println("已取消删除！");
        }

        try {
            System.out.println("输入回车继续：");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void queryTodo() {
        System.out.println("请输入用户id：");
        int userId = sc.nextInt();
        ArrayList<Todo> todos = todoService.queryTodoByUserId(userId);
        if (todos == null) {
            System.out.println("没有该用户的待办事项");
            return;
        }
        for (Todo todo : todos) {
            System.out.println("待办事项id："+todo.gettId()+"\t标题："+todo.getTitle()+"\t内容："+todo.getContent()+"\t截止日期"+todo.getDdl()+"\t创建时间："+todo.getCreateTime()+"\t最后修改时间"+todo.getUpdateTime());
        }
        try {
            System.out.println("输入回车继续：");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
