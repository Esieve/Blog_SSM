package tech.acodesigner.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.dto.CategoryDto;
import tech.acodesigner.entity.Category;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/3/31/0031.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/dao.xml")
public class CategoryDaoTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getCategories() throws Exception {
        List<CategoryDto> categories = categoryDao.getCategories();
        for (CategoryDto category:categories) {
            System.out.println(category);
        }
    }

    @Test
    public void getCategory() throws Exception {
        Category category = categoryDao.getCategory(1);
        System.out.println(category);
    }

    @Test
    public void saveCategory() throws Exception {
        int result = categoryDao.saveCategory("test");
        System.out.println(result);
    }

    @Test
    public void updateCategory() throws Exception {
        Category category = new Category();
        category.setCategoryId(14);
        category.setCategoryName("jjj");
        int result = categoryDao.updateCategory(category);
        System.out.println(result);
    }

    @Test
    public void deleteCategory() throws Exception {
        int result = categoryDao.deleteCategory(14);
        System.out.println(result);
    }

}