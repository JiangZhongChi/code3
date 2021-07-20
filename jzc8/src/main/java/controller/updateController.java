package controller;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-14-14:26
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import service.DepartmentService;
import service.DepartmentUserService;
import service.UserService;

/**
 @ClassName updateController
 @Description
 @author rabbit
 @create 2021-07-14-14:26
 @Version 1.0
 **/
@Controller
public class updateController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("DepartmentUserServiceImpl")
    private DepartmentUserService departmentUserService;
    @Autowired
    @Qualifier("DepartmentServiceImpl")
    private DepartmentService departmentService;

    @PostMapping("/update")
    public String update(Integer userId,Integer departmentId,Model model){

        Integer integer = departmentUserService.updateDepertmentUser(userId, departmentId);

        if(integer.equals(1)) {
            model.addAttribute("success", "true");
            model.addAttribute("content", "null");
            model.addAttribute("errMsg", "null");
        }
        return "result3";
    }
}
