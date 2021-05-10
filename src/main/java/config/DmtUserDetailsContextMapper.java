package config;

import java.util.Collection;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class DmtUserDetailsContextMapper implements UserDetailsContextMapper {
	private static final String DOMAIN_NAME = "@scb.com.vn";
	private static final String DEFAULT_USER_TYPE = "OFF";

	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> arg2) {
		DmtLdapUserDetails userDetails = new DmtLdapUserDetails();
		String mail = ctx.getStringAttribute("mail");
		if (mail == null) {
			mail = username.toLowerCase() + DOMAIN_NAME;
		}
		final String fullname = ctx.getStringAttribute("displayName");
		final String sAMAccountName = ctx.getStringAttribute("sAMAccountName");

		userDetails.setUsername(sAMAccountName);
		userDetails.setFullname(fullname);

		return userDetails;
	}

	@Override
	public void mapUserToContext(UserDetails arg0, DirContextAdapter arg1) {
		// TODO Auto-generated method stub

	}


}
