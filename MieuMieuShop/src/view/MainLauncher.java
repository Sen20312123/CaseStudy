package view;

import java.util.Scanner;

public class MainLauncher {
    public static Scanner sc = new Scanner(System.in);

    public MainLauncher(){
            run();
    }
    public static void run(){
       UserViewLauncher.login();
    }

    public static void menuOption(){
    do {
        mainMenu();
        try {
            System.out.println("Chọn chức năng: ");
            System.out.print("┌► ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    UserViewLauncher.run();
                    break;
                case 2:
                    ProductViewLauncher.runProduct();
                    break;
                case 3:
                    OrderViewLauncher.runOrder();
                    break;
                case 4:
                    UserViewLauncher.login();
                    break;
                default:
                    System.out.println("Nhập sai ❌ Vui lòng nhập lại!");
            }
        }catch (Exception e){
            System.out.println("Lỗi!!!");
        }

    }while (true);
    }

    public static void mainMenu(){
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[DANH SÁCH QUẢN LÝ]░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Quản lý người dùng                   │");
        System.out.println("\t│               【2】. Quản lý sản phẩm                     │");
        System.out.println("\t│               【3】. Quản lý đơn đặt hàng                 │");
        System.out.println("\t│               【0】. Thoát chương trình                   │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
    }
    public static void menuUser(){
        System.out.println("\t┌───────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░[DANH SÁCH NGƯỜI DÙNG]░░░░░░░░░░░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└───────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("\t│                        【1】. Thêm người dùng                                      │");
        System.out.println("\t│                        【2】. Sửa thông tin người dùng                             │");
        System.out.println("\t│                        【3】. Xóa người dùng                                       │");
        System.out.println("\t│                        【4】. Hiện thông tin người dùng                            │");
        System.out.println("\t│                        【5】. Quay lại MAIN MENU                                   │");
        System.out.println("\t│                        【0】. Thoát chương trình                                   │");
        System.out.println("\t└───────────────────────────────────────────────────────────────────────────────────┘");
    }

    public static void menuProduct(){
        System.out.println("\t┌──────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░[DANH SÁCH SẢN PHẨM]░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("\t│                             【1】. Hiển thị danh sách sản phẩm                        │");
        System.out.println("\t│                             【2】. Sửa sản phẩm                                       │");
        System.out.println("\t│                             【3】. Xóa sản phẩm                                       │");
        System.out.println("\t│                             【4】. Thêm sản phẩm                                      │");
        System.out.println("\t│                             【5】. Sắp xếp sản phẩm                                   │");
        System.out.println("\t│                             【6】. Tìm kiếm sản phẩm                                  │");
        System.out.println("\t│                             【7】. Quay lại menu                                      │");
        System.out.println("\t│                             【0】. Thoát chương trình                                 │");
        System.out.println("\t└──────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng:");
        System.out.printf("┌►\t");
    }

    public static void inputUpdata() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[CẬP NHẬT SẢN PHẨM]░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Cập nhật giá                         │");
        System.out.println("\t│               【2】. Cập nhật số lượng                    │");
        System.out.println("\t│               【0】. Quay lại                             │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng:");
        System.out.print("┌► \t");
    }

    public static void menuOrder() {
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[QUẢN LÍ HÓA ĐƠN]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Tạo đơn hàng                         │");
        System.out.println("\t│               【2】. Xem doanh thu                        │");
        System.out.println("\t│               【3】. Quay lại MAIN MENU                   │");
        System.out.println("\t│               【0】. THOÁT                                │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
    }
}
