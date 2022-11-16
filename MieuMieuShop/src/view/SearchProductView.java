package view;

import model.Product;
import service.ProductService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SearchProductView {
    public static Scanner sc = new Scanner(System.in);

    public static ProductView productView = new ProductView();

    public static ProductService productService = new ProductService();

    public static DecimalFormat format = new DecimalFormat("###,###,###" + "đ");

    public static void search(){
        productView.show(productService.findAll());
        boolean flag = true;
        int choose = -1;
        do {
            System.out.println("\t┌──────────────────────────────────────────────────────────┐");
            System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[TÌM KIẾM SẢN PHẨM]░░░░░░░░░░░░░░░░ ◄│");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("\t│               【1】. Tìm kiếm theo id sản phẩm            │");
            System.out.println("\t│               【2】. Tìm kiếm theo tên sản phẩm           │");
            System.out.println("\t│               【0】. Quay lại                             │");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("Chọn chức năng sắp xếp: ");
            System.out.print("┌► ");
            try {
                choose = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                e.printStackTrace();
            }
            switch (choose){
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
                case 0:
                    ProductViewLauncher.runProduct();
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập sai !!! Vui lòng nhập lại!");
                    break;
            }
        }while (flag);
    }

    public static void searchByName() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập tên cần tìm kiếm: ");
        try {
            String name = sc.nextLine();
            System.out.printf("%-20s %-30s %-18s %-10s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng\n");
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    count++;
                    System.out.printf("%-20s %-30s %-18s %-10s\n", product.getId(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Không hợp lệ!Mời nhập lại");
        }
    }

    public static void searchById() {
        List<Product> products = productService.findAll();
        int count = 0;
        System.out.println("Nhập id cần tìm kiếm: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            System.out.printf("%-15s %-30s %-18s %-10s", "Id", "Tên Sản Phẩm", "Giá", "Số lượng\n");
            for (Product product : products) {
                if (product.getId() == id) {
                    count++;
                    System.out.printf("%-10s %-30s %-18s %-10s\n", product.getId(), product.getName(), format.format(product.getPrice()),
                            product.getQuantity());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Không hợp lệ!Mời nhập lại");
        }
    }

    public static void showReturnSearch(int count) {
        char choice = ' ';
        boolean isChoice;
        System.out.println();
        do {
            System.out.println("Nhấn '1' để quay lại.");
            System.out.print("┌► ");
            try {
                choice = sc.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case '1': {
                    SearchProductView.search();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }

}
