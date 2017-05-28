package com.mono.core.shiro;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.mono.core.entity.Operation;
import com.mono.core.entity.Permission;
import com.mono.core.entity.Role;
import com.mono.core.entity.User;
import com.mono.core.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {
	@Resource(name = "userService")
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for(Role role : user.getRoles()){
				for(Permission permission : role.getPermissions()){
					for(Operation operation : permission.getOperations()){
						info.addStringPermission(operation.getUrl());
					}
				}
			}
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authcToken = (UsernamePasswordToken)token;
		String loginName = authcToken.getUsername();
		User user = userService.getUserByLoginname(loginName);
		if(user != null){
			if(!"0".equals(user.getStatus())){
				throw new DisabledAccountException();
			}
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				loginName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", user);
			session.setAttribute("userId", user.getId());
			return authenticationInfo;
		}else{
			throw new UnknownAccountException();
		}
	}

}
