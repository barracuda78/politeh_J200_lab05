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
    private Attribute attribute;

    @EJB
    private SelectBean selectBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int k = selectBean.count();
        List<Parameters> lp = selectBean.findAll();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style01.css\"/>");
            out.println("<title>Servlet ViewList</title>");            
            out.println("</head>");
            out.println("<body>");
                //===========================================================================================
                out.println("<div style=\"height:40px; border: 1px orangered solid; margin-top: 3px\">");
                    out.println("<div style=\"float:left; border: 1px white outset; background-color: #333333; text-align: center; height:30px; width: 180px; margin: 3px\">");
                        out.println("<a href=\"Registrator\">Новый параметр</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; background-color: #333333; text-align: center; height:30px; width: 180px; margin: 3px\">");
                        out.println("<a href=\"ViewList?action=findAll\">Показать все</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; background-color: #333333; text-align: center; height:30px; width: 180px; margin: 3px\">");
                        out.println("<a href=\"ViewList?action=findByName\">Поиск по шаблону</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; background-color: #333333; text-align: center; height:30px; width: 180px; margin: 3px\">");
                        out.println("<a href=\"ViewList?action=findByRange\">Поиск по диапазону</a>");
                    out.println("</div>");
                out.println("</div>");
            //===========================================================================================  
            out.println("<h1>Servlet ViewList</h1>");
            out.println("<p1>Количество записей =  " + k + "</p1>");
            
            out.println("<br/>");
            out.println("<p1>Список параметров:</p1><ul>");
             for(Parameters p : lp){
                 out.println(p.toHtmlString());
             }
            out.println("</ul>");
            out.println("<br/>");
            
            if(request.getParameter("action").equals("findByRange")){
                List<Parameters> list = attribute.getList();
            //нажата кнопка findByRange - получить по диапазону значения из бaзы
            try{
                int from = Integer.parseInt(request.getParameter("from"));
                int to = Integer.parseInt(request.getParameter("to"));
                String byRange = selectBean.findByRange(from, to);
                out.println("<p1>Список <strong>всех</strong> параметров:</p1>" + byRange);
            }catch(NumberFormatException e){
                String byRange = selectBean.findByRange(0, list.size()-1);
                out.println("<p1>Список <strong>всех</strong> параметров:</p1>" + byRange);
            }
            
        }
            
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
