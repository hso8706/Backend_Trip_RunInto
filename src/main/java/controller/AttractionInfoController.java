package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.AttractionInfoService;
import service.AttractionInfoServiceImpl;
import vo.AttractionInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttractionInfoController {
    AttractionInfoService service;
    public AttractionInfoController() {
        service = new AttractionInfoServiceImpl();
    }

    public void list(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<AttractionInfo> list = service.selectAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locations/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSido(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        ArrayList<String> sidos = service.selectSido();
        response.setContentType("application/json;charset=utf-8");
        System.out.println(sidos);
        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(sidos);
        response.getWriter().write(res);
        System.out.println(response);
    }
    public void getGugun(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String sidoName = request.getParameter("sidoName");
//        sidoName = URLEncoder.encode(sidoName, "UTF-8");
        System.out.println("param 해석 " + sidoName);
        ArrayList<String> guguns = service.selectGugun(sidoName);

        response.setContentType("application/json;charset=utf-8");
        System.out.println(guguns);
        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(guguns);
        response.getWriter().write(res);
        System.out.println(response);
    }


    public void locationSelectForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/locations/locationSelect.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void locationResult(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String sidoName = request.getParameter("sidoName");
        String gugunName = request.getParameter("gugunName");
        String keyword = request.getParameter("keyword");
        System.out.println(sidoName + " " + gugunName + " " + keyword);
        ArrayList<AttractionInfo> attractionInfos = service.search(sidoName, gugunName, keyword);
//        request.setAttribute("infos", attractionInfos);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(attractionInfos);
        response.getWriter().write(res);
    }

    public void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
