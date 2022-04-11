<%@page contenteType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<body>
Il risultato dell'inserimento è:
<h1>Lista nazioni registrate</h1>
<table>
    <c:forEach items="${nazioni}" var="nazione">
    <tr><td>${nazione.nazione} - ${nazione.sigla}</td></tr>
</table>
</body>
</html>
