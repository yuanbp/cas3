package com.cas.authentication.handler;

import com.cas.authentication.common.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.adaptors.jdbc.AbstractJdbcUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.validation.constraints.NotNull;
import java.security.GeneralSecurityException;
import java.util.Map;

public class JdbcUsernamePasswordAuthenticationHandler extends AbstractJdbcUsernamePasswordAuthenticationHandler {

	@NotNull
	private String sql;

	@Override
	protected final HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential)throws GeneralSecurityException, PreventedException {
		String username = credential.getUsername();
		getPasswordEncoder().encode(credential.getPassword());
		try {
			Map<String, Object> map = getJdbcTemplate().queryForMap(this.sql, new Object[] {username});
			if(StringUtils.equals(map.get("LOGIN_FLAG")+"", "0"))
				throw new AccountNotFoundException("用户已经被禁用，请联系管理员！");
			if (!EncryptUtil.validatePassword(credential.getPassword(),map.get("PASSWORD")+""))
				throw new FailedLoginException("Password does not match value on record.");
		} catch (IncorrectResultSizeDataAccessException e) {
			if (e.getActualSize() == 0) {
				throw new AccountNotFoundException(username + " not found with SQL query");
			}
			throw new FailedLoginException("Multiple records found for " + username);
		} catch (DataAccessException e) {
			throw new PreventedException("SQL exception while executing query for " + username, e);
		}
		return createHandlerResult(credential, new SimplePrincipal(username),null);
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
