package dao;

import sample.vo.Product;

import java.util.ArrayList;

public interface ProductDAO {
    ArrayList<Product> selectAll();
    Product selectOne(String code);

    int insert(Product product);

    int delete(String code);
}
