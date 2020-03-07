package com.shenjies88.practice.mybatispluspractice.contorller;

import com.shenjies88.practice.mybatispluspractice.common.HttpResult;
import com.shenjies88.practice.mybatispluspractice.entity.User;
import com.shenjies88.practice.mybatispluspractice.mapper.UserMapper;
import com.shenjies88.practice.mybatispluspractice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/3/6-11:55 PM
 */
@Api(tags = "用户接口")
@RequestMapping("/user")
@RestController
public class UserController {

    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper,UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @ApiOperation("用户列表")
    @GetMapping
    public HttpResult<List<User>> list() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return HttpResult.success(userList);
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public HttpResult<User> detail(@PathVariable("id") Integer id) {
        return HttpResult.success(userMapper.selectById(id));
    }

    @ApiOperation("新增用户")
    @PutMapping
    public HttpResult insert(@RequestBody User body) {
        userMapper.insert(body);
        return HttpResult.success();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable Integer id) {
        userMapper.deleteById(id);
        return HttpResult.success();
    }

    @ApiOperation("修改用户")
    @PostMapping("/{id}")
    public HttpResult update(@RequestBody User body) {
        userMapper.updateById(body);
        return HttpResult.success();
    }
}
