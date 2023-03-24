package dao;

import sample.util.DBUtil;
import sample.vo.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    private DBUtil util;
    public ProductDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select code, model, price from product";
            ResultSet rs = stat.executeQuery(q);
            while (rs.next()) {
                String code = rs.getString(1);
                String model = rs.getString(2);
                String price = rs.getString(3);
                Product p = new Product(code, model, price);
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product selectOne(String code) {
        Product p = null;
        try {
            Connection con = util.getConnection();
            String q = "select code, model, price from product where code = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, code);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                String model = rs.getString(2);
                String price = rs.getString(3);
                p = new Product(code, model, price);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public int insert(Product product) {
        int result = 0;
        try {
            Connection con = util.getConnection();
            String q = "insert into product (code, model, price) values (?,?,?)";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, product.getCode());
            stat.setString(2, product.getModel());
            stat.setString(3, product.getPrice());
            result = stat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int delete(String code) {
        int result = 0;
        try {
            Connection con = util.getConnection();
            String q = "delete from product where code = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, code);
            result = stat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
