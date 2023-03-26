package controller;

import service.CategoryService;
import service.CategoryServiceImpl;
import vo.AttractionInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryController {
    CategoryService cservice;

    public CategoryController() {
        cservice = new CategoryServiceImpl();
    }

    public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryNum = request.getParameter("categoryNum"); // 드랍다운 입력값 확인하고 수정할 것.
        ArrayList<AttractionInfo> list = cservice.selectCategory(categoryNum);
        request.setAttribute("clist", list);
        //home.jsp 에 c:include 를 사용하여 F02-03.jsp 를 넣고 갱신하며 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); // home 화면 경로 입력할 것.
        dispatcher.forward(request, response);
    }

    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("home");
        String zero = request.getParameter("0");
        String twoelv = request.getParameter("12");
        System.out.println(zero);
        System.out.println(twoelv);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
