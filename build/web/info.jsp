<%@page import="lab5.Parameters"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style01.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1><center>Info jsp</center></h1>
        <%
        String menuItem = (String)request.getAttribute("menuItem");
        List<Parameters> trimmedList = null;
        try{
            int from = Integer.parseInt(request.getParameter("from"));
            int to = Integer.parseInt(request.getParameter("to"));
        }catch(NumberFormatException e){
            
        }
        
        if("menuFindByRange".equals(menuItem) && request.getParameter("from") == null && request.getParameter("to") == null){
            //отрисовать кнопку получить по диапазону и поля ввода начала и конца диапазона.
            //и передать это обратно в ViewList
            System.out.println("info.jsp: menuItem = " + menuItem);
        %>
        
            <div style="float:left; height:40px; border: 1px orangered solid; margin-top: 3px; border-radius: 10px; margin-left: 3px;">
                <div style="float:left; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 540px; margin-left: 30%">
                    <form action="ViewList" method="GET"> 
                        <input type="text" name="from" value="" placeholder="type from value..." class="t1"/>
                        <!--a href="ViewList?action=findByRange">Поиск по диапазону</a-->
                        <input type="submit" name="rangeButton" value="Поиск по диапазону" class="b1"/>
                        <input type="text" name="to" value="" placeholder="type to value..." class="t1"/>
                    </form>
                </div>
            </div>
        
        <%    
            
        }
        
        if((trimmedList = (List<Parameters>)request.getAttribute("trimmedList")) != null){
        
            %>
            <p>Список параметров в диапазоне:</p>
            <ul>
            
            <%
                for(Parameters p : trimmedList){
                    %>
                    <%=p.toHtmlString()%>
                    <%
                }
                System.out.println("\"trimmedList\")) != null ");
        }
        %>
        </ul>
    </body>
</html>
