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
public class Registrator extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style01.css\"/>");
            out.println("<title>Servlet Registrator</title>");            
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
            out.println("<h1><center>Servlet Registrator: </center></h1>");
            String name = request.getParameter("name");
            
            if(name.length() > 255 || name.isEmpty()){
                out.println("<p1><center>Имя параметра пустое или превышает длину 255 символa.</center></p1>");
            }
            
            Parameters p = null;
            int num;
            try{
                num = Integer.parseInt(request.getParameter("num"));
                p = new Parameters(name, num); 
                int answerId = updateBean.addParameter(p);
                attribute.addToList(p);
                if(answerId == 1)
                out.println("<p1><center>Parameter has been <strong>added</strong> to DB \"test5\" :</center></p1>");
            else if(answerId == 2)
                out.println("<p1><center>Parameter has been <strong>changed</strong> in DB \"test5\" :</center></p1>");
            out.println("<p1><center><ul></center></p1>");
            out.println("<p1><center><li>" + name + " - " + num + "</li></center></p1>");
            out.println("<p1><center></ul></center></p1>");
            }catch(NumberFormatException e){
                out.println("<p1><center>Значение параметра не может быть корректно преобразовано к типу int.</center></p1>");
            }
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<p1><center><a href=\"index.jsp\">Перейти на страницу ввода данных</a></center></p1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    //    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        
//        //InitialContext ctx = (InitialContext)this.getServletContext();
//        
//        String name = request.getParameter("name");
//        int num = Integer.parseInt(request.getParameter("num"));
//        
//        
//        Parameters p = new Parameters(name, num); 
//        
//        updateBean.addParameter(p);
//                
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Registrator</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Registrator at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
}
