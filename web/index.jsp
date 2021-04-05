

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parameter info</title>
        <link rel="stylesheet" type="text/css" href="css/style01.css"/>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        
        <form action="Registrator" method="GET">
        <div class="container">
        <div class="box-1">    
        <table border="1">

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
        
        <!-- ФОРМА ДЛЯ КНОПКИ: DELETE -->
        <form action="Registrator" method="POST">
            <div class="container">
                <div class="box-1" style="width:100px;  height:100px; border:0 none; border-radius:50%;" >    
                    <td colspan="2"><input type="submit" name="deleteAll" value="DELETE ALL PARAMETERS FROM DB" class="b2"/></td>
                    <td><input type="text" name="parameterName" value="" placeholder="type name here..." class="t1"/></td>
                    <td colspan="2"><input type="submit" name="deleteOne" value="DELETE ONE PARAMETER by name" class="b2"/></td>
                    <td><input type="text" name="parameterRegex" value="" placeholder="type regex here..." class="t1"/></td>
                    <td colspan="2"><input type="submit" name="deleteRegex" value="DELETE PARAMETERS by regex" class="b2"/></td>
                </div>
            </div>    
        </form>
        <!-- КОНЕЦ ФОРМы ДЛЯ КНОПКИ: DELETE -->
    </body>
</html>
<!--

input[type="submit"]{
  display:inline-block;
  width:100px;
  height:100px;
  background:#333;
  color:#fff;
  border:0 none;
  border-radius:50%;
}
-->