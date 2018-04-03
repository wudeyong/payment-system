package com.davin.simplecache;

import com.davin.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "userServiceBean")
public class UserService {

    @Cacheable(cacheNames = "users")
    public User getUserById(String userId){
        System.out.println("Get from real database.");
        return new User();
    }

    private User getFrimDB(String userId){
        return new User();
    }
}
