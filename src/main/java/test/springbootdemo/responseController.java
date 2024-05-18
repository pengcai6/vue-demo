package test.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.pojo.Result;
import test.pojo.User;

@RestController
public class responseController {
    @RequestMapping("/hello1")
public Result hello1()
{
//    return new Result(1,"success","HEllo");
    return Result.success("HEllo");
}
@RequestMapping("/getuser")
public User getuser()
{
    User user=new User();
    user.setAge(15);
    user.setUsername("li");
    return Result.success(user);
}


}
