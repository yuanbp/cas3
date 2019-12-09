<%@page import="org.jasig.cas.CasVersion"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      </div> 
      <!-- END #content -->
      <footer>
        <div id="copyright">
          <p><spring:message code="copyright" /></p>
          <p>Powered by <a href="#">Jasig Central Authentication Service <%=CasVersion.getVersion()%></a></p>
        </div>
      </footer>
    </div> 
    <!-- END #container -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
    <script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script>
<%-- add by jfwu Begin --%>  
<script type="text/javascript">  
    /*function showErrorMsg(){  
        if($('#cas_serverFrame', window.parent.document)){  
        //if(window.parent.window.document.getElementById('cas_serverFrame')){  
            var statusEl = document.getElementById('status');  
            if(statusEl && statusEl.className === 'errors'){  
                window.parent.window.alert('账号或密码有误！');  
            }
        }  
    }  
    if(top.location !== self.location){  
        showErrorMsg();  
    } */
</script>  
<%-- add by jfwu End --%>  
  </body>
</html>

