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
    private final JedisPool jedisPool;

    private RuntimeSchema<ArticleDto> schema = RuntimeSchema.createFrom(ArticleDto.class);

    public RedisDao(JedisPoolConfig config, String addr) {
        jedisPool = new JedisPool(config, addr);
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
