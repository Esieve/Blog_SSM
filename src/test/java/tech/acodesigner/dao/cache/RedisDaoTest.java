package tech.acodesigner.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.dao.ArticleDao;
import tech.acodesigner.dto.ArticleDto;

/**
 * Created by 张秦遥 on 2017/6/26/0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/dao.xml")
public class RedisDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testRedis() {
        ArticleDto article = redisDao.getArticleByIdInCache(3);
        if (article == null) {
            article = articleDao.getArticleById(3);
            String result = redisDao.saveArticleInCache(article);
            System.out.println(result);
        } else {
            System.out.println(article.getArticleId());
        }
    }
}