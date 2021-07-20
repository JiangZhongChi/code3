package dao;

import org.springframework.web.bind.annotation.RequestParam;
import pojo.Company;
import pojo.Department;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-12-10:20
 */
public interface DepartmentMapper {
    Integer queryDepartmentIdByName( String name);

    Department queryDepartmentNameById(Integer id);
}
