<%@ page import="edu.wustl.catissuecore.util.global.Constants"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> 
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<head>
    <script language="JavaScript">

    </script>
    <%
		//String operation = request.getAttribute("operation");
	%>
</head>

<html:errors />


<html:form action="<%=Constants.ADVANCED_SEARCH_RESULTS_ACTION%>">

<table summary="" cellpadding="0" cellspacing="0" border="0" class="contentPage" width="100%" height="100%">
    <tr width="100%">
        <td height="65%">
            <iframe name="searchPageFrame" id="searchPageFrame" src="ParticipantAdvanceSearch.do?pageOf=pageOfParticipantAdvanceSearch" width="100%" height="100%" frameborder="0" scrolling="auto">
            </iframe>
        </td>
    </tr>
    
    <tr width="100%">
        <td height="2%">
            &nbsp;
        </td>
    </tr>
    

    <tr width="100%">
        <td height="28%">
            <iframe name="queryFrame" id="queryFrame" src="AdvanceQueryView.do" width="100%" height="100%" frameborder="0" scrolling="auto">
            </iframe>
        </td>
    </tr>
        <tr width="100%">
            <td height="5%">
                <html:submit styleClass="actionButton" >
                    <bean:message  key="buttons.search" />
                </html:submit>
            </td>
        </tr>
</table>
</html:form>