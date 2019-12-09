package com.cas.authentication.handler;

import org.jasig.cas.authentication.handler.PasswordEncoder;

import com.cas.authentication.common.EncryptUtil;

public class AuthPasswordEncoder implements PasswordEncoder{

	public String encode(final String password) {
		String pwd = "";
		try {
			pwd = EncryptUtil.entryptPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}

}
