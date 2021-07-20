package controller;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-13-16:21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Company;
import pojo.Department;
import pojo.DepartmentUser;
import pojo.User;
import service.DepartmentService;
import service.DepartmentUserService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 @ClassName UserController
 @Description
 @author rabbit
 @create 2021-07-13-16:21
 @Version 1.0
 **/

@Controller

public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("DepartmentUserServiceImpl")
    private DepartmentUserService departmentUserService;
    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService departmentService;



    @PostMapping("/user/adduser")
    public String list(@RequestParam("account") String account, @RequestParam("userName")String userName, @RequestParam("sex")Integer sex, @RequestParam("companyId")Integer companyId, @RequestParam("status")Integer status,@RequestParam("departmentName") String departmentName,Model model){
        //获取当前时间
        Timestamp d= new Timestamp(System.currentTimeMillis());
        //获取userId
        Integer userId = userService.queryMaxId() + 1;
        //根据传入参数创建user对象
        User user = new User(userId,account,userName,sex,companyId,d,d,status);
        //根据输入的部门名称查询部门id
        Integer departmentId = departmentService.queryDepartmentIdByName(departmentName);

        Integer departmentUserId = userId;
        //根据传入参数创建DepartmentUser对象
        DepartmentUser departmentUser = new DepartmentUser(departmentUserId,companyId,departmentId,userId,status);
        //在user表中增加用户
        Integer adduser = userService.adduser(user);
        //在department_user表中增加用户信息
        Integer adddepertmentUser = departmentUserService.adddepartmentUser(departmentUser);
        if(adduser.equals(1)){

            model.addAttribute("success","true");
            model.addAttribute("id", user.getId());
            model.addAttribute("errMsg", "null");
        }else {
            model.addAttribute("success","false");
            model.addAttribute("id", user.getId());
            model.addAttribute("errMsg", "未成功增加用户");
        }
        return "result1";


    }
}
