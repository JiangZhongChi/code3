package service;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-13-16:17
 */

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

/**
 @ClassName UserServiceImpl
 @Description
 @author rabbit
 @create 2021-07-13-16:17
 @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Integer adduser(User user) {
        return userMapper.adduser(user);
    }

    public Integer queryMaxId() {
        return userMapper.queryMaxId();
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryUserByNameLikeDesc(String nameLike) {
        return userMapper.queryUserByNameLikeDesc(nameLike);
    }

    public List<User> queryUserByNameLikeDescLimit(String nameLike, Integer pageNo, Integer pageSize) {
        return userMapper.queryUserByNameLikeDescLimit(nameLike,pageNo,pageSize);
    }


}
