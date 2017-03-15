package com.cyb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyb.dao.UserRepository;
import com.cyb.po.User;
@Service  
public class UserService extends BaseService<User>  {
    @Autowired  
    public void setUserRepository(UserRepository userRepository) {  
        setRepository(userRepository);  
    }  
}
