package com.mono.core.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.cache.support.SimpleValueWrapper;

import net.sf.ehcache.Ehcache;

public class ShiroCache<K,V> implements Cache<K,V>{
	private org.springframework.cache.Cache springCache;
	
	public ShiroCache(org.springframework.cache.Cache springCache){
		this.springCache = springCache;
	}

	@Override
	@SuppressWarnings("unchecked")
	public V get(K key) throws CacheException {
		 V value = (V) springCache.get(key);
		 if(value instanceof SimpleValueWrapper){
			 return (V) ((SimpleValueWrapper)value).get();
		 }
		 return value;
	}

	@Override
	public V put(K key, V value) throws CacheException {
		springCache.put(key, value);
		return value;
	}

	@Override
	public V remove(K key) throws CacheException {
		springCache.evict(key);
		return null;
	}

	@Override
	public void clear() throws CacheException {
		springCache.clear();
	}

	@Override
	public int size() {
		if(springCache.getNativeCache() instanceof Ehcache){
			Ehcache ehcache = (Ehcache)springCache.getNativeCache();
			return ehcache.getSize();
		}
		throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
	}

	@Override
    @SuppressWarnings("unchecked")
	public Set<K> keys() {
		 if(springCache.getNativeCache() instanceof Ehcache) {
             Ehcache ehcache = (Ehcache) springCache.getNativeCache();
             return new HashSet<K>(ehcache.getKeys());
         }
         throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
	}

	@Override
    @SuppressWarnings("unchecked")
	public Collection<V> values() {
		if(springCache.getNativeCache() instanceof Ehcache) {
            Ehcache ehcache = (Ehcache) springCache.getNativeCache();
			List<K> keys = ehcache.getKeys();
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<V>(keys.size());
                for (K key : keys) {
                    V value = get(key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        }
        throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
	}

}
