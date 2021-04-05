
package lab5;

import java.io.PrintWriter;


public interface HtmlRenderable {
    default public void printHtmlFooter(PrintWriter out){
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<p1><center><a href=\"index.jsp\">Перейти на страницу ввода данных</a></center></p1>");
            out.println("</body>");
            out.println("</html>");
    }
    
    default public void printHtmlHeader(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style01.css\"/>");
        out.println("<title>Servlet ViewList</title>");
        out.println("</head>");
        out.println("<body>");
    }

        default public void printHtmlEnd(PrintWriter out) {
        out.println("</body>");
        out.println("</html>");
    }

    default public void printHtmlHeaderWithoutFindByRange(PrintWriter out) {
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
//            out.println("<div style=\"float:left; border: 1px white outset; background-color: #333333; text-align: center; height:30px; width: 180px; margin: 3px\">");
//                out.println("<a href=\"ViewList?action=findByRange\">Поиск по диапазону</a>");
//            out.println("</div>");
        out.println("</div>");
    }
    
    default public void printHtmlHeaderFull(PrintWriter out){
            //===========================================================================================
                out.println("<div style=\"height:40px; border: 1px orangered solid; margin-top: 3px; border-radius: 10px; margin-left: 3px; padding-left: 20 px;\">");
                    out.println("<div style=\"float:left; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 300px; margin: 3px; padding-left: 20 px;\">");
                        out.println("<a href=\"Registrator\">Новый параметр</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 300px; margin: 3px; padding-left: 20 px;\">");
                        out.println("<a href=\"ViewList?action=findAll\">Показать все</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 300px; margin: 3px; padding-left: 20 px;\">");
                        out.println("<a href=\"ViewList?action=findByName\">Поиск по шаблону</a>");
                    out.println("</div>");
                    out.println("<div style=\"float:left; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 300px; margin: 3px; padding-left: 20 px;\">");
                        out.println("<a href=\"ViewList?action=findByRange\">Поиск по диапазону</a>");
                    out.println("</div>");
                out.println("</div>");
            //===========================================================================================    
    }
    

}
