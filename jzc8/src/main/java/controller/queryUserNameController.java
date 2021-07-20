package controller;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-14-15:11
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pojo.User;
import pojo.UserReturn;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 @ClassName queryUserNameController
 @Description
 @author rabbit
 @create 2021-07-14-15:11
 @Version 1.0
 **/
@Controller
public class queryUserNameController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @GetMapping("/queryUserName")
    public String queryUserName(String nameLike,Integer pageNo,Integer pageSize,Model model) throws JsonProcessingException {
        //根据名字模糊查询用户信息
        List<User> list = userService.queryUserByNameLikeDesc(nameLike);
        //根据名字 分页 模糊查询用户信息
        List<User> list1 = userService.queryUserByNameLikeDescLimit(nameLike,(pageNo-1)*pageSize,pageSize);
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        //转成json格式
        List<String> users = new ArrayList<String>();
        for(int i=0;i<list1.size();i++){
            User user = list1.get(i);
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

        return "result4";
    }



}
