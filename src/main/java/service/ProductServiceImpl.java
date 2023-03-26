package service;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import vo.Product;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    ProductDAO dao;
    public ProductServiceImpl() {
        dao = new ProductDAOImpl();
    }

    @Override
    public ArrayList<Product> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Product selectOne(String code) {
        return dao.selectOne(code);
    }

    @Override
    public int insert(Product product) {
        return dao.insert(product);
    }

    @Override
    public int delete(String code) {
        return dao.delete(code);
    }
}
