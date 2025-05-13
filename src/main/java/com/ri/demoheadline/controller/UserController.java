package com.ri.demoheadline.controller;

import com.ri.demoheadline.pojo.NewsUser;
import com.ri.demoheadline.service.NewsUserService;
import com.ri.demoheadline.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Component
public class z{
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody User user){
        Result result=userService.login(user);
        return result;
    }

}


public interface UserService extends IService<User> {

    Result login(User user);
}

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService{
    @Autowired
    private JwtHelper jwtHelper;
    /**
     * 实现登录操作
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        //1. 根据用户名查找用户，返回为null则说明用户名错误，501
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName,user.getUserName());
        //getOne方法如果查询到多个用户，会抛出异常
        User loginUser=getOne(lambdaQueryWrapper);
        if(loginUser==null){
            //说明用户名错误，返回错误信息
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //2. 对比输入的密码是否正确
        if(!StringUtils.isEmpty(user.getUserPwd()) && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            //用户输入的密码不为空且与数据库中的密码相同,说明登录成功,需要返回token值
            //使用jwt生成token
            String token=jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            Map data=new HashMap<>();
            data.put("token",token);
            return Result.ok(data);
        }
        else {
            //说明输入的密码有误
            return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }

    }

}
