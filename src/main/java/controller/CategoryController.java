package controller;

import service.CategoryService;
import service.CategoryServiceImpl;
import util.PageNavigation;
import vo.AttractionInfo;
import vo.ContentDescription;
import vo.Pagination;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryController {
    CategoryService cservice;

    public CategoryController() {
        cservice = new CategoryServiceImpl();
    }

    public void categoryMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content_type_id = request.getParameter("content_type_id");
        String pgno = request.getParameter("pgno");
//        if(pgno == null || pgno.equals("")) pgno = "1";
        String word = request.getParameter("word");
        ArrayList<AttractionInfo> list;

        Pagination pagination = new Pagination(pgno, word, content_type_id);


        //pagination
        if(content_type_id != null && !content_type_id.equals("0")) {
            if(word != null && word.length() != 0) word = URLEncoder.encode(word, "utf-8");
            PageNavigation pageNavigation = cservice.makePageNavigation(pagination);
            request.setAttribute("pageNavi", pageNavigation);
            list = cservice.searchCategory(pagination);
        }
        else list = cservice.selectCategory(content_type_id);
        request.setAttribute("clist", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/category.jsp"); // home 화면 경로 입력할 것.
        dispatcher.forward(request, response);
    }

    public void categoryDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content_id = request.getParameter("content_id");
        AttractionInfo content = cservice.selectOne(content_id);
        ContentDescription description = cservice.description(content_id);
        request.setAttribute("content", content);
        request.setAttribute("description", description);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/category_details.jsp");
        dispatcher.forward(request, response);
    }
}
