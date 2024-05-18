package test.sverice.iml;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.dao.Empdao;
import test.pojo.Emp;
import test.sverice.EmpService;

import java.util.List;


public class EmpServiceB implements EmpService {

    private Empdao empDao;
    @Override
    public List<Emp> listEmp() {

        List<Emp> empList = empDao.listEmp();
        //2.对数据进行转换处理
        empList.stream().forEach(emp->{
            String gender=emp.getGender();
            if("1".equals(gender))
            {
                emp.setGender("男是");
            } else if ("2".equals(gender)) {
                emp.setGender("女是");
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
