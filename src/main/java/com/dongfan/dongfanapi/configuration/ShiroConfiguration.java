package com.dongfan.dongfanapi.configuration;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/6/10 20:49
 * @Version 1.0
 */
@Configuration
public class ShiroConfiguration {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager( securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setLoginUrl("/user/unlogin");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("https://dfapi.houserqu.com/user/unlogin");

        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        //限制同一帐号同时在线的个数。
        //filtersMap.put("kickout", kickoutSessionControlFilter());

        filtersMap.put("authc", new ShiroLoginFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        // 权限控制map.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        // 从数据库获取动态的权限
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/course/getVideoListByCourseId","anon");
       // filterChainDefinitionMap.put("/user/getPreviousUserInfo","authc");
        filterChainDefinitionMap.put("/class/getClassList","anon");
        filterChainDefinitionMap.put("/class/getClassDetail","anon");
        filterChainDefinitionMap.put("/course/getCourseList","anon");
        filterChainDefinitionMap.put("/course/getCourseCategory","anon");
        filterChainDefinitionMap.put("/course/getCategoryVideo","anon");

        filterChainDefinitionMap.put("/video/getVideoDetail","anon");

        filterChainDefinitionMap.put("/user/weAppLogin","anon");
        filterChainDefinitionMap.put("/user/webLogin","anon");
        filterChainDefinitionMap.put("/user/unlogin","anon");

        filterChainDefinitionMap.put("/**", "authc");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //logout这个拦截器是shiro已经实现好了的。
        // 从数据库获取
        /*List<SysPermissionInit> list = sysPermissionInitService.selectAll();

        for (SysPermissionInit sysPermissionInit : list) {
            filterChainDefinitionMap.put(sysPermissionInit.getUrl(),
                    sysPermissionInit.getPermissionInit());
        }*/

        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        myShiroRealm().setCredentialsMatcher(MyCredentialsMatcher());
        securityManager.setRealm(myShiroRealm());

        // 自定义缓存实现 使用redis
        //securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        //注入记住我管理器;
      //  securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
       // myShiroRealm().setCredentialsMatcher(MyCredentialsMatcher());
        return myShiroRealm;
    }
    @Bean
    public CredentialsMatcher MyCredentialsMatcher(){
        return new MyCredentialsMatcher();
    }
    @Bean
    public SessionManager sessionManager(){
        return  new DefaultHeaderSessionManager();
    }

    /**
     * cookie对象;
     * @return
     */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

}
