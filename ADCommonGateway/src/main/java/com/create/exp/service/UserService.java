package com.create.exp.service;

import java.util.List;

public interface UserService {

	public List getAllProfile()throws Exception;
	public List getProfileByFirstName(String firstName)throws Exception;
}
