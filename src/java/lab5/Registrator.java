package lab5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Registrator", urlPatterns = {"/Registrator"})
public class Registrator extends HttpServlet implements HtmlRenderable{

    @EJB
    private Attribute attribute;

    @EJB
    private UpdateBean updateBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            printHtmlHeader(out);
            printHtmlHeaderFull(out);
            //request.getRequestDispatcher("WEB-INF/jspf/menu.jspf").include(request, response); //----> кодировка шалит
            
            out.println("<h1><center>Servlet Registrator: </center></h1>");
            String name = request.getParameter("name");
            
            if(name == null ){
                 out.println("<p1><center>Вы не задали имя параметра.</center></p1>");
                 //printHtmlFooter(out);
            }
            
            name = name.trim();
            
            if(name != null &&  name.isEmpty()){
                 out.println("<p1><center>Имя параметра не соответствует требованиям.</center></p1>");
                 //printHtmlFooter(out);
            }
            else if( name != null && (name.length() > 255 || name.isEmpty())){
                out.println("<p1><center>Имя параметра пустое или превышает длину 255 символa.</center></p1>");
                printHtmlFooter(out);
            }
            
            Parameters p = null;
            int num;
            try{
                num = Integer.parseInt(request.getParameter("num"));
                p = new Parameters(name, num); 
                int answerId = updateBean.addParameter(p);
                attribute.addToList(p);
                if(answerId == 1){
                    out.println("<p1><center>Parameter has been <strong>added</strong> to DB \"test5\" :</center></p1>");
                    out.println("<p1><center><ul></center></p1>");
                    out.println("<p1><center><li>" + name + " - " + num + "</li></center></p1>");
                    out.println("<p1><center></ul></center></p1>");
                }
                else if(answerId == 2){
                    out.println("<p1><center>Parameter has been <strong>changed</strong> in DB \"test5\" :</center></p1>");
                    out.println("<p1><center><ul></center></p1>");
                    out.println("<p1><center><li>" + name + " - " + num + "</li></center></p1>");
                    out.println("<p1><center></ul></center></p1>");
                }
                else if(answerId == 3){
                    out.println("<p1><center>Имя параметра не соответствует требованиям.</center></p1>");
                }
            }catch(NumberFormatException e){
                out.println("<p1><center>Значение параметра не может быть корректно преобразовано к типу int.</center></p1>");
            }
            
            printHtmlFooter(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            printHtmlHeader(out);
            out.println("<h1><center>Servlet Registrator: </center></h1>");
            if(request.getParameter("deleteAll") != null){
                //удалить все из БД с помощью бина:
                updateBean.deleteAll();
                out.println("<p><center>Все параметры были удалены из базы данных.</center></p>");
                printHtmlFooter(out);
            }
            
            if(request.getParameter("deleteOne") != null){
                String name = request.getParameter("parameterName");
                if(updateBean.deleteOne(name)){
                    out.println("<p><center>Параметр с именем " + name + " был удален из базы данных.</center></p>");
                }
                else{
                    out.println("<p><center>Не удалось удалить параметр с именем " + name + " из базы данных.</center></p>");
                    out.println("<p><center>Возможно, параметра с таким именем нет в базе.</center></p>");
                }
                printHtmlFooter(out);
            }
            
            if(request.getParameter("deleteRegex") != null){
                String regex = request.getParameter("parameterRegex");
                if(updateBean.deleteRegex(regex)){
                    out.println("<p><center>Параметры с именами, соответствующими заданному регулярному выражению, были удалены из базы данных.</center></p>");
                }
                else{
                    out.println("<p><center>Ни один параметр не был удален. Возможно, не было найдено соответствий.</center></p>");
                }
                printHtmlFooter(out);
            }
            
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
