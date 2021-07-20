package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Company;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-12-10:20
 */
public interface CompanyMapper {
    //查询公司
    Company queryCompanyById(@RequestParam("id") Integer id);
    //查询全部公司信息
    Company queryCompany();


}
