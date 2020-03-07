package com.shenjies88.practice.mybatispluspractice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenjies88.practice.mybatispluspractice.entity.User;
import com.shenjies88.practice.mybatispluspractice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author shenjies88
 * @since 2020/3/7-11:39 AM
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
