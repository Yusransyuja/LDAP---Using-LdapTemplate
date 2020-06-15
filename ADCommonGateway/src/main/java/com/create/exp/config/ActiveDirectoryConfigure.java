package com.create.exp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config.ActiveDirectory")
public class ActiveDirectoryConfigure {

	private String hostDirectory, baseDirectory, username, password;

	public String getHostDirectory() {
		return hostDirectory;
	}

	public void setHostDirectory(String hostDirectory) {
		this.hostDirectory = hostDirectory;
	}

	public String getBaseDirectory() {
		return baseDirectory;
	}

	public void setBaseDirectory(String baseDirectory) {
		this.baseDirectory = baseDirectory;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
