package front;

import sample.controller.ProductController;
import sample.controller.UserController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {
    ProductController pcon;
    UserController ucon;
    public FrontController() {
        pcon = new ProductController();
        ucon = new UserController();
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reqString = request.getServletPath();
        if (reqString.equals("/list")) {
            pcon.list(request, response);
        } else if (reqString.equals("/read")) {
            pcon.read(request, response);
        } else if (reqString.equals("/registForm")) {
            pcon.registForm(request, response);
        } else if (reqString.equals("/regist")) {
            pcon.regist(request, response);
        } else if (reqString.equals("/delete")) {
            pcon.delete(request, response);
        } else if (reqString.equals("/loginForm")) {
            ucon.loginForm(request, response);
        } else if (reqString.equals("/loginProcess")) {
            ucon.loginProcess(request, response);
        } else if (reqString.equals("/logout")) {
            ucon.logout(request, response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            process(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
