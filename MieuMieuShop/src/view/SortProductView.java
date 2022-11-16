package view;

import model.Product;
import service.ProductService;
import sort.*;

import java.util.List;
import java.util.Scanner;

public class SortProductView {
    public static Scanner sc = new Scanner(System.in);

    public static ProductView productView = new ProductView();

    public static ProductService productService = new ProductService();

    public static List<Product> products;
    public SortProductView(){
        products = productService.findAll();
    }

    public static void sortMenu(){
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[SẮP XẾP SẢN PHẨM]░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. Sắp xếp theo tên sản phẩm            │");
        System.out.println("\t│               【2】. Sắp xếp theo số lượng sản phẩm       │");
        System.out.println("\t│               【3】. Sắp xếp theo giá sản phẩm            │");
        System.out.println("\t│               【0】. QUAY LẠI                             │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("Chọn chức năng sắp xếp: ");
        System.out.print("┌► ");
    }
    public static void choose(){
        boolean isFlag = true;
        int option;
        do {
            sortMenu();
            option= Integer.parseInt(sc.nextLine());
            switch (option){
                case 1 :
                    showSortByName();
                    break;
                case 2:
                    showSortByQuantity();
                    break;
                case 3:
                    showSortByPrice();
                    break;
                case 0:
                    ProductViewLauncher.runProduct();
                    break;
                default:
                    System.out.println("Nhập sai!!! Vui lòng nhập lại!");
            }
        }while (!isFlag);
    }

    public static void showSortByName(){
        boolean flag = true;
        int choose;
        do {
            System.out.println("\t┌──────────────────────────────────────────────────────────┐");
            System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[SẮP XẾP THEO TÊN]░░░░░░░░░░░░░░░░ ◄│");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("\t│               【1】. Theo thứ tự từ A-Z                   │");
            System.out.println("\t│               【2】. Theo thứ tự từ Z-A                   │");
            System.out.println("\t│               【0】. Quay lại                             │");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("Chọn chức năng : ");
            System.out.print("┌► ");
            try {
                choose = Integer.parseInt(sc.nextLine());
                switch (choose){
                    case 1:
                        List<Product> products = productService.findAll();
                        System.out.println("Sắp xếp A-Z ");
                        SortByNameAsc sortByNameAsc = new SortByNameAsc();
                        products.sort(sortByNameAsc);
                        productView.show(products);
                        choose();
                        break;
                    case 2:
                        List<Product> products1 = productService.findAll();
                        System.out.println("Sắp xếp Z-A ");
                        SortByNameDesc sortByNameDesc = new SortByNameDesc();
                        products1.sort(sortByNameDesc);
                        productView.show(products1);
                        choose();
                        break;
                    case 0:
                        ProductViewLauncher.runProduct();
                        break;
                    default:
                        System.out.println("Nhập sai !!! Vui lòng nhập lại!");
                        flag = false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (!flag);
    }
    public static void showSortByQuantity(){
        boolean flag = true;
        int choose;
        do {
            System.out.println("\t┌──────────────────────────────────────────────────────────┐");
            System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[SẮP XẾP THEO SỐ LƯỢNG]░░░░░░░░░░░░░░░░ ◄│");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("\t│               【1】. Theo thứ tự từ tăng dần              │");
            System.out.println("\t│               【2】. Theo thứ tự từ giảm dần              │");
            System.out.println("\t│               【0】. Quay lại                             │");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("Chọn chức năng : ");
            System.out.print("┌► ");
            try {
                choose = Integer.parseInt(sc.nextLine());
                switch (choose){
                    case 1:
                        List<Product> products1 = productService.findAll();
                        System.out.println("Sắp xếp tăng dần ");
                        SortByQuantityAsc sortByQuantityAsc = new SortByQuantityAsc();
                        products1.sort(sortByQuantityAsc);
                        productView.show(products1);
                        choose();
                        break;
                    case 2:
                        List<Product> products2 = productService.findAll();
                        System.out.println("Sắp xếp giảm dần");
                        SortByQuantityDesc sortByQuantityDesc = new SortByQuantityDesc();
                        products2.sort(sortByQuantityDesc);
                        productView.show(products2);
                        choose();
                        break;
                    case 0:
                        ProductViewLauncher.runProduct();
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại!");
                        flag = false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (!flag);
    }

    public static void showSortByPrice(){
        boolean flag = true;
        int choose;
        do {
            System.out.println("\t┌──────────────────────────────────────────────────────────┐");
            System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░[SẮP XẾP THEO GIÁ]░░░░░░░░░░░░░░░░ ◄│");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("\t│               【1】. Theo thứ tự từ tăng dần              │");
            System.out.println("\t│               【2】. Theo thứ tự từ giảm dần              │");
            System.out.println("\t│               【0】. Quay lại                             │");
            System.out.println("\t└──────────────────────────────────────────────────────────┘");
            System.out.println("Chọn chức năng : ");
            System.out.print("┌► ");
            try {
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        List<Product> productList = productService.findAll();
                        System.out.println("Sắp xếp tăng dần");
                        SortByPriceAsc sortByPriceAsc = new SortByPriceAsc();
                        productList.sort(sortByPriceAsc);
                        productView.show(productList);
                        choose();
                        break;
                    case 2:
                        List<Product> productsList = productService.findAll();
                        System.out.println("Sắp xếp giảm dần");
                        SortByPriceDesc sortByPriceDesc = new SortByPriceDesc();
                        productsList.sort(sortByPriceDesc);
                        productView.show(productsList);
                        choose();
                        break;
                    case 0:
                        ProductViewLauncher.runProduct();
                        break;
                    default:
                        System.out.println("Chọn lại!");
                        flag = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (!flag);
    }
}
