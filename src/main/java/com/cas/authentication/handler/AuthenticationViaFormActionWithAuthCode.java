package com.cas.authentication.handler;

import com.cas.authentication.exception.BadAuthcodeAuthenticationException;
import com.cas.authentication.exception.NullAuthcodeAuthenticationException;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.RootCasException;
import org.jasig.cas.web.flow.AuthenticationViaFormAction;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
  
/**
* 项目名称：cas(V1.0)
* 类名称：AuthenticationViaFormActionWithAuthCode   
* 类描述：验证码校验
* 创建人：jfwu
* 创建时间：2016-10-18 下午5:04:21
* @version V1.0
 */
public class AuthenticationViaFormActionWithAuthCode extends AuthenticationViaFormAction {  
    public final String validatorCode(final RequestContext context,final Credential credentials, final MessageContext messageContext)throws Exception {  
        final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
        HttpSession session = request.getSession();
        String authcode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
        session.removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
        UsernamePasswordCredentialWithAuthCode upc = (UsernamePasswordCredentialWithAuthCode) credentials;  
        String submitAuthcode = upc.getAuthcode();  
        if (StringUtils.isEmpty(submitAuthcode)|| StringUtils.isEmpty(authcode)) {  
            populateErrorsInstance(new NullAuthcodeAuthenticationException(),messageContext);  
            return "error";  
        }
        if (submitAuthcode.equals(authcode)) {
            return "success";
        }
        populateErrorsInstance(new BadAuthcodeAuthenticationException(), messageContext);
        return "error";
    }  
  
    private void populateErrorsInstance(final RootCasException e, final MessageContext messageContext) {  
        try {  
            messageContext.addMessage(new MessageBuilder().error().code(e.getCode()).defaultText(e.getCode()).build());  
        } catch (final Exception fe) {  
            logger.error(fe.getMessage(), fe);  
        }  
    }  
}