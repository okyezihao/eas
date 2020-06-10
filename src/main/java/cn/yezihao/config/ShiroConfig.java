package cn.yezihao.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        // 添加 Shiro 内置过滤器
        /*
         *  anon: 无需认证就可以访问
         *  authc: 必须认证才能访问
         *  user: 必须拥有记住我功能才能访问
         *  perms: 拥有对某个资源的权限才能访问
         *  role: 拥有某个角色权限才能访问
         *  filterMap.put("/","anon");
         */
       Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/admin/*", "perms[admin]");
        filterMap.put("/logout", "logout");
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/noAuth");
        bean.setSuccessUrl("/admin/ssp");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm); // 关联 UserRealm
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
