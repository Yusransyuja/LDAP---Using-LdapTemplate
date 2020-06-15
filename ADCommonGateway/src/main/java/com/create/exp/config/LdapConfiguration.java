package com.create.exp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {

	@Autowired
	private ActiveDirectoryConfigure activeDirectoryConfigure;
	
	@Bean
	public LdapContextSource contextSource() {
		LdapContextSource source = new LdapContextSource();
			source.setUrl(activeDirectoryConfigure.getHostDirectory());
			source.setBase(activeDirectoryConfigure.getBaseDirectory());
			source.setUserDn(activeDirectoryConfigure.getUsername());
			source.setPassword(activeDirectoryConfigure.getPassword());
		 
			return source;
	}

	@Bean
	public LdapTemplate ldapTemplate() {
		LdapTemplate customTemplate = new LdapTemplate(contextSource());
		return customTemplate;
	}
	
}
