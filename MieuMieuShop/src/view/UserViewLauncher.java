package view;

import utils.AppUtils;

import java.util.Scanner;

import static view.MainLauncher.menuUser;

public class UserViewLauncher {
    public static Scanner sc = new Scanner(System.in);

    public static UserView userView = new UserView();

    public static AdminView adminView = new AdminView();

    public static void run(){
        int choose = -1;
        do {
            menuUser();
            try {
                do {
                    System.out.println("Chọn chức năng:");
                    System.out.println("┌► ");
                    choose = Integer.parseInt(sc.nextLine());
                    if (choose > 6 || choose < 1)
                        System.out.println("Chọn chức năng không đúng!!!");
                }while (choose > 6|| choose < 1);
                switch (choose){
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                    case 3:
                        userView.deleteUser();
                        break;
                    case 4:
                        userView.showUsers(InputOption.SHOW);
                        break;
                    case 5:
                        MainLauncher.menuOption();
                        break;
                    case 6:
                        UserViewLauncher.login();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng!!! ");
                        break;
                }
            }catch (Exception e){
                System.out.println("Nhập sai!!!");
            }
        }while (choose != 6);
    }

    public static void login() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│                【1】. Đăng ký                             │");
        System.out.println("\t│                【2】. Đăng nhập                           │");
        System.out.println("\t│                【0】. Thoát chương trình                  │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng");
        System.out.print("┌► ");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose){
            case 1 :
                userView.addUsers();
                break;
            case 2:
                adminView.adminLogin();
                break;
            case 0:
                AppUtils.exit();
            default:
                System.out.println("Chọn sai!!! Vui lòng chọn lại : ");
        }
        }
    }

