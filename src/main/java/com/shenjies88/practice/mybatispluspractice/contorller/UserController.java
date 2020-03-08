package com.shenjies88.practice.mybatispluspractice.contorller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shenjies88.practice.mybatispluspractice.common.HttpResult;
import com.shenjies88.practice.mybatispluspractice.entity.User;
import com.shenjies88.practice.mybatispluspractice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenjies88
 * @since 2020/3/6-11:55 PM
 */
@Api(tags = "用户接口")
@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户列表")
    @GetMapping
    public HttpResult<IPage<User>> list(@ApiParam(value = "页数") @RequestParam(defaultValue = "1") Integer pageNum,
                                        @ApiParam(value = "条数") @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        userService.page(page, new QueryWrapper<User>().orderByDesc("id"));
        return HttpResult.success(page);
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public HttpResult<User> detail(@PathVariable("id") Integer id) {
        return HttpResult.success(userService.getById(id));
    }

    @ApiOperation("新增用户")
    @PutMapping
    public HttpResult insert(@RequestBody User body) {
        userService.save(body);
        return HttpResult.success();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public HttpResult delete(@PathVariable Integer id) {
        userService.removeById(id);
        return HttpResult.success();
    }

    @ApiOperation("修改用户")
    @PostMapping("/{id}")
    public HttpResult update(@RequestBody User body) {
        userService.updateById(body);
        return HttpResult.success();
    }
}
