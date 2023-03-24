package service;

import sample.vo.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> selectAll();
    Product selectOne(String code);

    int insert(Product product);

    int delete(String code);
}
