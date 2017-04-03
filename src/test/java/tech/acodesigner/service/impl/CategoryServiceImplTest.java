package tech.acodesigner.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.dao.CategoryDao;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Category;
import tech.acodesigner.service.CategoryService;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/service.xml", "classpath:spring/dao.xml"})
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategory() throws Exception {
        OperationResult<Category> or = categoryService.getCategory(2);
        if (or.isSuccess()) {
            System.out.println(or.getData().getCategoryName());
        } else {
            System.out.println(or.getInfo());
        }
    }

}