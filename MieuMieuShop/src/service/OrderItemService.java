package service;

import model.OrderItem;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService{

    private final static String PATH = "E:\\Module2\\CaseStudy_module2\\MieuMieuShop\\data\\orderItem.csv";

    private static OrderItemService instance;

    public OrderItemService(){

    }

    public static OrderItemService getInstance(){
        if (instance == null){
            instance = new OrderItemService();
        }
        return instance;
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> records = CSVUtils.readFile(PATH);
        for(String record : records){
            orderItems.add(new OrderItem(record));
        }
        return orderItems;
    }

    @Override
    public void add(OrderItem newOrderItem) {
        List<OrderItem> orderItems = findAll();
        orderItems.add(newOrderItem);
        CSVUtils.writeFile(PATH,orderItems);
    }

    @Override
    public void update(OrderItem newOrderItem) {
    List<OrderItem> orderItems = findAll();
    CSVUtils.writeFile(PATH,orderItems);
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        List<OrderItem> orderItems = findAll();
        for (OrderItem orderItem : orderItems){
            if (orderItem.getOrderId()== id)
                return orderItem;
        }
        return null;
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        List<OrderItem> orderItems = findAll();
        List<OrderItem> orderItemFind = new ArrayList<>();
        for (OrderItem orderItem : orderItems){
            orderItemFind.add(orderItem);
        }
        return orderItemFind;
    }
}
