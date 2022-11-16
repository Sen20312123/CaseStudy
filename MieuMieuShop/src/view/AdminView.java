package view;

import model.Role;
import model.User;
import service.IUserService;
import service.UserService;
import utils.AppUtils;

import java.util.Scanner;

public class AdminView {
    private final IUserService userService;

    private static Scanner sc = new Scanner(System.in);

    public AdminView() {
        userService = UserService.getInstance();
    }

    public void adminLogin(){
        boolean isRetry = false;
        System.out.println("««««««««««««««««««««««««««« Đăng Nhập »»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
        do {
            System.out.println("Tên tài khoản: ");
            System.out.print("┌►");
            String username = AppUtils.retryString("Username");
            System.out.println("Mật khẩu: ");
            System.out.print("┌►");
            String password = AppUtils.retryString("Mật khẩu");
            User user = userService.adminLogin(username, password);
            if (user == null) {
                System.out.println("Tài khoản không hợp lệ!");
                isRetry = isRetry();
            } else if (user.getRole() == Role.ADMIN) {
                System.out.println(" ☻☻☻ Đăng nhập thành công ☻☻☻ ");
                System.out.println(" ☻☻☻ Chào mừng Admin " + user.getFullName() + " ☻☻☻ ");
                MainLauncher.menuOption();
            } else if (user.getRole() == Role.USER) {
                System.out.println("Đăng nhập thành công ☻☻☻ ");
                System.out.println(" ☻☻☻ Chào mừng user ☻☻☻ " + user.getFullName());
                MenuUser.runOrderUser();
            }
        }while (isRetry);
    }

    private boolean isRetry() {
        do {
            try {
                System.out.println("Nhấn '1' để đăng nhập lại! || Nhấn '0' để thoát chương trình");
                System.out.print("┌►");
                String option = sc.nextLine().toLowerCase();
                switch (option) {
                    case "1":
                        return true;
                    case "0":
                        AppUtils.exit();
                    default:
                        System.out.println("Nhập chức năng không đúng! Vui lòng nhập lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! Vui lòng nhập lại!");
                e.printStackTrace();
            }
        } while (true);
    }
}
