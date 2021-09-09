
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

   <!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
   <html>
   <head>
   <title>Welcome Login Form</title>
   </head>
   <body>
   <form action="custom.jsp" method="post">
   <table style="width: 50%">
   <tr>
   <td>User</td>
   <td><input type="text" name="users"/></td>
   </tr>
   <tr>
   <td>Pass</td>
   <td><input type="password" name="password"/></td>
   </tr>
   </table>
   <input type="submit" value="Login"/></form>
   </body>
   </html>

   <!DOCTYPEhtml PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
   <html>
   <body>
   <%
   String site = "Please Log In";
   out.print(site);
   %>
   </body>
   </html>