package com.cas.authentication.handler;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jasig.cas.authentication.UsernamePasswordCredential;

public class UsernamePasswordCredentialWithAuthCode extends UsernamePasswordCredential {
	private static final long serialVersionUID = -864735145551932618L;
    /** 验证码*/  
    @NotNull  
    @Size(min = 1, message = "required.authcode")  
    private String authcode;  
    /** 
     *  
     * @return 
     */  
    public final String getAuthcode() {  
        return authcode;  
    }  
  
    /** 
     *  
     * @param authcode 
     */  
    public final void setAuthcode(String authcode) {  
        this.authcode = authcode;  
    }  
  
    @Override  
    public boolean equals(final Object o) {  
        if (this == o) {  
            return true;  
        }  
        if (o == null || getClass() != o.getClass()) {  
            return false;  
        }  
  
        final UsernamePasswordCredentialWithAuthCode that = (UsernamePasswordCredentialWithAuthCode) o;  
  
        if (getPassword() != null ? !getPassword().equals(that.getPassword())  
                : that.getPassword() != null) {  
            return false;  
        }  
  
        if (getPassword() != null ? !getPassword().equals(that.getPassword())  : that.getPassword() != null) {  
            return false;  
        }  
        if (authcode != null ? !authcode.equals(that.authcode)  
                : that.authcode != null)  
            return false;  
  
        return true;  
    }  
  
    @Override  
    public int hashCode() {  
        return new HashCodeBuilder().append(getUsername()).append(getPassword()).append(authcode).toHashCode();  
    }  
}
