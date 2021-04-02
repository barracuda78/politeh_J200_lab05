package lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewList", urlPatterns = {"/ViewList"})
public class ViewList extends HttpServlet {

    @EJB
    private SelectBean selectBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int k = selectBean.count();
        List<Parameters> lp = selectBean.findAll();
        
        if(request.getParameter("action").equals("findByRange")){
            //нажата кнопка findByRange - получить по диапазону значения из бызы
        }
        
        String byRange = selectBean.findByRange(50, 100);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewList , numbers of records =  " + k + "</h1>");
            out.println("<h1>Список параметров</h1><ul>");
             for(Parameters p : lp){
                 out.println(p.toHtmlString());
             }
            out.println("</ul>");
            
            out.println("<h1>Список параметров в диапазоне 50-100</h1>" + byRange);
            
            out.println("<h1>Servlet ViewList , numbers of records =  " + k + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
