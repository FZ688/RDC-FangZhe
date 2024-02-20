package week3.view;

import org.junit.Test;
import week3.entity.Todo;
import week3.entity.User;
import week3.service.TodoService;
import week3.service.UserService;

import java.util.Scanner;

/**
 * @author fz
 */
public class TestDemo {
    Scanner sc = new Scanner(System.in);
    UserView uv = new UserView();
    TodoView tv = new TodoView();
    public void start() {
        System.out.println("1. 登录 | 2. 注册");
        System.out.println("请选择：");
        String choose = sc.next();
        if ("1".equals(choose)) {
            User user = uv.login();
            tv.showMainMenu(user);
        } else if ("2".equals(choose)) {
            uv.register();
        }
    }


}
