package tech.acodesigner.service;

import tech.acodesigner.dto.CategoryDto;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Category;

import java.util.List;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
public interface CategoryService {

    public List<CategoryDto> getCategories();

    public OperationResult<Category> getCategory(int categoryId);

    public OperationResult saveCategory(String categoryName);

    public OperationResult updateCategory(Category category);

    public OperationResult deleteCategory(int categoryId);

}
