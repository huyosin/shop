package com.mono.core.shiro;

import java.util.List;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mono.core.entity.Operation;
import com.mono.core.entity.User;
import com.mono.core.service.OperationService;
import com.mono.core.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {
	private final static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "operationService")
	private OperationService operationService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Operation> operations = operationService.getOperationByLoginName(user.getLoginName());
			for(Operation operation : operations){
				info.addStringPermission(operation.getUrl());
			}
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authcToken = (UsernamePasswordToken)token;
		String loginName = authcToken.getUsername();
		logger.debug("ShiroDbRealm Authentication-loginName:"+loginName);
		User user = userService.getUserByLoginName(loginName);
		if(user != null){
			if(user.enabled()){
				SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
					loginName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), this.getName());
				Session session = SecurityUtils.getSubject().getSession();
				session.setAttribute("user", user);
				session.setAttribute("userId", user.getId());
				return authenticationInfo;
			}else{
				logger.debug(loginName+"账号未启用！");
				throw new DisabledAccountException("账号未启用！");
			}
		}else{
			logger.debug(loginName+"账号不存在！");
			throw new UnknownAccountException("账号不存在！");
		}
	}

}
