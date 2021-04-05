package lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewList", urlPatterns = {"/ViewList"})
public class ViewList extends HttpServlet implements HtmlRenderable{

    @EJB
    private Attribute attribute;

    @EJB
    private SelectBean selectBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            int k = selectBean.count();
            List<Parameters> lp = selectBean.findAll();
            List<Parameters> list = attribute.getList();

            //если заданы параметры from и to, то пытаемся их прочитать:
            if (request.getParameter("rangeButton") != null && request.getParameter("to") != null) {
                try {
                    int from = Integer.parseInt(request.getParameter("from"));
                    int to = Integer.parseInt(request.getParameter("to"));
                    //если параметры в пределах размеров списка:
                    if (null != lp && from <= to) {
                        
                        List<Parameters> trimmedList = new ArrayList<>();
                        for(Parameters p : lp){
                            if(p.getNum() >= from && p.getNum() <= to)
                                trimmedList.add(p);
                        }

                        request.setAttribute("trimmedList", trimmedList);
                        request.getRequestDispatcher("info.jsp").forward(request, response);
                        System.out.println("мы побывали тут ViewList: null != lp");
                    }else{
                        out.println("<p>вы указали параметры некорректно<p>");
                        System.out.println("lp = " + lp);
                    }
                    
                } catch (NumberFormatException e) {
                    printHtmlHeader(out);
                    printHtmlHeaderWithoutFindByRange(out); 
                    out.println("<p1>Введенные значения не могут быть преобразованы к числам.</p1>");
                    out.println("<br/>");
                    out.println("<br/>");
                    out.println("<p1><a href=\"info.jsp\"/>Назад к вводу значений from и to</a></p1>");
                    printHtmlEnd(out);
                    return;
                }
            }
            
            //если задан параметр regex для findByName, то пытаемся его прочитать:
            if (request.getParameter("regexButton") != null && request.getParameter("regex") != null) {

                    String regexString = request.getParameter("regex");
                    //если параметры соответствуют регулярке:
                    if (null != lp && regexString.length() > 0) {
                        
                        List<Parameters> trimmedList2 = new ArrayList<>();
                        for(Parameters p : lp){
                            if(p.getName().matches(regexString))    
                                trimmedList2.add(p);
                        }
                        System.out.println("Это сервлет ViewList и список trimmedList2 = " + trimmedList2);
                        request.setAttribute("trimmedList2", trimmedList2);
                        request.getRequestDispatcher("info.jsp").forward(request, response);
                        System.out.println("мы побывали тут ViewList: regex and null != lp");
                    }else{
                        out.println("<p>Указано некорректное регулярное выражение для поиска.<p>");
                        System.out.println("lp = " + lp);
                    }
            }

            printHtmlHeader(out);
            //===========================================================================================
            printHtmlHeaderFull(out);   
            //===========================================================================================  
            out.println("<h1><center>Servlet ViewList</center></h1>");
            

            if (request.getParameter("action") != null && request.getParameter("action").equals("findByRange") && request.getParameter("from") == null && request.getParameter("to") == null) {
                System.out.println("мы побывали тут ViewList: request.getParameter(\"from\") == null");
                //нажата кнопка findByRange - получить по диапазону значения из бaзы
                //отправить на index.jsp -> кнопку для диапазона и два поля ограничителей диапазона.
                request.setAttribute("menuItem", "menuFindByRange");
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }
            
            if (request.getParameter("action") != null && request.getParameter("action").equals("findByName") && request.getParameter("regex") == null) {
                System.out.println("мы побывали тут ViewList: action = findByName and request.getParameter(\"regex\") == null");
                //нажата кнопка findByName - получить по регулярке значения из бaзы
                //отправить на index.jsp -> кнопку для диапазона и поле регулярки.
                request.setAttribute("menuItem2", "menuFindByName");
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }

            out.println("<div style=\"float:center; margin-top: 3px; border-radius: 10px; margin-left: 30px;\"");
                out.println("<p1>Количество записей =  " + k + "</p1>");

                out.println("<br/>");
                out.println("<p1>Список параметров:</p1><ul>");
                for (Parameters p : lp) {
                    out.println(p.toHtmlString());
                }
                out.println("</ul>");
                out.println("<br/>");
            out.println("<div");
            
            printHtmlFooter(out);
            printHtmlEnd(out);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
