package front;

import controller.CategoryController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class FrontController extends HttpServlet {
    private CategoryController ccon;

    public FrontController() {
        ccon = new CategoryController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        String reqString = request.getServletPath();


        if (reqString.equals("/locations")) {
//            pcon.read(request, response);
        } else if (reqString.equals("/category")) {
            ccon.categoryMain(request, response);
        }
        else if (reqString.equals("/category_details")) {
            ccon.categoryDetails(request, response);
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
