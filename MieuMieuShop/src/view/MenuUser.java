package view;

import java.util.Scanner;

public class MenuUser {
   public static ProductView productView = new ProductView();
    public static OrderView orderView = new OrderView();

    public static void menuOrderUser(){
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[QUẢN LÍ HÓA ĐƠN]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Tạo đơn hàng                         │");
        System.out.println("\t│               【2】. Danh sách sản phẩm                   │");
        System.out.println("\t│               【0】. Thoát                                │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
    }

    public static void runOrderUser() {
        menuOrderUser();
        System.out.println("Chọn chức năng:");
        System.out.println("┌► ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                orderView.addOrderUser();
                break;
            case 2:
                productView.showProduct(InputOption.SHOW);
                runOrderUser();
                break;
            case 0:
                UserViewLauncher.login();
                break;
            default:
                System.out.println("Nhập chức năng sai !!! Vui lòng nhập lại !!!");
        }
    }
}
