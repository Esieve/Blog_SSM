package tech.acodesigner.dao;

import tech.acodesigner.dto.CategoryDto;
import tech.acodesigner.entity.Category;

import java.util.List;

/**
 * Created by 77239 on 2017/3/31/0031.
 */
public interface CategoryDao {

    public List<CategoryDto> getCategories();

    public Category getCategory(int categoryId);

    public int saveCategory(String categoryName);

    public int updateCategory(Category category);

    public int deleteCategory(int categoryId);


}
