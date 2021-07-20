package service;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-14-9:22
 */

import dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Department;

/**
 @ClassName DepartmentServiceImpl
 @Description
 @author rabbit
 @create 2021-07-14-9:22
 @Version 1.0
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public Integer queryDepartmentIdByName(String name) {
        return departmentMapper.queryDepartmentIdByName(name);
    }

    public Department queryDepartmentNameById(Integer id) {
        return departmentMapper.queryDepartmentNameById(id);
    }
}
