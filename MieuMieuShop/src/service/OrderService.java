package service;

import model.Order;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService{

    private final static String PATH = "E:\\Module2\\CaseStudy_module2\\MieuMieuShop\\data\\order.csv";

    private static OrderService instance;

    public OrderService(){

    }

    public static OrderService getInstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;
    }
    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for(String record : records){
            orders.add(Order.parse(record));
        }
        return orders;
    }

    @Override
    public void add(Order newOrder) {
    List<Order> orders = findAll();
    orders.add(newOrder);
    CSVUtils.writeFile(PATH,orders);
    }

    @Override
    public void update() {
        List<Order> orders = findAll();
        CSVUtils.writeFile(PATH,orders);
    }

    @Override
    public Order getOrderById(int id) {
        List<Order> orders = findAll();
        for (Order order : orders){
            if (id == order.getId())
                return order;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getOrderById(id) != null;
    }

    @Override
    public boolean checkNames(String name) {
        List<Order> orders = findAll();
        for (Order order : orders){
            if (order.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkId(int id) {
        List<Order> orders = findAll();
        for (Order order : orders){
            if (order.getId()== id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(Order order) {
    List<Order> orders = findAll();
    orders.remove(order);
    CSVUtils.writeFile(PATH,orders);
    }

    @Override
    public boolean existsByPhone(String phone) {
        List<Order> orders = findAll();
        for (Order order : orders){
            if(order.getPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public Order findById(long orderId) {
        List<Order> orders = findAll();
        for (Order order : orders){
            if (order.getId()== orderId)
                return order;
        }
        return null;
    }
}
