

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parameter info</title>
        <!--link rel="stylesheet" type="text/css" href="styles.css"-->
        <link rel="stylesheet" type="text/css" href="css/style01.css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        
        <form action="Registrator" method="GET">
        <div class="container">
        <div class="box-1">    
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
                    <td><input type="text" name="name" value="" placeholder="type name here..." class="t1"/></td>

                </tr>
                <tr>
                    <td>Введите значение параметра</td>
                    <td><input type="text" name="num" value="" placeholder="type int here..." class="t1"/></td>

                </tr>
                                <tr>
                    <td>Введите значение параметра</td>
                    <td colspan="2"><input type="submit" name="new" value="Отправить" class="b1"/></td>

                </tr>
            </tbody>
        </table>
        </div>
        </div>    
            </form>

    </body>
</html>
