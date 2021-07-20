package service;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-12-10:39
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dao.CompanyMapper;
import jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.Company;
import redis.clients.jedis.Client;

import java.security.PrivilegedExceptionAction;
import java.text.SimpleDateFormat;

/**
 @ClassName CompanyServiceImpl
 @Description
 @author rabbit
 @create 2021-07-12-10:39
 @Version 1.0
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private JedisClient client;
    @Autowired
    private CompanyMapper companyMapper;
    @Value("${companyMessage}")
    private String companyMessage;


    public void setCompanyMapper(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public Company queryCompanyById(Integer id) {
        //设置json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);


        //判断redis中是否有数据，如果有，直接从redis中获取数据返回
        try {
            String jsonstr = client.hget(companyMessage, id + "");
            if(jsonstr!=null){
                System.out.println("有缓存");
                    return mapper.readValue(jsonstr,Company.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //从mysql中查询company信息
        Company company = companyMapper.queryCompanyById(id);



        //调用方法将company信息写入redis
        try {
            client.hset(companyMessage,id+"",mapper.writeValueAsString(company));
            client.expire(companyMessage,300);
            System.out.println("没有缓存");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return company;
    }

    public Company queryCompany() {
        return companyMapper.queryCompany();
    }
}
