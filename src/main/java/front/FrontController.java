package front;

import controller.CategoryController;
import controller.AttractionInfoController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {
    AttractionInfoController aicon;
    private CategoryController ccon;

    public FrontController() {
        aicon = new AttractionInfoController();
        ccon = new CategoryController();
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        String reqString = request.getServletPath();
        if (reqString.equals("/")) {
            aicon.home(request, response);
        } else if (reqString.equals("/locations")) {
            aicon.locationSelectForm(request, response);
//            aicon.locationSelect(request, response);
        } else if (reqString.equals("/sidos")) {
            aicon.getSido(request, response);
        } else if (reqString.equals("/guguns")) {
            System.out.println(reqString);
            System.out.println(request.getParameter("sidoName"));
            aicon.getGugun(request, response);
        } else if (reqString.equals("/locationsResult")) {
            aicon.locationResult(request, response);
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
