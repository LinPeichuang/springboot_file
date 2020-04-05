package com.myCache.springboot4.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


@Configuration
public class CacheConfig {
	@Bean("mykeyGenetator")
	public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
        
	        @Override
	        public Object generate(Object target, Method method, Object... params) {
	        	return method.getName()+"["+ Arrays.asList(params).toString()+"]";
	        }
        };
	}
}