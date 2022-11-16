package utils;

import view.InputOption;

import java.text.DecimalFormat;
import java.util.Scanner;

import static jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode.SEARCH;
import static view.InputOption.*;


public class AppUtils {
    public static Scanner sc = new Scanner(System.in);

    public static int retryChoose(int min , int max){
        int choose;
        do {
            try {
                choose = Integer.parseInt(sc.nextLine());
                if(choose > max || choose < min ){
                    System.out.println("Chọn sai , vui lòng nhập lại");
                    continue;
                }
                break;

            }catch (Exception e){
                System.out.println("Nhập sai , vui lòng nhập lại");
            }

        }while (true);
        return choose;
    }

    public static int retryParseInt(){
        int result;
        do {
            try {
                result = Integer.parseInt(sc.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Nhập sai , vui lòng nhập lại");
            }

        }while (true);
    }

    public static String retryString(String filedName){
        String result;
        while ((result = sc.nextLine()).isEmpty()){
            System.out.printf("%s Không được để trống \n" , filedName);
            System.out.println("┌► ");
        }
        return result;
    }

    public static double retryParseDouble(){
        double result;
        do {
            try {
                result = Double.parseDouble(sc.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Nhập sai , vui lòng nhập lại");
            }
        }while (true);
    }

    public static String doubleToVND(double value){
        String patternVND = ",###đ";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static boolean isRetry(InputOption inputOption){
        do {
            switch (inputOption){
                case ADD:
                    System.out.println("Nhấn 1 để tiếp tục \t|\t Nhấn 2 để quay lại \t|\t Nhấn 0 để thoát chương trình");
                    break;
                case UPDATE:
                    System.out.println("Nhấn 1 để tiếp tục \t|\t Nhấn 2 để quay lại \t|\t Nhấn 0 để thoát chương trình");
                    break;
                case DELETE:
                    System.out.println("Nhấn 1 để tiếp tục \t|\t Nhấn 2 để quay lại \t|\t Nhấn 0 để thoát chương trình");
                    break;
                case SHOW:
                    System.out.println("Nhấn 1 để tiếp tục \t|\t Nhấn 2 để quay lại \t|\t Nhấn 0 để thoát chương trình");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + inputOption);
            }

            System.out.print("┌► ");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    return true;
                case "2":
                    return false;
                case "0":
                    exit();
                    break;
                default:
                    System.out.println("Chọn số sai , vui lòng nhập lại ");
                    break;
            }

        }while (true);
    }
    public static void exit() {
        System.out.println("░░░ Cảm ơn quý khách. Hẹn gặp lại !!! ░░░");
        System.exit(5);
    }
}
