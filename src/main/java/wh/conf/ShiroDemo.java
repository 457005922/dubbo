package wh.conf;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import wh.user.domain.User;
import wh.user.service.UserService;
import wh.util.MD5Util;

public class ShiroDemo extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 String username = (String) principals.getPrimaryPrincipal(); //��ȡ�û���
	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//	        authorizationInfo.setRoles(userService.getRoles(username));
//	        authorizationInfo.setStringPermissions(userService.getPermissions(username));
	        authorizationInfo.setStringPermissions((Set<String>) userService.getName());
	        return authorizationInfo;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		    String username = (String) token.getPrincipal();
            User user = userService.getName();
	        String pow = MD5Util.getMD5(user.getName());
	        if(user != null) {
	            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getName(), pow, "myRealm");
	            return authcInfo;
	        } else {
	            return null;
	        }       
	}

}
