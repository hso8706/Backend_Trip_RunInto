package controller;

import sample.model.service.UserService;
import sample.model.service.UserServiceImpl;
import sample.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController {
    UserService service;
    HttpSession session = null;
    public UserController() {
        service = new UserServiceImpl();
    }
    public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/loginForm.jsp");
        dispatcher.forward(request, response);
    }
    public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        User user = new User();
        user.setId(id);
        user.setPw(pass);

        boolean flag = service.check(user);
        String url = "";

        System.out.println(flag);
        if (flag) {
            session = request.getSession();
            session.setAttribute("user", user);
            url = "list";
            if (remember != null) {
                Cookie remem = new Cookie("remem", id);
                remem.setMaxAge(-1);
                response.addCookie(remem);
            } else {
                Cookie cookie = new Cookie("remem", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        } else {
            request.setAttribute("msg", "로그인 정보가 틀렸습니다");
            url = "loginForm";
        }
        response.sendRedirect(url);

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("list");
    }
}
