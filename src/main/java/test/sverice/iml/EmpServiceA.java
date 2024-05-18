package test.sverice.iml;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import test.dao.Empdao;
import test.pojo.Emp;
import test.sverice.EmpService;

import java.util.List;
@Service//将当前类交给IOC容器管理，成为IOC容器中的bean
public class EmpServiceA implements EmpService {
    @Autowired
    private Empdao empDao;
    @Override
    public List<Emp> listEmp() {

        List<Emp> empList = empDao.listEmp();
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

        return empList;
    }
}
