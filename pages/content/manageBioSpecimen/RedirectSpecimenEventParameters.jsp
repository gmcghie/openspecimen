<%@ page import="edu.wustl.catissuecore.util.global.Constants"%>

<logic:present name="statusMessageKey">
	<%
		Long eventId = (Long)request.getAttribute(Constants.SYSTEM_IDENTIFIER);
		
		System.out.println("EventID on RedirectEventParameters.jsp===>"+eventId);

		if(eventId == null)
			eventId=new Long(request.getParameter(Constants.SYSTEM_IDENTIFIER));

		String parentUrl = "top.window.location.href='ListSpecimenEventParameters.do?pageOf=pageOfListSpecimenEventParameters&eventId="+eventId.toString()+"'";
	%>

	<body onload="<%=parentUrl%>" />
</logic:present>