
package com.krishagni.catissueplus.rest.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.krishagni.catissueplus.core.auth.events.LoginDetail;
import com.krishagni.catissueplus.core.auth.services.UserAuthenticationService;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

import edu.wustl.catissuecore.util.global.Constants;
import edu.wustl.common.beans.SessionDataBean;

@Controller
@RequestMapping("/sessions")
public class AuthenticationController {
	
	@Autowired
	private UserAuthenticationService userAuthService;

	@Autowired
	private HttpServletRequest httpReq;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> authenticate(@RequestBody LoginDetail loginDetail) {
		loginDetail.setIpAddress(httpReq.getRemoteAddr());
		RequestEvent<LoginDetail> req = new RequestEvent<LoginDetail>(getSession(), loginDetail);
		ResponseEvent<Map<String, Object>> resp = userAuthService.authenticateUser(req);
		resp.throwErrorIfUnsuccessful();

		return resp.getPayload();
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, String> delete(HttpServletResponse httpResp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		RequestEvent<String> req = new RequestEvent<String>(getSession(), (String)auth.getCredentials());
		
		ResponseEvent<String> resp = userAuthService.removeToken(req);
		resp.throwErrorIfUnsuccessful();

		return Collections.singletonMap("Status", resp.getPayload());
	}

	private SessionDataBean getSession() {
		return (SessionDataBean) httpReq.getSession().getAttribute(Constants.SESSION_DATA);
	}
	
}
