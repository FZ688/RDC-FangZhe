package week3.view;

import week3.entity.User;
import week3.service.UserService;

import java.util.Scanner;

/**
 * @author fz
 */
public class UserView {
    private UserService userService = new UserService();
    Scanner sc = new Scanner(System.in);

    public User login() {
        System.out.println("您选择的是【登录】");
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        User user = userService.login(name, password);
        if (user != null) {
            System.out.println("登录成功");
            System.out.println("您的用户id是："+user.getId());
            return user;
        } else {
            System.out.println("登录失败");
            System.out.println("请重新登录");
            login();
        }
        return null;
    }

    public void register() {
        System.out.println("您选择的是【注册】");
        System.out.println("请输入新账号的用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请再次输入密码：");
        String password2 = sc.next();
        if (!password.equals(password2)) {
            System.out.println("两次输入的密码不一致，请重新注册");
            register();
        }else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            boolean flag = userService.register(user);
            if (flag) {
                System.out.println("注册成功");
                System.out.println("您的用户id为："+userService.findUserByName(name).getId());
                System.out.println("请登录");
                login();
            } else {
                System.out.println("注册失败");
                System.out.println("请重新注册");
                register();
            }
        }
    }
}
