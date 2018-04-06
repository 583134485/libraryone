

package com.guo.ssm.shiro.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.guo.ssm.model.UserModel;
import com.guo.ssm.shiro.service.UserModelService;
import com.guo.ssm.shiro.service.impl.UserModelServiceImpl;

/*import com.github.zhangkaitao.shiro.chapter12.entity.User;
import com.github.zhangkaitao.shiro.chapter12.service.UserService;*/

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:21:15
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public class UserRealm extends AuthorizingRealm {
 Logger log=Logger.getLogger(Class.class);
    
    //没有autowired 进去。。。奇怪
	@Autowired
    private UserModelService userService;
 //尽管用了 impl 类  发现dao 下的 类也没有加载进来
	/*UserModelService userService = new UserModelServiceImpl();*/
	//已经有自动装配了，但好像没装进去
  /*  public void setUserService(UserModelService userService) {
        this.userService = userService;
    }*/
    
	//权限授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        log.info("authorizat:username:"+username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }

     //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        log.info("username:"+username);
        UserModel user = userService.findByUsername(username);
        log.info("find:"+user.toString());
        
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

       /* if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定 ,暂时弄
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
    /*    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getUserpassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),//salt
                getName()  //realm name
        );*/
        //暂时不同加密算法
        SimpleAuthenticationInfo authenticationInfo2=new SimpleAuthenticationInfo(user.getUsername(), user.getUserpassword(), getName());
        
        return authenticationInfo2;
    }
}
