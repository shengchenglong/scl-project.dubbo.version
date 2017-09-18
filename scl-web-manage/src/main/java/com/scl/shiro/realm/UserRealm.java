package com.scl.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.scl.user.domain.SysResource;
import com.scl.user.domain.SysRole;
import com.scl.user.service.SysResourceService;
import com.scl.user.service.SysRoleService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.scl.eum.EnumLock;
import com.scl.user.domain.SysUser;
import com.scl.user.service.SysUserService;


/**
 * 
 * @author shengchenglong
 *
 */
public class UserRealm extends AuthorizingRealm {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysResourceService sysResourceService;

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 认证 <br/>
	 * 1.先根据username查找user对象，并判断帐号的存在，锁定等状态 <br/>
	 * 2.返回一个含有user信息的认证信息AuthenticationInfo
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		SysUser user = sysUserService.selectByUsername(username);

		if (user == null) {
			throw new UnknownAccountException("Account does not exists!");
		} else if (EnumLock.YES.getValue() == user.getIsLocked()) {
			throw new LockedAccountException("Account is locked!");
		}
		String salt = user.getSalt();
		// 创建认证信息 注意：crazy cake 的 shiro－redis不支持SimpleAuthenticationInfo(username, password, salt, realmName);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(username + salt));
		
//		Subject curUser = SecurityUtils.getSubject();
//		Session session = curUser.getSession();
//		session.setAttribute("curUser", curUser);
		return info;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		// 创建授权信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 设置角色信息
		List<SysRole> roles = sysRoleService.getByUsername(username);
		Set<String> roleStrings = new HashSet<String>();
		for (SysRole role : roles) {
			roleStrings.add(role.getRole());
		}
		info.setRoles(roleStrings);
		// 设置资源信息
		List<SysResource> resources = sysResourceService.getByRoles(roles);
		Set<String> permissionStrings = new HashSet<String>();
		for (SysResource resource : resources) {
			permissionStrings.add(resource.getPermission());
		}
		info.setStringPermissions(permissionStrings);
		return info;
	}
	
	
}
