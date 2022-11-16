package view;

import java.util.Scanner;

public class ProductViewLauncher {
    public static Scanner sc = new Scanner(System.in);


        public static void runProduct(){
            int choose;
            boolean flag = true ;
            try {
                do {
                    ProductView productView = new ProductView();
                    MainLauncher.menuProduct();
                    choose = Integer.parseInt(sc.nextLine());
                    switch (choose){
                        case 1:
                            productView.showProduct(InputOption.SHOW);
                            runProduct();
                            break;
                        case 2:
                            productView.update();
                            break;
                        case 3:
                            productView.remove();
                            break;
                        case 4:
                            productView.addProduct();
                            runProduct();
                            break;
                        case 5:
                            SortProductView.choose();
                            break;
                        case 6:
                            SearchProductView.search();
                            break;
                        case 7:
                            MainLauncher.menuOption();
                        case 8:
                            UserViewLauncher.login();
                            break;
                        default:
                            System.out.println("Nhập sai!!! Vui lòng nhập lại");
                    }
                }while (!flag);
            }catch (Exception e){
                System.out.println("Nhập sai!!!Vui lòng nhập lại");
                runProduct();
            }
        }
}
