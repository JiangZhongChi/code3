package controller;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-14-11:30
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pojo.User;
import pojo.UserReturn;
import service.DepartmentService;
import service.DepartmentUserService;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 @ClassName queryUserController
 @Description
 @author rabbit
 @create 2021-07-14-11:30
 @Version 1.0
 **/
@Controller
public class queryUserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("DepartmentUserServiceImpl")
    private DepartmentUserService departmentUserService;




    @GetMapping("/user/queryuser1")
    public String queryUser1(Integer departmentId1, Integer pageNo,Integer pageSize, Model model) throws JsonProcessingException {
        //根据部门id查询userId
        List<Integer> list = departmentUserService.queryUserIdByDepartmentId(departmentId1);
        //根据部门id分页查询userId
        List<Integer> list1 = departmentUserService.queryUserIdByDepartmentIdLimit(departmentId1,(pageNo-1)*pageSize,pageSize);
//        User user = userService.queryUserById((Integer) list.get(0));
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        //根据得到的userId，查询用户信息，并转成json格式
        List<String> users = new ArrayList<String>();
        for(int i=0;i<list1.size();i++){
            User user = userService.queryUserById(list1.get(i));
            UserReturn userReturn = new UserReturn(user.getId(),user.getName(),user.getAccount(),user.getSex(),user.getCreateTime(),user.getUpdateTime());
            String str = mapper.writeValueAsString(userReturn);
            users.add(str);
        }
        int total = list.size();
        model.addAttribute("success", "true");
        model.addAttribute("page",pageNo);
        model.addAttribute("total",total);
        model.addAttribute("rowCount",pageSize);
        model.addAttribute("list",users);
        model.addAttribute("errMsg","null");

        return "result2";
    }


}
