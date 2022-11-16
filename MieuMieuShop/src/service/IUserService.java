package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll() ;

    User adminLogin(String userName , String passWord) ;

    void addUser(User newUser) ;

    void update(User newUser) ;

    boolean existById ( int id) ;

    boolean existByEmail(String email)  ;

    boolean existByPhone(String phone);

    boolean existByUserName(String userName) ;

    User findById(int id);

    void deleteById(int id) ;
}
