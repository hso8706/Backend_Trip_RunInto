package front;

import controller.CategoryController;
import controller.ProductController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {
    ProductController pcon;
    CategoryController ccon;

    public FrontController() {
        pcon = new ProductController();
        ccon = new CategoryController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        String reqString = request.getServletPath();
//대충 위치는 찾았으니 내부 구현부터 해놓고 나중에 해결하자
        System.out.println("home1: " + request.getParameter("temp"));
        System.out.println(reqString);
        if (reqString.equals("/")) {
//            System.out.println("home: " + request.getParameter("temp"));
        } else if (reqString.equals("/locations")) {
            pcon.read(request, response);
        } else if (reqString.equals("/category")) {
            ccon.read(request, response);
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
