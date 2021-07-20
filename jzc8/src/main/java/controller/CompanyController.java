package controller;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-13-8:16
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Company;
import redis.clients.jedis.Jedis;
import service.CompanyService;

import java.util.List;

/**
 @ClassName CompanyController
 @Description
 @author rabbit
 @create 2021-07-13-8:16
 @Version 1.0
 **/

@Controller

public class CompanyController {
    //controller 调  service层
    @Autowired
    @Qualifier("CompanyServiceImpl")
    private CompanyService companyService;

    //查询公司
    @GetMapping("/company/queryCompanyById")
    public String list(Integer companyId,Model model){


        Company company = companyService.queryCompanyById(companyId);
        model.addAttribute("msg",company);
        return "test";

    }

    @GetMapping("/test")
    public String test(Model model){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());


        model.addAttribute("msg","123");
        return "test";
    }




}
