package service;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-14-9:03
 */

import dao.DepartmentUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.DepartmentUser;

import java.util.List;

/**
 @ClassName DepartmentUserServiceImpl
 @Description
 @author rabbit
 @create 2021-07-14-9:03
 @Version 1.0
 **/
@Service
public class DepartmentUserServiceImpl implements DepartmentUserService {
    @Autowired
    private DepartmentUserMapper departmentUserMapper;

    public void setDepartmentUserMapper(DepartmentUserMapper departmentUserMapper) {
        this.departmentUserMapper = departmentUserMapper;
    }

    public Integer adddepartmentUser(DepartmentUser departmentUser) {
        return departmentUserMapper.adddepartmentUser(departmentUser);
    }

    public List<Integer> queryUserIdByDepartmentId(Integer departmentId) {
        return departmentUserMapper.queryUserIdByDepartmentId(departmentId);
    }

    public List<Integer> queryUserIdByDepartmentIdLimit(Integer departmentId, Integer pageNo, Integer pageSize) {
        return departmentUserMapper.queryUserIdByDepartmentIdLimit(departmentId,pageNo,pageSize);
    }

    public Integer updateDepertmentUser(Integer userId, Integer departmentId) {
        return departmentUserMapper.updateDepertmentUser(userId,departmentId);
    }


}
