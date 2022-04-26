<%-- 
    Document   : error
    Created on : Apr 26, 2022, 11:57:19 AM
    Author     : costiss
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"
              href="resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="styles/globals.css" />
        <link rel="stylesheet" href="styles/index.css" />
        <link href="http://fonts.cdnfonts.com/css/helvetica-255"
              rel="stylesheet">
        <script src="resources/jquery-3.5.0.min.js"></script>
        <script
        src="resources/jQuery-Mask-Plugin-master/dist/jquery.mask.min.js"></script>
        <script src="resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
        <meta charset="UTF-8">
        <title>Error</title>
    </head>
    <body>

        <h1> <c:out value="${error}" /> </h1>
        <h2> <c:out value="${javaerror}" /> </h1>
    </body>
</html>
