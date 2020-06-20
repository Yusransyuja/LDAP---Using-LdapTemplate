package com.create.exp.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.create.exp.message.Profile;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private LdapTemplate ldapTemplate;
		
	public List getAllProfile()throws Exception{
		List dataList = new ArrayList();
		try{
	        SearchControls searchControl = new SearchControls();
	        searchControl.setSearchScope(SearchControls.SUBTREE_SCOPE);
	        searchControl.setTimeLimit(3000);
	        searchControl.setCountLimit(10);

	        AndFilter filter = new AndFilter();
	        filter.and(new EqualsFilter("objectclass", "person"));
	        
			dataList = ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), new ProfileAttributesMapper());

		}catch (Exception e) {
			logger.error("Exception", e);
			throw e;
		}
		
		return dataList;
	}
	
	public List getProfileByFirstName(String firstName)throws Exception{
		List dataList = new ArrayList();
		try{
	        SearchControls searchControl = new SearchControls();
	        searchControl.setSearchScope(SearchControls.SUBTREE_SCOPE);
	        searchControl.setTimeLimit(3000);
	        searchControl.setReturningAttributes(new String[]{"cn"});

	        AndFilter filter = new AndFilter();
	        filter.and(new EqualsFilter("objectclass", "person"));
	        filter.and(new EqualsFilter("sn", firstName));
	        
			dataList = ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), new ProfileAttributesMapper());

		}catch (Exception e) {
			logger.error("Exception", e);
			throw e;
		}
		
		return dataList;
	}
	
   private class ProfileAttributesMapper implements AttributesMapper<Profile> {
        public Profile mapFromAttributes(Attributes attrs) throws NamingException {
        	Profile profile = new Profile();
        	profile.setFullName((String) attrs.get("cn").get());
        	profile.setLastName((String) attrs.get("sn").get());
            return profile;
        }
    }
}
