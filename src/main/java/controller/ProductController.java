package controller;

import service.ProductService;
import service.ProductServiceImpl;
import vo.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductController {
    ProductService service;
    public ProductController() {
        service = new ProductServiceImpl();
    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> list = service.selectAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read(HttpServletRequest request, HttpServletResponse response) {

    }
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product p = new Product();
        p.setCode(request.getParameter("code"));
        p.setPrice(request.getParameter("price"));
        p.setModel(request.getParameter("model"));
        service.insert(p);
        response.sendRedirect("list");
    }

    public void registForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/regist.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        service.delete(code);
        response.sendRedirect("list");
    }
}
