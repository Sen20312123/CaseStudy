package view;

import model.Product;
import service.ProductService;
import utils.AppUtils;
import utils.InstantUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import static java.awt.event.PaintEvent.UPDATE;
import static javax.swing.event.TableModelEvent.DELETE;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.ADD;

public class ProductView {

    private ProductService productService = new ProductService();

    public static Scanner sc = new Scanner(System.in);

    private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###" + " đ");

    public ProductView(){
        productService = ProductService.getInstance();
    }

    private final static String PATH = "E:\\Module2\\CaseStudy_module2\\MieuMieuShop\\data\\product.csv";

    public  String inputNameProduct(InputOption option){
        String nameProduct= "";
        switch (option){
            case ADD:
                System.out.println("Nhập tên sản phẩm : ");
                break;
            case UPDATE:
                System.out.println("Nhập tên sản phẩm bạn muốn sửa: ");
                break;
        }
        do {
            nameProduct = AppUtils.retryString("Tên sản phẩm:");
        }while (nameProduct.isEmpty());
        return nameProduct;
    }

    public int inputQuantity(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập số lượng: ");
                break;
            case UPDATE:
                System.out.println("Nhập số lượng muốn sửa: ");
                break;
        }
        int quantity;
        do {
            quantity = AppUtils.retryParseInt();
            if (quantity < 0) {
                System.out.println("Số lượng phải lớn hơn 0");
            }
        } while (quantity < 0);
        return quantity;
        }
        public void inputQuantity( int id ){
        Product product = productService.getProductByID(id);
            System.out.println("Nhập số lượng: ");
            System.out.println("┌►");
            int quantity = Integer.parseInt(sc.nextLine());
            product.setQuantity(quantity);
            productService.update(product);
            showProduct(InputOption.UPDATE);
            System.out.println(" Cập nhật thành công ☺☺☺ ");
        }

        private double inputPrice(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập giá sản phẩm: ");
                break;
            case UPDATE:
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                break;
        }
            double price;
            do {
                price = AppUtils.retryParseDouble();
                if (price <= 0) {
                    System.out.println("Giá phải lớn hơn 0");
                }
            } while (price < 0);
            return price;
        }
        public void inputPrice(int id){
        Product product = productService.getProductByID(id);
            System.out.println("Nhập giá: ");
            System.out.println("┌►");
            double price = Double.parseDouble(sc.nextLine());
            product.setPrice(price);
            productService.update(product);
            showProduct(InputOption.UPDATE);
            System.out.println(" Cập nhật thành công ☺☺☺ ");
        }

        public void addProduct(){
        do {
            long id = System.currentTimeMillis() / 1000;
            String nameProduct = inputNameProduct(InputOption.ADD);
            double price = inputPrice(InputOption.ADD);
            int quantity = inputQuantity(InputOption.ADD);
            Product product = new Product((int) id, nameProduct, price, quantity);
            productService.add(product);
            System.out.println("Sản phẩm đã được thêm thành công!❀");
            showProduct(InputOption.ADD);
        }while (AppUtils.isRetry(InputOption.ADD));
    }

    public void show(List<Product> productList){
        System.out.println("──────────────────────────────────────────────────────────────── DANH SÁCH SẢN PHẨM ────────────────────────────────────────────────────────────────");
        System.out.printf("%-25s▎ %-25s| %-15s| %-18s|", "ID", "Tên ", "Giá", "Số lượng");
        System.out.println("");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        for (Product product : productList) {
            System.out.printf("%-25s| %-25s| %-15s| %-13s     |\n",
                    product.getId(),
                    product.getName(),
                    decimalFormat.format(product.getPrice()),
                    product.getQuantity());
        }
        System.out.println("");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
    }
    void showProduct(InputOption option) {
        List<Product> products = productService.findAll();
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf("%-17s %-20s %-15s %-20s %-25s %-25s\n",
                " ID",
                "TÊN SẢN PHẨM",
                "SỐ LƯỢNG",
                "GIÁ",
                "THỜI GIAN TẠO",
                "THỜI GIAN CẬP NHẬT");
        System.out.println();
        for (Product product : productService.findAll()) {
            System.out.printf("%-17s %-20s %-15s %-20s %-25s %-25s\n",
                    "【" + product.getId() + "】",
                    product.getName(),
                    product.getQuantity(),
                    AppUtils.doubleToVND(product.getPrice()),
                    InstantUtils.instantToString(product.getTimeNow()),
                    product.getTimeUpdate() == null ? "" : InstantUtils.instantToString(product.getTimeUpdate()));
        }
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        if (option == InputOption.SHOW) {
            AppUtils.isRetry(InputOption.SHOW);
        }
    }

    public void update() {
        show(productService.findAll());
        System.out.println("Nhập ID cần sửa:");
        System.out.println("┌►");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if(productService.exitsts(id)){
                MainLauncher.inputUpdata();
                boolean isFlag = true;
                do{
                    try {
                        int choose = Integer.parseInt(sc.nextLine());
                        switch (choose){
                            case 1:
                                inputPrice(id);
                                break;
                            case 2:
                                inputQuantity(id);
                                break;
                            case 3:
                                ProductViewLauncher.runProduct();
                                break;
                            default:
                                System.out.println(" Không hợp lệ !!! Vui lòng nhập lại");
                                break;
                        }
                    }catch (Exception e){
                        update();
                    }
            }while (!isFlag);
                boolean flag = true;
                do {
                    System.out.println("Nhấn 1 để tiếp tục cập nhật || Nhấn 2 để quay lại || Nhấn 0 để thoát \n");
                    System.out.println("┌►");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose){
                        case 1:
                            update();
                            break;
                        case 2:
                            ProductViewLauncher.runProduct();
                            break;
                        case 0 :
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Nhập sai !!! Vui lòng nhập lại");
                            break;
                    }
                }while (!flag);
                }else {
                System.out.println("Mời nhập lại!");
                update();
            }
        }catch (Exception e){
            System.out.println("Nhập không chính xác ❌");
            update();
        }
    }

    public void remove() {
        List<Product> products = productService.findAll();
        show(products);
        int id;
        while (!productService.exitsts(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tìm thấy id! ");
            System.out.println("Nhấn 1 để tiếp tục || Nhấn 2 để quay lại || Nhấn 0 để thoát! ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    remove();
                    MainLauncher.menuProduct();
                    break;
                case 2:
                    MainLauncher.menuProduct();
                    return;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn sai !!! Vui lòng chọn lại!");
                    break;
            }
        }
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░░░░[XÁC NHẬN XÓA]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│                  【1】. ĐỒNG Ý XÓA                        │");
        System.out.println("\t│                  【2】. QUAY LẠI                          │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("┌► Chọn số :");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            productService.remove(id);
            System.out.println("Xóa thành công !");
            showProduct(InputOption.DELETE);
            AppUtils.isRetry(InputOption.DELETE);
        } else if (option == 2) {
            ProductViewLauncher.runProduct();
        }
    }

    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập id: ");
                break;
            case UPDATE:
                System.out.println("Nhập id muốn sửa: ");
                break;
            case DELETE:
                System.out.println("Nhập id muốn xóa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = productService.exitsts(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("ID đã tồn tại! Vui lon nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;

    }
}
