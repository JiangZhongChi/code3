package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.DepartmentUser;
import pojo.User;

import java.util.List;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-12-10:21
 */
public interface DepartmentUserMapper {
    //增加一个用户到department_user表
    Integer adddepartmentUser(DepartmentUser departmentUser);
    //根据department_id查询user_id
    List<Integer> queryUserIdByDepartmentId(Integer departmentId);
    //根据department_id分页查询user_id
    List<Integer> queryUserIdByDepartmentIdLimit(@Param("departmentId") Integer departmentId, @Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);
    //根据user_id和department_id修改department_user表
    Integer updateDepertmentUser(@Param("userId") Integer userId,@Param("departmentId") Integer departmentId);


}
