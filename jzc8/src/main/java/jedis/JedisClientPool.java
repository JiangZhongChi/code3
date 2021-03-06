package jedis;/**
 * @Description:
 * @author rabbit
 * @create 2021-07-16-13:35
 */

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 @ClassName JedisClientPool
 @Description
 @author rabbit
 @create 2021-07-16-13:35
 @Version 1.0
 **/
public class JedisClientPool implements JedisClient {
    @Autowired
    private JedisPool jedisPool;





    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key,value);
        jedis.close();
        return result;
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    public Long expire(String key, Integer seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key,seconds);
        jedis.close();
        return result;
    }

    public Long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(key,field,value);
        jedis.close();
        return result;
    }

    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key,field);
        jedis.close();
        return result;
    }

    public Long hdel(String key, String... field) {
        Jedis jedis = jedisPool.getResource();

        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }
}
