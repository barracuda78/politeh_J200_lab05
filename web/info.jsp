<%-- 
    Document   : info
    Created on : Apr 1, 2021, 6:39:29 PM
    Author     : ENVY
--%>

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
        try{
            int from = Integer.parseInt(request.getParameter("from"));
            int to = Integer.parseInt(request.getParameter("to"));
        }catch(NumberFormatException e){
            
        }
        
        if("menuFindByRange".equals(menuItem) && request.getParameter("from") == null && request.getParameter("to") == null){
            //отрисовать кнопку получить по диапазону и поля ввода начала и конца диапазона.
            //и передать это обратно в ViewList
        %>
        
        <div style="float:center; height:40px; border: 1px orangered solid; margin-top: 3px; border-radius: 10px; margin-left: 3px;">
            <div style="float:center; border: 1px white outset; border-radius: 7px; background-color: #333333; text-align: center; height:30px; width: 540px; margin-left: 30%">
                <form action="ViewList" method="GET"> 
                    <input type="text" name="from" value="" placeholder="type from value..." class="t1"/>
                    <a href="ViewList?action=findByRange">Поиск по диапазону</a>
                    <input type="text" name="to" value="" placeholder="type to value..." class="t1"/>
                </form>
            </div>
        </div>
        
        <%    
        }
        %>
    </body>
</html>
