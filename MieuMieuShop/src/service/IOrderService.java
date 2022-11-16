package service;

import model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    void add( Order newOrder);

    void update();

    Order getOrderById(int id);

    boolean exist(int id);

    boolean checkNames(String name);

    boolean checkId( int id);

    void remove(Order order);

    boolean existsByPhone(String phone);

    Order findById(long orderId);
}
