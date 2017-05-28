package com.mono.core.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class ShiroCacheManager implements CacheManager {
	private org.springframework.cache.CacheManager cacheManager;

	public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new ShiroCache<K,V>(cacheManager.getCache(name));
	}

}
