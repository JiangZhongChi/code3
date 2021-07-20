package service;

import pojo.Company;
import pojo.Department;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-14-9:22
 */
public interface DepartmentService {
    Integer queryDepartmentIdByName(String name);

    Department queryDepartmentNameById(Integer id);
}
