package com.guo.ssm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.cache.RedisCache;
import com.guo.ssm.dao.UserDao;
import com.guo.ssm.model.User;
import com.guo.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	 private UserDao userdao;
	@Autowired
	private RedisCache cache;
	
	
	
	

	@Override
	public List<User> fingAllUser() {
		//String cache_key=RedisCache.CAHCENAME+"|getAllUserList";
		String cache_key="user";
		List<User> user=cache.getListCache(cache_key, User.class);
		if(user==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			user=userdao.findAllUser();
			cache.putListCacheWithExpireTime(cache_key, user, RedisCache.CAHCETIME);
			LOG.info("放put cache with key:"+cache_key);
		}else{
			LOG.info("拿get cache with key:"+cache_key);
		}
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		//暂时通过删除缓存避免错误
		String cache_key=RedisCache.CAHCENAME+"|getAllUserList";
	cache.deleteCache(cache_key);
			userdao.updateUser(user);
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser(User user) {
		String cache_key=RedisCache.CAHCENAME+"|getAllUserList";
		cache.deleteCache(cache_key);
		userdao.addUser(user);// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserById(long userid) {
		String cache_key=RedisCache.CAHCENAME+"|getAllUserList";
		cache.deleteCache(cache_key);
	userdao.deleteUser(userid);	// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(long userid) {
		//id user
		String cache_key=RedisCache.CAHCENAME+"|getUserById|"+userid;
		User user_cache=cache.getCache(cache_key, User.class);
		if(user_cache==null){
			 user_cache=userdao.findUserById(userid);
			cache.putCacheWithExpireTime(cache_key, user_cache, RedisCache.CAHCETIME);
			LOG.info("put key"+cache_key);
		}
		else{
			LOG.info("get key from redis"+cache_key);
		}
		
		
		return user_cache;
	}

	@Override
	public User UserLogin(String username, String userpassword) {
		User user=userdao.findUserByName(username);
		if(user!=null&&user.getUserpassword().equals(userpassword)){
			return user;
		}
		return null;
		
	}

	
}
