package view;

import model.Role;
import model.User;
import service.IUserService;
import service.UserService;
import utils.AppUtils;
import utils.InstantUtils;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class UserView {

    public static Scanner sc = new Scanner(System.in);
    public final IUserService userService;

    public UserView() {
        userService = UserService.getInstance();
    }

    public void addUser(){
    do {
        try {
            long id = System.currentTimeMillis() / 1000;
            String userName = inputUserName();
            String password = inputPassword();
            String fullName = inputFullName(InputOption.ADD);
            String phone = inputPhone(InputOption.ADD);
            String address = inputAddress(InputOption.ADD);
            String email = inputEmail(InputOption.ADD);
            User user = new User(id ,userName ,password , fullName , phone , address, email , Role.USER);
            setRole(user);
            userService.addUser(user);
            System.out.println("Đã thêm người dùng thành công♥");
        }catch (Exception e){
            System.out.println("Nhập sai!!! Vui lòng nhập lại !!!");
        }
      }while (AppUtils.isRetry(InputOption.ADD));
    }

    public void addUsers(){
        try {
            long id = System.currentTimeMillis() / 1000;
            String username = inputUserName();
            String password = inputPassword();
            String fullName = inputFullName(InputOption.ADD);
            String phone = inputPhone(InputOption.ADD);
            String address = inputAddress(InputOption.ADD);
            String email = inputEmail(InputOption.ADD);
            User user = new User(id, username, password, fullName, phone, email, address, Role.USER);
            userService.addUser(user);
            System.out.println("Đăng ký thành công!");
        } catch (Exception e) {
            System.out.println("Nhập sai. Vui lòng nhập lại!111");
        }
        UserViewLauncher.login();
    }


    public void setRole(User user){
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░[PHÂN QUYỀN NGƯỜI DÙNG]░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│               【1】. THÀNH VIÊN                           │");
        System.out.println("\t│               【2】. QUẢN TRỊ VIÊN                        │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.print("┌► Chọn chức năng:");
        String option = sc.nextLine();
        sc.nextLine();
        switch (option) {
            case "1":
                user.setRole(Role.USER);
                break;
            case "2":
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Nhập không đúng. Vui lòng nhập lại! ");
                setRole(user);
        }
    }

    private String inputEmail(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập email (vd: vana123@gmail.com):");
                break;
            case UPDATE:
                System.out.println("Nhập email bạn muốn đổi: ");
                break;
        }
        System.out.print("┌► ");
        String email;
        do {
            if (!ValidateUtils.isEmailValid(email = sc.nextLine())) {
                System.out.println("Email " + email + " không đúng định dạng. Vui lòng nhập lại !!!" + "");
                System.out.println("Nhập email (vd: vana456@gmail.com)");
                System.out.print("┌► ");
                continue;
            }
            if (userService.existByEmail(email)) {
                System.out.println("Email " + email + " của bạn đẫ tồn tại! Vui lòng nhập lại!");
                System.out.println("Nhập email (vd: nguyenvana123@gmail.com");
                System.out.print("┌► ");
                continue;
            }
            break;
        } while (true);
        return email;
    }

    private String inputAddress(InputOption option) {
            switch (option) {
                case ADD:
                    String address;
                    System.out.println("Nhập địa chỉ (vd: Huế)");
                    System.out.print("┌► ");
                    do {
                        address = sc.nextLine();
                        if (address.trim().isEmpty()) {
                            System.out.println("Địa chỉ không được để trống!!!");
                            System.out.println("Nhập lại địa chỉ:");
                            System.out.print("┌► ");
                            address = sc.nextLine();
                        }
                    } while (address.trim().isEmpty());
                    return address;
                case UPDATE:
                    System.out.println("Nhập địa chỉ muốn đổi (vd: Huế):");
                    do {
                        address = sc.nextLine();
                        if (address.trim().isEmpty()) {
                            System.out.println("Địa chỉ không được để trống!!!");
                            System.out.println("Nhập lại địa chỉ:");
                            System.out.print("┌► ");
                            address = sc.nextLine();
                        }
                    } while (address.trim().isEmpty());
                    return address;
            }
            return null;
        }


    private String inputPhone(InputOption option) {
        switch (option){
            case ADD :
                System.out.println("Nhập số điện thoại (vd: 0387564859, 10 số):");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại mà bạn muốn đổi lại: ");
                break;
    }
        System.out.println("┌► ");
        String phone;
        do {
            phone = sc.nextLine();
            if (!ValidateUtils.isPhoneValid(phone)){
                System.out.println("Số " + phone + " không đúng định dạng! Nhập lại!" + "Gồm 10 số và bắt đầu bằng số 0, số thứ 2 là từ 3,7,8,9!");
                System.out.println("Nhập số điện thoại (vd: 0748593849)");
                System.out.print("┌► ");
                continue;
            }
            if (userService.existByPhone(phone)){
                System.out.println("Số này đã tồn tại. Vui lòng nhập lại!");
                System.out.print("┌► ");
                continue;
            }
            break;
        }while (true);
        return phone;
        }

    private String inputFullName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Nguyen Van A)");
                break;
            case UPDATE:
                System.out.println("Nhập tên bạn muốn sửa :");
                break;
        }
        System.out.println("┌► ");
        String fullName;
        while (!ValidateUtils.isNameValid(fullName = sc.nextLine())){
            System.out.println("Tên " + fullName + " không đúng định dạng." + " Viết hoa chữ cái đầu." + " Không bao gồm số, không thêm ký tự đặc biệt");
            System.out.println("Nhập tên (vd : Tran Van A) ");
            System.out.println("┌► ");
        }
        return fullName;
    }

    private String inputPassword() {
        System.out.println("Nhập mật khẩu (từ 8 - 20 ký tự ,bao gồm số, chữ cái viết hoa, ký tự đặc biệt ):");
        System.out.println("┌► ");
        String password;
        while (!ValidateUtils.isPasswordValid(password = sc.nextLine())){
            System.out.println("Mật khẩu yếu !!! Vui lòng nhập lại !!!");
            System.out.println("┌► ");
        }
        return password;
    }

    private String inputUserName() {
        System.out.println("Nhập Username (không bao gồm dấu cách, kí tự đặc biệt)");
        System.out.print("┌►");
        String username;
        do {
            if (!ValidateUtils.isUserNameValid(username = AppUtils.retryString("Username"))) {
                System.out.println("Không đúng định dạng. Vui lòng kiểm tra và nhập lại!");
                System.out.print("┌► ");
                continue;
            }
            if (userService.existByUserName(username)) {
                System.out.println("Username này đã tồn tại. Vui lòng nhập lại!");
                System.out.print("┌► ");
                continue;
            }
            break;
        } while (true);
        return username;
    }

    public void updateUser() {
        boolean isRetry = false;
        do {
            try {
                showUsers(InputOption.UPDATE);
                int id = inputId(InputOption.UPDATE);
                System.out.println("\t┌──────────────────────────────────────────────────────────┐");
                System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░[THAY ĐỔI NGƯỜI DÙNG]░░░░░░░░░░░░░░ ◄│");
                System.out.println("\t└──────────────────────────────────────────────────────────┘");
                System.out.println("\t│               【1】. Thay đổi tên                         │");
                System.out.println("\t│               【2】. Thay đổi số điện thoại               │");
                System.out.println("\t│               【3】. Thay đổi địa chỉ                     │");
                System.out.println("\t│               【4】. Thay đổi tất cả                      │");
                System.out.println("\t│               【5】. Quay lại                             │");
                System.out.println("\t│               【0】. Thoát chương trình                   │");
                System.out.println("\t└──────────────────────────────────────────────────────────┘");
                System.out.print("┌►  CHỌN SỐ : ");
                int option = AppUtils.retryChoose(0, 5);
                User newUser = new User();
                newUser.setIdUser(id);
                String name;
                String phone;
                String address;
                switch (option) {
                    case 1:
                        name = inputFullName(InputOption.UPDATE);
                        newUser.setFullName(name);
                        userService.update(newUser);
                        System.out.println("Thay đổi tên thành công ♥");
                        break;
                    case 2:
                        phone = inputPhone(InputOption.UPDATE);
                        newUser.setPhone(phone);
                        userService.update(newUser);
                        System.out.println("Thay đổi số điện thoại thành công ♥");
                        break;
                    case 3:
                        address = inputAddress(InputOption.UPDATE);
                        newUser.setAddress(address);
                        userService.update(newUser);
                        System.out.println("Thay đổi địa chỉ thành công ♥");
                        break;
                    case 4:
                        name = inputFullName(InputOption.UPDATE);
                        newUser.setFullName(name);
                        phone = inputPhone(InputOption.UPDATE);
                        newUser.setPhone(phone);
                        address = inputAddress(InputOption.UPDATE);
                        newUser.setAddress(address);
                        userService.update(newUser);
                        System.out.println("Thay đổi thành công ♥");
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
                isRetry = option != 5 && AppUtils.isRetry(InputOption.UPDATE);
            }catch (Exception e){
                System.out.println("Nhập sai!!!");
            }
        }while (isRetry);
    }

    public void showUsers(InputOption inputOption) {
        System.out.println("֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍ DANH SÁCH NGƯỜI DÙNG֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍");
        System.out.printf("%-15s %-22s %-15s %-22s %-18s %-15s %-20s %-20s\n", "Id", "Tên", "Số điện thoại", "Email", "Địa chỉ", "Người dùng", "Ngày tạo", "Ngày cập nhật");
        List<User> users = userService.findAll();
        for (User user : users){
            System.out.printf("%-15d %-22s %-15s %-22s %-18s %-15s %-20s %-20s\n",
                    user.getIdUser(),
                    user.getFullName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getRole(),
                    InstantUtils.instantToString(user.getCreateAt()),
                    user.getUpdateAt() == null ? "" : InstantUtils.instantToString(user.getUpdateAt())
                    );
        }
        System.out.println("֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍֍");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }

    private int inputId(InputOption option) {
        int id;
        switch (option){
            case ADD:
                System.out.println("Nhập id: ");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa: ");
                break;
            case DELETE:
                System.out.println("Nhập id muốn xóa: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = userService.existById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id đã tồn tại. Vui lòng nhập lại!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy id. Vui lòng nhập lại!");
                    }
                    isRetry = !exist;
            }
        } while (isRetry);
        return id;
    }

    public void deleteUser() {
        List<User> users = userService.findAll();
        showUsers(InputOption.DELETE);
        int id;
        while (!userService.existById(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tồn tại người dùng !");
            System.out.println("Nhấn 1 để tìm lại người dùng || Nhấn 2 để quay lại || Nhấn 0 để thoát chương trình ");
            System.out.print("┌► ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    deleteUser();
                    break;
                case 2:
                    MainLauncher.menuUser();
                    return;
                case 0:
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Nhập chức năng không đúng! Vui lòng nhập lại!");
                    break;
            }
        }
        System.out.println("\t┌──────────────────────────────────────────────────────────┐");
        System.out.println("\t│► ░░░░░░░░░░░░░░░░░░░░░░░[XÁC NHẬN XÓA]░░░░░░░░░░░░░░░░░ ◄│");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("\t│                  【1】. ĐỒNG Ý XÓA                        │");
        System.out.println("\t│                  【2】. QUAY LẠI                          │");
        System.out.println("\t└──────────────────────────────────────────────────────────┘");
        System.out.println("┌► CHỌN SỐ :");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            userService.deleteById(id);
            System.out.println("Đã xóa user thành công!");
            showUsers(InputOption.DELETE);
            AppUtils.isRetry(InputOption.DELETE);
        } else if (option == 2) {
            UserViewLauncher.run();
        }
    }


}
