package test.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.pojo.Emp;
import test.pojo.Result;
import test.sverice.EmpService;

import java.util.List;
@RestController
public class empController {
  @Autowired//运行时，IOC容器会提供该类型的BEAN对象，并赋值给该变量  -依赖注入
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list()
    {
        List<Emp> empList = empService.listEmp();
        //3.响应数据
        return Result.success(empList);
    }

}
/*

@RestController
public class empController {
    @RequestMapping("/listEmp")
    public Result list()
    {//1.加载解析处理
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList =XmlParserUtils.parse(file, Emp.class);
    //2.对数据进行转换处理
            empList.stream().forEach(emp->{
                String gender=emp.getGender();
                if("1".equals(gender))
                {
                    emp.setGender("男");
                } else if ("2".equals(gender)) {
                    emp.setGender("女");
                }
                String job=emp.getJob();
                if("1".equals(job))
                {
                   emp.setJob("讲师");
                } else if ("2".equals(job)) {
                    emp.setJob("班主任");
                }
                else if ("3".equals(job)) {
                    emp.setJob("就业指导");
                }

            });
    //3.响应数据
        return Result.success(empList);
    }

}
*/
