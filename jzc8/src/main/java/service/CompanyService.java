package service;

import pojo.Company;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-12-10:38
 */
public interface CompanyService {
    //查询公司
    Company queryCompanyById(Integer id);

    Company queryCompany();
}
