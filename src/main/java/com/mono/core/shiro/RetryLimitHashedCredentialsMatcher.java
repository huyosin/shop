package com.mono.core.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher implements InitializingBean {
	private final static Logger logger = LoggerFactory.getLogger(RetryLimitHashedCredentialsMatcher.class);
	
	private final static String DEFAULT_CHACHE_NAME = "retryLimitCache";
	private Cache<String, AtomicInteger> passwordRetryCache;
	private final CacheManager cacheManager;
	private String passwordRetryCacheName;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.passwordRetryCacheName = DEFAULT_CHACHE_NAME;
	}

	public String getPasswordRetryCacheName() {
		return passwordRetryCacheName;
	}

	public void setPasswordRetryCacheName(String passwordRetryCacheName) {
		this.passwordRetryCacheName = passwordRetryCacheName;
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		String loginName = authcToken.getUsername();
		AtomicInteger retryCount = this.passwordRetryCache.get(loginName);
		if (retryCount == null) {
			retryCount = new AtomicInteger(1);
			this.passwordRetryCache.put(loginName, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			logger.warn("loginName: " + loginName + " tried to login more than 5 times in period");
			throw new ExcessiveAttemptsException("登录名: " + loginName + " 密码连续输入错误超过5次，锁定半小时！");
		}
		boolean matches = super.doCredentialsMatch(authcToken, info);
		if(matches){
			passwordRetryCache.remove(loginName);
		}
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.passwordRetryCache = this.cacheManager.getCache(passwordRetryCacheName);
	}
}
