package test.springbootdemo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import test.pojo.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    //传统方式
  /*  @RequestMapping("/hello")
    public String hello(HttpServletRequest request)
    {
        //获取请求参数
       String name= request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        return "OK";
    }*/
    //SRINGBOOT方式
    @RequestMapping("/hello")
    public String hello(@RequestParam(name="name",required = false) String username, Integer age)
    {

        System.out.println(username +":"+age);
        return "OK";
    }
    @RequestMapping("/simplePojo")
    public String simplePojo(User user  )
    {

        System.out.println(user);
    return "OK";
    }
    @RequestMapping("/array")
    public String array(String [] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }
  @RequestMapping("/list")
    public String list( @RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }
    //时间参数
    @RequestMapping("/dateParam")
    public String Data(@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" ) LocalDateTime updateTime)
    {
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/json")
    public String json(@RequestBody User user  )
    {
        System.out.println(user);
        return "OK";
    }
    @RequestMapping("/page/{id}")
    public String Path(@PathVariable Integer id)
    {
        System.out.println(id);
        return "OK";
    }


}
