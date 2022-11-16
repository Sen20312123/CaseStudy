package service;

import model.Role;
import model.User;
import utils.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserService implements IUserService{
    public final static String PATH = "E:\\Module2\\CaseStudy_module2\\MieuMieuShop\\data\\user.csv";

    private static UserService instance;

    private UserService(){

    }

    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public User adminLogin(String userName, String passWord)  {
        List<User> users = findAll();
        for (User user : users){
            if(user.getUserName().equals(userName) && user.getPassWord().equals(passWord)){
                return user;
            }
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)
            && user.getRole().equals(Role.ADMIN)){
                return user;
            }
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)
            && user.getRole().equals(Role.USER)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User newUser)  {
    newUser.setCreateAt(Instant.now());
    List<User> users = findAll();
    users.add(newUser);
    CSVUtils.writeFile(PATH,users);
    }

    @Override
    public void update(User newUser)  {
    List<User> users = findAll();
    for (User user : users){
        if(user.getIdUser()== newUser.getIdUser()){
            String fullName = newUser.getFullName();
            if(fullName != null && !fullName.isEmpty())user.setFullName(fullName);;
            String phone = newUser.getPhone();
            if (phone != null && !phone.isEmpty())user.setPhone(newUser.getPhone());
            String address = newUser.getAddress();
            if (address != null && !address.isEmpty())user.setAddress(newUser.getAddress());
            user.setUpdateAt(Instant.now());
            CSVUtils.writeFile(PATH,users);
            break;
        }
    }
    }

    @Override
    public boolean existById(int id){
        return findById(id) != null;
    }

    @Override
    public boolean existByEmail(String email) {
        List<User> users = findAll();
        for (User user : users){
            if(user.getEmail().equals(email))
                return true;
        }
        return false ;
    }

    @Override
    public boolean existByPhone(String phone) {
        List<User> users = findAll();
        for (User user : users){
            if (user.getPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByUserName(String userName) {
        List<User> users = findAll();
        for (User user : users){
            if (user.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        for (User user : users){
            if(user.getIdUser() == id)
                return user;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
    List<User> users = findAll();
    users.removeIf(new Predicate<User>() {
        @Override
        public boolean test(User user) {
            return user.getIdUser() == id;
        }
    });
    CSVUtils.writeFile(PATH,users);
    }
}
