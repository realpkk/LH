package com.luxury.hotel.common.configs;

import com.luxury.hotel.common.shiro.CustomAuthorizingRealm;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        logger.info("-------------------- DefaultWebSecurityManager init ---------------------");
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getAuthorizingRealm());
        defaultWebSecurityManager.setCacheManager(getEhCacheManager());
        return defaultWebSecurityManager;
    }

    @Bean(name = "realm")
    public AuthorizingRealm getAuthorizingRealm(){
        logger.info("-------------------- AuthorizingRealm init ---------------------");
        return new CustomAuthorizingRealm();
    }

    @Bean(name = "shiroEhCacheManager")
    public MemoryConstrainedCacheManager getEhCacheManager(){
        logger.info("-------------------- EhCacheManager init ---------------------");
        return new MemoryConstrainedCacheManager();
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        logger.info("-------------------- LifecycleBeanPostProcessor init ---------------------");
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        logger.info("-------------------- DefaultAdvisorAutoProxyCreator init ---------------------");
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        logger.info("-------------------- AuthorizationAttributeSourceAdvisor init ---------------------");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getDefaultWebSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        logger.info("-------------------- ShiroFilterFactoryBean init ---------------------");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        Map<String,String> filterChainDefinitionMap = new HashMap<>();

        filterChainDefinitionMap.put("/index","anon");

        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/toRegister","anon");
        filterChainDefinitionMap.put("/register","anon");
        filterChainDefinitionMap.put("/static/**","anon");

        filterChainDefinitionMap.put("/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        logger.info("-------------------- FilterRegistrationBean init ---------------------");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        delegatingFilterProxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(delegatingFilterProxy);
        filterRegistrationBean.addInitParameter("targetFilterLifecycle","true");
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
