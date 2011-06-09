<%-- 
    Document   : projectnavi
    Created on : 09.06.2011, 21:07:47
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a class="buttoncontent" href="JProjectServlet?do=ShowProject&projectName=${sessionScope.aktProject}">Project</a>
<a class="buttoncontent" href="JProjectServlet?do=ShowAllSource&projectName=${sessionScope.aktProject}">Sourcecode</a>
<a class="buttoncontent" href="JProjectServlet?do=ShowAllDocu&projectName=${sessionScope.aktProject}">Documents</a>
<a class="buttoncontent" href="JProjectServlet?do=ShowAllTasks&projectName=${sessionScope.aktProject}">Tasks</a>
