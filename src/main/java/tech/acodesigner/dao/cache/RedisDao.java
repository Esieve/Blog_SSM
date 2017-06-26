package tech.acodesigner.dao.cache;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import tech.acodesigner.dto.ArticleDto;

/**
 * Created by 张秦遥 on 2017/6/26/0026.
 */
public class RedisDao {
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_TOTAL = 1024;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private final JedisPool jedisPool;

    private RuntimeSchema<ArticleDto> schema = RuntimeSchema.createFrom(ArticleDto.class);

    public RedisDao(String addr, int port, String password) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_TOTAL);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        jedisPool = new JedisPool(config, addr, port, TIMEOUT, password);
    }

    public ArticleDto getArticleByIdInCache(int articleId) {
        Jedis jedis = jedisPool.getResource();
        String key = "article" + articleId;
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes != null) {
            ArticleDto article = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes, article, schema);
            return article;
        }
        jedis.close();
        return null;
    }

    public String saveArticleInCache(ArticleDto article) {
        Jedis jedis = jedisPool.getResource();
        String key = "article" + article.getArticleId();
        byte[] bytes = ProtostuffIOUtil.toByteArray(article, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        String result = jedis.setex(key.getBytes(), 60 * 60, bytes);
        jedis.close();
        return result;
    }
}
