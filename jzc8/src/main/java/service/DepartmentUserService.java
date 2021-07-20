package service;

import pojo.DepartmentUser;

import java.util.List;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-14-9:03
 */
public interface DepartmentUserService {
    //增加一个用户到department_user表
    Integer adddepartmentUser(DepartmentUser departmentUser);
    //根据department_id查询user_id
    List<Integer> queryUserIdByDepartmentId(Integer departmentId);
    //根据department_id分页查询user_id
    List<Integer> queryUserIdByDepartmentIdLimit(Integer departmentId,Integer pageNo,Integer pageSize);
    //根据user_id和department_id修改department_user表
    Integer updateDepertmentUser(Integer userId,Integer departmentId);




}
