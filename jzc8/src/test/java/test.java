/**
 * @Description:
 * @author rabbit
 * @create 2021-07-13-13:38
 */

import dao.CompanyMapper;
import jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Company;
import service.CompanyService;
import service.CompanyServiceImpl;

/**
 @ClassName test
 @Description
 @author rabbit
 @create 2021-07-13-13:38
 @Version 1.0
 **/
public class test {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-redis.xml");
        JedisClient bean = context.getBean(JedisClient.class);
        bean.set("qweqwe","qweqweqweqwe");
        System.out.println(bean.get("qweqwe"));
    }
}
