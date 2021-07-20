package jedis;

/**
 * @author rabbit
 * @Description:
 * @create 2021-07-16-12:45
 */
public interface JedisClient {
    String set(String key,String value);
    String get(String key);
    Boolean exists(String key);
    Long expire(String key,Integer seconds);
    Long ttl(String key);
    Long incr(String key);
    Long hset(String key,String field,String value);
    String hget(String key,String field);
    Long hdel(String key,String... field);
}
