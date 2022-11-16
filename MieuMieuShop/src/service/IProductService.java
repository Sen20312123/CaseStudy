package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add (Product newProduct);

    void update(Product newProduct);

    void remove ( long id);

    Product getProductByID(int id);
    boolean exitsts(long id);

    Product findById( long id);

    void updateQuantity( long id , int quantity);
}
