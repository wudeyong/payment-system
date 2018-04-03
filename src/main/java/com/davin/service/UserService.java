package com.davin.service;

import com.davin.cache.CacheManager;
import com.davin.domain.User;
import org.springframework.stereotype.Service;

/**
 * 自定义UserService，并简单实现了一个缓存器
 */

@Service("userService")
public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        this.cacheManager = new CacheManager<User>();
    }

    /**
     * UserID不能为空
     * @param userId 用户ID
     * @return 返回查询的用户
     */
    public User getUserById(String userId){
        User result = cacheManager.getValue(userId);
        if (result == null){
            System.out.println("Cache missing");
            result = new User();
            cacheManager.addOrUpdateCache(userId,result);
            System.out.println("Add cache to Cache Manager");
            return  result;
        }
        System.out.println("Get cache from cache manager");
        return result;
    }

    // 使缓存全部失效
    public void reload(){
        cacheManager.evict();
    }

}
