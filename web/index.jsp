<%-- 
    Document   : index
    Created on : Apr 1, 2021, 6:38:30 PM
    Author     : ENVY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parameter info</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <hr>
        <form action="Registrator" method="GET">
        <table border="1">
            
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Введите имя параметра</td>
                    <td><input type="text" name="name" value=""/></td>

                </tr>
                <tr>
                    <td>Введите значение параметра</td>
                    <td><input type="text" name="num" value=""/></td>

                </tr>
                                <tr>
                    <td>Введите значение параметра</td>
                    <td colspan="2"><input type="submit" name="new" value="Отправить"/></td>

                </tr>
            </tbody>
        </table>
            </form>

    </body>
</html>
